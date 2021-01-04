package javapractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OP06DBConnectionPoolExample implements Runnable {// This is a thread class and hence implements Runnable
																// interface

	// Remember all the following 9 field variables
	int initPoolSize;
	int maxPoolSize;
	String dbURL;
	String dbUserName;
	String dbPassword;
	String dbDriverClassName;
	boolean waitIfBusy;
	List<Connection> availableConnectionList = null;
	List<Connection> busyConnectionList = null;

	// Constructor:
	// Get all the required information to create a db connection
	// 1. initial size of the pool
	// 2. max size of the pool
	// 3. db connection url
	// 4. db connection username
	// 5. db connection password
	// 6. db driver class name
	// 7. boolean flag - waitIfBusy - i.e. if no connection is available then wait.
	// Then create initPoolSize number of Connections and add it in available list
	// of connections.
	public OP06DBConnectionPoolExample(int initPoolSize, int maxPoolSize, String dbURL, String dbUserName,
			String dbPassword, String dbDriverClassName, boolean waitIfBusy) throws ClassNotFoundException, SQLException {
		this.initPoolSize = initPoolSize;
		this.maxPoolSize = maxPoolSize;
		this.dbURL = dbURL;
		this.dbUserName = dbUserName;
		this.dbPassword = dbPassword;
		this.dbDriverClassName = dbDriverClassName;
		this.waitIfBusy = waitIfBusy;

		if (initPoolSize > maxPoolSize) {
			initPoolSize = maxPoolSize;
		}

		availableConnectionList = new ArrayList<Connection>();
		busyConnectionList = new ArrayList<Connection>();

		// Create availableConnectionList with the initPoolSize - number of connections
		// as this is initial pool size.
		for (int i = 0; i < initPoolSize; i++) {
			Connection con = createNewConnection();
			availableConnectionList.add(con);
		}
	}

	// Will be invoked from Driver class
	// have to be synchronized
	synchronized public Connection getConnection() throws InterruptedException, SQLException {
		Connection con = null;
		// If we have an available connection, then return that connection.
		if (!availableConnectionList.isEmpty()) {
			con = availableConnectionList.get(availableConnectionList.size() - 1);// return the last connection in the
																					// list.
			//Check if this last connection is closed() -> then call notifyAll() - if any other thread is waiting.
			if(con.isClosed()) {
				notifyAll();
				con = getConnection();
			} else {
				// remove last element from the available connection and add it in the busy
				// connection list.
				availableConnectionList.remove(availableConnectionList.size() - 1);
				busyConnectionList.add(con);
			}
			return con;
		} else {// if no available connection then either wait for a connection to be freed or
				// create a new one.
			if (busyConnectionList.size() == maxPoolSize) {// If all the connections from the pool are busy.
				if (!waitIfBusy) {// If no connection available and limit is reached.
	                throw new SQLException("Connection limit reached");
				}
				this.wait();
			} else if ((busyConnectionList.size() + availableConnectionList.size()) < maxPoolSize) {
				// if adding (available+busy) connection list is less than maxpoolsize -> then
				// create new connection in background.
				// You can't just make a new connection in the foreground when none are available, 
				// since this can take several seconds with a slow network connection. 
				// Instead, start a thread that establishes a new connection, then wait. 
				// You get woken up either when the new connection is established or
				// if someone finishes with an existing connection.
				createNewConnectionInBackground();
			}

			// Once you come out of the wait() - call the getConnection() method again.
			if (busyConnectionList.size() == maxPoolSize) {// If all the connections from the pool are busy.
				con = getConnection();
			}
		}
		return con;
	}

	// To free connection:
	// remove from busy and add in available
	synchronized public void freeConnection(Connection con) {
		busyConnectionList.remove(con);
		availableConnectionList.add(con);
        // Wake up threads that are waiting for a connection
        notifyAll();
	}
	
	// Close all the connections
	synchronized public void closeAllConnection() {
		// iterate over availableConnectionList & busyConnectionList 
		// And call .close on each Connection and remove it from the list
		// make sure the size is 0 for both the list.

	} 

	//Remember following steps
	private Connection createNewConnection() throws ClassNotFoundException, SQLException {
		Class.forName(this.dbDriverClassName);
		Connection con = DriverManager.getConnection(this.dbURL, this.dbUserName, this.dbPassword);
		return con;
	}

	// In background means spawn a new thread which creates a new connection and updates: available list
	private void createNewConnectionInBackground() {
		Thread t = new Thread(this);
		t.start();
	}


	public void run() {
		// create a new connection
		try {
			Connection con = createNewConnection();
			availableConnectionList.add(con);
			//After creating notify any waiting thread
			notifyAll();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

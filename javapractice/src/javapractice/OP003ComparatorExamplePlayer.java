package javapractice;

public class OP003ComparatorExamplePlayer {

	private int age;
	private int salary;
	private int rank;
	private int wins;
	
	public OP003ComparatorExamplePlayer(int age, int salary, int rank, int wins) {
		this.age=age;
		this.salary=salary;
		this.rank=rank;
		this.wins=wins;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "AGE:"+this.age +" SALARY:" + this.salary + " RANK:" + this.rank + " WINS:" + this.wins;
	}

	/**
	 * @return the rank
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * @param rank the rank to set
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}

	/**
	 * @return the wins
	 */
	public int getWins() {
		return wins;
	}

	/**
	 * @param wins the wins to set
	 */
	public void setWins(int wins) {
		this.wins = wins;
	}
}

package javapractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OP003ComparableExamplePlayer implements Comparable<OP003ComparableExamplePlayer>{
	//Consider this call to be a Player class with Age and Salary
	private int age;
	private int salary;
	private OP003ComparableExamplePlayer(int age, int salary) {
		this.age = age;
		this.salary = salary;
	}
	
	// This is default sort by age
	public int compareTo(OP003ComparableExamplePlayer o) {
		return Integer.compare(this.age, o.age);
	}
	
	public static void main(String[] args) {
		OP003ComparableExamplePlayer player1 = new OP003ComparableExamplePlayer(20, 20000);
		OP003ComparableExamplePlayer player2 = new OP003ComparableExamplePlayer(35, 90000);
		OP003ComparableExamplePlayer player3 = new OP003ComparableExamplePlayer(15, 30000);
		//player1.compareTo(player2); Need not to call this method. Instead call Collections.Sort(Comparable);
		List<OP003ComparableExamplePlayer> list = new ArrayList<OP003ComparableExamplePlayer>();
		list.add(player1);
		list.add(player2);
		list.add(player3);
		System.out.println("OP003ComparableExamplePlayer.main() BEFORE:"+  list);
		Collections.sort(list);
		System.out.println("OP003ComparableExamplePlayer.main() after:"+  list);
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
		return "AGE:"+this.age +" SALARY:" + this.salary;
	}

}

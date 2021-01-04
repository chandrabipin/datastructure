package javapractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OP003ComparatorExampleDriverClass {
	public static void main(String[] args) {
		OP003ComparatorExamplePlayer player1 = new OP003ComparatorExamplePlayer(20, 350000,2,9);
		OP003ComparatorExamplePlayer player2 = new OP003ComparatorExamplePlayer(35, 15000,3,4);
		OP003ComparatorExamplePlayer player3 = new OP003ComparatorExamplePlayer(15, 20000,1,6);
		//player1.compareTo(player2); Need not to call this method. Instead call Collections.Sort(Comparable);
		List<OP003ComparatorExamplePlayer> list = new ArrayList<OP003ComparatorExamplePlayer>();
		list.add(player1);
		list.add(player2);
		list.add(player3);
		System.out.println("AGE SORT BEFORE:"+  list);
		Collections.sort(list, new OP003PlayerAgeComparator());
		System.out.println("AGE SORT AFTER:"+  list);

		System.out.println("\nSalary Sort BEFORE:"+  list);
		Collections.sort(list, new OP003PlayerSalaryComparator());
		System.out.println("Salary Sort AFTER:"+  list);
		
		System.out.println("\nRANK Sort BEFORE:"+  list);
		//anonymous call.
		Collections.sort(list, new Comparator<OP003ComparatorExamplePlayer>() {
			public int compare(OP003ComparatorExamplePlayer a, OP003ComparatorExamplePlayer b) {
				return Integer.compare(a.getRank(), b.getRank());
			}
		});
		System.out.println("RANK Sort AFTER:"+  list);

		System.out.println("\nWINS Sort BEFORE:"+  list);
		//Java 8 - lambda expression. // Comparator should take OP003ComparatorExamplePlayer as its generic type - else it will not compile.
		Comparator<OP003ComparatorExamplePlayer> c = 
				(OP003ComparatorExamplePlayer a, OP003ComparatorExamplePlayer b) -> Integer.compare(a.getWins(), b.getWins());
		Collections.sort(list, c);

		System.out.println("WINS Sort AFTER:"+  list);
	}
}

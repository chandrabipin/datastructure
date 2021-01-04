package javapractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OP003ComparatorJava8LambdaExample {
	public static void main(String[] args) {
		OP003ComparatorExamplePlayer player1 = new OP003ComparatorExamplePlayer(20, 350000,2,9);
		OP003ComparatorExamplePlayer player2 = new OP003ComparatorExamplePlayer(35, 15000,3,4);
		OP003ComparatorExamplePlayer player3 = new OP003ComparatorExamplePlayer(15, 20000,1,6);
		//player1.compareTo(player2); Need not to call this method. Instead call Collections.Sort(Comparable);
		List<OP003ComparatorExamplePlayer> list = new ArrayList<OP003ComparatorExamplePlayer>();
		list.add(player1);
		list.add(player2);
		list.add(player3);
		System.out.println("\nWINS Sort BEFORE:"+  list);
		//Java 8 - lambda expression. // Comparator should take OP003ComparatorExamplePlayer as its generic type - else it will not compile.
		Comparator<OP003ComparatorExamplePlayer> c = 
				(OP003ComparatorExamplePlayer a, OP003ComparatorExamplePlayer b) -> Integer.compare(a.getWins(), b.getWins());
		Collections.sort(list, c);

		System.out.println("WINS Sort AFTER:"+  list);
	}
}

package javapractice;

import java.util.Comparator;

public class OP003PlayerAgeComparator implements Comparator<OP003ComparatorExamplePlayer>{

	public int compare(OP003ComparatorExamplePlayer a, OP003ComparatorExamplePlayer b) {
		return Integer.compare(a.getAge(), b.getAge());
	}
}

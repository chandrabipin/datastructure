
package com.bipin.algo.greedy;

import java.util.*;

public class G03ComparatorDensityDesc implements Comparator<G03GoldType>{
	public int compare(G03GoldType g1, G03GoldType g2){
		// since density is in double
		// and we want to reverse the order -> multiply by -1
		return -1*Double.compare(g1.getDensity(), g2.getDensity());
	}
}

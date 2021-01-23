package com.bipin.algo.greedy;

import java.util.*;

public class G01ActivitySortByEndTime implements Comparator<G01Activity>{

	@Override
    // Used for sorting in ascending order of endTime
	public int compare(G01Activity a1, G01Activity a2){
		return a1.getEndTime()-a2.getEndTime();
	}
	
	//Invoke in respective call 
	// Collections.sort(ar, new G01ActivitySortByEndTime()); 
}

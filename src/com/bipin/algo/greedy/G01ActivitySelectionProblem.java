package com.bipin.algo.greedy;

import java.util.*;

//1st problem encountered - how to sort only the endtime as I can not separate it from the starttime. I have to retain the start time with each endtime for further processing.
public class G01ActivitySelectionProblem{
	public static void main(String[] args){
		//Input
		//i>  Create public static void main and start with the 'given input' as a first step.
		ArrayList<G01Activity> arrList = new ArrayList<G01Activity>();
		arrList.add(new G01Activity(0,6));
		arrList.add(new G01Activity(3,4));
		arrList.add(new G01Activity(1,2));
		arrList.add(new G01Activity(5,8));
		arrList.add(new G01Activity(5,7));
		arrList.add(new G01Activity(8,9));

		//ii> Create class's object and invoke its algo's method and pass the input as arguments.
		G01ActivitySelectionProblem g = new G01ActivitySelectionProblem();
		g.activitySelection(arrList);
	}
	
	public void activitySelection(ArrayList<G01Activity> arrList){
		Collections.sort(arrList, new G01ActivitySortByEndTime());// Very Important Step, note the second arg. Sort arrList by endTime.
		int previousEndTime = -1;
		for(int i=0;i<arrList.size();i++){
			if(i==0){
				System.out.println((G01Activity)arrList.get(0));
				previousEndTime = ((G01Activity)(arrList.get(0))).getEndTime();
			} else {
				if(((G01Activity)arrList.get(i)).getStartTime()>=previousEndTime){
					System.out.println((G01Activity)arrList.get(i));
					previousEndTime=((G01Activity)(arrList.get(i))).getEndTime();
				}
			}
		}
		
	}
}
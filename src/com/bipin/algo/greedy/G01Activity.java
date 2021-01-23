package com.bipin.algo.greedy;

import java.util.Arrays;

public class G01Activity{
	private int startTime = 0;
	private int endTime = 0;
	
	public G01Activity(int startTime, int endTime){
		this.startTime=startTime;
		this.endTime=endTime;
	}
	public void setStartTime(int startTime){
		this.startTime=startTime;
	}

	public int getStartTime(){
		return this.startTime;
	}

	public void setEndTime(int endTime){
		this.endTime=endTime;
	}

	public int getEndTime(){
		return this.endTime;
	}
	
	//@Overide
	public String toString(){
		return "startTime: "+startTime+"  endTime: "+endTime;
	}
}

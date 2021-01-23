package com.bipin.algo.dnq;

import java.util.*;

public class D06ProfitWt{
	String name;
	int profit;
	int wt;
	
	public D06ProfitWt(String name, int profit, int wt){
		this.name=name;
		this.profit=profit;
		this.wt=wt;
	}
	
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name=name;
	}
	
	public int getProfit(){
		return this.profit;
	}
	public void setProfit(int profit){
		this.profit=profit;
	}

	public int getWt(){
		return this.wt;
	}
	public void setWt(int wt){
		this.wt=wt;
	}
}




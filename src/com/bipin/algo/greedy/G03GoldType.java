package com.bipin.algo.greedy;


public class G03GoldType{
	private String goldType = null;
	private int weight = 0;
	private int value = 0;
	private double density = 0.0;
	
	public G03GoldType(String goldType, int weight, int value){
		this.goldType = goldType;
		this.weight = weight;
		this.value = value;
		this.density = value/weight;
	}
	
	public void setGoldType(String goldType){
		this.goldType=goldType;
	}
	public String getGoldType(){
		return this.goldType;
	}

	public void setWeight(int weight){
		this.weight=weight;
	}
	public int getWeight(){
		return this.weight;
	}

	public void setValue(int value){
		this.value=value;
	}
	public int getValue(){
		return this.value;
	}

	public void setDensity(double density){
		this.density=density;
	}
	public double getDensity(){
		return this.density;
	}

	public String toString(){
		return "GoldType= "+goldType+"  Weight: "+weight+"   value: "+value+"   Density: "+density;
	}
}

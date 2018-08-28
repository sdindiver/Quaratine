package com.quarantine.core;

public class Patients {
	private int counter;
	
	public int get(){
		return counter;
	}
	
	public Patients combine(Patients patients){
		this.counter+=patients.counter;
		patients.counter=0;
		return this;
	}
	
	public Patients(int counter){
		System.out.println("master1");
		this.counter=counter;
	}
	
	public void increment(){
		counter++;
	}

}

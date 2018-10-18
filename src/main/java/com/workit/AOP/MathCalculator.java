package com.workit.AOP;

public class MathCalculator {
	public int div(int i,int j){
		System.out.println("MathCalculator.div被调用啦。。。。。");
		return i/j;
	}
}

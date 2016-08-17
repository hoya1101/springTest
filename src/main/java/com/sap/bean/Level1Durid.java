package main.java.com.sap.bean;

import main.java.com.sap.aop.Durid;

public class Level1Durid implements Durid{
	public void castFire(int num) {
		System.out.println("In Level 1 Character, level 1 FireBall casted:" + num);
	}
	public void castStorm() {
		System.out.println("In Level 1 Character, level 1 Storm casted!");
	}
}

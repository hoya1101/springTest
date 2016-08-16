package main.java.com.sap.bean;

import main.java.com.sap.aop.Durid;

// http://docs.spring.io/spring/docs/current/spring-framework-reference/html/classic-aop-spring.html
public class Level10Durid implements Durid{
	public void castFire(int num) {
		System.out.println("In Level 10 Character, level 10 FireBall casted:" + num);
	}
	public void castStorm() {
		System.out.println("In Level 10 Character, level 10 Storm casted!");
	}

}

package org.practice;

import org.testng.annotations.Test;

public class priority {
	@Test(priority=-2, invocationCount=5)
	public void tc01() {
		System.out.println("Test1");
	}
	@Test(priority=0)
public void tc02() {
	System.out.println("Test2");
}
	@Test(priority=-1)
public void tc03() {
	System.out.println("Test3");
}
	@Test(priority=3, enabled=false)
public void tc04() {
	System.out.println("Test4");
}
	@Test(priority=-4)
public void tc05() {
	System.out.println("Test5");
}

}

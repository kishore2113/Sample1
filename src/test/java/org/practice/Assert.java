package org.practice;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class Assert {
		@Test(retryAnalyzer=AutomaticRerun.class)
		public void tc01() {
			String s ="Kishore";
			System.out.println("Test1");
			org.testng.Assert.assertNotEquals(s, "Kihore");
			System.out.println(s);
		}
		@Test(retryAnalyzer=AutomaticRerun.class)
		public void tc02() {
			String s="kishore";
			System.out.println(s);
			assertTrue(false);
			System.out.println("Test2");
		}
		@Test
		public void tc03() {
			System.out.println("Test3");
		}
		@Test
		public void tc04() {
			System.out.println("Test4");
		}
		@Test
		public void tc05() {
			System.out.println("Test5");
		}
	}


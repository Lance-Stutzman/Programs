package edu.nmsu.cs.circles;

import java.beans.Transient;

/***
 * Example JUnit testing class for Circle1 (and Circle)
 *
 * - must have your classpath set to include the JUnit jarfiles - to run the test do: java
 * org.junit.runner.JUnitCore Circle1Test - note that the commented out main is another way to run
 * tests - note that normally you would not have print statements in a JUnit testing class; they are
 * here just so you see what is happening. You should not have them in your test cases.
 ***/

import org.junit.*;


public class Circle1Test
{
	// Data you need for each test case
	private Circle1 circle1;

	//
	// Stuff you want to do before each test case
	//
	@Before
	public void setup()
	{
		System.out.println("\nTest starting...");
		circle1 = new Circle1(1, 2, 3);
	}

	//
	// Stuff you want to do after each test case
	//
	@After
	public void teardown()
	{
		System.out.println("\nTest finished.");
	}

	//
	// Test a simple positive move
	//
	@Test
	public void simpleMove()
	{
		Point p;
		System.out.println("Running test simpleMove.");
		p = circle1.moveBy(1, 1);
		Assert.assertTrue(p.x == 2 && p.y == 3);
		System.out.println(p);
	}

	@Test
	public void positiveMove()
	{
		
		Point p;
		System.out.println("Running Test: Positive Move By");
		p = circle1.moveBy(1.1, 1.1);
		Assert.assertTrue(p.x == 0 && p.y == 1);
		System.out.println(p);
	
	}
	//
	// Test a simple negative move
	//
	@Test
	public void simpleMoveNeg()
	{
		Point p;
		System.out.println("Running test simpleMoveNeg.");
		p = circle1.moveBy(-1, -1);
		Assert.assertTrue(p.x == 0 && p.y == 1);
		System.out.println(p);
	}

	//tests for no intersect
	@Test
	public void noIntersect()
	{
		System.out.println("Running Test: no intersect");

		Circle1 baseCircle = new Circle1(0, 50, 10);
		Circle1 nextCircle = new Circle1(0, 0, 5); 
		Assert.assertFalse(baseCircle.intersects(nextCircle));
		Assert.assertFalse(nextCircle.intersects(baseCircle));

		baseCircle = new Circle1(1, 10, 2.99);
		nextCircle = new Circle1(1, 5, 5); 
		Assert.assertFalse(baseCircle.intersects(nextCircle));
		Assert.assertFalse(nextCircle.intersects(baseCircle));
	}

	@Test
	public void overlap()
	{

		System.out.println("Running Test: Overlap");

		Circle1 baseCircle = new Circle1(0, 0, 10);
		Circle1 nextCircle = new Circle1(0, 0, 10); 
		Assert.assertFalse(baseCircle.intersects(nextCircle));
		Assert.assertFalse(nextCircle.intersects(baseCircle));

	}

	@Test

	public void intersectAtOnePoint()
	{
		System.out.println("Running Test: IntersectAtOnePoint");

		System.out.println("intersectAtOnePoint - on x axis");
		Circle1 baseCircle = new Circle1(0,0,3);
		Circle1 nextCircle = new Circle1(7, 0, 4);
		Assert.assertTrue(baseCircle.intersects(nextCircle));
		Assert.assertTrue(nextCircle.intersects(baseCircle));
	}

	@Test
	public void scaleTest() 
	{
		double r=2; 
		System.out.println("Running Test: Scale");
		r = circle1.scale(2);
		Circle1 baseCircle = new Circle1(1, 1, r);

	}

	/***
	 * NOT USED public static void main(String args[]) { try { org.junit.runner.JUnitCore.runClasses(
	 * java.lang.Class.forName("Circle1Test")); } catch (Exception e) { System.out.println("Exception:
	 * " + e); } }
	 ***/

}

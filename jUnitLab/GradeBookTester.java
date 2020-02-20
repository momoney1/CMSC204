package jUnitLab;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class GradeBookTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	GradeBook book1;
	GradeBook book2;
	@Before
	public void setUp() throws Exception {
		book1 = new GradeBook(5);
		book2 = new GradeBook(5);
		book1.addScore(7);
		book1.addScore(8);
		book2.addScore(9);
		book2.addScore(5);
	}

	@After
	public void tearDown() throws Exception {
		book1 = null;
		book2 = null;
	}

	@Test
	public void testSum() {
		assertTrue(15 == book1.sum());
	}
	public void testSize() {
		assertEquals(2, book1.getScoreSize());
	}
	public void testMinimum() {
		assertTrue(7 == book1.minimum());
	}
	public void addScoreTest() {
		assertTrue('7' == (book1.toString().charAt(0)));
		assertTrue('8' == (book1.toString().charAt(1)));
	}
	public void finalScoreTest() {
		assertTrue(8 == book1.finalScore());
	}

}

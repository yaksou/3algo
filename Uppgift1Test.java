package inlämningsuppgift3;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

public class Uppgift1Test {

	Integer[] array1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	Integer[] array2 = { 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 };

	@Test
	public void testsearch() {
		Assert.assertTrue(Uppgift1.beginSearch(array1, 5) == 4);
		Assert.assertTrue(Uppgift1.beginSearch(array1, 9) == 8);

	}

	@Test
	public void testfindIndex() {
		Assert.assertTrue(Uppgift1.beginSearch(array2, 22) == 14);
		Assert.assertTrue(Uppgift1.beginSearch(array2, 30) == 22);
	}

}

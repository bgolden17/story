import static org.junit.Assert.*;
import java.io.*;
import java.util.Scanner;

import org.junit.*;
import org.junit.jupiter.api.Test;

public class Tests {
	private final InputStream systemIn = System.in;
	private final PrintStream systemOut = System.out;

	private ByteArrayInputStream testIn;
	private ByteArrayOutputStream testOut;
	private Scanner scnr;

	@Test
	public void testCase1() {
		boolean expected = true;
		boolean actual = Validator.isValidCardCvv("134");
		assertEquals(expected, actual);
	}

	@Test
	public void testCase2() {
		boolean expected = false;
		boolean actual = Validator.isValidCardCvv("invalid");
		assertEquals(expected, actual);
	}

	@Test
	public void testCase3() {
		boolean expected = true;
		boolean actual = Validator.isValidCardExp("10/01");
		assertEquals(expected, actual);
	}

	@Test
	public void testCase4() {
		boolean expected = false;
		boolean actual = Validator.isValidCardExp("ab/cd");
		assertEquals(expected, actual);
	}

	@Test
	public void testCase5() {
		boolean expected = false;
		boolean actual = Validator.isValidCardExp("10/");
		assertEquals(expected, actual);
	}
}
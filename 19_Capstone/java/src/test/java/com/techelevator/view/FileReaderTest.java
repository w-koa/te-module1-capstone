package com.techelevator.view;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FileReaderTest {
		


	@Test
	public void testFileReaderMethod_empty() throws FileNotFoundException {
		FileReader test = new FileReader();
		List<Item> actual = test.fileReader("test.csv");
		List<Item> expected = new ArrayList<>();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFileReaderMethod_with_one_line() throws FileNotFoundException {
		FileReader test = new FileReader();
		List<Item> actual = test.fileReader("test_one_line.csv");
		List<Item> expected = new ArrayList<>();
		String [] array = {"D2","Little League Chew", "0.95", "Gum"};
		expected.add(new Gum(array));
		assertEquals(expected, actual);
	}

	
//	expected.add(new Chip())
}

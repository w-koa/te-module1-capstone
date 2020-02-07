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
	public void testFileReaderMethod_with_one_gum() throws FileNotFoundException {
		FileReader test = new FileReader();
		List<Item> actual = test.fileReader("test_one_line.csv");
		List<Item> expected = new ArrayList<>();
		String [] array = {"D2","Little League Chew", "0.95", "Gum"};
		expected.add(new Gum(array));
		assertEquals(expected.get(0).getName(), actual.get(0).getName());
	}

	@Test
	public void testFileReaderMethod_with_one_chip() throws FileNotFoundException {
		FileReader test = new FileReader();
		List<Item> actual = test.fileReader("testchip.csv");
		List<Item> expected = new ArrayList<>();
		String [] array = {"A1", "Potato Crisps", "3.05", "Chip"};
		expected.add(new Chip(array));
		assertEquals(expected.get(0).getName(), actual.get(0).getName());
	}
	
	@Test
	public void testFileReaderMethod_with_one_candy() throws FileNotFoundException {
		FileReader test = new FileReader();
		List<Item> actual = test.fileReader("testcandy.csv");
		List<Item> expected = new ArrayList<>();
		String [] array = {"B1", "Moonpie", "1.80", "Candy"};
		expected.add(new Candy(array));
		assertEquals(expected.get(0).getName(), actual.get(0).getName());
	}
	
	@Test
	public void testFileReaderMethod_with_one_drink() throws FileNotFoundException {
		FileReader test = new FileReader();
		List<Item> actual = test.fileReader("testdrink.csv");
		List<Item> expected = new ArrayList<>();
		String [] array = {"C1", "Cola", "1.25", "Drink"};
		expected.add(new Drink(array));
		assertEquals(expected.get(0).getName(), actual.get(0).getName());
	}
//	expected.add(new Chip())
}

package com.dev.files;

import java.io.FileReader;

import com.opencsv.CSVReader;

public class ReadCSV {

	public static void main(String[] args) {
		try {

			// Create an object of filereader
			// class with CSV file as a parameter.
			FileReader filereader = new FileReader("C:\\Users\\mail2\\Documents\\Downloads\\addresses.csv");

			// create csvReader object passing
			// file reader as a parameter
			CSVReader csvReader = new CSVReader(filereader);
			String[] nextRecord;

			// we are going to read data line by line
			while ((nextRecord = csvReader.readNext()) != null) {
				for (String cell : nextRecord) {
					System.out.print(cell + "\t");
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

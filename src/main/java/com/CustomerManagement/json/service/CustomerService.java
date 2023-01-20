package com.CustomerManagement.json.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.CustomerManagement.json.payload.Customer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class CustomerService {
	public static void main(String[] args) {
		Customer cus = new Customer("Sanjeev", "Kumar", "sanjeev12@gmail.com", 8878242502L);

		// Java Class to Json Object - Serialized

		// Gson gson = new Gson()

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String string = gson.toJson(cus);
		System.out.println(string);

		// Json Object to Java Class - Deserialized
		gson.fromJson(string, Customer.class);
		System.out.println(cus.getFirstName());
		System.out.println(cus.getLastName());
		System.out.println(cus.getEmail());
		System.out.println(cus.getMobile());

		readFile("E:\\json\\jsonfile.json");
		writeFile(new Customer("Vikram", "Singh", "vikram34@gmail.com", 8978767656L));

	}
	// FILE READER

	public static void readFile(String fileAddress) {
		// Gson gson = new Gson();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try {
			Customer cus = gson.fromJson(new FileReader(fileAddress), Customer.class);
			System.out.println(gson.toJson(cus));
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// FILE WRITER
	private static void writeFile(Customer cus) {
		//Gson gson = new Gson();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		try {
			FileWriter writer = new FileWriter("E:\\json\\jsonfileWrite.json");
			gson.toJson(cus, writer);
			writer.close();
			System.out.println("Write Success");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

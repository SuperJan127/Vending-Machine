package com.techelevator;

import java.io.FileNotFoundException;

public class Application {

	public static void main(String[] args) throws FileNotFoundException {
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.displayMenu();

	}
}

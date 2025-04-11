package com.techelevator;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Application {

	public static void main(String[] args) throws IOException {
		VendingMachine vendingMachine = new VendingMachine();

		InventoryLog.newInventory.createItems();
		InventoryLog.newInventory.createInventoryMap();
		InventoryLog.createMap();
		vendingMachine.displayMenu();

	}
}

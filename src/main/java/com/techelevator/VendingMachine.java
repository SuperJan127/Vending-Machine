package com.techelevator;

import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



public class VendingMachine {

    private Inventory inventory = new Inventory();
    private String filePath;
    public VendingMachine() throws FileNotFoundException {
        inventory.createItems();
    }
    private Scanner keyboard = new Scanner(System.in);

    public void displayMenu() throws IOException {
        String choice;
        do {
            System.out.println("*************************************");
            System.out.println("(1) Display Vending Machine Items");
            System.out.println("(2) Purchase");
            System.out.println("(3) Exit");
            System.out.println("*************************************");
            choice = keyboard.nextLine();
            try {
                if (choice.equals("1")) {
                    for (Item item : inventory.getItems()) {
                        System.out.println(item.getLocation() + " " + item.getName() + " $" + item.getPrice() + " Qty. Remaining " + item.getQuantity());
                    }

                }
                if (choice.equals("2")) {
                    Transaction transaction = new Transaction();
                    String selection = "";
                    do {
                        System.out.println("*************************************");
                        System.out.println("Current Money Provided: $" + transaction.getBalance());
                        System.out.println("(1) Feed Money");
                        System.out.println("(2) Select Product");
                        System.out.println("(3) Finish Transaction");
                        System.out.println("*************************************");
                        selection = keyboard.nextLine();
                        try {
                            if (selection.equals("1")) {
                                System.out.println("Enter amount to add (in dollar amount): ");
                                String moneyAdded = keyboard.nextLine();
                                BigDecimal moneyAddedBigDecimal = new BigDecimal(moneyAdded);
                                transaction.addMoney(moneyAddedBigDecimal);
                                TransactionLog.writeLog("FEED MONEY:", moneyAddedBigDecimal, transaction.getBalance());
                            }
                            if (selection.equals("2")) {


                                try {
                                    Map<String, Item> itemMap = inventory.createInventoryMap();
                                    for (Item item : inventory.getItems()) {
                                        System.out.println(item.getLocation() + " " + item.getName() + " $" + item.getPrice() + " Qty. Remaining " + item.getQuantity());
                                    }
                                    System.out.println("*************************************");
                                    System.out.println("Current Balance is: $" + transaction.getBalance());
                                    System.out.println("Enter Location of item to purchase: ");
                                    String itemChosen = keyboard.nextLine();
                                    Item chosenItem = itemMap.get(itemChosen);
                                    if (transaction.getBalance().compareTo(chosenItem.getPrice()) < 0){
                                        System.out.println("Insufficient funds, please add more money ");
                                    } else if(!itemMap.containsKey(itemChosen)) {
                                        System.out.println("Invalid Location. Please Choose Again.");
                                    } else if(chosenItem.getQuantity() == 0){
                                        System.out.println("Item is Sold Out. Please Choose Another Item.");
                                    } else {
                                            transaction.useMoney(chosenItem.getPrice());
                                            System.out.println(chosenItem.getName() + " purchased for $" + chosenItem.getPrice() +
                                                    ". Remaining Balance is $" + transaction.getBalance());
                                            System.out.println(chosenItem.getDispenseMessage());
                                            chosenItem.setQuantity(chosenItem.getQuantity() - 1);
                                            TransactionLog.writeLog(chosenItem.getName() + " " + chosenItem.getLocation(), chosenItem.getPrice(), transaction.getBalance());
                                            InventoryLog.writeLog(chosenItem.getName(), chosenItem.getPrice());
                                            filePath = InventoryLog.getFilePathName();

                                    }
                                } catch (Exception e) {


                                }
                            }
                            if (selection.equals("3")) {
                                BigDecimal quarter = new BigDecimal(".25");
                                BigDecimal dime = new BigDecimal(".1");
                                BigDecimal nickel = new BigDecimal(".05");
                                BigDecimal tempBalance = transaction.getBalance();

                                BigDecimal quarters = (transaction.getBalance().divide(quarter).setScale(0, RoundingMode.DOWN));
                                transaction.useMoney(quarters.multiply(quarter));
                                BigDecimal dimes = (transaction.getBalance().divide(dime).setScale(0, RoundingMode.DOWN));
                                transaction.useMoney(dimes.multiply(dime));
                                BigDecimal nickels = (transaction.getBalance().divide(nickel).setScale(0, RoundingMode.DOWN));
                                transaction.useMoney(nickels.multiply(nickel));
                                System.out.println("Your change is: " + quarters + " Quarter(s) " + dimes + " Dime(s) " + nickels + " Nickel(s) ");
                                TransactionLog.writeLog("GIVE CHANGE:", tempBalance, transaction.getBalance());

                            }

                        } catch (Exception e) {
                            System.out.println("Invalid Selection. Please Select Again.");
                        }

                    } while (!selection.equals("3"));
                }
                if(choice.equals("4")){
                    try {
                        Scanner fileScanner = new Scanner(new File(filePath));
                        while (fileScanner.hasNextLine()){
                            System.out.println(fileScanner.nextLine());
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                }
            } catch (Exception e){
                System.out.println("Invalid Selection. Please Select Again.");
            }
        } while (!choice.equals("3"));

        keyboard.close();
    }

}

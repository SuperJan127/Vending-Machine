package com.techelevator;

import org.w3c.dom.ls.LSOutput;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {

    private Inventory inventory = new Inventory();
    public VendingMachine() throws FileNotFoundException {
        inventory.createItems();
    }
    private Scanner keyboard = new Scanner(System.in);

    public void displayMenu(){
        System.out.println("(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");
        String choice = keyboard.nextLine();
        if(choice.equals("1")){
            for(Item item : inventory.getItems()){
                System.out.println(item.getLocation() + " " + item.getName() + " $" + item.getPrice() + " Qty. Remaining " + item.getQuantity());
            }

        }
        if(choice.equals("2")){
            Transaction transaction = new Transaction();
            String selection = "";
            do {
                System.out.println("Current Money Provided: $" +transaction.getBalance());
                System.out.println("(1) Feed Money");
                System.out.println("(2) Select Product");
                System.out.println("(3) Finish Transaction");
                selection = keyboard.nextLine();
                if(selection.equals("1")) {
                    System.out.println("Enter amount to add (in dollar amount): ");
                    String moneyAdded = keyboard.nextLine();
                    Double moneyAddedDouble = Double.parseDouble(moneyAdded);

                    transaction.addMoney(moneyAddedDouble);
                }
                if(selection.equals("2")){
                    if(transaction.getBalance() == 0){
                        System.out.println("Please add money: ");
                    } else {
                        Map<String, Item> itemMap = inventory.createInventoryMap();
                        System.out.println("Enter Location of item to purchase: ");
                        String itemChosen = keyboard.nextLine();
                        Item chosenItem = itemMap.get(itemChosen);
                        transaction.useMoney(chosenItem.getPrice());
                        System.out.println(chosenItem.getDispenseMessage());
                        chosenItem.setQuantity(chosenItem.getQuantity() - 1);
                    }
                }
                if(selection.equals("3")){

                    int quarters = (int)(transaction.getBalance() / .25);
                    transaction.useMoney(quarters * .25);
                    int dimes = (int)(transaction.getBalance() / .10);
                    transaction.useMoney(dimes * .10);
                    int nickels = (int)(transaction.getBalance() / .05);
                    transaction.useMoney(nickels * .05);
                    System.out.println("Your change is: " + quarters + " Quarter(s) " + dimes + " Dime(s) " + nickels + " Nickel(s) ");


                }

            } while(!selection.equals("3"));
        }
    }
}

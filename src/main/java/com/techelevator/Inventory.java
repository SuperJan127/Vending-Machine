package com.techelevator;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    private final String DIVIDER = "\\|";
    private final String INPUT_FILE = "vendingmachine.csv";

    public List<Item> getItems() {
        return items;
    }

    private List<Item> items = new ArrayList<>();

    public List createItems() throws FileNotFoundException {
        File inventoryData = new File(INPUT_FILE);
        try(Scanner filereader = new Scanner(inventoryData)){
            while(filereader.hasNext()){
                String line = filereader.nextLine();
                String[] lineParts = line.split(DIVIDER);
                String location = lineParts[0];
                String name = lineParts[1];
                String price = lineParts[2];
                Double priceAsDouble = Double.parseDouble(price);
                String type = lineParts[3];
                if(type.equals("Chip")){
                  items.add(new Chip(name, priceAsDouble, location));

                } else if ( type.equals("Candy")){
                    items.add(new Candy(name, priceAsDouble, location));
                } else if ( type.equals("Drink")){
                    items.add(new Drink(name, priceAsDouble, location));
                } else{
                   items.add(new Gum(name, priceAsDouble, location));
                }

            }


        }
        return items;
    }


}

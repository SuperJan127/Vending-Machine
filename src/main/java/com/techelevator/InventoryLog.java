package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class InventoryLog {


    static String filePathName;
    static BigDecimal totalSales = new BigDecimal("0");
    static Map<String, Integer> inventoryLogMap = new HashMap<>();
    static Inventory newInventory = new Inventory();
    static Map<String, Item> newInventoryMap = newInventory.createInventoryMap();
    public static String getFilePathName() {
        return filePathName;
    }

    public static BigDecimal getTotalSales() {
        return totalSales;
    }
    public static Map<String, Integer> createMap(){
        for (Map.Entry<String, Item> item : newInventoryMap.entrySet()){
            inventoryLogMap.put(item.getValue().getName(), 0);
        }
        return inventoryLogMap;
    }
    public static String writeLog(String itemName, BigDecimal price) throws IOException {
        totalSales = totalSales.add(price);
        for(Map.Entry<String, Integer> item : inventoryLogMap.entrySet()){
            if (item.getKey().equals(itemName)){
                inventoryLogMap.put(itemName, item.getValue() + 1);
            }
        }
        String directoryName = "data";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String timeStamp = LocalDateTime.now().format(formatter);
        String fileName = timeStamp + " inventoryLog.txt";
        File logDirectory = new File(directoryName);

        if(!logDirectory.exists()){
            logDirectory.mkdir();
        }
        String filePath = directoryName + "\\" + fileName;
        File inventoryFile = new File(filePath);

        try (PrintWriter writer = new PrintWriter(inventoryFile)) {
            for (Map.Entry<String, Integer> item : inventoryLogMap.entrySet()) {
                writer.println(item.getKey() + " | " + item.getValue());
            }
            writer.println("**Total Sales** $" + totalSales);
        }

        filePathName = filePath;

        return filePathName;
    }

}

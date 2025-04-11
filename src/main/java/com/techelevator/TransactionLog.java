package com.techelevator;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionLog {
    public static void writeLog(String description, BigDecimal transactionAmount, BigDecimal newBalance) throws IOException {
        String directoryName = "data";
        String filename = "transactionLog.txt";
        File logDirectory = new File(directoryName);
        if(!logDirectory.exists()){
        logDirectory.mkdir();
        }
        String temp = directoryName + "\\" + filename;
        try(FileOutputStream outputStream = new FileOutputStream(temp, true);
            PrintWriter writer = new PrintWriter(outputStream)){
            writer.println(LocalDateTime.now() + " " + description + " $" + transactionAmount + " $" + newBalance);
            } catch (IOException e) {

        }

    }

}

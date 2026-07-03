package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UTRGenerator {

    // Counter for unique UTR numbers
    private static int counter = 1;

    // Generate UTR
    public static String generateUTR() {

        String date = LocalDate.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        String sequence = String.format("%06d", counter++);

        return "SBI" + date + sequence;
    }
}
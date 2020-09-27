package com.tadas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {

        printBonusDatesBetween(2010, 2015);
    }

    static void printBonusDatesBetween(int fromYear, int toYear) {

        if (fromYear < 0|| toYear < 0) {
            System.out.println("Invalid year number");
        } else {
            LocalDate startDate = LocalDate.of(fromYear, 1, 1);
            LocalDate endDate = LocalDate.of(toYear - 1, 12, 31);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            DateTimeFormatter formatterDash = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)) {

                String dateFormatted = date.format(formatter);

                if (dateFormatted.compareTo(new StringBuilder(dateFormatted).reverse().toString()) == 0) {
                    System.out.println(date.format(formatterDash));
                }
            }
        }
    }
}

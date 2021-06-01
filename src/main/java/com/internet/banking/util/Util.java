package com.internet.banking.util;

import com.internet.banking.services.exceptions.FormatoDataException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public final class Util {

    public static LocalDate parseData(String data) {
        try {
            return LocalDate.parse(data, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (DateTimeParseException dtpe) {
            throw new FormatoDataException(data);
        }
    }

    public static double parseValue(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException nfe) {
            return 0.0;
        }
    }
}

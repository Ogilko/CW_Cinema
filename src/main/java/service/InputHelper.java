package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

public class InputHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static Optional<String> getInputString() {
        try {
            String result = reader.readLine();
            if ((result != null) && (!result.isEmpty())) {
                return Optional.of(result);
            } else {
                return Optional.empty();
            }
        } catch (IOException e) {
            System.out.println("Something wrong, try again");
            return Optional.empty();
        }
    }

    public static Optional<Integer> getInputInteger() {
        Optional<String> input = getInputString();
        if (input.isPresent()) {
            try {
                return Optional.of(Integer.parseInt(input.get()));
            } catch (NumberFormatException e) {
                System.out.println("Entered value was not number");
                return Optional.empty();
            }
        } else {
            return Optional.empty();
        }
    }

    public static Optional<LocalDate> getInputDate(String pattern) {
        Optional<String> input = getInputString();
        if (input.isPresent()) {
            try {
                return Optional.of(LocalDate.parse(input.get(), DateTimeFormatter.ofPattern(pattern)));
            } catch (DateTimeParseException e) {
                System.out.println("Entered value was not valid date in format " + pattern);
                return Optional.empty();
            }
        } else {
            return Optional.empty();
        }
    }

}

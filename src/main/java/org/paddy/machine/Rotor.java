package org.paddy.machine;

import org.apache.log4j.Logger;

import java.util.AbstractMap;
import java.util.Map;

public class Rotor {
    private static final Logger LOGGER = Logger.getLogger(Rotor.class);
    private static final Map<String, String> rotor1default = Map.ofEntries(
            new AbstractMap.SimpleEntry<>("A", "T"),//65
            new AbstractMap.SimpleEntry<>("B", "A"),
            new AbstractMap.SimpleEntry<>("C", "G"),//67
            new AbstractMap.SimpleEntry<>("D", "B"),
            new AbstractMap.SimpleEntry<>("E", "P"),
            new AbstractMap.SimpleEntry<>("F", "C"),//70
            new AbstractMap.SimpleEntry<>("G", "S"),
            new AbstractMap.SimpleEntry<>("H", "D"),
            new AbstractMap.SimpleEntry<>("I", "Q"),
            new AbstractMap.SimpleEntry<>("J", "E"),
            new AbstractMap.SimpleEntry<>("K", "U"),//75
            new AbstractMap.SimpleEntry<>("L", "F"),
            new AbstractMap.SimpleEntry<>("M", "V"),
            new AbstractMap.SimpleEntry<>("N", "N"),
            new AbstractMap.SimpleEntry<>("O", "Z"),
            new AbstractMap.SimpleEntry<>("P", "H"),//80
            new AbstractMap.SimpleEntry<>("Q", "Y"),
            new AbstractMap.SimpleEntry<>("R", "I"),
            new AbstractMap.SimpleEntry<>("S", "X"),//83
            new AbstractMap.SimpleEntry<>("T", "J"),//84
            new AbstractMap.SimpleEntry<>("U", "W"),//85
            new AbstractMap.SimpleEntry<>("V", "L"),//86
            new AbstractMap.SimpleEntry<>("W", "R"),//87
            new AbstractMap.SimpleEntry<>("X", "K"),//88
            new AbstractMap.SimpleEntry<>("Y", "O"),//89
            new AbstractMap.SimpleEntry<>("Z", "M")//90
    );
    private static final Map<String, String> rotor2default = Map.ofEntries(
            new AbstractMap.SimpleEntry<>("A", "A"),//65
            new AbstractMap.SimpleEntry<>("B", "J"),
            new AbstractMap.SimpleEntry<>("C", "P"),//67
            new AbstractMap.SimpleEntry<>("D", "C"),
            new AbstractMap.SimpleEntry<>("E", "Z"),
            new AbstractMap.SimpleEntry<>("F", "W"),//70
            new AbstractMap.SimpleEntry<>("G", "R"),
            new AbstractMap.SimpleEntry<>("H", "L"),
            new AbstractMap.SimpleEntry<>("I", "F"),
            new AbstractMap.SimpleEntry<>("J", "B"),
            new AbstractMap.SimpleEntry<>("K", "D"),//75
            new AbstractMap.SimpleEntry<>("L", "K"),
            new AbstractMap.SimpleEntry<>("M", "O"),
            new AbstractMap.SimpleEntry<>("N", "T"),
            new AbstractMap.SimpleEntry<>("O", "Y"),
            new AbstractMap.SimpleEntry<>("P", "U"),//80
            new AbstractMap.SimpleEntry<>("Q", "Q"),
            new AbstractMap.SimpleEntry<>("R", "G"),
            new AbstractMap.SimpleEntry<>("S", "E"),//83
            new AbstractMap.SimpleEntry<>("T", "N"),//84
            new AbstractMap.SimpleEntry<>("U", "H"),//85
            new AbstractMap.SimpleEntry<>("V", "X"),//86
            new AbstractMap.SimpleEntry<>("W", "M"),//87
            new AbstractMap.SimpleEntry<>("X", "I"),//88
            new AbstractMap.SimpleEntry<>("Y", "V"),//89
            new AbstractMap.SimpleEntry<>("Z", "S")//90
    );
    private static final Map<String, String> rotor3default = Map.ofEntries(
            new AbstractMap.SimpleEntry<>("A", "U"),//65
            new AbstractMap.SimpleEntry<>("B", "W"),
            new AbstractMap.SimpleEntry<>("C", "Y"),//67
            new AbstractMap.SimpleEntry<>("D", "G"),
            new AbstractMap.SimpleEntry<>("E", "A"),
            new AbstractMap.SimpleEntry<>("F", "D"),//70
            new AbstractMap.SimpleEntry<>("G", "F"),
            new AbstractMap.SimpleEntry<>("H", "P"),
            new AbstractMap.SimpleEntry<>("I", "V"),
            new AbstractMap.SimpleEntry<>("J", "Z"),
            new AbstractMap.SimpleEntry<>("K", "B"),//75
            new AbstractMap.SimpleEntry<>("L", "E"),
            new AbstractMap.SimpleEntry<>("M", "C"),
            new AbstractMap.SimpleEntry<>("N", "K"),
            new AbstractMap.SimpleEntry<>("O", "M"),
            new AbstractMap.SimpleEntry<>("P", "T"),//80
            new AbstractMap.SimpleEntry<>("Q", "H"),
            new AbstractMap.SimpleEntry<>("R", "X"),
            new AbstractMap.SimpleEntry<>("S", "S"),//83
            new AbstractMap.SimpleEntry<>("T", "L"),//84
            new AbstractMap.SimpleEntry<>("U", "R"),//85
            new AbstractMap.SimpleEntry<>("V", "I"),//86
            new AbstractMap.SimpleEntry<>("W", "N"),//87
            new AbstractMap.SimpleEntry<>("X", "Q"),//88
            new AbstractMap.SimpleEntry<>("Y", "O"),//89
            new AbstractMap.SimpleEntry<>("Z", "J")//90
    );
    private final int number;
    private final String initialLetter;

    public Rotor(int number, String initialLetter) {
        this.number = number;
        this.initialLetter = initialLetter;
        LOGGER.info("Creating Rotor with letter: " + this.initialLetter);
        int asciiVal = (int) initialLetter.charAt(0);
        switch (number) {
            case 0:
                slideRotator1(asciiVal);
                break;
            case 1:
                slideRotator2(asciiVal);
                break;
            case 2:
                slideRotator3(asciiVal);
                break;
            default:
                break;
        }
    }

    void slideRotator1(int asciiVal) {
        LOGGER.info("Sliding rotator: " + asciiVal);
        int j = 91 - (asciiVal - 65);
        for (int i = 65; i <= 90; i++) {
            j = j > 90 ? 65 : j;
            System.out.println(Character.toString((char) i) + " " + rotor1default.get(Character.toString((char) j)));
            j++;
        }
    }

    void slideRotator2(int asciiVal) {
        LOGGER.info("Sliding rotator: " + asciiVal);
        int j = 91 - (asciiVal - 65);
        for (int i = 65; i <= 90; i++) {
            j = j > 90 ? 65 : j;
            System.out.println(Character.toString((char) i) + " " + rotor2default.get(Character.toString((char) j)));
            j++;
        }
    }

    void slideRotator3(int asciiVal) {
        LOGGER.info("Sliding rotator: " + asciiVal);
        int j = 91 - (asciiVal - 65);
        for (int i = 65; i <= 90; i++) {
            j = j > 90 ? 65 : j;
            System.out.println(Character.toString((char) i) + " " + rotor3default.get(Character.toString((char) j)));
            j++;
        }
    }
}

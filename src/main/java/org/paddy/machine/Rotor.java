package org.paddy.machine;

import org.apache.log4j.Logger;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
    private final Map<String, String> rotatorEncode = new HashMap<>();
    private final Map<String, String> rotatorDecode = new HashMap<>();
    public static final String SLIDING_ROTATOR = "Sliding rotator: ";
    private final int number;
    private final String initialLetter;

    public Rotor(int number, String initialLetter) {
        this.number = number;
        this.initialLetter = initialLetter;
        LOGGER.info("Creating Rotor with letter: " + number + " " + this.initialLetter);
        initRotor();
    }

    int setLetter(int lastOffset) {
        lastOffset = lastOffset > 26 ? lastOffset - 26 : lastOffset;
        int offset = (((int) this.initialLetter.charAt(0)) - 65) - lastOffset;
        offset = offset < 0 ? offset + 26 : offset;
        LOGGER.info(SLIDING_ROTATOR + offset);
        rotateRotator(offset);
        return offset;
    }

    void initRotor() {
        switch (this.number) {
            case 0:
                this.rotatorEncode.putAll(rotor1default
                        .entrySet()
                        .stream()
                        .collect((Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey))));
                break;
            case 1:
                this.rotatorEncode.putAll(rotor2default
                        .entrySet()
                        .stream()
                        .collect((Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey))));
                break;
            case 2:
                this.rotatorEncode.putAll(rotor3default
                        .entrySet()
                        .stream()
                        .collect((Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey))));
                break;
            default:
                LOGGER.fatal("Should not happen!");
                System.exit(-1);
                break;
        }
    }

    void rotateRotator(int offset) {
        //LOGGER.info("Offset: " + offset);
        final Map<String, String> rotatorEncodeNew = new HashMap<>();
        String newEncode;
        int j;
        for (int i = 65; i <= 90; i++) {
            j = i + offset > 90 ? (i + offset) - 26 : i + offset;
            j = j < 65 ? j + 26 : j;
            rotatorEncodeNew.put(Character.toString((char) i), this.rotatorEncode.get(Character.toString((char) j)));
        }
        this.rotatorEncode.clear();
        this.rotatorEncode.putAll(rotatorEncodeNew);
        this.rotatorDecode.putAll(this.rotatorEncode
                .entrySet()
                .stream()
                .collect((Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey))));
    }

    void showCurrentRotatorMapping() {
        LOGGER.info("Current Rotator:");
        rotatorDecode.forEach((k, v) -> System.out.println((k + ":" + v)));
        System.out.println("----");
        rotatorEncode.forEach((k, v) -> System.out.println((k + ":" + v)));
        System.out.println("----");
    }

    public String encryptLetter(String letter) {
        return this.rotatorEncode.get(letter);
    }
}

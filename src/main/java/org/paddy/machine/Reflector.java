package org.paddy.machine;

import java.util.AbstractMap;
import java.util.Map;

public class Reflector {
    private static final Map<String, String> reflector = Map.ofEntries(
            new AbstractMap.SimpleEntry<>("A", "Y"),//65
            new AbstractMap.SimpleEntry<>("B", "R"),
            new AbstractMap.SimpleEntry<>("C", "U"),//67
            new AbstractMap.SimpleEntry<>("D", "H"),
            new AbstractMap.SimpleEntry<>("E", "Q"),
            new AbstractMap.SimpleEntry<>("F", "S"),//70
            new AbstractMap.SimpleEntry<>("G", "L"),
            new AbstractMap.SimpleEntry<>("H", "D"),
            new AbstractMap.SimpleEntry<>("I", "P"),
            new AbstractMap.SimpleEntry<>("J", "X"),
            new AbstractMap.SimpleEntry<>("K", "N"),//75
            new AbstractMap.SimpleEntry<>("L", "G"),
            new AbstractMap.SimpleEntry<>("M", "O"),
            new AbstractMap.SimpleEntry<>("N", "K"),
            new AbstractMap.SimpleEntry<>("O", "M"),
            new AbstractMap.SimpleEntry<>("P", "I"),//80
            new AbstractMap.SimpleEntry<>("Q", "E"),
            new AbstractMap.SimpleEntry<>("R", "B"),
            new AbstractMap.SimpleEntry<>("S", "F"),//83
            new AbstractMap.SimpleEntry<>("T", "Z"),//84
            new AbstractMap.SimpleEntry<>("U", "C"),//85
            new AbstractMap.SimpleEntry<>("V", "W"),//86
            new AbstractMap.SimpleEntry<>("W", "V"),//87
            new AbstractMap.SimpleEntry<>("X", "J"),//88
            new AbstractMap.SimpleEntry<>("Y", "A"),//89
            new AbstractMap.SimpleEntry<>("Z", "T")//90
    );
}

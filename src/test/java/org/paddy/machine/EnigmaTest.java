package org.paddy.machine;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EnigmaTest {
    private final String[] dog = new String[]{"G", "O", "D"};
    private final String[] cat = new String[]{"T", "A", "C"};

    @Test
    void enigmaInitDogTest() {
        Rotor[] rotors = new Rotor[3];
        for (int i = 0; i < dog.length; i++) {
            rotors[i] = new Rotor(i, dog[i]);
        }
        Enigma enigma = new Enigma(rotors);
        assertThat(enigma).isNotNull();
        enigma.encrypt("ENIGMA");
        enigma.decrypt("GSPHDX");//DOG
    }

    @Test
    void enigmaInitCatTest() {
        Rotor[] rotors = new Rotor[3];
        for (int i = 0; i < cat.length; i++) {
            rotors[i] = new Rotor(i, cat[i]);
        }
        Enigma enigma = new Enigma(rotors);
        assertThat(enigma).isNotNull();
        enigma.encrypt("ENIGMA");
        enigma.decrypt("QTRMGS");//CAT
    }
}

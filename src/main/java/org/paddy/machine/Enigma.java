package org.paddy.machine;

public class Enigma {
    private Keyboard keyboard;
    private Reflector reflector;
    private Rotor[] rotors;
    public Enigma(Rotor[] rotors) {
        this.rotors = rotors;
        this.keyboard = new Keyboard();
        this.reflector= new Reflector();
    }
    public void encrypt(String text) {

    }
    public void decrypt(String encrypted) {

    }
}

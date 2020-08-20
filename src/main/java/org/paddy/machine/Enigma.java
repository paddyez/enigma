package org.paddy.machine;

public class Enigma {
    //private Keyboard keyboard;
    private Reflector reflector;
    private Rotor[] rotors;

    public Enigma(Rotor[] rotors) {
        this.rotors = rotors;
        //this.keyboard = new Keyboard();
        this.reflector = new Reflector();
        setCode();
    }

    void setCode() {
        int lastOffset = 0;
        for (int i = 0; i < rotors.length; i++) {
            lastOffset += this.rotors[i].setLetter(lastOffset);
        }
    }

    public void encrypt(String text) {
        for(int i = 0; i < text.length(); i++) {
            String letter = Character.toString(text.charAt(i));
            System.out.println("Encrypt: " + letter);
            rotors[0].rotateRotator(1);
            rotors[1].rotateRotator(-1);
            //rotors[2].rotateRotator(26);
            for (int j = 0; j < rotors.length; j++) {
                letter = rotors[j].encryptLetter(letter);
                System.out.println("Rotator: " + j + " new " + letter);
            }
        }
        //rotors[0].showCurrentRotatorMapping();
    }

    public void decrypt(String encrypted) {

    }
}

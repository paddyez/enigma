package org.paddy.machine;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.paddy.App.LETTERSET;

class RotorTest {
    @Test
    void rotorInitTest() {
        int i = 0;
        assertThat(LETTERSET.size()).isEqualTo(26);
        for (String letter : LETTERSET) {
            i = i > 2 ? 0 : i;
            Rotor rotor = new Rotor(i, letter);
            assertThat(rotor).isNotNull();
            i++;
        }
    }
}

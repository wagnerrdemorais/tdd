package com.morais.wagner.tdd.exercicios;

import com.morais.wagner.tdd.exercicios.Multiplos;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class MultiplosTest {

    @Test
    public void multiplosOuTest() {
        Multiplos multiplos = new Multiplos();

        int a = 3;
        int b = 5;
        int delta = 0;

        int res10 = multiplos.multiplosOu(10, a, b);
        assertEquals(23, res10, delta);

        int res1000 = multiplos.multiplosOu(1000, a, b);
        assertEquals(233168, res1000, delta);
    }

    @Test
    public void multiplosETest() {
        Multiplos multiplos = new Multiplos();

        int a = 3;
        int b = 5;
        int delta = 0;


        int res20 = multiplos.multiplosE(20, a, b);
        assertEquals(15, res20, delta);

        //int res1000 = multiplos.multiplosE(1000, a, b);
        //assertEquals(15, res1000, delta);
    }

    @Test
    public void multiplosOuETest() {
        Multiplos multiplos = new Multiplos();

        int a = 3;
        int b = 5;
        int c = 7;
        int delta = 0;


        int res110 = multiplos.multiplosOuE(110, a, b, c);
        assertEquals(420, res110, delta);

        int res1000 = multiplos.multiplosOuE(1000, a, b, c);
        assertEquals(33173, res1000, delta);
    }

}

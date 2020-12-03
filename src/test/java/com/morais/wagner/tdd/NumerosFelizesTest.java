package com.morais.wagner.tdd;


import com.morais.wagner.tdd.exercicios.NumerosFelizes;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class NumerosFelizesTest {

    @Test
    public void removerDecimaisTest() {
        NumerosFelizes subject = new NumerosFelizes();
        assertEquals(7, subject.removerDecimais(7.09d));
    }

    @Test
    public void calcularQuadradoTest() {
        NumerosFelizes subject = new NumerosFelizes();
        int num = 7;
        int quadrado = subject.calcularQuadrado(num);
        assertEquals(49, quadrado);
    }

    @Test
    public void somarQuadradosTest() {
        NumerosFelizes subject = new NumerosFelizes();
        int quadrado = subject.somarQuadrados("49");
        assertEquals(97, quadrado);
    }

    @Test
    public void isFelizTest() {
        NumerosFelizes subject = new NumerosFelizes();
        assertTrue(subject.isNumeroFeliz(7));
    }

    @Test
    public void isInfelizTest() {
        NumerosFelizes subject = new NumerosFelizes();
        assertFalse(subject.isNumeroFeliz(8));
    }

    @Test
    public void calcularIteracoesTest() {
        NumerosFelizes subject = new NumerosFelizes();
        assertEquals(1, subject.calcularResultadoIteracoes(7));
    }

    @Test
    public void convertToIntListTest() {
        NumerosFelizes subject = new NumerosFelizes();
        List<Integer> list = Arrays.asList(1,2,3);
        assertEquals(list, subject.convertStringToIntList("123"));
    }

}

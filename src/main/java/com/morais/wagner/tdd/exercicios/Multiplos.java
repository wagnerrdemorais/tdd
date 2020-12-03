package com.morais.wagner.tdd.exercicios;

import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class Multiplos {

    public static final int MIN = 1;

    public Integer multiplosOu(int abaixoDe, int val1, int val2) {
        AtomicReference<Integer> soma = new AtomicReference<>(0);

        IntStream.rangeClosed(MIN, ajustarNumeroAbaixoDe(abaixoDe))
                .filter(value -> (value % val1 == 0 || value % val2 == 0))
                .forEach(value -> soma.set(value + soma.get()));

        Integer res = soma.get();
        log(res);
        return res;
    }

    public Integer multiplosE(int abaixoDe, int val1, int val2) {
        AtomicReference<Integer> soma = new AtomicReference<>(0);

        IntStream.rangeClosed(MIN, ajustarNumeroAbaixoDe(abaixoDe))
                .filter(value -> value % val1 == 0 && value % val2 == 0)
                .forEach(value -> soma.set(value + soma.get()));

        Integer res = soma.get();
        log(res);
        return res;
    }

    public Integer multiplosOuE(int abaixoDe, int val1, int val2, int val3) {
        AtomicReference<Integer> soma = new AtomicReference<>(0);

        IntStream.rangeClosed(MIN, ajustarNumeroAbaixoDe(abaixoDe))
                .filter(value -> (value % val1 == 0 || value % val2 == 0) && value % val3 == 0)
                .forEach(value -> soma.set(value + soma.get()));

        Integer res = soma.get();
        log(res);
        return res;
    }

    private int ajustarNumeroAbaixoDe(int abaixoDe) {
        if (abaixoDe - 1 > 0) {
            abaixoDe = abaixoDe - 1;
        }
        return abaixoDe;
    }

    private void log(int num) {
        System.out.println(num + "\n");
    }
}

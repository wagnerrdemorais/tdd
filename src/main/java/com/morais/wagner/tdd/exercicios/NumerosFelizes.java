package com.morais.wagner.tdd.exercicios;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class NumerosFelizes {

    public static void main(String[] args) {
        NumerosFelizes nf = new NumerosFelizes();
        IntStream.rangeClosed(0, 10).forEach(value ->
                System.out.println("Numero " + value + " é feliz ? " + nf.isNumeroFeliz(value)));
    }

    public boolean isNumeroFeliz(Integer numero) {
        return calcularResultadoIteracoes(numero) == 1;
    }

    public int calcularResultadoIteracoes(int numero) {
        List<Integer> controlList = new ArrayList<>();
        int soma = somarQuadrados(valueOf(numero));
        while (!controlList.contains(soma) && soma != 1) {
            controlList.add(soma);
            soma = somarQuadrados(valueOf(soma));
        }
        return soma;
    }

    public int somarQuadrados(String quadrado) {
        int somaQuadrados = 0;
        for (int i : convertStringToIntList(quadrado)) {
            somaQuadrados += calcularQuadrado(i);
        }
        return somaQuadrados;
    }

    public List<Integer> convertStringToIntList(String quadrado) {
        int[] numerosEmAscii = quadrado.chars().toArray();

        return stream(numerosEmAscii)
                .mapToObj(i -> parseInt(valueOf((char) i)))
                .collect(toList());
    }

    public int calcularQuadrado(int num) {
        double pow = Math.pow(num, 2);
        return removerDecimais(pow);
    }

    public int removerDecimais(double pow) {
        String res = new DecimalFormat("#").format(pow);
        return parseInt(res);
    }

}

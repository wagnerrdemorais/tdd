package com.morais.wagner.tdd.exercicios;

//Exercício 3 - Palavras em números
//        Neste problema, dado uma palavra composta somente por letras [a-zA-Z], cada letra possui um valor específico,
//        ‘a’ vale 1, ‘b’ vale 2 e assim por diante, até a letra ‘z’ que vale 26.
//        Do mesmo modo ‘A’ vale 27, ‘B’ vale 28, até a letra ‘Z’ que vale 52.
//        O valor da palavra será a soma total dos valores de todas as letras da palavra.
//        Você precisa definir se cada palavra em um conjunto de palavras é:
//        Prima ou não;
//        Feliz ou não;
//        Múltipla de 3 ou 5;
//        Qualquer caracter na palavra que não seja uma letra deve ser desconsiderado.

import java.util.HashMap;
import java.util.Map;

public class WordsAndNumbers {
    static Map<String, Integer> wordNumberMap = createAlphabetCorrespondenceMap();

    public Map<String, Integer> getWordNumberMap() {
        return wordNumberMap;
    }

    public static void main(String[] args) {

        WordsAndNumbers wan = new WordsAndNumbers();

        wordNumberMap.keySet()
                .forEach(key -> System.out.println(key + ": " + wordNumberMap.get(key)));

        String word = "00E5Z3";

        System.out.println("\n isWordPrimeNumber ? " + word + " " + wan.isWordPrimeNumber(word));
        System.out.println("\n isWordHappy ? " + word + " " + wan.isWordHappy(word));
        System.out.println("\n isWordMultipleOR ? " + word + " " + wan.isWordMultipleOf_3_Or_5(word));
    }

    private static Map<String, Integer> createAlphabetCorrespondenceMap() {
        Map<String, Integer> wordNumberMap = new HashMap<>();
        generateNumberCorrespondence(wordNumberMap, 'a', 'z');
        generateNumberCorrespondence(wordNumberMap, 'A', 'Z');
        return wordNumberMap;
    }

    public static void generateNumberCorrespondence(Map<String, Integer> wordNumberMap, char first, char last) {
        for (char letter = first; letter <= last; letter++) {
            int wordNumberLocation = wordNumberMap.keySet().size() + 1;
            wordNumberMap.put(String.valueOf(letter), wordNumberLocation);
        }
    }

    public int generateWordSum(String word) {
        Map<String, Integer> correspondenceMap = createAlphabetCorrespondenceMap();
        int res = 0;
        for (Character c : word.toCharArray()) {
            Integer letterNumber = correspondenceMap.get(c.toString());
            if (letterNumber != null) {
                res += letterNumber;
            }
        }
        System.out.print(res);
        return res;
    }

    public boolean isWordPrimeNumber(String word) {
        int num = generateWordSum(word);
        boolean flag = false;
        for (int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) {
                flag = true;
                break;
            }
        }
        return !flag;
    }

    public boolean isWordHappy(String word) {
        int num = generateWordSum(word);
        NumerosFelizes nf = new NumerosFelizes();
        return nf.isNumeroFeliz(num);
    }

    public boolean isWordMultipleOf_3_Or_5(String word) {
        int num = generateWordSum(word);
        return num % 3 == 0 || num % 5 == 0;
    }

}

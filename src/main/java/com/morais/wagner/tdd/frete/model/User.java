package com.morais.wagner.tdd.frete.model;

public class User {

    private String name;
    private String postalCode;

    public User(String name, String postalCode) {
        this.name = name;
        this.postalCode = postalCode;
    }

    public String getName() {
        return name;
    }

    public String getPostalCode() {
        return postalCode;
    }

}

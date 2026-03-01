package com.example;

import java.util.List;

public class Lion {

    private Animal animal;
    private boolean hasMane;

    public Lion(String sex, Animal animal) throws Exception {
        if ("Самец".equals(sex)) {
            this.hasMane = true;
        } else if ("Самка".equals(sex)) {
            this.hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - Самец или Самка");
        }
        this.animal = animal;
    }

    public int getKittens() {
        if (animal instanceof Feline) {
            return ((Feline) animal).getKittens();
        }
        return 0;
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return animal.getFood("Хищник");
    }
}
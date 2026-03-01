package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParameterizedAnimalTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 10})
    void felineGetKittensWithArgs(int kittens) {
        Feline feline = new Feline();
        assertEquals(kittens, feline.getKittens(kittens));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Травоядное", "Хищник"})
    void felineGetFoodParameterized(String kind) throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.getFood(kind);

        if ("Травоядное".equals(kind)) {
            assertEquals(List.of("Трава", "Различные растения"), food);
        } else {
            assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"Травоядное", "Хищник"})
    void catGetFoodParameterized(String kind) throws Exception {
        Cat cat = new Cat("Барсик");
        List<String> food = cat.getFood(kind);

        if ("Травоядное".equals(kind)) {
            assertEquals(List.of("Трава", "Различные растения"), food);
        } else {
            assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
        }
    }

    @ParameterizedTest
    @CsvSource({
            "Барсик,Барсик",
            "Мурка,Мурка",
            "Рыжик,Рыжик"
    })
    void catGetNameParameterized(String inputName, String expectedName) {
        Cat cat = new Cat(inputName);
        assertEquals(expectedName, cat.getName());
    }

    @ParameterizedTest
    @CsvSource({
            "Самец,true",
            "Самка,false"
    })
    void lionDoesHaveManeParameterized(String sex, boolean expected) throws Exception {
        Animal animal = new Animal();
        Lion lion = new Lion(sex, animal);
        assertEquals(expected, lion.doesHaveMane());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3, 5})
    void lionGetKittensParameterized(int kittens) throws Exception {
        Feline feline = new Feline() {
            @Override
            public int getKittens() {
                return kittens;
            }
        };
        Lion lion = new Lion("Самец", feline);
        assertEquals(kittens, lion.getKittens());
    }
}
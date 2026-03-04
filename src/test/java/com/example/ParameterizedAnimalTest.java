package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ParameterizedAnimalTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 10})
    void felineGetKittensWithArgs(int kittens) {
        Feline feline = new Feline();
        assertEquals(kittens, feline.getKittens(kittens));
    }

    @ParameterizedTest
    @CsvSource({
            "Травоядное, Трава",
            "Хищник, Животные"
    })
    void felineGetFoodParameterized(String kind, String expectedFirstItem) throws Exception {
        Feline feline = new Feline();
        assertEquals(expectedFirstItem, feline.getFood(kind).get(0));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Животные", "Рыба", "Птицы"})
    void catGetFoodParameterized(String firstFoodItem) throws Exception {

        Feline feline = mock(Feline.class);

        when(feline.eatMeat()).thenReturn(List.of(firstFoodItem));

        Cat cat = new Cat(feline);

        assertEquals(firstFoodItem, cat.getFood().get(0));
    }
}
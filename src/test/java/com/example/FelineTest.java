package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FelineTest {

    Feline feline;

    @BeforeEach
    void setUp() {
        feline = new Feline();
    }

    @Test
    void eatMeatReturnsPredatorFood() throws Exception {
        List<String> food = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    void getFamilyReturnsFeline() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void getKittensWithoutArgsReturnsOne() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    void getFoodThrowsExceptionForUnknownKind() {
        Exception exception = assertThrows(Exception.class, () -> feline.getFood("Неизвестно"));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }

    @Test
    void getFamilyFromAnimalViaFeline() {
        assertTrue(feline.getFamily() instanceof String);
        Animal base = new Animal();
        assertTrue(base.getFamily().contains("кошачьи"));
    }
}
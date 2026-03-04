package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        assertEquals(
                List.of("Животные", "Птицы", "Рыба"),
                feline.eatMeat()
        );
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
        assertThrows(Exception.class,
                () -> feline.getFood("Неизвестно"));
    }

    @Test
    void getFoodThrowsCorrectMessageForUnknownKind() {
        Exception exception = assertThrows(Exception.class,
                () -> feline.getFood("Неизвестно"));

        assertEquals(
                "Неизвестный вид животного, используйте значение Травоядное или Хищник",
                exception.getMessage()
        );
    }

    @Test
    void animalFamilyContainsCats() {
        Animal base = new Animal();
        assertTrue(base.getFamily().contains("кошачьи"));
    }
}
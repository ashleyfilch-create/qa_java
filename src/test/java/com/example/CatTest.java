package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CatTest {

    @Test
    void catInheritsKittensFromFeline() {
        Cat cat = new Cat("Мурка");
        assertEquals(1, cat.getKittens());         // без аргумента
        assertEquals(5, cat.getKittens(5));       // с аргументом
    }

    @Test
    void catInheritsFamilyFromFeline() {
        Cat cat = new Cat("Мурка");
        assertEquals("Кошачьи", cat.getFamily());
    }

    @Test
    void getFoodThrowsExceptionForUnknownKindViaCat() {
        Cat cat = new Cat("Барсик");
        Exception exception = assertThrows(Exception.class, () -> cat.getFood("Неизвестно"));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }

    @Test
    void getFamilyFromAnimalViaCat() {
        Cat cat = new Cat("Барсик");
        Animal base = new Animal();
        assertTrue(base.getFamily().contains("кошачьи")); // базовая реализация Animal
        assertEquals("Кошачьи", cat.getFamily());         // переопределение в Feline
    }
}
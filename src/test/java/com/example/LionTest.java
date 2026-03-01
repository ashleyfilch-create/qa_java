package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LionTest {

    @Test
    void invalidSexThrowsException() {
        Animal animal = mock(Animal.class);
        assertThrows(Exception.class, () -> new Lion("Неизвестно", animal));
    }

    @Test
    void getFoodUsesAnimalDependency() throws Exception {
        Animal animal = mock(Animal.class);
        when(animal.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы"));

        Lion lion = new Lion("Самец", animal);
        List<String> food = lion.getFood();

        assertEquals(List.of("Животные", "Птицы"), food);
        verify(animal).getFood("Хищник");
    }

    @Test
    void getKittensFromNonFelineDependencyReturnsZero() throws Exception {
        Animal animal = mock(Animal.class);
        Lion lion = new Lion("Самец", animal);
        assertEquals(0, lion.getKittens());
    }
}
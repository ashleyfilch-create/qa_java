package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LionTest {

    @Test
    void constructorThrowsExceptionForInvalidSex() {
        Feline feline = mock(Feline.class);

        assertThrows(Exception.class,
                () -> new Lion("Неизвестно", feline));
    }

    @Test
    void getFoodReturnsFoodFromFeline() throws Exception {
        Feline feline = mock(Feline.class);
        when(feline.getFood("Хищник"))
                .thenReturn(List.of("Животные", "Птицы"));

        Lion lion = new Lion("Самец", feline);

        assertEquals(List.of("Животные", "Птицы"), lion.getFood());
    }

    @Test
    void getFoodCallsFelineGetFoodOnce() throws Exception {
        Feline feline = mock(Feline.class);
        when(feline.getFood("Хищник"))
                .thenReturn(List.of("Животные"));

        Lion lion = new Lion("Самец", feline);
        lion.getFood();

        verify(feline, times(1)).getFood("Хищник");
    }

    @Test
    void getKittensReturnsValueFromFeline() throws Exception {
        Feline feline = mock(Feline.class);
        when(feline.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец", feline);

        assertEquals(3, lion.getKittens());
    }

    @Test
    void doesHaveManeReturnsTrueForMale() throws Exception {
        Feline feline = mock(Feline.class);
        Lion lion = new Lion("Самец", feline);

        assertTrue(lion.doesHaveMane());
    }

    @Test
    void doesHaveManeReturnsFalseForFemale() throws Exception {
        Feline feline = mock(Feline.class);
        Lion lion = new Lion("Самка", feline);

        assertFalse(lion.doesHaveMane());
    }
}
package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CatTest {

    @Test
    void getSoundReturnsMeow() {
        Feline feline = mock(Feline.class);
        Cat cat = new Cat(feline);

        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void getFoodDelegatesToPredator() throws Exception {
        Feline feline = mock(Feline.class);
        when(feline.eatMeat()).thenReturn(java.util.List.of("Мыши"));

        Cat cat = new Cat(feline);

        assertEquals(java.util.List.of("Мыши"), cat.getFood());
    }

    @Test
    void getFoodCallsEatMeatOnce() throws Exception {
        Feline feline = mock(Feline.class);
        when(feline.eatMeat()).thenReturn(java.util.List.of("Мыши"));

        Cat cat = new Cat(feline);
        cat.getFood();

        verify(feline, times(1)).eatMeat();
    }
}
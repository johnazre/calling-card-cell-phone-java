package com.galvanize;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CallingCardTest {
    @Test
    public void canAddMoneyToCard() {
        CallingCard card = new CallingCard(20);
        card.addDollars(1);
        assertEquals(5, card.getRemainingMinutes());
    }

    @Test
    public void canCheckRemainingMinutes() {
        CallingCard card = new CallingCard(20);
        card.addDollars(1);
        assertEquals(5, card.getRemainingMinutes());
    }

    @Test
    public void canDecreaseMinutes() {
        CallingCard card = new CallingCard(20);
        card.addDollars(1);
        card.useMinutes(3);
        assertEquals(2, card.getRemainingMinutes());
    }

    @Test
    public void cannotDecreaseMinutesBelowZero() {
        CallingCard card = new CallingCard(20);
        card.addDollars(1);
        card.useMinutes(6);
        assertEquals(0, card.getRemainingMinutes());
    }

    @Test
    public void removeDecimalPlacesFromUnevenNumbers() {
        CallingCard card = new CallingCard(13);
        card.addDollars(1);
        assertEquals(7, card.getRemainingMinutes());
    }
}

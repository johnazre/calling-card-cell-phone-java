package com.galvanize;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CellPhoneTest {
    @Test
    public void canGetMostRecentPhoneNumberCalled() {
        CallingCard card = new CallingCard(10);
        card.addDollars(1); // add 100 cents @ 10 cents/minute = 10 minutes added

        CellPhone phone = new CellPhone(card);
        phone.isTalking();  // => returns false

        phone.call("555-1212");
        phone.isTalking();  // => returns true

        phone.tick();       // simulate a minute going by
        phone.tick();       // simulate another minute going by

        phone.endCall();
        phone.isTalking();  // => returns false (because the call is over)
        phone.getHistory(); // => returns "555-1212 (2 minutes)"
        assertEquals("555-1212 (2 minutes)", phone.getHistory());

        card.getRemainingMinutes(); // => return 8, because the call lasted 2 minutes;
        assertEquals(8, card.getRemainingMinutes());
    }

    @Test
    public void canKeepTrackOfCallHistory() {
        CallingCard card = new CallingCard(20);
        card.addDollars(1); // add 100 cents @ 20 cents/minute = 5 minutes added

        CellPhone phone = new CellPhone(card);
        phone.call("555-1111");
        phone.tick();       // 1 minute elapsed
        phone.tick();       // 2 minutes elapsed
        phone.endCall();

        phone.call("555-3333");
        phone.tick();       // 3 minutes elapsed
        phone.tick();       // 4 minutes elapsed
        phone.tick();       // this is the end of the 5th minute, so the call is ended

        assertEquals("555-1111 (2 minutes), 555-3333 (cut off at 3 minutes)", phone.getHistory());
        assertEquals(0, card.getRemainingMinutes());
    }
}
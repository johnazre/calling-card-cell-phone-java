package com.galvanize;

import java.util.ArrayList;

public class CellPhone {

    private CallingCard card;
    private boolean onCall = false;
    private ArrayList<String> recentCalls = new ArrayList<String>();
    private String currentPhoneNumber;
    private int callLength = 0;
    private boolean cutOff = false;

    public CellPhone() { }

    public CellPhone(CallingCard card) {
        this.card = card;
    }

    public Boolean isTalking() {
        return this.onCall;
    }

    public void call(String phoneNumber) {
        this.onCall = true;
        this.currentPhoneNumber = phoneNumber;
    }

    public void endCall() {
        this.onCall = false;
        String minuteOrMinutes = this.callLength == 1? "minute" : "minutes";
        String cutOffOrNot = this.cutOff ? "cut off at " : "";
        String formattedString = String.format("%s (%s%d %s)", this.currentPhoneNumber, cutOffOrNot, this.callLength, minuteOrMinutes);
        this.recentCalls.add(formattedString);
        this.callLength = 0;
        this.cutOff = false;
        this.currentPhoneNumber = "";
    }

    public void tick() {
        this.card.useMinutes(1);
        this.callLength++;

        if(card.getRemainingMinutes() < 1) {
            this.cutOff = true;
            this.endCall();
        }
    }

    public String getHistory() {
        String theStr = "";
        for(int i = 0; i < this.recentCalls.size(); i++) {
            if(i == this.recentCalls.size() - 1) {
                theStr = theStr.concat(this.recentCalls.get(i));
            } else {
                theStr = theStr.concat(this.recentCalls.get(i) + ", ");
            }
        }
        return theStr;
    }


}
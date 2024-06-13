package models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Card {
    private long number;
    private String name;
    private Expiry expiry;
    private int securityCode;


    @Setter
    @Getter
    private class Expiry {
        private int month;
        private int year;
    }
}

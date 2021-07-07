package com.yakovliam.battlegrounds;

public class Messages {

    private static Messages instance;

    public static Messages getInstance() {
        if (instance == null) {
            instance = new Messages();
        }
        return instance;
    }
}

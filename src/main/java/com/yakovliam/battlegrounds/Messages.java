package com.yakovliam.battlegrounds;

import com.yakovliam.battlegrounds.api.message.Message;

public class Messages {

    private static Messages instance;

    public static Messages getInstance() {
        if (instance == null) {
            instance = new Messages();
        }
        return instance;
    }
}

package com.yakovliam.battlegrounds.builder;

import com.yakovliam.battlegrounds.config.generic.adapter.ConfigurationAdapter;
import com.yakovliam.battlegrounds.message.Message;
import com.yakovliam.battlegrounds.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class WaitingBroadcastListBuilder implements Builder<Pair<ConfigurationAdapter, String>, List<Message>> {

    @Override
    public List<Message> build(Pair<ConfigurationAdapter, String> context) {
        String rootPath = context.getRight();
        ConfigurationAdapter adapter = context.getLeft();

        // define list
        List<Message> messages = new ArrayList<>();

        // get all message keys
        List<String> keys = adapter.getKeys(rootPath, new ArrayList<>());

        // loop through
        for (String key : keys) {
            // construct ident
            String identifier = rootPath + "." + key;
            // construct message
            Message message = Message.fromConfigurationSection(adapter, identifier).build();
            // add to list
            messages.add(message);
        }

        return messages;
    }
}

package com.yakovliam.battlegrounds.calculator;

import com.yakovliam.battlegrounds.message.Message;
import com.yakovliam.battlegrounds.random.weighted.WeightedCollection;
import com.yakovliam.battlegrounds.random.weighted.WeightedItem;

import java.util.List;

public class RandomWaitingBroadcastMessageCalculator implements Calculator<List<Message>, Message> {

    @Override
    public Message calculate(List<Message> context) {
        WeightedCollection<Message> weightedCollection = new WeightedCollection<>();

        for (Message message : context) {
            weightedCollection.add(new WeightedItem<>(message));
        }

        return weightedCollection.next();
    }
}

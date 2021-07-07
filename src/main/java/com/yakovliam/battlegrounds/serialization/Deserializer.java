package com.yakovliam.battlegrounds.serialization;

public interface Deserializer<K, V> {

    /**
     * Deserialize a k
     *
     * @param k k
     * @return v
     */
    V deserialize(K k);
}

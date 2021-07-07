package com.yakovliam.battlegrounds.serialization;

public interface Serializer<K, V> {

    /**
     * Serialize a k
     *
     * @param k k
     * @return v
     */
    V serialize(K k);
}

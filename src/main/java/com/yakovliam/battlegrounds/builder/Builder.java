package com.yakovliam.battlegrounds.builder;

public interface Builder<C, O> {

    /**
     * Build something given context
     *
     * @param context context
     * @return built
     */
    O build(C context);
}

package com.yakovliam.battlegrounds.calculator;

public interface Calculator<C, O> {

    /**
     * Calculate something given context
     *
     * @param context context
     * @return calculated
     */
    O calculate(C context);
}

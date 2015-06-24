package com.jyril;

import org.junit.Test;

/**
 * Created by jyril81 on 22.06.2015.
 */
public class ParenthesisTest {

    @Test
    public void tests() {
        Parenthesis.solve("true");
        Parenthesis.solve("true and false");
        Parenthesis.solve("true and false xor true");
        Parenthesis.solve("true and false xor true and true");
    }
}

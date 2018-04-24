package org.centaurus.app.test;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class FakeTest {
    @Test
    public void TestEqualityOfTwoString(){
        Assertions.assertEquals("centaurus", "centaurus");
    }
}

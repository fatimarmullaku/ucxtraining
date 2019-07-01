package com.ucx.domainexercise;

import org.junit.*;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class UtilTest {

    private Util util = new Util();

    @Test
    public void testSum() {
        assertEquals(Integer.valueOf(10), util.sum(5, 5));
        assertNotNull(util.sum(5, 5));
    }

    @Test(expected = Exception.class)
    public void testSumWithNullArguments(){
        util.sum(null, null);
    }
}
package com.exam;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {

    @Test
    public void testAdd() {

        Assert.assertEquals(30, App.add(10,20));

    }
}
package com.exam;

import org.junit.Assert;
import org.junit.Test;
import com.google.gson.Gson;

public class AppTest {

    @Test
    public void testJsonConversion() {

        Gson gson = new Gson();

        Student s = new Student("Ravi", 21);

        String json = gson.toJson(s);

        Assert.assertTrue(json.contains("Ravi"));

    }
}
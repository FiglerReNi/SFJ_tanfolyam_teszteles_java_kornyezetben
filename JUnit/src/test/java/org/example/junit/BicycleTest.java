package org.example.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BicycleTest {

    Bicycle bike;

    @Before
    public void inti(){
        bike = new Bicycle();
    }

    @Test
    public void sum(){
        assertEquals(3, bike.sum(1,1,1));
        assertEquals(9, bike.sum(2,3,4));
        assertEquals(11, bike.sum(4,3,4));
        assertEquals(1980, bike.sum(2000,-30,10));
    }

    @After
    public void destroy(){
        bike = null;
    }
}
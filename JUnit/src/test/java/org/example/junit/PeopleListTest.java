package org.example.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class PeopleListTest {

    PeopleList peopleList;

    @Before
    public void init(){
        peopleList = new PeopleList();
        peopleList.add("Gyula");
        peopleList.add("Gizi");
    }

    @Test
    public void add(){
        peopleList.add("Jani");
        assertEquals("Méret ellenőrzés", 3, peopleList.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void removeException(){
        peopleList.remove("Norbi");
    }

    @Test()
    public void remove(){
        peopleList.remove("Gizi");
    }

    @Test
    public void size(){
        assertEquals("Méret ellenőrzés", 2, peopleList.size());
    }

    @Test
    public void isEmpty(){
        assertFalse(peopleList.isEmpty());
    }

    @Test
    public void removeAll(){
        peopleList.removeAll();
        assertTrue(peopleList.isEmpty());
    }

    @After
    public void destroy(){
        peopleList = null;
    }
}
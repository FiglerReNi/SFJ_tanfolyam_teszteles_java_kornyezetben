package org.example.junit;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MockBicycleTest {

    MockBicycle bike;
    //Függőségek kezelése
    //A változat - fake object
    //Úgy állítjuk be, hogy mindig true-t adjon vissza
    //DataBaseConnection dbConn = new DataBaseConnection() {
    //    @Override
    //    public boolean checkUserPass(String user, String password) {
    //        return true;
    //    }
    //};
    //B változat - fake object
    //Lambda expression
    //DataBaseConnection dbConn = ((String user, String password) ->(true));
    //C változat - mockito.core csomag használatával
    DataBaseConnection dbConn = Mockito.mock(DataBaseConnection.class);

    @Before
    public void inti(){
        bike = new MockBicycle(dbConn);
    }

    @Test
    public void sum(){
        //C változat - mockito.core csomag használatával
        when(dbConn.checkUserPass("Gyula", "pass")).thenReturn(true);

        Integer expected = 3;
        assertEquals(expected, bike.sum("Gyula", "pass",1,1,1));

        //C változat - meg kell vizsgálni, hogy tényleg használva lett-e az objektum a tesztelendő metódusban
        verify(dbConn).checkUserPass("Gyula", "pass");
    }


}
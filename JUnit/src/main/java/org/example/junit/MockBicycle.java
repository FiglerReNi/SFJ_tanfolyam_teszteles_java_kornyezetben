package org.example.junit;

public class MockBicycle {

    DataBaseConnection dbConn;

    public MockBicycle(DataBaseConnection dbConn) {
        this.dbConn = dbConn;
    }

    public Integer sum(String name, String password, int a, int b, int c){

        boolean checkUser = dbConn.checkUserPass(name, password);

        if(checkUser)
            return a+b+c;

        return null;
    }
}

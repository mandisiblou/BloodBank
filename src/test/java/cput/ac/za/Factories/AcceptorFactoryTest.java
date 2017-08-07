package cput.ac.za.Factories;


import cput.ac.za.Domain.Acceptor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

/**
 * Created by mandisi on 2017/05/31.
 */
public class AcceptorFactoryTest {
    Map<String,String> values;
    Acceptor acceptor;
    @BeforeMethod
    public void setUp() throws Exception {
        values = new HashMap<String, String>();
        values.put("id","2");
        values.put("Fname","Zuko");
        values.put("Lname","Blou");
        values.put("DOB","0201");
        values.put("gender","Male");
        values.put("bloodGroup","0+");
        values.put("division","Western Cape");
        values.put("district","Cape Town");
        values.put("availDate","0211");
    }
    @Test
    public void getAcceptor() throws Exception {
        Acceptor acceptor = AcceptorFactory.getAcceptor(values, 5313,5666666);
        assertEquals(5313,acceptor.getPassword());
    }
}
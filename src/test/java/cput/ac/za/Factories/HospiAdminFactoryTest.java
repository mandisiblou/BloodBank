package cput.ac.za.Factories;


import cput.ac.za.Domain.HospiAdmin;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

/**
 * Created by hashcode on 2017/05/09.
 */
public class HospiAdminFactoryTest {
    Map<String,String> values;

    @BeforeMethod
    public void setUp() throws Exception {
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("firstname","Tracy");
        values.put("lastname","Wampach");
        values.put("emailA","tracy@gmail.com");
    }

    @Test
    public void getAdmin() throws Exception {
        HospiAdmin hospiAdmin = HospiAdminFactory.getHospiAdmin(values);
        assertEquals("Wampach", hospiAdmin.getLastname());
    }

}
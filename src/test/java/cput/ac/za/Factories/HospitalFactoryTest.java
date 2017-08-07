package cput.ac.za.Factories;


import cput.ac.za.Domain.Hospital;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

/**
 * Created by hashcode on 2017/05/09.
 */
public class HospitalFactoryTest {
    Map<String,String> values;

    @BeforeMethod
    public void setUp() throws Exception {
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("hName","Mowbray");
        values.put("phone","021445");
        values.put("emailA","mandisiblou@gmail.com");
        values.put("addres","Mowbray,1723");
    }

    @Test
    public void getAdmin() throws Exception {
        Hospital hospital = HospitalFactory.getHospital(values);
        assertEquals("021445", hospital.getPhone());
    }

}
package cput.ac.za.Services;


import cput.ac.za.Domain.Hospital;
import cput.ac.za.Factories.HospitalFactory;
import cput.ac.za.Services.Impl.HospitalServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by hashcode on 2017/05/16.
 */
public class HospitalServiceTest {
    HospitalService service;
    Map<String,String> values;

    @BeforeMethod
    public void setUp() throws Exception {
        service = new HospitalServiceImpl();
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("hName","Obz");
        values.put("phone","0214567");
        values.put("emailA","ajax@gmail");
        values.put("addres","Mowbray,1723");
    }

    @Test
    public void testCreate() throws Exception {
        Hospital hospital = HospitalFactory.getHospital(values);
        service.create(hospital);
        assertEquals("ajax@gmail", hospital.getEmailA());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Hospital readHospital = service.read("1");
        assertEquals("ajax@gmail",readHospital.getEmailA());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Hospital hospital = service.read("1");
        Hospital newHospital = new Hospital.Builder()
                .emailA("ajax@yahoo")
                .hName(values.get("hName"))
                .phone(values.get("phone"))
                .addres(values.put("addres","Mowbray,1723"))
                .id(values.get("id"))
                .build();
        service.update(newHospital);
        Hospital updateHospital = service.read("1");
        assertEquals("ajax@yahoo", updateHospital.getEmailA());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        service.delete("1");
        Hospital hospital = service.read("1");
        assertNull(hospital);
    }

}
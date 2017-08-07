package cput.ac.za.Repositories;


import cput.ac.za.Domain.Hospital;
import cput.ac.za.Factories.HospitalFactory;
import cput.ac.za.Repositories.Impl.HospitalRepositoryImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;


/**
 * Created by hashcode on 2017/05/09.
 */
public class HospitalRepositoryTest {
    Map<String,String> values;
    HospitalRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {
        repository = HospitalRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("hName","Mowbray");
        values.put("phone","021456");
        values.put("emailA","mowbray@yahoo");
        values.put("addres","Mowbray,1723");
    }

    @Test
    public void create() throws Exception {
        Hospital hospital = HospitalFactory.getHospital(values);
        repository.create(hospital);
        assertEquals("mowbray@yahoo", hospital.getEmailA());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Hospital readHospital = repository.read("1");
        assertEquals("mowbray@yahoo",readHospital.getEmailA());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Hospital hospital = repository.read("1");
        Hospital newHospital = new Hospital.Builder()
                .emailA("Obz@gmail.com")
                .hName(values.get("Mowbray"))
                .phone(values.get("021456"))
                .addres(values.put("addres","Mowbray,1723"))
                .id(values.get("id"))
                .build();
        repository.update(newHospital);
        Hospital updateHospital = repository.read("1");
        assertEquals("Obz@gmail.com", updateHospital.getEmailA());
    }

    @Test (dependsOnMethods = "update")
    public void delete() throws Exception {
        repository.delete("1");
        Hospital hospital = repository.read("1");
        assertNull(hospital);
    }

}
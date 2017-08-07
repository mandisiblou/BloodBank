package cput.ac.za.Services;


import cput.ac.za.Domain.Donor;
import cput.ac.za.Factories.DonorFactory;
import cput.ac.za.Services.Impl.DonorServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by mandisi on 2017/05/31.
 */
public class DonorServiceTest {
    DonorService service;
    Map<String,String> values;

    @BeforeMethod
    public void setUp() throws Exception {
        service = new DonorServiceImpl();
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("Fname","Mandisi");
        values.put("Lname","Blou");
        values.put("DOB","1102");
        values.put("gender","Male");
        values.put("bloodGroup","0+");
        values.put("division","Western Cape");
        values.put("district","Cape Town");
        values.put("availDate","0211");
    }

    @Test
    public void testCreate() throws Exception {
        Donor donor = DonorFactory.getDonor(values,5313, 2555);
        service.create(donor);
        assertEquals(2555,donor.getMobileN());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Donor readDonor = service.read("1");
        assertEquals(5313,readDonor.getPassword());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Donor donor = service.read("1");
        Donor newDonor = new Donor.Builder()
                .division("Western Cape")
                .district("Cape Town")
                .availDate("0511")
                .password(53133)
                .mobileN(56565)
                .id(values.get("id"))
                .build();
        service.update(newDonor);
        Donor UpdateDonor = service.read("1");
        assertEquals("0511",UpdateDonor.getAvailDate());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        service.delete("1");
        Donor donor = service.read("1");
        assertNull(donor);
    }
}
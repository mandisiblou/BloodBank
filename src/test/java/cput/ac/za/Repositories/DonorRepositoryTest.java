package cput.ac.za.Repositories;


import cput.ac.za.Domain.Donor;
import cput.ac.za.Factories.DonorFactory;
import cput.ac.za.Repositories.Impl.DonorRepositoryImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;


/**
 * Created by mandisi on 2017/05/31.
 */
public class DonorRepositoryTest {
    Map<String,String> values;
    DonorRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {
        repository = DonorRepositoryImpl.getInstance();
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
    public void create() throws Exception {
        Donor donor = DonorFactory.getDonor(values,53133,56565);
        repository.create(donor);
        assertEquals("0211",donor.getAvailDate());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Donor readDonor = repository.read("1");
        assertEquals("0211",readDonor.getAvailDate());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Donor donor = repository.read("1");
        Donor newDonor = new Donor.Builder()
                .division("Western Cape")
                .district("Cape Town")
                .availDate("0512")
                .password(53133)
                .mobileN(56565)
                .id(values.get("id"))
                .build();
        repository.update(newDonor);
        Donor UpdateDonor = repository.read("1");
        assertEquals("0512",UpdateDonor.getAvailDate());
    }

    @Test (dependsOnMethods = "update")
    public void delete() throws Exception {
        repository.delete("1");
        Donor donor = repository.read("1");
        assertNull(donor);
    }
}
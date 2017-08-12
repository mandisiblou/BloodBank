package cput.ac.za.Repositories;


import cput.ac.za.Domain.HospiAdmin;
import cput.ac.za.Factories.HospiAdminFactory;
import cput.ac.za.Repositories.Impl.HospiAdminRepositoryImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;


/**
 * Created by hashcode on 2017/05/09.
 */
public class HospiAdminRepositoryTest {
    Map<String,String> values;
    HospiAdminRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {
        repository = HospiAdminRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("firstname","Lauren");
        values.put("lastname","Hendricksy");
        values.put("emailA","lauren@yahoo");
    }

    @Test
    public void create() throws Exception {
        HospiAdmin agent = HospiAdminFactory.getHospiAdmin(values);
        repository.create(agent);
        assertEquals("lauren@yahoo", agent.getEmailA());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        HospiAdmin readperson = repository.read("1");
        assertEquals("lauren@yahoo",readperson.getEmailA());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        HospiAdmin hospiAdmin = repository.read("1");
        HospiAdmin newHospiAdmin = new HospiAdmin.Builder()
                .emailA("hendric@gmail.com")
                .firstname(values.get("firstname"))
                .lastname(values.get("lastname"))
                .id(values.get("id"))
                .build();
        repository.update(newHospiAdmin);
        HospiAdmin updateHospiAdmin = repository.read("1");
        assertEquals("hendric@gmail.com", updateHospiAdmin.getEmailA());
    }

    @Test (dependsOnMethods = "update")
    public void delete() throws Exception {
        repository.delete("1");
        HospiAdmin hospiAdmin = repository.read("1");
        assertNull(hospiAdmin);
    }
}
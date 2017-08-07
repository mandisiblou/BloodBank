package cput.ac.za.Repositories;


import cput.ac.za.Domain.Acceptor;
import cput.ac.za.Factories.AcceptorFactory;
import cput.ac.za.Repositories.Impl.AcceptorRepositoryImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;


/**
 * Created by mandisi on 2017/05/31.
 */
public class AcceptorRepositoryTest {
    Map<String,String> values;
    AcceptorRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {
        repository = AcceptorRepositoryImpl.getInstance();
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
    public void create() throws Exception {
        Acceptor acceptor = AcceptorFactory.getAcceptor(values,53133,56565);
        repository.create(acceptor);
        assertEquals("0211",acceptor.getAvailDate());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Acceptor readAcceptor = repository.read("2");
        assertEquals("0211",readAcceptor.getAvailDate());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Acceptor acceptor = repository.read("2");
        Acceptor newAcceptor = new Acceptor.Builder()
                .division("Western Cape")
                .district("Cape Town")
                .availDate("0512")
                .password(53133)
                .mobileN(56565)
                .id(values.get("id"))
                .build();
        repository.update(newAcceptor);
        Acceptor UpdateAcceptor = repository.read("2");
        assertEquals("0512",UpdateAcceptor.getAvailDate());
    }

    @Test (dependsOnMethods = "update")
    public void delete() throws Exception {
        repository.delete("2");
        Acceptor acceptor = repository.read("2");
        assertNull(acceptor);
    }
}
package cput.ac.za.Services;


import cput.ac.za.Domain.Acceptor;
import cput.ac.za.Factories.AcceptorFactory;
import cput.ac.za.Services.Impl.AcceptorServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by mandisi on 2017/05/31.
 */
public class AcceptorServiceTest {
    AcceptorService service;
    Map<String,String> values;

    @BeforeMethod
    public void setUp() throws Exception {
        service = new AcceptorServiceImpl();
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
    public void testCreate() throws Exception {
        Acceptor acceptor = AcceptorFactory.getAcceptor(values,5313, 2555);
        service.create(acceptor);
        assertEquals(2555,acceptor.getMobileN());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Acceptor readAcceptor = service.read("2");
        assertEquals(5313,readAcceptor.getPassword());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Acceptor acceptor = service.read("2");
        Acceptor newAcceptor = new Acceptor.Builder()
                .division("Western Cape")
                .district("Cape Town")
                .password(53133)
                .mobileN(56565)
                .id(values.get("id"))
                .availDate("0511")
                .build();
        service.update(newAcceptor);
        Acceptor UpdateAcceptor = service.read("2");
        assertEquals("0511",UpdateAcceptor.getAvailDate());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        service.delete("2");
        Acceptor acceptor = service.read("2");
        assertNull(acceptor);
    }
}
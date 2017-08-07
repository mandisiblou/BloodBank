package cput.ac.za.Services;


import cput.ac.za.Domain.Agent;
import cput.ac.za.Factories.AgentFactory;
import cput.ac.za.Services.Impl.AgentServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by hashcode on 2017/05/16.
 */
public class AgentServiceTest {
    AgentService service;
    Map<String,String> values;

    @BeforeMethod
    public void setUp() throws Exception {
        service = new AgentServiceImpl();
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("firstname","Andile");
        values.put("lastname","Sodinga");
        values.put("emailA","ajax@gmail");
    }

    @Test
    public void testCreate() throws Exception {
        Agent agent = AgentFactory.getAdmin(values);
        service.create(agent);
        assertEquals("ajax@gmail", agent.getEmailA());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Agent readperson = service.read("1");
        assertEquals("ajax@gmail",readperson.getEmailA());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Agent agent = service.read("1");
        Agent newAgent = new Agent.Builder()
                .emailA("ajax@yahoo")
                .firstname(values.get("firstname"))
                .lastname(values.get("lastname"))
                .id(values.get("id"))
                .build();
        service.update(newAgent);
        Agent updateAgent = service.read("1");
        assertEquals("ajax@yahoo", updateAgent.getEmailA());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        service.delete("1");
        Agent agent = service.read("1");
        assertNull(agent);
    }

}
package cput.ac.za.Repositories;


import cput.ac.za.Domain.Agent;
import cput.ac.za.Factories.AgentFactory;
import cput.ac.za.Repositories.Impl.AgentRepositoryImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;


/**
 * Created by hashcode on 2017/05/09.
 */
public class AgentRepositoryTest {
    Map<String,String> values;
    AgentRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {
        repository = AgentRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("firstname","John");
        values.put("lastname","Deo");
        values.put("emailA","pruneSoding@yahoo");
    }

    @Test
    public void create() throws Exception {
        Agent agent = AgentFactory.getAdmin(values);
        repository.create(agent);
        assertEquals("pruneSoding@yahoo", agent.getEmailA());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Agent readperson = repository.read("1");
        assertEquals("pruneSoding@yahoo",readperson.getEmailA());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Agent agent = repository.read("1");
        Agent newAgent = new Agent.Builder()
                .emailA("prune@gmail.com")
                .firstname(values.get("firstname"))
                .lastname(values.get("lastname"))
                .id(values.get("id"))
                .build();
        repository.update(newAgent);
        Agent updateAgent = repository.read("1");
        assertEquals("prune@gmail.com", updateAgent.getEmailA());
    }

    @Test (dependsOnMethods = "update")
    public void delete() throws Exception {
        repository.delete("1");
        Agent agent = repository.read("1");
        assertNull(agent);
    }

}
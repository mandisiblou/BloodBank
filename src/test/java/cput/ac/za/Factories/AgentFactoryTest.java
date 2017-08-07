package cput.ac.za.Factories;


import cput.ac.za.Domain.Agent;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

/**
 * Created by hashcode on 2017/05/09.
 */
public class AgentFactoryTest {
    Map<String,String> values;

    @BeforeMethod
    public void setUp() throws Exception {
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("firstname","Prune");
        values.put("lastname","Sodinga");
        values.put("emailA","mandisiblou@gmail.com");
    }

    @Test
    public void getAdmin() throws Exception {
        Agent agent = AgentFactory.getAdmin(values);
        assertEquals("Sodinga", agent.getLastname());
    }

}
package cput.ac.za.Factories;


import cput.ac.za.Domain.Agent;

import java.util.Map;

/**
 * Created by mandisi on 2017/05/31.
 */
public class AgentFactory {

    public static Agent getAdmin(Map<String, String> values){
        Agent agent = new Agent.Builder()
                .emailA(values.get("emailA"))
                .firstname(values.get("firstname"))
                .lastname(values.get("lastname"))
                .id(values.get("id"))
                .build();
        return agent;

    }


}

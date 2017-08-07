package cput.ac.za.Repositories.Impl;

import cput.ac.za.Domain.Agent;
import cput.ac.za.Repositories.AgentRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mandisi on 2017/05/31.
 */
public class AgentRepositoryImpl implements AgentRepository {

    private static AgentRepositoryImpl respository = null;

    private Map<String,Agent> adminTable;

    private AgentRepositoryImpl() {
        adminTable = new HashMap<String, Agent>();
    }

    public static AgentRepositoryImpl getInstance(){
        if(respository==null)
            respository = new AgentRepositoryImpl();
        return respository;
    }

    public Agent create(Agent agent) {
        adminTable.put(agent.getId(), agent);
        Agent savedAgent = adminTable.get(agent.getId());
        return savedAgent;
    }

    public Agent read(String id) {
        Agent agent = adminTable.get(id);
        return agent;
    }

    public Agent update(Agent agent) {
        adminTable.put(agent.getId(), agent);
        Agent savedAgent = adminTable.get(agent.getId());
        return savedAgent;
    }

    public void delete(String id) {
        adminTable.remove(id);

    }
}

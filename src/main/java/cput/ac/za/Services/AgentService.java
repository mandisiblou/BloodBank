package cput.ac.za.Services;


import cput.ac.za.Domain.Agent;

/**
 * Created by hashcode on 2017/05/16.
 */
public interface AgentService {
    Agent create(Agent agent);
    Agent read(String id);
    Agent update(Agent agent);
    void delete(String id);
}

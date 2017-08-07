package cput.ac.za.Repositories;


import cput.ac.za.Domain.Agent;

/**
 * Created by hashcode on 2017/05/09.
 */
public interface AgentRepository {
    Agent create(Agent agent);

    Agent read(String id);

    Agent update(Agent agent);

    void delete(String id);
}

package cput.ac.za.Services.Impl;


import cput.ac.za.Domain.Agent;
import cput.ac.za.Repositories.Impl.AgentRepositoryImpl;
import cput.ac.za.Repositories.AgentRepository;
import cput.ac.za.Services.AgentService;

/**
 * Created by mandisi on 2017/05/31.
 */
public class AgentServiceImpl implements AgentService {

    private static AgentServiceImpl service = null;

    AgentRepository repository = AgentRepositoryImpl.getInstance();

    public static AgentServiceImpl getInstance(){
        if(service == null)
            service = new AgentServiceImpl();
        return service;
    }

    public Agent create(Agent agent) {
        return repository.create(agent);
    }

    public Agent read(String id) {
        return repository.read(id);
    }

    public Agent update(Agent agent) {
        return repository.update(agent);
    }

    public void delete(String id) {
        repository.delete(id);

    }
}

package cput.ac.za.Services.Impl;


import cput.ac.za.Domain.Acceptor;
import cput.ac.za.Repositories.AcceptorRepository;
import cput.ac.za.Repositories.Impl.AcceptorRepositoryImpl;
import cput.ac.za.Services.AcceptorService;

/**
 * Created by mandisi on 2017/05/31.
 */
public class AcceptorServiceImpl implements AcceptorService {

    private static AcceptorServiceImpl service = null;

    AcceptorRepository repository = AcceptorRepositoryImpl.getInstance();

    public static AcceptorServiceImpl getInstance(){
        if(service == null)
            service = new AcceptorServiceImpl();
        return service;
    }

    public Acceptor create(Acceptor acceptor) {
        return repository.create(acceptor);
    }

    public Acceptor read(String id) {
        return repository.read(id);
    }

    public Acceptor update(Acceptor acceptor) {
        return repository.update(acceptor);
    }

    public void delete(String id) {
        repository.delete(id);
    }
}

package cput.ac.za.Repositories.Impl;


import cput.ac.za.Domain.Acceptor;
import cput.ac.za.Repositories.AcceptorRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mandisi on 2017/05/31.
 */
public class AcceptorRepositoryImpl implements AcceptorRepository {

    private static AcceptorRepositoryImpl respository = null;

    private Map<String,Acceptor> acceptorTable;

    private AcceptorRepositoryImpl() {
        acceptorTable = new HashMap<String, Acceptor>();
    }

    public static AcceptorRepositoryImpl getInstance(){
        if(respository==null)
            respository = new AcceptorRepositoryImpl();
        return respository;
    }

    public Acceptor create(Acceptor acceptor) {
        acceptorTable.put(acceptor.getId(),acceptor);
        Acceptor savedAcceptor = acceptorTable.get(acceptor.getId());
        return savedAcceptor;
    }

    public Acceptor read(String id) {
        Acceptor acceptor = acceptorTable.get(id);
        return acceptor;
    }

    public Acceptor update(Acceptor acceptor) {
        acceptorTable.put(acceptor.getId(),acceptor);
        Acceptor savedAcceptor = acceptorTable.get(acceptor.getId());
        return savedAcceptor;
    }

    public void delete(String id) {
        acceptorTable.remove(id);

    }
}

package cput.ac.za.Repositories;


import cput.ac.za.Domain.Acceptor;

/**
 * Created by mandisi on 2017/05/31.
 */
public interface AcceptorRepository {
    Acceptor create(Acceptor acceptor);

    Acceptor read(String id);

    Acceptor update(Acceptor acceptor);

    void delete(String id);
}

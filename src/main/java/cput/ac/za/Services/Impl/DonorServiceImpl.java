package cput.ac.za.Services.Impl;


import cput.ac.za.Domain.Donor;
import cput.ac.za.Repositories.DonorRepository;
import cput.ac.za.Repositories.Impl.DonorRepositoryImpl;
import cput.ac.za.Services.DonorService;

/**
 * Created by mandisi on 2017/05/31.
 */
public class DonorServiceImpl implements DonorService {

    private static DonorServiceImpl service = null;

    DonorRepository repository = DonorRepositoryImpl.getInstance();

    public static DonorServiceImpl getInstance(){
        if(service == null)
            service = new DonorServiceImpl();
        return service;
    }

    public Donor create(Donor donor) {
        return repository.create(donor);
    }

    public Donor read(String id) {
        return repository.read(id);
    }

    public Donor update(Donor donor) {
        return repository.update(donor);
    }

    public void delete(String id) {
        repository.delete(id);
    }
}

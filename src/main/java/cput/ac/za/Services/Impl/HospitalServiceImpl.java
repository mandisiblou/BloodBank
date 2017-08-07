package cput.ac.za.Services.Impl;


import cput.ac.za.Domain.Hospital;
import cput.ac.za.Repositories.HospitalRepository;
import cput.ac.za.Repositories.Impl.HospitalRepositoryImpl;
import cput.ac.za.Services.HospitalService;

/**
 * Created by mandisi on 2017/05/31.
 */
public class HospitalServiceImpl implements HospitalService {

    private static HospitalServiceImpl service = null;

    HospitalRepository repository = HospitalRepositoryImpl.getInstance();

    public static HospitalServiceImpl getInstance(){
        if(service == null)
            service = new HospitalServiceImpl();
        return service;
    }

    public Hospital create(Hospital hospital) {
        return repository.create(hospital);
    }

    public Hospital read(String id) {
        return repository.read(id);
    }

    public Hospital update(Hospital hospital) {
        return repository.update(hospital);
    }

    public void delete(String id) {
        repository.delete(id);

    }
}

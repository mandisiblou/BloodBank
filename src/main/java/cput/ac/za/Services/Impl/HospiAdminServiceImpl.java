package cput.ac.za.Services.Impl;


import cput.ac.za.Domain.HospiAdmin;
import cput.ac.za.Repositories.HospiAdminRepository;
import cput.ac.za.Repositories.Impl.HospiAdminRepositoryImpl;
import cput.ac.za.Services.HospiAdminService;

/**
 * Created by mandisi on 2017/05/31.
 */
public class HospiAdminServiceImpl implements HospiAdminService {

    private static HospiAdminServiceImpl service = null;

    HospiAdminRepository repository = HospiAdminRepositoryImpl.getInstance();

    public static HospiAdminServiceImpl getInstance(){
        if(service == null)
            service = new HospiAdminServiceImpl();
        return service;
    }

    public HospiAdmin create(HospiAdmin hospiAdmin) {
        return repository.create(hospiAdmin);
    }

    public HospiAdmin read(String id) {
        return repository.read(id);
    }

    public HospiAdmin update(HospiAdmin hospiAdmin) {
        return repository.update(hospiAdmin);
    }

    public void delete(String id) {
        repository.delete(id);

    }
}

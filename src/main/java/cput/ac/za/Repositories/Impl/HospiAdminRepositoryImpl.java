package cput.ac.za.Repositories.Impl;

import cput.ac.za.Domain.HospiAdmin;
import cput.ac.za.Repositories.HospiAdminRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mandisi on 2017/05/31.
 */
public class HospiAdminRepositoryImpl implements HospiAdminRepository {

    private static HospiAdminRepositoryImpl respository = null;

    private Map<String,HospiAdmin> adminHTable;

    private HospiAdminRepositoryImpl() {
        adminHTable = new HashMap<String, HospiAdmin>();
    }

    public static HospiAdminRepositoryImpl getInstance(){
        if(respository==null)
            respository = new HospiAdminRepositoryImpl();
        return respository;
    }

    public HospiAdmin create(HospiAdmin hospiAdmin) {
        adminHTable.put(hospiAdmin.getId(), hospiAdmin);
        HospiAdmin savedHospiAdmin = adminHTable.get(hospiAdmin.getId());
        return savedHospiAdmin;
    }

    public HospiAdmin read(String id) {
        HospiAdmin hospiAdmin = adminHTable.get(id);
        return hospiAdmin;
    }

    public HospiAdmin update(HospiAdmin hospiAdmin) {
        adminHTable.put(hospiAdmin.getId(), hospiAdmin);
        HospiAdmin savedHospiAdmin = adminHTable.get(hospiAdmin.getId());
        return savedHospiAdmin;
    }

    public void delete(String id) {
        adminHTable.remove(id);

    }
}

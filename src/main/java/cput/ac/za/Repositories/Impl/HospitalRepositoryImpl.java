package cput.ac.za.Repositories.Impl;

import cput.ac.za.Domain.Hospital;
import cput.ac.za.Repositories.HospitalRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mandisi on 2017/05/31.
 */
public class HospitalRepositoryImpl implements HospitalRepository {

    private static HospitalRepositoryImpl respository = null;

    private Map<String,Hospital> hospitalTable;

    private HospitalRepositoryImpl() {
        hospitalTable = new HashMap<String, Hospital>();
    }

    public static HospitalRepositoryImpl getInstance(){
        if(respository==null)
            respository = new HospitalRepositoryImpl();
        return respository;
    }

    public Hospital create(Hospital hospital) {
        hospitalTable.put(hospital.getId(), hospital);
        Hospital savedHospital = hospitalTable.get(hospital.getId());
        return savedHospital;
    }

    public Hospital read(String id) {
        Hospital hospital = hospitalTable.get(id);
        return hospital;
    }

    public Hospital update(Hospital hospital) {
        hospitalTable.put(hospital.getId(), hospital);
        Hospital savedHospital = hospitalTable.get(hospital.getId());
        return savedHospital;
    }

    public void delete(String id) {
        hospitalTable.remove(id);

    }
}

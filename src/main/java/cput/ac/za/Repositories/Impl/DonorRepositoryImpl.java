package cput.ac.za.Repositories.Impl;


import cput.ac.za.Domain.Donor;
import cput.ac.za.Repositories.DonorRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mandisi on 2017/05/31.
 */
public class DonorRepositoryImpl implements DonorRepository {

    private static DonorRepositoryImpl respository = null;

    private Map<String,Donor> donorTable;

    private DonorRepositoryImpl() {
        donorTable = new HashMap<String, Donor>();
    }

    public static DonorRepositoryImpl getInstance(){
        if(respository==null)
            respository = new DonorRepositoryImpl();
        return respository;
    }

    public Donor create(Donor donor) {
        donorTable.put(donor.getId(),donor);
        Donor savedDonor = donorTable.get(donor.getId());
        return savedDonor;
    }

    public Donor read(String id) {
        Donor donor = donorTable.get(id);
        return donor;
    }

    public Donor update(Donor donor) {
        donorTable.put(donor.getId(),donor);
        Donor savedDonor = donorTable.get(donor.getId());
        return savedDonor;
    }

    public void delete(String id) {
        donorTable.remove(id);

    }
}

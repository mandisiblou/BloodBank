package cput.ac.za.Services;


import cput.ac.za.Domain.Donor;

/**
 * Created by mandisi on 2017/05/31.
 */
public interface DonorService {
    Donor create(Donor donor);
    Donor read(String id);
    Donor update(Donor donor);
    void delete(String id);
}

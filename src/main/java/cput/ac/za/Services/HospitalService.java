package cput.ac.za.Services;


import cput.ac.za.Domain.Hospital;

/**
 * Created by hashcode on 2017/05/16.
 */
public interface HospitalService {
    Hospital create(Hospital hospital);
    Hospital read(String id);
    Hospital update(Hospital hospital);
    void delete(String id);
}

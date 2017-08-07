package cput.ac.za.Repositories;


import cput.ac.za.Domain.Hospital;

/**
 * Created by hashcode on 2017/05/09.
 */
public interface HospitalRepository {
    Hospital create(Hospital hospital);

    Hospital read(String id);

    Hospital update(Hospital hospital);

    void delete(String id);
}

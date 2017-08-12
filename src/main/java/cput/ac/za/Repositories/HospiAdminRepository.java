package cput.ac.za.Repositories;


import cput.ac.za.Domain.HospiAdmin;

/**
 * Created by hashcode on 2017/05/09.
 */
public interface HospiAdminRepository {
    HospiAdmin create(HospiAdmin hospiAdmin);

    HospiAdmin read(String id);

    HospiAdmin update(HospiAdmin hospiAdmin);

    void delete(String id);
}

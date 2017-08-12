package cput.ac.za.Services;


import cput.ac.za.Domain.HospiAdmin;

/**
 * Created by hashcode on 2017/05/16.
 */
public interface HospiAdminService {
    HospiAdmin create(HospiAdmin hospiAdmin);
    HospiAdmin read(String id);
    HospiAdmin update(HospiAdmin hospiAdmin);
    void delete(String id);
}

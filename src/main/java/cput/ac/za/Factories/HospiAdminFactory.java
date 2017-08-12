package cput.ac.za.Factories;


import cput.ac.za.Domain.HospiAdmin;

import java.util.Map;

/**
 * Created by mandisi on 2017/05/31.
 */
public class HospiAdminFactory {

    public static HospiAdmin getHospiAdmin(Map<String, String> values){
        HospiAdmin hospiAdmin = new HospiAdmin.Builder()
                .emailA(values.get("emailA"))
                .firstname(values.get("firstname"))
                .lastname(values.get("lastname"))
                .id(values.get("id"))
                .build();
        return hospiAdmin;

    }


}

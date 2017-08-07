package cput.ac.za.Factories;


import cput.ac.za.Domain.Hospital;

import java.util.Map;

/**
 * Created by mandisi on 2017/05/31.
 */
public class HospitalFactory {

    public static Hospital getHospital(Map<String, String> values){
        Hospital hospital = new Hospital.Builder()
                .emailA(values.get("emailA"))
                .hName(values.get("hName"))
                .phone(values.get("phone"))
                .addres(values.get("addres"))
                .id(values.get("id"))
                .build();
        return hospital;

    }


}

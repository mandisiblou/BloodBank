package cput.ac.za.Factories;




import cput.ac.za.Domain.Acceptor;

import java.util.Map;

/**
 * Created by mandisi on 2017/05/31.
 */
public class AcceptorFactory {

    public static Acceptor getAcceptor(Map<String, String> values, int password, int mobileN){
        Acceptor acceptor = new Acceptor.Builder()
                .password(password)
                .mobileN(mobileN)
                .id(values.get("id"))
                .Fname(values.get("Fname"))
                .Lname(values.get("Lname"))
                .DOB(values.get("DOB"))
                .gender(values.get("gender"))
                .bloodGroup(values.get("bloodGroup"))
                .division(values.get("division"))
                .district(values.get("district"))
                .availDate(values.get("availDate"))
                .build();
        return acceptor;
    }
}

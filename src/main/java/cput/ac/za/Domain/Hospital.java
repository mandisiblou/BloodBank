package cput.ac.za.Domain;

import java.io.Serializable;

/**
 * Created by hashcode on 2017/05/09.
 */
public class Hospital implements Serializable{
    private String id;
    private String hName;
    private String phone;
    private String emailA;
    private String addres;

    public String getId() {
        return id;
    }

    public String gethName() {
        return hName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmailA() {
        return emailA;
    }

    public String getAddres() {
        return addres;
    }

    private Hospital() {
    }

    public Hospital(Builder builder) {
        this.emailA = builder.emailA;
        this.id = builder.id;
        this.hName = builder.hName;
        this.phone = builder.phone;
        this.addres = builder.addres;
    }

    public static class Builder{
        private String id;
        private String hName;
        private String phone;
        private String emailA;
        private String addres;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder hName(String value){
            this.hName = value;
            return this;
        }

        public Builder phone(String value){
            this.phone = value;
            return this;
        }

        public Builder emailA(String value){
            this.emailA = value;
            return this;
        }

        public Builder addres(String value){
            this.addres = value;
            return this;
        }

        public Hospital build(){
            return new Hospital(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hospital admin = (Hospital) o;

        return id.equals(admin.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

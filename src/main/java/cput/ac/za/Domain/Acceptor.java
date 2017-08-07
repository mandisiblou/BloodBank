package cput.ac.za.Domain;

import java.io.Serializable;

/**
 * Created by mandisi on 2017/07/31.
 */
public class Acceptor implements Serializable{
    private int password;
    private int mobileN;
    private String id;
    private String Fname;
    private String Lname;
    private String DOB;
    private String gender;
    private String bloodGroup;
    private String division;
    private String district;
    private String availDate;

    public String getId() {
        return id;
    }

    public int getPassword() {
        return password;
    }

    public int getMobileN() {
        return mobileN;
    }

    public String getFname() {
        return Fname;
    }

    public String getLname() {
        return Lname;
    }

    public String getDOB() {
        return DOB;
    }

    public String getGender() {
        return gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getDivision() {
        return division;
    }

    public String getDistrict() {
        return district;
    }

    public String getAvailDate() {
        return availDate;
    }

    private Acceptor() {
    }

    public Acceptor(Builder builder) {
        this.id = builder.id;
        this.password = builder.password;
        this.mobileN = builder.mobileN;
        this.Fname = builder.Fname;
        this.Lname = builder.Lname;
        this.DOB = builder.DOB;
        this.gender = builder.gender;
        this.bloodGroup = builder.bloodGroup;
        this.division = builder.division;
        this.district = builder.district;
        this.availDate = builder.availDate;
    }

    public static class Builder{
        private String id;
        private int password;
        private int mobileN;
        private String Fname;
        private String Lname;
        private String DOB;
        private String gender;
        private String bloodGroup;
        private String division;
        private String district;
        private String availDate;

        public Builder id(String value){
            this.id = value;
            return this;
        }
        public Builder mobileN(int value){
            this.mobileN = value;
            return this;
        }
        public Builder password(int value){
            this.password = value;
            return this;
        }

        public Builder Fname(String value){
            this.Fname = value;
            return this;
        }

        public Builder Lname(String value){
            this.Lname = value;
            return this;
        }

        public Builder DOB(String value){
            this.DOB = value;
            return this;
        }
        public Builder gender(String value){
            this.gender = value;
            return this;
        }

        public Builder bloodGroup(String value){
            this.bloodGroup = value;
            return this;
        }

        public Builder availDate(String value){
            this.availDate = value;
            return this;
        }
        public Builder division(String value){
            this.division = value;
            return this;
        }

        public Builder district(String value){
            this.district = value;
            return this;
        }
        public Acceptor build(){
            return new Acceptor(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Acceptor employee = (Acceptor) o;

        return id.equals(employee.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

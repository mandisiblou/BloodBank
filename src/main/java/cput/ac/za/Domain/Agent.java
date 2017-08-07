package cput.ac.za.Domain;

import java.io.Serializable;

/**
 * Created by hashcode on 2017/05/09.
 */
public class Agent implements Serializable{
    private String id;
    private String firstname;
    private String lastname;
    private String emailA;

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmailA() {
        return emailA;
    }

    private Agent() {
    }

    public Agent(Builder builder) {
        this.emailA = builder.emailA;
        this.id = builder.id;
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
    }

    public static class Builder{
        private String id;
        private String firstname;
        private String lastname;
        private String emailA;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder firstname(String value){
            this.firstname = value;
            return this;
        }

        public Builder lastname(String value){
            this.lastname = value;
            return this;
        }

        public Builder emailA(String value){
            this.emailA = value;
            return this;
        }

        public Agent build(){
            return new Agent(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Agent agent = (Agent) o;

        return id.equals(agent.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

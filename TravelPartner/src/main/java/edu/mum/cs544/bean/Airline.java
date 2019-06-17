package edu.mum.cs544.bean;

import java.io.Serializable;


public class Airline implements Serializable {

    private static final long serialVersionUID = 1L;
    private long id;
    private String name;

    public Airline() {
    }

    public Airline(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

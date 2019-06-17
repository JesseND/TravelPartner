package edu.mum.cs544.bean;

import java.io.Serializable;

public class Airplane implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private String serialnr;
    private String model;
    private int capacity;

    public Airplane() {
    }

    public Airplane(String serialnr, String model, int capacity) {
        this.serialnr = serialnr;
        this.model = model;
        this.capacity = capacity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSerialnr() {
        return serialnr;
    }

    public void setSerialnr(String serialnr) {
        this.serialnr = serialnr;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "id=" + id +
                ", serialnr='" + serialnr + '\'' +
                ", model='" + model + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}

package com.hfonseca.tdd.model;

public class Passenger {

    private Long id;
    private String name;
    private PassengerType type;

    public Passenger(Long id, String name, PassengerType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PassengerType getType() {
        return type;
    }

    public void setType(PassengerType type) {
        this.type = type;
    }
}

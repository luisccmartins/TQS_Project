package com.uatqs.drugdrop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Stores")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "name")
    private String name;

    @OneToOne
    private Address address;

    @Column(name = "druglist")
    @ElementCollection
    public List<Drug> druglist = new ArrayList<Drug>();

    public Store(String name, Address address, List<Drug> druglist){
        this.name = name;
        this.address = address;
        this.druglist = druglist;
    }

    public Store(){

    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Drug> getDruglist() {
        return druglist;
    }

    public void setDruglist(List<Drug> druglist) {
        this.druglist = druglist;
    }

    
}

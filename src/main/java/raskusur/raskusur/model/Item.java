package raskusur.raskusur.model;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="item")
public class Item {
    
    @Id
    @GeneratedValue
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="value")
    private Double value;

    @Column(name="is_owed")
    private String isOwed; // person who payed

    @Column(name="owes_list")
    private ArrayList<Person> owesList; 

    public Item() {

    }

    public Item(String name, Double value, String isOwed, ArrayList<Person> owes) {
        this.name = name;
        this.value = value;
        this.isOwed = isOwed;
        this.owesList = owes;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return this.value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getIsOwed() {
        return isOwed;
    }

    public void setIsOwned(String isOwed) {
        this.isOwed = isOwed;
    }

    public void setIsOwed(String isOwed) {
        this.isOwed = isOwed;
    }

    public ArrayList<Person> getOwesList() {
        return owesList;
    }

    public void setOwesList(ArrayList<Person> owesList) {
        this.owesList = owesList;
    }

}

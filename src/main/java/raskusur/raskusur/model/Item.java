package raskusur.raskusur.model;

import java.util.ArrayList;

public class Item {
    
    private int id;
    private String name;
    private Double value;
    private String isOwed; // person who payed
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

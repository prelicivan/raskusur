package raskusur.raskusur.model;
import java.sql.Timestamp;
import java.util.LinkedList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ledger")
public class Ledger {
    
    @Id
    @GeneratedValue
    private int id;

    @Column(name="datetime")
    private Timestamp datetime;

    @Column(name="item_list")
    private LinkedList<Item> itemList;

    public Ledger() {
    }

    public Ledger(int id, LinkedList<Item> itemList) {
        this.id = id;
        //this.datetime = datetime;
        this.itemList = itemList;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDatetime() {
        return this.datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public LinkedList<Item> getItemList() {
        return this.itemList;
    }

    public void setItemList(LinkedList<Item> itemList) {
        this.itemList = itemList;
    }

}

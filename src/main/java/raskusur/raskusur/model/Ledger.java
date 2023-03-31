package raskusur.raskusur.model;
import java.sql.Timestamp;
import java.util.LinkedList;

public class Ledger {
    
    private int id;
    private Timestamp datetime;
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

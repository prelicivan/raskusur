package raskusur.raskusur.model;

import java.util.List;

public class User {
    
    private int id;
    private String username;
    private String password;
    private String name;
    private List<Ledger> ledgerList;

    public User() {
        
    }

    public User(int id, String username, String password, String name, List<Ledger> ledgerList) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.ledgerList = ledgerList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ledger> getLedgerList() {
        return ledgerList;
    }

    public void setLedgerList(List<Ledger> ledgerList) {
        this.ledgerList = ledgerList;
    }

    

}

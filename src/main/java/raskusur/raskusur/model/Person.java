package raskusur.raskusur.model;
public class Person {

    private int id;
    private String name;
    private Double balance;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
        this.balance = 0.0;
    }

    public Person(String name, Double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return this.balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}

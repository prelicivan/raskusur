package raskusur.raskusur.util;

import java.util.Comparator;

import raskusur.raskusur.model.Person;

public class PersonComparator implements Comparator<Person>{

    @Override
    public int compare(Person arg0, Person arg1) {
        double delta = arg0.getBalance() - arg1.getBalance();
        if (delta > 0.00001) return 1;
        if (delta < -0.00001) return -1;
        return 0;
    }
    

}

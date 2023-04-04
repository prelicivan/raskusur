package raskusur.raskusur.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import raskusur.raskusur.model.Ledger;
import raskusur.raskusur.model.Person;
import raskusur.raskusur.util.PersonComparator;
import raskusur.raskusur.model.Item;

@Service
public class LedgerController {

    private static LedgerController instance;

    private HashMap personHM;
    private ArrayList<Person> balancePlusList; // owes money
    private ArrayList<Person> balanceMinusList; // is owed money

    private LedgerController() {
        personHM = new HashMap<String, Double>();
        balanceMinusList = new ArrayList<>();
        balancePlusList = new ArrayList<>();
    }

    public static LedgerController getInstance() {
        if (instance == null) {
            instance = new LedgerController();
        }
        return instance;
    }

    public void calculateDebt(Ledger ledger) {
        addToPersonList(ledger); // adds persons to personListCont with their balance
        filterByBalance(personHM); // sorts person according to their balance + -
        sortListAscending(balanceMinusList); // sorts in ascending order because of -
        sortListDescending(balancePlusList); // sorts in descending order
        calculateDifferenceInBalance(); // prints out who owes how much to whom
    }

    private void addToPersonList(Ledger ledger) {
        LinkedList<Item> items = ledger.getItemList();
        for (Item i : items) {
            if (i.getOwesList().size() == 0)
                continue; // if there is no one who owes money then dont add that expense

            int numOfPersons = i.getOwesList().size() + 1; // number of persons that pay for the item
            double value = i.getValue(); // value of the itme

            double valueIsOwed = value / numOfPersons - value; // a negative value that is added to ISOWED
            double valueOwes = value / numOfPersons; // a positive value that is added to the balance of OWES

            if (personHM.containsKey(i.getIsOwed())) { // if person exists just add to balance
                double balance = (double) personHM.get(i.getIsOwed()) + valueIsOwed;
                personHM.put(i.getIsOwed(), balance);
            } else { // if person doesnt exist add new person
                personHM.put(i.getIsOwed(), valueIsOwed);
            }

            for (Person p : i.getOwesList()) {
                if (personHM.containsKey(p.getName())) {
                    double balance = (double) personHM.get(p.getName()) + valueOwes;
                    personHM.put(p.getName(), balance);
                } else {
                    personHM.put(p.getName(), valueOwes);
                }
            }
        }
    }

    private void filterByBalance(HashMap<String, Double> map) {
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                balancePlusList.add(new Person(entry.getKey(), entry.getValue()));
            } else if (entry.getValue() < 0) { // else if - so it doesnt add person with balance = 0
                balanceMinusList.add(new Person(entry.getKey(), entry.getValue()));
            }
        }
    }

    private void sortListAscending(List<Person> list) {
        PersonComparator ps = new PersonComparator();
        Collections.sort(list, ps);
    }

    private void sortListDescending(List<Person> list) {
        PersonComparator ps = new PersonComparator();
        Collections.sort(list, ps);
        Collections.reverse(list);
    }

    private void calculateDifferenceInBalance() {
        int countM = 0;
        int countP = 0;

        while (balanceMinusList.size() > countM) {
            while (balancePlusList.size() > countP) {
                Person pMinus = balanceMinusList.get(countM);
                Person pPlus = balancePlusList.get(countP);
                if (Math.abs(pMinus.getBalance()) >= pPlus.getBalance()) {
                    System.out.println(pPlus.getName() + " "
                            + pPlus.getBalance() + " --> "
                            + pMinus.getName());

                    Double diff = pMinus.getBalance() + pPlus.getBalance();
                    pMinus.setBalance(diff);
                    pPlus.setBalance(0.0);
                    if (pMinus.getBalance() == 0.0) {
                        countM++;
                    }
                    countP++;
                } else {
                    System.out.println(
                            pPlus.getName() + " "
                                    + Math.abs(pMinus.getBalance()) + " --> "
                                    + pMinus.getName());

                    Double diff = pMinus.getBalance() + pPlus.getBalance();
                    pMinus.setBalance(0.0);
                    pPlus.setBalance(diff);
                    if (pPlus.getBalance() == 0.0) {
                        countP++;
                    }
                    countM++;
                }
            }
        }
    }

}

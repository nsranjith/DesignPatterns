package LLD.splitwise.models;

import java.util.Currency;
import java.util.HashMap;

public class Expense {
    Double amount;
    Currency currency;
    String description;
    HashMap<User, Double> paidBy;
    HashMap<User, Double> ownedBy;
}

package com.example.designpatterns.Adapter;

import com.example.designpatterns.Adapter.library.YesBank;

public class Client {

    public static void main(String[] args) {
        BankingAdapter yesBank=new BankingAdapterImpl(new YesBank());
        System.out.println(yesBank.getBalance("25434535"));
    }
}

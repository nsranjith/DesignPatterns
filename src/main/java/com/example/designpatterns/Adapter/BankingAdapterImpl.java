package com.example.designpatterns.Adapter;

import com.example.designpatterns.Adapter.library.YesBank;

public class BankingAdapterImpl implements BankingAdapter {
    YesBank yesBank;

    public BankingAdapterImpl(YesBank yesBank) {
        this.yesBank = yesBank;
    }

    @Override
    public Double getBalance(String accountNo) {
        Long amount=yesBank.getBalance(accountNo);
        return Double.parseDouble(String.valueOf(amount));
    }
}

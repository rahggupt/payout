package com.test;

import java.util.List;

public class StaticData {
    List<BankAccountData> bankAccountData;
    List<SellerModeMap> sellerModeMap;

    public List<BankAccountData> getBankAccountData() {
        return bankAccountData;
    }

    public void setBankAccountData(List<BankAccountData> bankAccountData) {
        this.bankAccountData = bankAccountData;
    }

    public List<SellerModeMap> getSellerModeMap() {
        return sellerModeMap;
    }

    public void setSellerModeMap(List<SellerModeMap> sellerModeMap) {
        this.sellerModeMap = sellerModeMap;
    }

    @Override
    public String toString() {
        return "StaticData{" +
                "bankAccountData=" + bankAccountData +
                ", sellerModeMap=" + sellerModeMap +
                '}';
    }
}

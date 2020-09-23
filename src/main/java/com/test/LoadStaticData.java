package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class LoadStaticData {

    static List<BankAccountData> bankAccountDataList = new ArrayList<>();

    static List<SellerModeMap> sellerModeMaps = new ArrayList<>();

    private static LoadStaticData instance = new LoadStaticData();

    public LoadStaticData getInstance(){
        if (instance == null){
            instance = new LoadStaticData();
        }
        return  instance;
    }

    public static StaticData loadData(){
        loadBankAccountDetails();
        loadSellerModeMap();
        StaticData data = new StaticData();
        data.setBankAccountData(bankAccountDataList);
        data.setSellerModeMap(sellerModeMaps);
        return data;
    }

    private static void loadBankAccountDetails() {
        BankAccountData b1 = new BankAccountData();
        b1.setBankName("b1"); b1.setBalance(new AtomicInteger(1000));

        BankAccountData b2 = new BankAccountData();
        b2.setBankName("b2"); b2.setBalance(new AtomicInteger(1000));

        BankAccountData b3 = new BankAccountData();
        b3.setBankName("b3"); b3.setBalance(new AtomicInteger(1000));

        bankAccountDataList.add(b1);
        bankAccountDataList.add(b2);
        bankAccountDataList.add(b3);
    }

    private static void loadSellerModeMap() {
        SellerModeMap s1 = new SellerModeMap();
        s1.setSellerName("s1"); s1.setModeEnum(ModeEnum.IMPS);

        SellerModeMap s2 = new SellerModeMap();
        s2.setSellerName("s2"); s2.setModeEnum(ModeEnum.NEFT);

        SellerModeMap s3 = new SellerModeMap();
        s3.setSellerName("s3"); s3.setModeEnum(ModeEnum.IMPS);

        SellerModeMap s4 = new SellerModeMap();
        s3.setSellerName("c1"); s4.setModeEnum(ModeEnum.IMPS);

        sellerModeMaps.add(s1);
        sellerModeMaps.add(s2);
        sellerModeMaps.add(s3);
        sellerModeMaps.add(s4);

    }
}

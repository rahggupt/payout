import com.test.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestMainClass {

    static DataStore dataStore = new DataStore();
    Object processObj = new Object();

    public static void main(String[] args) {

        StaticData data = LoadStaticData.loadData();
        TestMainClass mainClass = new TestMainClass();

        OrderLevelRequest orderLData = new OrderLevelRequest();
        orderLData.setAmount(1000);
        orderLData.setEntityEnum(EntityEnum.SELLER);
        orderLData.setEntityName("s1");

        mainClass.processOrderLevelData(orderLData);

        OrderLevelRequest orderLData1 = new OrderLevelRequest();
        orderLData1.setAmount(4000);
        orderLData1.setEntityEnum(EntityEnum.SELLER);
        orderLData1.setEntityName("s1");
        mainClass.processOrderLevelData(orderLData1);

        OrderLevelRequest orderLData2 = new OrderLevelRequest();
        orderLData2.setAmount(5000);
        orderLData2.setEntityEnum(EntityEnum.CUSTOMER);
        orderLData2.setEntityName("c1");
        mainClass.processOrderLevelData(orderLData2);
//        processOrderLevelData(orderLData);
//        processOrderLevelData(orderLData);
//        processOrderLevelData(orderLData);
//        processOrderLevelData(orderLData);
//        processOrderLevelData(orderLData);


        mainClass.payOut(data);
    }

    private synchronized void payOut(StaticData data) {
        System.out.println(dataStore);
        System.out.println(data);
        for(String entityName : dataStore.getDataStoreMap().keySet()){
            for (SellerModeMap sellerModeMap: data.getSellerModeMap()){
                if(sellerModeMap.getSellerName() != null && sellerModeMap.getSellerName().equals(entityName)) {
                        System.out.println("Seller Found");
                        synchronized (processObj){
                            validateTransaction(sellerModeMap, data);
                        }
                }
            }
        }

        System.out.println("after processing " + data);

    }

    private boolean validateTransaction(SellerModeMap sellerModeMap, StaticData data) {
        int totalTxnSum = 0;
        // validation 1 :if s1 is present in my static data
        if(data.getSellerModeMap().stream().findFirst().get().getSellerName().equals(sellerModeMap.getSellerName())){
            for(Transactions txn : dataStore.getDataStoreMap().get(sellerModeMap.getSellerName())){
                totalTxnSum += txn.getAmount();
            }
        }
        System.out.println(totalTxnSum);
        for(BankAccountData bankAccountData : data.getBankAccountData()){
            //validation 2 : check balance in the bank
            if(bankAccountData.getBalance().get() >= totalTxnSum){
                bankAccountData.getBalance().getAndSet(bankAccountData.getBalance().get() - totalTxnSum);
                return true;
            }
        }
        System.out.println(" source a/c balance is insufficient, do not any transaction");

        return false;
    }

    private synchronized void processOrderLevelData(OrderLevelRequest orderLData) {
        if(dataStore.getDataStoreMap() == null){
            dataStore.setDataStoreMap(new HashMap<>());
        }
//        if(dataStore.getDataStoreMap() != null){
            List<Transactions> txn = dataStore.getDataStoreMap().get(orderLData.getEntityName());
            if(txn != null && !txn.isEmpty()){
                txn.add(new Transactions(orderLData.getAmount(), "sadad"));
            } else if(txn == null) {
                txn = new ArrayList<>();
                txn.add(new Transactions(orderLData.getAmount(), "sadad"));
            }
            dataStore.getDataStoreMap().put(orderLData.getEntityName(), txn);
//        }
    }
}

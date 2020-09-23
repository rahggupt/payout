package com.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataStore {
    public Map<String, List<Transactions>> getDataStoreMap() {
        return dataStoreMap;
    }

    public void setDataStoreMap(Map<String, List<Transactions>> dataStoreMap) {
        this.dataStoreMap = dataStoreMap;
    }

    Map<String, List<Transactions>> dataStoreMap = new HashMap<>();

    @Override
    public String toString() {
        return "DataStore{" +
                "dataStoreMap=" + dataStoreMap +
                '}';
    }
}

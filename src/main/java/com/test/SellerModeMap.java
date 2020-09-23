package com.test;

import java.util.Objects;

public class SellerModeMap {
    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public ModeEnum getModeEnum() {
        return modeEnum;
    }

    public void setModeEnum(ModeEnum modeEnum) {
        this.modeEnum = modeEnum;
    }

    private String sellerName;
    ModeEnum modeEnum;

    @Override
    public String toString() {
        return "SellerModeMap{" +
                "sellerName='" + sellerName + '\'' +
                ", modeEnum=" + modeEnum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellerModeMap that = (SellerModeMap) o;
        return sellerName.equals(that.sellerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sellerName);
    }
}

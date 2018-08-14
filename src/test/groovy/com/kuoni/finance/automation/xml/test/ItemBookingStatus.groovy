package com.kuoni.finance.automation.xml.test

class ItemBookingStatus {

    private String itemValue
    private String netValue
    private String itemStatus
    private String paymentValue
    private int rowCount

    public String getItemValue() {
        return itemValue
    }
    public void setItemValue(String itemValueStatus) {
        this.itemValue = itemValueStatus
    }

    public String getNetValue(){
        return netValue
    }
    public void setNetValue(String netValueStatus){
        this.netValue = netValueStatus
    }

    public String getItemStatus(){
        return itemStatus
    }
    public void setItemStatus(String itemStat){
        this.itemStatus = itemStat
    }

    public String getPaymentValue(){
        return paymentValue
    }
    public void setPaymentValue(String paymentValeStatus){
        this.paymentValue = paymentValeStatus
    }

    public int getRowCount() {
        return rowCount
    }
    public void setRowCount(int rowCountStatus) {
        this.rowCount = rowCountStatus
    }

}

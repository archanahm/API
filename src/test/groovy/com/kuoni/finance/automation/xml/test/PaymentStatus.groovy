/**
 * 
 */
package com.kuoni.finance.automation.xml.test

/**
 * @author 104337
 *
 */
class PaymentStatus implements Serializable{
	
	private String paymentStatus
	private String amount
	private int rowcount
	
	/**
	 * @return the paymentStatus
	 */
	public String getPaymentStatus() {
		return paymentStatus;
	}
	/**
	 * @param paymentStatus the paymentStatus to set
	 */
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	/**
	 * @param numberofrows to set
	 */
	public void setNumberOfRows(int rows){
		this.rowcount = rows
	}
	
	/**
	 * @param numberofrows to set
	 */
	public int getNumberOfRows(){
		return rowcount
	}

}

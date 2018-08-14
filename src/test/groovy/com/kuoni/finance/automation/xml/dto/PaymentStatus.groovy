/**
 * 
 */
package com.kuoni.finance.automation.xml.dto

/**
 * @author 104337
 *
 */
class PaymentStatus implements Serializable{

	String paymentStatus
	Integer totalAmount
	private List<PaymentStatusDetails> paymentStatusDetails;

	public PaymentStatus() {
		paymentStatusDetails = new ArrayList<>()
	}

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
	public Integer getTotalAmount() {
		return totalAmount;
	}
	
	/**
	 * @param amount the amount to set
	 */
	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * @param numberofrows to set
	 */
	public int getNumberOfRows(){
		return paymentStatusDetails.size()
	}

	public List<PaymentStatusDetails> getPaymentStatusDetails() {
		return paymentStatusDetails;
	}

	@Override
	public String toString() {
		return "PaymentStatus [paymentStatus=" + paymentStatus + ", totalAmount=" + totalAmount + ", paymentStatusDetails=" + paymentStatusDetails + "]";
	}
}

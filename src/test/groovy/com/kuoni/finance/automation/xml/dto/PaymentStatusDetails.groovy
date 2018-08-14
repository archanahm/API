/**
 * 
 */
package com.kuoni.finance.automation.xml.dto

/**
 * @author 104337
 *
 */
class PaymentStatusDetails implements Serializable{

	String paymentStatus
	Integer amount

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
	public Integer getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "PaymentStatusDetails [paymentStatus=" + paymentStatus + ", amount=" + amount + "]";
	}
}

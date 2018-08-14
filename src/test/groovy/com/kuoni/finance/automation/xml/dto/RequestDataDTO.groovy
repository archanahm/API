package com.kuoni.finance.automation.xml.dto

import javax.xml.datatype.XMLGregorianCalendar

class RequestDataDTO implements Serializable{

	private int clientId
	private String emailID
	private String password
	private String country
	private String currency
	private String language
	private String requestMode
	private int paxId
	private String paxType
	private String itemCityCode
	private String itemCode
	private boolean alternativesAllowed
	private int duration
	private String hotelRoomCode
	private boolean extraBed
	private String hotelID
	private int numberOfBeds
	private int hotemRoomPaxID
	private String paymentGateWayCode
	private String cardType
	private String cardHolderName
	private String addressLine1
	private String cardCityName
	private String zipCode
	private String cardCountry
	private String cardNumber
	private String cardCV2
	private String cardExpiryMonth
	private String cardExpiryYear
	private XMLGregorianCalendar checkinDate
	private XMLGregorianCalendar departureDate;
	private XMLGregorianCalendar bookignReference;
	private String addBookingCurrency
	private int bookingItemReference
	private String paxName
	private XMLGregorianCalendar checkOutDate
	private String url
	private String as400SiteId

	/**
	 * @return the checkinDate
	 */
	public XMLGregorianCalendar getCheckOutDate() {
		return checkOutDate;
	}

	/**
	 * @param checkinDate the checkinDate to set
	 */
	public void setCheckOutDate(XMLGregorianCalendar checkOutDate) {
		this.checkOutDate = checkOutDate;
	}


	/**
	 * @return the clientId
	 */
	public int getClientId() {
		return clientId;
	}
	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	/**
	 * @return the emailID
	 */
	public String getEmailID() {
		return emailID;
	}
	/**
	 * @param emailID the emailID to set
	 */
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	/**
	 * @return the requestMode
	 */
	public String getRequestMode() {
		return requestMode;
	}
	/**
	 * @param requestMode the requestMode to set
	 */
	public void setRequestMode(String requestMode) {
		this.requestMode = requestMode;
	}
	/**
	 * @return the paxId
	 */
	public int getPaxId() {
		return paxId;
	}
	/**
	 * @param paxId the paxId to set
	 */
	public void setPaxId(int paxId) {
		this.paxId = paxId;
	}
	/**
	 * @return the paxType
	 */
	public String getPaxType() {
		return paxType;
	}
	/**
	 * @param paxType the paxType to set
	 */
	public void setPaxType(String paxType) {
		this.paxType = paxType;
	}
	/**
	 * @return the itemCityCode
	 */
	public String getItemCityCode() {
		return itemCityCode;
	}
	/**
	 * @param itemCityCode the itemCityCode to set
	 */
	public void setItemCityCode(String itemCityCode) {
		this.itemCityCode = itemCityCode;
	}
	/**
	 * @return the itemCode
	 */
	public String getItemCode() {
		return itemCode;
	}
	/**
	 * @param itemCode the itemCode to set
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	/**
	 * @return the alternativesAllowed
	 */
	public boolean isAlternativesAllowed() {
		return alternativesAllowed;
	}
	/**
	 * @param alternativesAllowed the alternativesAllowed to set
	 */
	public void setAlternativesAllowed(boolean alternativesAllowed) {
		this.alternativesAllowed = alternativesAllowed;
	}
	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	/**
	 * @return the hotelRoomCode
	 */
	public String getHotelRoomCode() {
		return hotelRoomCode;
	}
	/**
	 * @param hotelRoomCode the hotelRoomCode to set
	 */
	public void setHotelRoomCode(String hotelRoomCode) {
		this.hotelRoomCode = hotelRoomCode;
	}
	/**
	 * @return the extraBed
	 */
	public boolean isExtraBed() {
		return extraBed;
	}
	/**
	 * @param extraBed the extraBed to set
	 */
	public void setExtraBed(boolean extraBed) {
		this.extraBed = extraBed;
	}
	/**
	 * @return the hotelID
	 */
	public String getHotelID() {
		return hotelID;
	}
	/**
	 * @param hotelID the hotelID to set
	 */
	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}
	/**
	 * @return the numberOfBeds
	 */
	public int getNumberOfCots() {
		return numberOfBeds;
	}
	/**
	 * @param numberOfBeds the numberOfBeds to set
	 */
	public void setNumberOfCots(int numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}
	/**
	 * @return the hotemRoomPaxID
	 */
	public int getHotemRoomPaxID() {
		return hotemRoomPaxID;
	}
	/**
	 * @param hotemRoomPaxID the hotemRoomPaxID to set
	 */
	public void setHotemRoomPaxID(int hotemRoomPaxID) {
		this.hotemRoomPaxID = hotemRoomPaxID;
	}
	/**
	 * @return the paymentGateWayCode
	 */
	public String getPaymentGateWayCode() {
		return paymentGateWayCode;
	}
	/**
	 * @param paymentGateWayCode the paymentGateWayCode to set
	 */
	public void setPaymentGateWayCode(String paymentGateWayCode) {
		this.paymentGateWayCode = paymentGateWayCode;
	}
	/**
	 * @return the cardType
	 */
	public String getCardType() {
		return cardType;
	}
	/**
	 * @param cardType the cardType to set
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	/**
	 * @return the cardHolderName
	 */
	public String getCardHolderName() {
		return cardHolderName;
	}
	/**
	 * @param cardHolderName the cardHolderName to set
	 */
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	/**
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}
	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	/**
	 * @return the cardCityName
	 */
	public String getCardCityName() {
		return cardCityName;
	}
	/**
	 * @param cardCityName the cardCityName to set
	 */
	public void setCardCityName(String cardCityName) {
		this.cardCityName = cardCityName;
	}
	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}
	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	/**
	 * @return the cardCountry
	 */
	public String getCardCountry() {
		return cardCountry;
	}
	/**
	 * @param cardCountry the cardCountry to set
	 */
	public void setCardCountry(String cardCountry) {
		this.cardCountry = cardCountry;
	}
	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}
	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	/**
	 * @return the cardCV2
	 */
	public String getCardCV2() {
		return cardCV2;
	}
	/**
	 * @param cardCV2 the cardCV2 to set
	 */
	public void setCardCV2(String cardCV2) {
		this.cardCV2 = cardCV2;
	}
	/**
	 * @return the cardExpiryMonth
	 */
	public String getCardExpiryMonth() {
		return cardExpiryMonth;
	}
	/**
	 * @param cardExpiryMonth the cardExpiryMonth to set
	 */
	public void setCardExpiryMonth(String cardExpiryMonth) {
		this.cardExpiryMonth = cardExpiryMonth;
	}
	/**
	 * @return the cardExpiryYear
	 */
	public String getCardExpiryYear() {
		return cardExpiryYear;
	}
	/**
	 * @param cardExpiryYear the cardExpiryYear to set
	 */
	public void setCardExpiryYear(String cardExpiryYear) {
		this.cardExpiryYear = cardExpiryYear;
	}

	/**
	 * @return the checkinDate
	 */
	public XMLGregorianCalendar getCheckinDate() {
		return checkinDate;
	}

	/**
	 * @param checkinDate the checkinDate to set
	 */
	public void setCheckinDate(XMLGregorianCalendar checkinDate) {
		this.checkinDate = checkinDate;
	}

	/**
	 * @return the addBookingCurrency
	 */
	public String getAddBookingCurrency() {
		return addBookingCurrency;
	}
	/**
	 * @param addBookingCurrency the addBookingCurrency to set
	 */
	public void setAddBookingCurrency(String addBookingCurrency) {
		this.addBookingCurrency = addBookingCurrency;
	}
	/**
	 * @return the bookingItemReference
	 */
	public int getBookingItemReference() {
		return bookingItemReference;
	}
	/**
	 * @param bookingItemReference the bookingItemReference to set
	 */
	public void setBookingItemReference(int bookingItemReference) {
		this.bookingItemReference = bookingItemReference;
	}

	/**
	 * @return the departureDate
	 */
	public XMLGregorianCalendar getDepartureDate() {
		return departureDate;
	}
	/**
	 * @param departureDate the departureDate to set
	 */
	public void setDepartureDate(XMLGregorianCalendar departureDate) {
		this.departureDate = departureDate;
	}
	/**
	 * @return the bookignReference
	 */
	public XMLGregorianCalendar getBookignReference() {
		return bookignReference;
	}
	/**
	 * @param bookignReference the bookignReference to set
	 */
	public void setBookignReference(XMLGregorianCalendar bookignReference) {
		this.bookignReference = bookignReference;
	}

	/**
	 * @return the paxName
	 */
	public String getPaxName() {
		return paxName;
	}
	/**
	 * @param paxName the paxName to set
	 */
	public void setPaxName(String paxName) {
		this.paxName = paxName;
	}

	public String getUrl() {
		return url
	}

	public void setUrl(String url) {
		this.url = url
	}
	
	public String getAs400SiteId() {
		return as400SiteId
	}
	
	public void setAs400SiteId(String as400SiteId) {
		this.as400SiteId = as400SiteId
	}

	@Override
	public String toString() {
		return "RequestDataDTO [clientId=" + clientId + ", emailID=" + emailID + ", password=" + password + ", country=" + country + ", currency=" + currency + ", language="+ language + ", requestMode=" + requestMode + ", paxId=" + paxId + ", paxType=" + paxType + ", itemCityCode=" + itemCityCode + ", itemCode=" + itemCode+ ", alternativesAllowed=" + alternativesAllowed + ", duration=" + duration + ", hotelRoomCode=" + hotelRoomCode + ", extraBed=" + extraBed + ", hotelID="+ hotelID + ", numberOfBeds=" + numberOfBeds + ", hotemRoomPaxID=" + hotemRoomPaxID + ", paymentGateWayCode=" + paymentGateWayCode + ", cardType=" + cardType+ ", cardHolderName=" + cardHolderName + ", addressLine1=" + addressLine1 + ", cardCityName=" + cardCityName + ", zipCode=" + zipCode + ", cardCountry="+ cardCountry + ", cardNumber=" + cardNumber + ", cardCV2=" + cardCV2 + ", cardExpiryMonth=" + cardExpiryMonth + ", cardExpiryYear=" + cardExpiryYear+ ", checkinDate=" + checkinDate + ", departureDate=" + departureDate + ", bookignReference=" + bookignReference + ", addBookingCurrency=" + addBookingCurrency+ ", bookingItemReference=" + bookingItemReference + ", paxName=" + paxName + ", checkOutDate=" + checkOutDate +", as400SiteId=" + as400SiteId + "]";
	}
}

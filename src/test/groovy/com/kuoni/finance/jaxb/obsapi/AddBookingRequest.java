//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.29 at 09:28:41 AM BST 
//


package com.kuoni.finance.jaxb.obsapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for t_AddBookingRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="t_AddBookingRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BookingName" type="{}t_Input50" minOccurs="0"/>
 *         &lt;element name="BookingReference" type="{}t_BookingReferenceInput"/>
 *         &lt;element name="AgentReference" type="{}t_Input20" minOccurs="0"/>
 *         &lt;element name="BookingDepartureDate" type="{}t_Date" minOccurs="0"/>
 *         &lt;element name="PassengerEmail" type="{}t_EMailAddress" minOccurs="0"/>
 *         &lt;element name="PaxNames" type="{}t_PaxNames"/>
 *         &lt;element name="BookingItems" type="{}t_BookingItems"/>
 *         &lt;element name="CreditCard" type="{}t_CreditCardDetails" minOccurs="0"/>
 *         &lt;element name="PaymentGateway" type="{}t_PaymentGateway" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Currency" type="{}t_CurrencyISOCode" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddBookingRequest", propOrder = {
    "bookingName",
    "bookingReference",
    "agentReference",
    "bookingDepartureDate",
    "passengerEmail",
    "paxNames",
    "bookingItems",
    "creditCard",
    "paymentGateway"
})
@XmlRootElement(name="AddBookingRequest")
public class AddBookingRequest {

    @XmlElement(name = "BookingName")
    protected String bookingName;
    @XmlElement(name = "BookingReference", required = true)
    protected TBookingReferenceInput bookingReference;
    @XmlElement(name = "AgentReference")
    protected String agentReference;
    @XmlElement(name = "BookingDepartureDate")
    protected XMLGregorianCalendar bookingDepartureDate;
    @XmlElement(name = "PassengerEmail")
    protected String passengerEmail;
    @XmlElement(name = "PaxNames", required = true)
    protected TPaxNames paxNames;
    @XmlElement(name = "BookingItems", required = true)
    protected TBookingItems bookingItems;
    @XmlElement(name = "CreditCard")
    protected TCreditCardDetails creditCard;
    @XmlElement(name = "PaymentGateway")
    protected TPaymentGateway paymentGateway;
    @XmlAttribute(name = "Currency")
    protected String currency;

    /**
     * Gets the value of the bookingName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookingName() {
        return bookingName;
    }

    /**
     * Sets the value of the bookingName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookingName(String value) {
        this.bookingName = value;
    }

    /**
     * Gets the value of the bookingReference property.
     * 
     * @return
     *     possible object is
     *     {@link TBookingReferenceInput }
     *     
     */
    public TBookingReferenceInput getBookingReference() {
        return bookingReference;
    }

    /**
     * Sets the value of the bookingReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link TBookingReferenceInput }
     *     
     */
    public void setBookingReference(TBookingReferenceInput value) {
        this.bookingReference = value;
    }

    /**
     * Gets the value of the agentReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgentReference() {
        return agentReference;
    }

    /**
     * Sets the value of the agentReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgentReference(String value) {
        this.agentReference = value;
    }

    /**
     * Gets the value of the bookingDepartureDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBookingDepartureDate() {
        return bookingDepartureDate;
    }

    /**
     * Sets the value of the bookingDepartureDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBookingDepartureDate(XMLGregorianCalendar value) {
        this.bookingDepartureDate = value;
    }

    /**
     * Gets the value of the passengerEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassengerEmail() {
        return passengerEmail;
    }

    /**
     * Sets the value of the passengerEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassengerEmail(String value) {
        this.passengerEmail = value;
    }

    /**
     * Gets the value of the paxNames property.
     * 
     * @return
     *     possible object is
     *     {@link TPaxNames }
     *     
     */
    public TPaxNames getPaxNames() {
        return paxNames;
    }

    /**
     * Sets the value of the paxNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPaxNames }
     *     
     */
    public void setPaxNames(TPaxNames value) {
        this.paxNames = value;
    }

    /**
     * Gets the value of the bookingItems property.
     * 
     * @return
     *     possible object is
     *     {@link TBookingItems }
     *     
     */
    public TBookingItems getBookingItems() {
        return bookingItems;
    }

    /**
     * Sets the value of the bookingItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link TBookingItems }
     *     
     */
    public void setBookingItems(TBookingItems value) {
        this.bookingItems = value;
    }

    /**
     * Gets the value of the creditCard property.
     * 
     * @return
     *     possible object is
     *     {@link TCreditCardDetails }
     *     
     */
    public TCreditCardDetails getCreditCard() {
        return creditCard;
    }

    /**
     * Sets the value of the creditCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link TCreditCardDetails }
     *     
     */
    public void setCreditCard(TCreditCardDetails value) {
        this.creditCard = value;
    }

    /**
     * Gets the value of the paymentGateway property.
     * 
     * @return
     *     possible object is
     *     {@link TPaymentGateway }
     *     
     */
    public TPaymentGateway getPaymentGateway() {
        return paymentGateway;
    }

    /**
     * Sets the value of the paymentGateway property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPaymentGateway }
     *     
     */
    public void setPaymentGateway(TPaymentGateway value) {
        this.paymentGateway = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

}

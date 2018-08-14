//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.29 at 09:28:41 AM BST 
//


package com.kuoni.finance.jaxb.obsapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for t_ApartmentPriceBreakdownResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="t_ApartmentPriceBreakdownResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice minOccurs="0">
 *           &lt;sequence>
 *             &lt;element name="ItemCity" type="{}t_City"/>
 *             &lt;element name="Item" type="{}t_Item"/>
 *             &lt;element name="ItemPrice" type="{}t_BookingPrice"/>
 *             &lt;element name="ApartmentItem" type="{}t_ApartmentItemPriceBreakdown"/>
 *           &lt;/sequence>
 *           &lt;element name="Errors" type="{}t_Errors"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "t_ApartmentPriceBreakdownResponse", propOrder = {
    "itemCity",
    "item",
    "itemPrice",
    "apartmentItem",
    "errors"
})
public class TApartmentPriceBreakdownResponse {

    @XmlElement(name = "ItemCity")
    protected TCity itemCity;
    @XmlElement(name = "Item")
    protected TItem item;
    @XmlElement(name = "ItemPrice")
    protected TBookingPrice itemPrice;
    @XmlElement(name = "ApartmentItem")
    protected TApartmentItemPriceBreakdown apartmentItem;
    @XmlElement(name = "Errors")
    protected TErrors errors;

    /**
     * Gets the value of the itemCity property.
     * 
     * @return
     *     possible object is
     *     {@link TCity }
     *     
     */
    public TCity getItemCity() {
        return itemCity;
    }

    /**
     * Sets the value of the itemCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link TCity }
     *     
     */
    public void setItemCity(TCity value) {
        this.itemCity = value;
    }

    /**
     * Gets the value of the item property.
     * 
     * @return
     *     possible object is
     *     {@link TItem }
     *     
     */
    public TItem getItem() {
        return item;
    }

    /**
     * Sets the value of the item property.
     * 
     * @param value
     *     allowed object is
     *     {@link TItem }
     *     
     */
    public void setItem(TItem value) {
        this.item = value;
    }

    /**
     * Gets the value of the itemPrice property.
     * 
     * @return
     *     possible object is
     *     {@link TBookingPrice }
     *     
     */
    public TBookingPrice getItemPrice() {
        return itemPrice;
    }

    /**
     * Sets the value of the itemPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link TBookingPrice }
     *     
     */
    public void setItemPrice(TBookingPrice value) {
        this.itemPrice = value;
    }

    /**
     * Gets the value of the apartmentItem property.
     * 
     * @return
     *     possible object is
     *     {@link TApartmentItemPriceBreakdown }
     *     
     */
    public TApartmentItemPriceBreakdown getApartmentItem() {
        return apartmentItem;
    }

    /**
     * Sets the value of the apartmentItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link TApartmentItemPriceBreakdown }
     *     
     */
    public void setApartmentItem(TApartmentItemPriceBreakdown value) {
        this.apartmentItem = value;
    }

    /**
     * Gets the value of the errors property.
     * 
     * @return
     *     possible object is
     *     {@link TErrors }
     *     
     */
    public TErrors getErrors() {
        return errors;
    }

    /**
     * Sets the value of the errors property.
     * 
     * @param value
     *     allowed object is
     *     {@link TErrors }
     *     
     */
    public void setErrors(TErrors value) {
        this.errors = value;
    }

}
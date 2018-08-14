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
 * <p>Java class for t_ApartmentPriceBreakdownRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="t_ApartmentPriceBreakdownRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="City" type="{}t_CityCode"/>
 *         &lt;element name="Item" type="{}t_Item"/>
 *         &lt;element name="PeriodOfStay" type="{}t_PeriodOfStay"/>
 *         &lt;element name="ApartmentUnit" type="{}t_ApartmentBreakdownUnit"/>
 *         &lt;element name="ItemSupplements" type="{}t_ItemSupplementsBreakdown" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "t_ApartmentPriceBreakdownRequest", propOrder = {

})
public class TApartmentPriceBreakdownRequest {

    @XmlElement(name = "City", required = true)
    protected String city;
    @XmlElement(name = "Item", required = true)
    protected TItem item;
    @XmlElement(name = "PeriodOfStay", required = true)
    protected TPeriodOfStay periodOfStay;
    @XmlElement(name = "ApartmentUnit", required = true)
    protected TApartmentBreakdownUnit apartmentUnit;
    @XmlElement(name = "ItemSupplements")
    protected TItemSupplementsBreakdown itemSupplements;

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
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
     * Gets the value of the periodOfStay property.
     * 
     * @return
     *     possible object is
     *     {@link TPeriodOfStay }
     *     
     */
    public TPeriodOfStay getPeriodOfStay() {
        return periodOfStay;
    }

    /**
     * Sets the value of the periodOfStay property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPeriodOfStay }
     *     
     */
    public void setPeriodOfStay(TPeriodOfStay value) {
        this.periodOfStay = value;
    }

    /**
     * Gets the value of the apartmentUnit property.
     * 
     * @return
     *     possible object is
     *     {@link TApartmentBreakdownUnit }
     *     
     */
    public TApartmentBreakdownUnit getApartmentUnit() {
        return apartmentUnit;
    }

    /**
     * Sets the value of the apartmentUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link TApartmentBreakdownUnit }
     *     
     */
    public void setApartmentUnit(TApartmentBreakdownUnit value) {
        this.apartmentUnit = value;
    }

    /**
     * Gets the value of the itemSupplements property.
     * 
     * @return
     *     possible object is
     *     {@link TItemSupplementsBreakdown }
     *     
     */
    public TItemSupplementsBreakdown getItemSupplements() {
        return itemSupplements;
    }

    /**
     * Sets the value of the itemSupplements property.
     * 
     * @param value
     *     allowed object is
     *     {@link TItemSupplementsBreakdown }
     *     
     */
    public void setItemSupplements(TItemSupplementsBreakdown value) {
        this.itemSupplements = value;
    }

}
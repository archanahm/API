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
 * <p>Java class for t_ApartmentItemPriceBreakdown complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="t_ApartmentItemPriceBreakdown">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PeriodOfStay" type="{}t_PeriodOfStay"/>
 *         &lt;element name="ApartmentUnits" type="{}t_ApartmentUnitsPriceBreakdown" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "t_ApartmentItemPriceBreakdown", propOrder = {
    "periodOfStay",
    "apartmentUnits"
})
public class TApartmentItemPriceBreakdown {

    @XmlElement(name = "PeriodOfStay", required = true)
    protected TPeriodOfStay periodOfStay;
    @XmlElement(name = "ApartmentUnits")
    protected TApartmentUnitsPriceBreakdown apartmentUnits;

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
     * Gets the value of the apartmentUnits property.
     * 
     * @return
     *     possible object is
     *     {@link TApartmentUnitsPriceBreakdown }
     *     
     */
    public TApartmentUnitsPriceBreakdown getApartmentUnits() {
        return apartmentUnits;
    }

    /**
     * Sets the value of the apartmentUnits property.
     * 
     * @param value
     *     allowed object is
     *     {@link TApartmentUnitsPriceBreakdown }
     *     
     */
    public void setApartmentUnits(TApartmentUnitsPriceBreakdown value) {
        this.apartmentUnits = value;
    }

}

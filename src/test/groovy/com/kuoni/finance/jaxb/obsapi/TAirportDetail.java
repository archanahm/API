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
 * <p>Java class for t_AirportDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="t_AirportDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="City" type="{}t_City"/>
 *         &lt;element name="Airport" type="{}t_Airport"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "t_AirportDetail", propOrder = {
    "city",
    "airport"
})
public class TAirportDetail {

    @XmlElement(name = "City", required = true)
    protected TCity city;
    @XmlElement(name = "Airport", required = true)
    protected TAirport airport;

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link TCity }
     *     
     */
    public TCity getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link TCity }
     *     
     */
    public void setCity(TCity value) {
        this.city = value;
    }

    /**
     * Gets the value of the airport property.
     * 
     * @return
     *     possible object is
     *     {@link TAirport }
     *     
     */
    public TAirport getAirport() {
        return airport;
    }

    /**
     * Sets the value of the airport property.
     * 
     * @param value
     *     allowed object is
     *     {@link TAirport }
     *     
     */
    public void setAirport(TAirport value) {
        this.airport = value;
    }

}

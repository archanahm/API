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
 * <p>Java class for t_AssistanceLanguage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="t_AssistanceLanguage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Language" type="{}t_Language"/>
 *         &lt;element name="OfficeHours" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AOTNumbers" type="{}t_AOTNumbers"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "t_AssistanceLanguage", propOrder = {
    "language",
    "officeHours",
    "aotNumbers"
})
public class TAssistanceLanguage {

    @XmlElement(name = "Language", required = true)
    protected TLanguage language;
    @XmlElement(name = "OfficeHours", required = true)
    protected String officeHours;
    @XmlElement(name = "AOTNumbers", required = true)
    protected TAOTNumbers aotNumbers;

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link TLanguage }
     *     
     */
    public TLanguage getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link TLanguage }
     *     
     */
    public void setLanguage(TLanguage value) {
        this.language = value;
    }

    /**
     * Gets the value of the officeHours property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOfficeHours() {
        return officeHours;
    }

    /**
     * Sets the value of the officeHours property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOfficeHours(String value) {
        this.officeHours = value;
    }

    /**
     * Gets the value of the aotNumbers property.
     * 
     * @return
     *     possible object is
     *     {@link TAOTNumbers }
     *     
     */
    public TAOTNumbers getAOTNumbers() {
        return aotNumbers;
    }

    /**
     * Sets the value of the aotNumbers property.
     * 
     * @param value
     *     allowed object is
     *     {@link TAOTNumbers }
     *     
     */
    public void setAOTNumbers(TAOTNumbers value) {
        this.aotNumbers = value;
    }

}

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) 
//Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package se.atg.service.harrykart.generated;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for participantType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="participantType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lane" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="baseSpeed" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "participantType", propOrder = {
    "lane",
    "name",
    "baseSpeed"
})
public class ParticipantType {

    @XmlElement(required = true)
    protected Integer lane;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected Integer baseSpeed;

    /**
     * Gets the value of the lane property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public Integer getLane() {
        return lane;
    }

    /**
     * Sets the value of the lane property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLane(Integer value) {
        this.lane = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the baseSpeed property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public Integer getBaseSpeed() {
        return baseSpeed;
    }

    /**
     * Sets the value of the baseSpeed property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBaseSpeed(Integer value) {
        this.baseSpeed = value;
    }

}
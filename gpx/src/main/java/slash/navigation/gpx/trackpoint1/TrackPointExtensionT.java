//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-646 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.02 at 08:44:35 PM MEZ 
//


package slash.navigation.gpx.trackpoint1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *     This type contains data fields that cannot
 *     be represented in track points in GPX 1.1 instances.
 *     
 * 
 * <p>Java class for TrackPointExtension_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TrackPointExtension_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="atemp" type="{http://www.garmin.com/xmlschemas/TrackPointExtension/v1}DegreesCelsius_t" minOccurs="0"/>
 *         &lt;element name="wtemp" type="{http://www.garmin.com/xmlschemas/TrackPointExtension/v1}DegreesCelsius_t" minOccurs="0"/>
 *         &lt;element name="depth" type="{http://www.garmin.com/xmlschemas/TrackPointExtension/v1}Meters_t" minOccurs="0"/>
 *         &lt;element name="hr" type="{http://www.garmin.com/xmlschemas/TrackPointExtension/v1}BeatsPerMinute_t" minOccurs="0"/>
 *         &lt;element name="cad" type="{http://www.garmin.com/xmlschemas/TrackPointExtension/v1}RevolutionsPerMinute_t" minOccurs="0"/>
 *         &lt;element name="Extensions" type="{http://www.garmin.com/xmlschemas/TrackPointExtension/v1}Extensions_t" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrackPointExtension_t", propOrder = {
    "atemp",
    "wtemp",
    "depth",
    "hr",
    "cad",
    "extensions"
})
public class TrackPointExtensionT {

    protected Double atemp;
    protected Double wtemp;
    protected Double depth;
    protected Short hr;
    protected Short cad;
    @XmlElement(name = "Extensions")
    protected ExtensionsT extensions;

    /**
     * Gets the value of the atemp property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAtemp() {
        return atemp;
    }

    /**
     * Sets the value of the atemp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAtemp(Double value) {
        this.atemp = value;
    }

    /**
     * Gets the value of the wtemp property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getWtemp() {
        return wtemp;
    }

    /**
     * Sets the value of the wtemp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setWtemp(Double value) {
        this.wtemp = value;
    }

    /**
     * Gets the value of the depth property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDepth() {
        return depth;
    }

    /**
     * Sets the value of the depth property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDepth(Double value) {
        this.depth = value;
    }

    /**
     * Gets the value of the hr property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getHr() {
        return hr;
    }

    /**
     * Sets the value of the hr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setHr(Short value) {
        this.hr = value;
    }

    /**
     * Gets the value of the cad property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getCad() {
        return cad;
    }

    /**
     * Sets the value of the cad property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setCad(Short value) {
        this.cad = value;
    }

    /**
     * Gets the value of the extensions property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionsT }
     *     
     */
    public ExtensionsT getExtensions() {
        return extensions;
    }

    /**
     * Sets the value of the extensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionsT }
     *     
     */
    public void setExtensions(ExtensionsT value) {
        this.extensions = value;
    }

}

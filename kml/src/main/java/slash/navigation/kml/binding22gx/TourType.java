//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-646 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.08.13 at 10:12:26 PM MESZ 
//


package slash.navigation.kml.binding22gx;

import slash.navigation.kml.binding22.AbstractFeatureType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TourType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TourType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/kml/2.2}AbstractFeatureType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.google.com/kml/ext/2.2}Playlist" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TourType", propOrder = {
    "playlist"
})
public class TourType
    extends AbstractFeatureType
{

    @XmlElement(name = "Playlist")
    protected PlaylistType playlist;

    /**
     * Gets the value of the playlist property.
     * 
     * @return
     *     possible object is
     *     {@link PlaylistType }
     *     
     */
    public PlaylistType getPlaylist() {
        return playlist;
    }

    /**
     * Sets the value of the playlist property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlaylistType }
     *     
     */
    public void setPlaylist(PlaylistType value) {
        this.playlist = value;
    }

}

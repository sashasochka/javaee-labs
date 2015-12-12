
package jaxws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for vacancy complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="vacancy">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="candidates" type="{http://endpoint.jaxws/}candidate" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="position" type="{http://endpoint.jaxws/}position" minOccurs="0"/>
 *         &lt;element name="salary" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vacancy", propOrder = {
        "candidates",
        "description",
        "id",
        "position",
        "salary"
})
public class Vacancy {

    @XmlElement(nillable = true)
    protected List<Candidate> candidates;
    protected String description;
    protected int id;
    protected Position position;
    protected Integer salary;

    /**
     * Gets the value of the candidates property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the candidates property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCandidates().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Candidate }
     */
    public List<Candidate> getCandidates() {
        if (candidates == null) {
            candidates = new ArrayList<Candidate>();
        }
        return this.candidates;
    }

    /**
     * Gets the value of the description property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the id property.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the position property.
     *
     * @return possible object is
     * {@link Position }
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Sets the value of the position property.
     *
     * @param value allowed object is
     *              {@link Position }
     */
    public void setPosition(Position value) {
        this.position = value;
    }

    /**
     * Gets the value of the salary property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getSalary() {
        return salary;
    }

    /**
     * Sets the value of the salary property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setSalary(Integer value) {
        this.salary = value;
    }

}


package jaxws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for position complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="position">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="company" type="{http://endpoint.jaxws/}company" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vacancies" type="{http://endpoint.jaxws/}vacancy" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="workers" type="{http://endpoint.jaxws/}worker" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "position", propOrder = {
        "company",
        "description",
        "id",
        "name",
        "vacancies",
        "workers"
})
public class Position {

    protected Company company;
    protected String description;
    protected int id;
    protected String name;
    @XmlElement(nillable = true)
    protected List<Vacancy> vacancies;
    @XmlElement(nillable = true)
    protected List<Worker> workers;

    /**
     * Gets the value of the company property.
     *
     * @return possible object is
     * {@link Company }
     */
    public Company getCompany() {
        return company;
    }

    /**
     * Sets the value of the company property.
     *
     * @param value allowed object is
     *              {@link Company }
     */
    public void setCompany(Company value) {
        this.company = value;
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
     * Gets the value of the name property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the vacancies property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vacancies property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVacancies().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Vacancy }
     */
    public List<Vacancy> getVacancies() {
        if (vacancies == null) {
            vacancies = new ArrayList<Vacancy>();
        }
        return this.vacancies;
    }

    /**
     * Gets the value of the workers property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the workers property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWorkers().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Worker }
     */
    public List<Worker> getWorkers() {
        if (workers == null) {
            workers = new ArrayList<Worker>();
        }
        return this.workers;
    }

}

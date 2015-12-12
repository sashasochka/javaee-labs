
package jaxws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for candidate complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="candidate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="resume" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vacancy" type="{http://endpoint.jaxws/}vacancy" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "candidate", propOrder = {
        "id",
        "name",
        "resume",
        "vacancy"
})
public class Candidate {

    protected int id;
    protected String name;
    protected String resume;
    protected Vacancy vacancy;

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
     * Gets the value of the resume property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getResume() {
        return resume;
    }

    /**
     * Sets the value of the resume property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setResume(String value) {
        this.resume = value;
    }

    /**
     * Gets the value of the vacancy property.
     *
     * @return possible object is
     * {@link Vacancy }
     */
    public Vacancy getVacancy() {
        return vacancy;
    }

    /**
     * Sets the value of the vacancy property.
     *
     * @param value allowed object is
     *              {@link Vacancy }
     */
    public void setVacancy(Vacancy value) {
        this.vacancy = value;
    }

}

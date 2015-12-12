
package jaxws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the jaxws.endpoint package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetCompaniesResponse_QNAME = new QName("http://endpoint.jaxws/", "getCompaniesResponse");
    private final static QName _SaveCompany_QNAME = new QName("http://endpoint.jaxws/", "createCompany");
    private final static QName _GetCompanies_QNAME = new QName("http://endpoint.jaxws/", "getCompanies");
    private final static QName _SaveCompanyResponse_QNAME = new QName("http://endpoint.jaxws/", "saveCompanyResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jaxws.endpoint
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SaveCompany }
     */
    public SaveCompany createSaveCompany() {
        return new SaveCompany();
    }

    /**
     * Create an instance of {@link GetCompanies }
     */
    public GetCompanies createGetCompanies() {
        return new GetCompanies();
    }

    /**
     * Create an instance of {@link SaveCompanyResponse }
     */
    public SaveCompanyResponse createSaveCompanyResponse() {
        return new SaveCompanyResponse();
    }

    /**
     * Create an instance of {@link GetCompaniesResponse }
     */
    public GetCompaniesResponse createGetCompaniesResponse() {
        return new GetCompaniesResponse();
    }

    /**
     * Create an instance of {@link Candidate }
     */
    public Candidate createCandidate() {
        return new Candidate();
    }

    /**
     * Create an instance of {@link Company }
     */
    public Company createCompany() {
        return new Company();
    }

    /**
     * Create an instance of {@link Position }
     */
    public Position createPosition() {
        return new Position();
    }

    /**
     * Create an instance of {@link Worker }
     */
    public Worker createWorker() {
        return new Worker();
    }

    /**
     * Create an instance of {@link Vacancy }
     */
    public Vacancy createVacancy() {
        return new Vacancy();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompaniesResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://endpoint.jaxws/", name = "getCompaniesResponse")
    public JAXBElement<GetCompaniesResponse> createGetCompaniesResponse(GetCompaniesResponse value) {
        return new JAXBElement<GetCompaniesResponse>(_GetCompaniesResponse_QNAME, GetCompaniesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveCompany }{@code >}}
     */
    @XmlElementDecl(namespace = "http://endpoint.jaxws/", name = "createCompany")
    public JAXBElement<SaveCompany> createSaveCompany(SaveCompany value) {
        return new JAXBElement<SaveCompany>(_SaveCompany_QNAME, SaveCompany.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompanies }{@code >}}
     */
    @XmlElementDecl(namespace = "http://endpoint.jaxws/", name = "getCompanies")
    public JAXBElement<GetCompanies> createGetCompanies(GetCompanies value) {
        return new JAXBElement<GetCompanies>(_GetCompanies_QNAME, GetCompanies.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveCompanyResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://endpoint.jaxws/", name = "saveCompanyResponse")
    public JAXBElement<SaveCompanyResponse> createSaveCompanyResponse(SaveCompanyResponse value) {
        return new JAXBElement<SaveCompanyResponse>(_SaveCompanyResponse_QNAME, SaveCompanyResponse.class, null, value);
    }

}

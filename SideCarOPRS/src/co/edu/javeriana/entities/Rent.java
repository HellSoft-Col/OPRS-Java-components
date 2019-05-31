/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HellSoft
 */
@Entity
@Table(name = "RENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rent.findAll", query = "SELECT r FROM Rent r"),
    @NamedQuery(name = "Rent.findById", query = "SELECT r FROM Rent r WHERE r.rentPK.id = :id"),
    @NamedQuery(name = "Rent.findByRentalDate", query = "SELECT r FROM Rent r WHERE r.rentalDate = :rentalDate"),
    @NamedQuery(name = "Rent.findByRentalTimeStart", query = "SELECT r FROM Rent r WHERE r.rentalTimeStart = :rentalTimeStart"),
    @NamedQuery(name = "Rent.findByRentalTimeEnd", query = "SELECT r FROM Rent r WHERE r.rentalTimeEnd = :rentalTimeEnd"),
    @NamedQuery(name = "Rent.findByRentProperty", query = "SELECT r FROM Rent r WHERE r.rentProperty = :rentProperty"),
    @NamedQuery(name = "Rent.findByState", query = "SELECT r FROM Rent r WHERE r.state = :state"),
    @NamedQuery(name = "Rent.findByPropertyId", query = "SELECT r FROM Rent r WHERE r.rentPK.propertyId = :propertyId"),
    @NamedQuery(name = "Rent.findByPropertyOwnerId", query = "SELECT r FROM Rent r WHERE r.rentPK.propertyOwnerId = :propertyOwnerId"),
    @NamedQuery(name = "Rent.findByCustomerId", query = "SELECT r FROM Rent r WHERE r.rentPK.customerId = :customerId"),
    @NamedQuery(name = "Rent.findByCustomerIdAndState", query = "SELECT r FROM Rent r WHERE r.customer.id=:id AND r.state=:state"),
    @NamedQuery(name = "Rent.findByOwnerIdAndState", query = "SELECT r FROM Rent r WHERE r.property.owner.id=:id AND r.state=:state"),
    @NamedQuery(name = "Rent.findByCustomerIdAndStateDTO", query = "SELECT new co.edu.javeriana.dtos.RentSignDTO(r.rentPK.id, r.property.address, r.property.location,r.rentalDate, r.rentalTimeStart, r.rentalTimeEnd, r.rentProperty) FROM Rent r WHERE r.customer.id=:id AND r.state=:state"),
    @NamedQuery(name = "Rent.findByOwnerIdAndStateDTO", query = "SELECT new co.edu.javeriana.dtos.RentSignDTO(r.rentPK.id, r.property.address, r.property.location,r.rentalDate, r.rentalTimeStart, r.rentalTimeEnd, r.rentProperty) FROM Rent r WHERE r.property.owner.id=:id AND r.state=:state"),
    @NamedQuery(name = "Rent.findRentPropertiesByNdi", query="SELECT new co.edu.javeriana.dtos.RentsCustomerDTO(r.property.address, r.property.location, r.property.rent, r.property.roomsNumber, r.property.type,r.customer.name,r.customer.ndi) FROM Rent r ORDER BY r.customer.id")
    })
public class Rent implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RentPK rentPK;
    @Column(name = "RENTAL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rentalDate;
    @Column(name = "RENTAL_TIME_START")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rentalTimeStart;
    @Column(name = "RENTAL_TIME_END")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rentalTimeEnd;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "RENT_PROPERTY")
    private BigDecimal rentProperty;
    @Column(name = "STATE")
    private BigInteger state;
    @OneToMany(mappedBy = "rent")
    private Collection<Document> documentCollection;
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Customer customer;
    @JoinColumns({
        @JoinColumn(name = "PROPERTY_ID", referencedColumnName = "ID", insertable = false, updatable = false),
        @JoinColumn(name = "PROPERTY_OWNER_ID", referencedColumnName = "OWNER_ID", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Property property;

    public Rent() {
    }

    public Rent(RentPK rentPK, Date rentalDate, Date rentalTimeStart, Date rentalTimeEnd, BigDecimal rentProperty, BigInteger state) {
        this.rentPK = rentPK;
        this.rentalDate = rentalDate;
        this.rentalTimeStart = rentalTimeStart;
        this.rentalTimeEnd = rentalTimeEnd;
        this.rentProperty = rentProperty;
        this.state = state;
    }

    public Rent(RentPK rentPK) {
        this.rentPK = rentPK;
    }

    public Rent(BigInteger id, BigInteger propertyId, BigInteger propertyOwnerId, BigInteger customerId) {
        this.rentPK = new RentPK(id, propertyId, propertyOwnerId, customerId);
    }

    public RentPK getRentPK() {
        return rentPK;
    }

    public void setRentPK(RentPK rentPK) {
        this.rentPK = rentPK;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getRentalTimeStart() {
        return rentalTimeStart;
    }

    public void setRentalTimeStart(Date rentalTimeStart) {
        this.rentalTimeStart = rentalTimeStart;
    }

    public Date getRentalTimeEnd() {
        return rentalTimeEnd;
    }

    public void setRentalTimeEnd(Date rentalTimeEnd) {
        this.rentalTimeEnd = rentalTimeEnd;
    }

    public BigDecimal getRentProperty() {
        return rentProperty;
    }

    public void setRentProperty(BigDecimal rentProperty) {
        this.rentProperty = rentProperty;
    }

    public BigInteger getState() {
        return state;
    }

    public void setState(BigInteger state) {
        this.state = state;
    }

    @XmlTransient
    public Collection<Document> getDocumentCollection() {
        return documentCollection;
    }

    public void setDocumentCollection(Collection<Document> documentCollection) {
        this.documentCollection = documentCollection;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rentPK != null ? rentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rent)) {
            return false;
        }
        Rent other = (Rent) object;
        if ((this.rentPK == null && other.rentPK != null) || (this.rentPK != null && !this.rentPK.equals(other.rentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.entities.Rent[ rentPK=" + rentPK + " ]";
    }

}

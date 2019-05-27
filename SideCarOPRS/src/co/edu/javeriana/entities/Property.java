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
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SANTI
 */
@Entity
@Table(name = "PROPERTY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Property.findAll", query = "SELECT p FROM Property p"),
    @NamedQuery(name = "Property.findById", query = "SELECT p FROM Property p WHERE p.propertyPK.id = :id"),
    @NamedQuery(name = "Property.findByType", query = "SELECT p FROM Property p WHERE p.type = :type"),
    @NamedQuery(name = "Property.findByAddress", query = "SELECT p FROM Property p WHERE p.address = :address"),
    @NamedQuery(name = "Property.findByRoomsNumber", query = "SELECT p FROM Property p WHERE p.roomsNumber = :roomsNumber"),
    @NamedQuery(name = "Property.findByRent", query = "SELECT p FROM Property p WHERE p.rent = :rent"),
    @NamedQuery(name = "Property.findByOwnerId", query = "SELECT p FROM Property p WHERE p.propertyPK.ownerId = :ownerId"),
    @NamedQuery(name = "Property.findByLocation", query = "SELECT p FROM Property p WHERE p.location = :location"),
    @NamedQuery(name = "Property.findByRentRange", query = "SELECT p FROM Property p WHERE p.rent >= :minumrent AND p.rent <= :maximalrent")})
public class Property implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PropertyPK propertyPK;
    @Basic(optional = false)
    @Column(name = "TYPE")
    private BigInteger type;
    @Basic(optional = false)
    @Column(name = "ADDRESS")
    private String address;
    @Basic(optional = false)
    @Column(name = "ROOMS_NUMBER")
    private BigInteger roomsNumber;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "RENT")
    private BigDecimal rent;
    @Basic(optional = false)
    @Column(name = "LOCATION")
    private String location;
    @JoinColumn(name = "OWNER_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Owner owner;
    @OneToMany(mappedBy = "property")
    private Collection<Document> documentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "property")
    private Collection<VisitingList> visitingListCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "property")
    private Collection<Rent> rentCollection;

    public Property() {
    }

    public Property(PropertyPK propertyPK) {
        this.propertyPK = propertyPK;
    }

    public Property(PropertyPK propertyPK, BigInteger type, String address, BigInteger roomsNumber, BigDecimal rent, String location) {
        this.propertyPK = propertyPK;
        this.type = type;
        this.address = address;
        this.roomsNumber = roomsNumber;
        this.rent = rent;
        this.location = location;
    }

    public Property(BigInteger id, BigInteger ownerId) {
        this.propertyPK = new PropertyPK(id, ownerId);
    }

    public PropertyPK getPropertyPK() {
        return propertyPK;
    }

    public void setPropertyPK(PropertyPK propertyPK) {
        this.propertyPK = propertyPK;
    }

    public BigInteger getType() {
        return type;
    }

    public void setType(BigInteger type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigInteger getRoomsNumber() {
        return roomsNumber;
    }

    public void setRoomsNumber(BigInteger roomsNumber) {
        this.roomsNumber = roomsNumber;
    }

    public BigDecimal getRent() {
        return rent;
    }

    public void setRent(BigDecimal rent) {
        this.rent = rent;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @XmlTransient
    public Collection<Document> getDocumentCollection() {
        return documentCollection;
    }

    public void setDocumentCollection(Collection<Document> documentCollection) {
        this.documentCollection = documentCollection;
    }

    @XmlTransient
    public Collection<VisitingList> getVisitingListCollection() {
        return visitingListCollection;
    }

    public void setVisitingListCollection(Collection<VisitingList> visitingListCollection) {
        this.visitingListCollection = visitingListCollection;
    }

    @XmlTransient
    public Collection<Rent> getRentCollection() {
        return rentCollection;
    }

    public void setRentCollection(Collection<Rent> rentCollection) {
        this.rentCollection = rentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (propertyPK != null ? propertyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Property)) {
            return false;
        }
        Property other = (Property) object;
        if ((this.propertyPK == null && other.propertyPK != null) || (this.propertyPK != null && !this.propertyPK.equals(other.propertyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.entities.Property[ propertyPK=" + propertyPK + " ]";
    }
    
}

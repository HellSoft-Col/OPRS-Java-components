/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SANTI
 */
@Entity
@Table(name = "VISITING_LIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VisitingList.findAll", query = "SELECT v FROM VisitingList v"),
    @NamedQuery(name = "VisitingList.findByState", query = "SELECT v FROM VisitingList v WHERE v.state = :state"),
    @NamedQuery(name = "VisitingList.findByPropertyId", query = "SELECT v FROM VisitingList v WHERE v.visitingListPK.propertyId = :propertyId"),
    @NamedQuery(name = "VisitingList.findByPropertyOwnerId", query = "SELECT v FROM VisitingList v WHERE v.visitingListPK.propertyOwnerId = :propertyOwnerId"),
    @NamedQuery(name = "VisitingList.findByCustomerId", query = "SELECT v FROM VisitingList v WHERE v.visitingListPK.customerId = :customerId")})
public class VisitingList implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VisitingListPK visitingListPK;
    @Column(name = "STATE")
    private BigInteger state;
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Customer customer;
    @JoinColumns({
        @JoinColumn(name = "PROPERTY_ID", referencedColumnName = "ID", insertable = false, updatable = false),
        @JoinColumn(name = "PROPERTY_OWNER_ID", referencedColumnName = "OWNER_ID", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Property property;

    public VisitingList() {
    }

    public VisitingList(VisitingListPK visitingListPK) {
        this.visitingListPK = visitingListPK;
    }

    public VisitingList(BigInteger propertyId, BigInteger propertyOwnerId, BigInteger customerId) {
        this.visitingListPK = new VisitingListPK(propertyId, propertyOwnerId, customerId);
    }

    public VisitingListPK getVisitingListPK() {
        return visitingListPK;
    }

    public void setVisitingListPK(VisitingListPK visitingListPK) {
        this.visitingListPK = visitingListPK;
    }

    public BigInteger getState() {
        return state;
    }

    public void setState(BigInteger state) {
        this.state = state;
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
        hash += (visitingListPK != null ? visitingListPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VisitingList)) {
            return false;
        }
        VisitingList other = (VisitingList) object;
        if ((this.visitingListPK == null && other.visitingListPK != null) || (this.visitingListPK != null && !this.visitingListPK.equals(other.visitingListPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.entities.VisitingList[ visitingListPK=" + visitingListPK + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author SANTI
 */
@Embeddable
public class VisitingListPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "PROPERTY_ID")
    private BigInteger propertyId;
    @Basic(optional = false)
    @Column(name = "PROPERTY_OWNER_ID")
    private BigInteger propertyOwnerId;
    @Basic(optional = false)
    @Column(name = "CUSTOMER_ID")
    private BigInteger customerId;

    public VisitingListPK() {
    }

    public VisitingListPK(BigInteger propertyId, BigInteger propertyOwnerId, BigInteger customerId) {
        this.propertyId = propertyId;
        this.propertyOwnerId = propertyOwnerId;
        this.customerId = customerId;
    }

    public BigInteger getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(BigInteger propertyId) {
        this.propertyId = propertyId;
    }

    public BigInteger getPropertyOwnerId() {
        return propertyOwnerId;
    }

    public void setPropertyOwnerId(BigInteger propertyOwnerId) {
        this.propertyOwnerId = propertyOwnerId;
    }

    public BigInteger getCustomerId() {
        return customerId;
    }

    public void setCustomerId(BigInteger customerId) {
        this.customerId = customerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (propertyId != null ? propertyId.hashCode() : 0);
        hash += (propertyOwnerId != null ? propertyOwnerId.hashCode() : 0);
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VisitingListPK)) {
            return false;
        }
        VisitingListPK other = (VisitingListPK) object;
        if ((this.propertyId == null && other.propertyId != null) || (this.propertyId != null && !this.propertyId.equals(other.propertyId))) {
            return false;
        }
        if ((this.propertyOwnerId == null && other.propertyOwnerId != null) || (this.propertyOwnerId != null && !this.propertyOwnerId.equals(other.propertyOwnerId))) {
            return false;
        }
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.entities.VisitingListPK[ propertyId=" + propertyId + ", propertyOwnerId=" + propertyOwnerId + ", customerId=" + customerId + " ]";
    }
    
}

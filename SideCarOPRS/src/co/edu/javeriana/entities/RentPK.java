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
 * @author HellSoft
 */
@Embeddable
public class RentPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID", insertable=false)
    private BigInteger id;
    @Basic(optional = false)
    @Column(name = "PROPERTY_ID")
    private BigInteger propertyId;
    @Basic(optional = false)
    @Column(name = "PROPERTY_OWNER_ID")
    private BigInteger propertyOwnerId;
    @Basic(optional = false)
    @Column(name = "CUSTOMER_ID")
    private BigInteger customerId;

    public RentPK() {
    }

    public RentPK(BigInteger id, BigInteger propertyId, BigInteger propertyOwnerId, BigInteger customerId) {
        this.id = id;
        this.propertyId = propertyId;
        this.propertyOwnerId = propertyOwnerId;
        this.customerId = customerId;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
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
        hash += (id != null ? id.hashCode() : 0);
        hash += (propertyId != null ? propertyId.hashCode() : 0);
        hash += (propertyOwnerId != null ? propertyOwnerId.hashCode() : 0);
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RentPK)) {
            return false;
        }
        RentPK other = (RentPK) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
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
        return "co.edu.javeriana.entities.RentPK[ id=" + id + ", propertyId=" + propertyId + ", propertyOwnerId=" + propertyOwnerId + ", customerId=" + customerId + " ]";
    }
    
}

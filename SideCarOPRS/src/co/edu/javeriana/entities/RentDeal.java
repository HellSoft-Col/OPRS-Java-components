/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.javeriana.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HellSoft
 */
@Entity
@Table(name = "RENT_DEAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RentDeal.findAll", query = "SELECT r FROM RentDeal r"),
    @NamedQuery(name = "RentDeal.findById", query = "SELECT r FROM RentDeal r WHERE r.id = :id"),
    @NamedQuery(name = "RentDeal.findByNdi", query = "SELECT r FROM RentDeal r WHERE r.ndi = :ndi"),
    @NamedQuery(name = "RentDeal.findByName", query = "SELECT r FROM RentDeal r WHERE r.name = :name"),
    @NamedQuery(name = "RentDeal.findByLastName", query = "SELECT r FROM RentDeal r WHERE r.lastName = :lastName"),
    @NamedQuery(name = "RentDeal.findByLocationAddress", query = "SELECT r FROM RentDeal r WHERE r.locationAddress = :locationAddress"),
    @NamedQuery(name = "RentDeal.findByPropertyAddress", query = "SELECT r FROM RentDeal r WHERE r.propertyAddress = :propertyAddress"),
    @NamedQuery(name = "RentDeal.findByRentalTimeStart", query = "SELECT r FROM RentDeal r WHERE r.rentalTimeStart = :rentalTimeStart"),
    @NamedQuery(name = "RentDeal.findByRentalTimeEnd", query = "SELECT r FROM RentDeal r WHERE r.rentalTimeEnd = :rentalTimeEnd"),
    @NamedQuery(name = "RentDeal.findByAmount", query = "SELECT r FROM RentDeal r WHERE r.amount = :amount")})
public class RentDeal implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 10)
    @Column(name = "NDI")
    private String ndi;
    @Size(max = 20)
    @Column(name = "NAME")
    private String name;
    @Size(max = 20)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Size(max = 30)
    @Column(name = "LOCATION_ADDRESS")
    private String locationAddress;
    @Size(max = 50)
    @Column(name = "PROPERTY_ADDRESS")
    private String propertyAddress;
    @Column(name = "RENTAL_TIME_START")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rentalTimeStart;
    @Column(name = "RENTAL_TIME_END")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rentalTimeEnd;
    @Column(name = "AMOUNT")
    private Long amount;

    public RentDeal() {
    }

    public RentDeal(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNdi() {
        return ndi;
    }

    public void setNdi(String ndi) {
        this.ndi = ndi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
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

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RentDeal)) {
            return false;
        }
        RentDeal other = (RentDeal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.entities.RentDeal[ id=" + id + " ]";
    }
    
}

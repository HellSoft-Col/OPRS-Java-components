/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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

/**
 *
 * @author LICHO
 */
@Entity
@Table(name = "RENT")
@NamedQueries({
    @NamedQuery(name = "Rent.findAll", query = "SELECT r FROM Rent r"),
    @NamedQuery(name = "Rent.findById", query = "SELECT r FROM Rent r WHERE r.id = :id"),
    @NamedQuery(name = "Rent.findByRentalDate", query = "SELECT r FROM Rent r WHERE r.rentalDate = :rentalDate"),
    @NamedQuery(name = "Rent.findByRentalTimeStart", query = "SELECT r FROM Rent r WHERE r.rentalTimeStart = :rentalTimeStart"),
    @NamedQuery(name = "Rent.findByRentalTimeEnd", query = "SELECT r FROM Rent r WHERE r.rentalTimeEnd = :rentalTimeEnd"),
    @NamedQuery(name = "Rent.findByRentProperty", query = "SELECT r FROM Rent r WHERE r.rentProperty = :rentProperty"),
    @NamedQuery(name = "Rent.findByState", query = "SELECT r FROM Rent r WHERE r.state = :state"),
    @NamedQuery(name = "Rent.findByCostumerName", query = "SELECT r FROM Rent r WHERE r.costumerName = :costumerName"),
    @NamedQuery(name = "Rent.findByCostumerLastName", query = "SELECT r FROM Rent r WHERE r.costumerLastName = :costumerLastName"),
    @NamedQuery(name = "Rent.findByCustomerNdi", query = "SELECT r FROM Rent r WHERE r.customerNdi = :customerNdi"),
    @NamedQuery(name = "Rent.findByCustomerEmail", query = "SELECT r FROM Rent r WHERE r.customerEmail = :customerEmail"),
    @NamedQuery(name = "Rent.findByPropertyType", query = "SELECT r FROM Rent r WHERE r.propertyType = :propertyType"),
    @NamedQuery(name = "Rent.findByPropertyAddress", query = "SELECT r FROM Rent r WHERE r.propertyAddress = :propertyAddress"),
    @NamedQuery(name = "Rent.findByPropertyRooms", query = "SELECT r FROM Rent r WHERE r.propertyRooms = :propertyRooms"),
    @NamedQuery(name = "Rent.findByPropertyLocation", query = "SELECT r FROM Rent r WHERE r.propertyLocation = :propertyLocation"),
    @NamedQuery(name = "Rent.findByOwnerName", query = "SELECT r FROM Rent r WHERE r.ownerName = :ownerName"),
    @NamedQuery(name = "Rent.findByOwnerLastName", query = "SELECT r FROM Rent r WHERE r.ownerLastName = :ownerLastName"),
    @NamedQuery(name = "Rent.findByOwnerNdi", query = "SELECT r FROM Rent r WHERE r.ownerNdi = :ownerNdi"),
    @NamedQuery(name = "Rent.findByOwnerEmail", query = "SELECT r FROM Rent r WHERE r.ownerEmail = :ownerEmail"),
    @NamedQuery(name = "Rent.findByConsecutivoConsulta", query = "SELECT r FROM Rent r WHERE r.consecutivoConsulta = :consecutivoConsulta")})
public class Rent implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", insertable = false)
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RENTAL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rentalDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RENTAL_TIME_START")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rentalTimeStart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RENTAL_TIME_END")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rentalTimeEnd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RENT_PROPERTY")
    private double rentProperty;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "STATE")
    private String state;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "COSTUMER_NAME")
    private String costumerName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "COSTUMER_LAST_NAME")
    private String costumerLastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CUSTOMER_NDI")
    private String customerNdi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CUSTOMER_EMAIL")
    private String customerEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PROPERTY_TYPE")
    private String propertyType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PROPERTY_ADDRESS")
    private String propertyAddress;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROPERTY_ROOMS")
    private BigInteger propertyRooms;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PROPERTY_LOCATION")
    private String propertyLocation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "OWNER_NAME")
    private String ownerName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "OWNER_LAST_NAME")
    private String ownerLastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "OWNER_NDI")
    private String ownerNdi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "OWNER_EMAIL")
    private String ownerEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONSECUTIVO_CONSULTA")
    private BigInteger consecutivoConsulta;

    public Rent() {
    }

    public Rent(BigDecimal id) {
        this.id = id;
    }

    public Rent(Date rentalDate, Date rentalTimeStart, Date rentalTimeEnd, double rentProperty, String state, String costumerName, String costumerLastName, String customerNdi, String customerEmail, String propertyType, String propertyAddress, BigInteger propertyRooms, String propertyLocation, String ownerName, String ownerLastName, String ownerNdi, String ownerEmail, BigInteger consecutivoConsulta) {
        this.rentalDate = rentalDate;
        this.rentalTimeStart = rentalTimeStart;
        this.rentalTimeEnd = rentalTimeEnd;
        this.rentProperty = rentProperty;
        this.state = state;
        this.costumerName = costumerName;
        this.costumerLastName = costumerLastName;
        this.customerNdi = customerNdi;
        this.customerEmail = customerEmail;
        this.propertyType = propertyType;
        this.propertyAddress = propertyAddress;
        this.propertyRooms = propertyRooms;
        this.propertyLocation = propertyLocation;
        this.ownerName = ownerName;
        this.ownerLastName = ownerLastName;
        this.ownerNdi = ownerNdi;
        this.ownerEmail = ownerEmail;
        this.consecutivoConsulta = consecutivoConsulta;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
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

    public double getRentProperty() {
        return rentProperty;
    }

    public void setRentProperty(double rentProperty) {
        this.rentProperty = rentProperty;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCostumerName() {
        return costumerName;
    }

    public void setCostumerName(String costumerName) {
        this.costumerName = costumerName;
    }

    public String getCostumerLastName() {
        return costumerLastName;
    }

    public void setCostumerLastName(String costumerLastName) {
        this.costumerLastName = costumerLastName;
    }

    public String getCustomerNdi() {
        return customerNdi;
    }

    public void setCustomerNdi(String customerNdi) {
        this.customerNdi = customerNdi;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public BigInteger getPropertyRooms() {
        return propertyRooms;
    }

    public void setPropertyRooms(BigInteger propertyRooms) {
        this.propertyRooms = propertyRooms;
    }

    public String getPropertyLocation() {
        return propertyLocation;
    }

    public void setPropertyLocation(String propertyLocation) {
        this.propertyLocation = propertyLocation;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    public String getOwnerNdi() {
        return ownerNdi;
    }

    public void setOwnerNdi(String ownerNdi) {
        this.ownerNdi = ownerNdi;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public BigInteger getConsecutivoConsulta() {
        return consecutivoConsulta;
    }

    public void setConsecutivoConsulta(BigInteger consecutivoConsulta) {
        this.consecutivoConsulta = consecutivoConsulta;
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
        if (!(object instanceof Rent)) {
            return false;
        }
        Rent other = (Rent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Rent[ id=" + id + " ]";
    }
    
}

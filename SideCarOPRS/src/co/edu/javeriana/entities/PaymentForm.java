/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HellSoft
 */
@Entity
@Table(name = "PAYMENT_FORM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaymentForm.findAll", query = "SELECT p FROM PaymentForm p"),
    @NamedQuery(name = "PaymentForm.findById", query = "SELECT p FROM PaymentForm p WHERE p.paymentFormPK.id = :id"),
    @NamedQuery(name = "PaymentForm.findByTypeCreditCard", query = "SELECT p FROM PaymentForm p WHERE p.typeCreditCard = :typeCreditCard"),
    @NamedQuery(name = "PaymentForm.findByCreditCardNumber", query = "SELECT p FROM PaymentForm p WHERE p.creditCardNumber = :creditCardNumber"),
    @NamedQuery(name = "PaymentForm.findByNameHolder", query = "SELECT p FROM PaymentForm p WHERE p.nameHolder = :nameHolder"),
    @NamedQuery(name = "PaymentForm.findByExpiryDate", query = "SELECT p FROM PaymentForm p WHERE p.expiryDate = :expiryDate"),
    @NamedQuery(name = "PaymentForm.findByCustomerId", query = "SELECT p FROM PaymentForm p WHERE p.paymentFormPK.customerId = :customerId")})
public class PaymentForm implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PaymentFormPK paymentFormPK;
    @Column(name = "TYPE_CREDIT_CARD")
    private String typeCreditCard;
    @Column(name = "CREDIT_CARD_NUMBER")
    private String creditCardNumber;
    @Column(name = "NAME_HOLDER")
    private String nameHolder;
    @Column(name = "EXPIRY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiryDate;
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Customer customer;

    public PaymentForm() {
    }

    public PaymentForm(PaymentFormPK paymentFormPK) {
        this.paymentFormPK = paymentFormPK;
    }

    public PaymentForm(BigInteger id, BigInteger customerId) {
        this.paymentFormPK = new PaymentFormPK(id, customerId);
    }

    public PaymentFormPK getPaymentFormPK() {
        return paymentFormPK;
    }

    public void setPaymentFormPK(PaymentFormPK paymentFormPK) {
        this.paymentFormPK = paymentFormPK;
    }

    public String getTypeCreditCard() {
        return typeCreditCard;
    }

    public void setTypeCreditCard(String typeCreditCard) {
        this.typeCreditCard = typeCreditCard;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getNameHolder() {
        return nameHolder;
    }

    public void setNameHolder(String nameHolder) {
        this.nameHolder = nameHolder;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentFormPK != null ? paymentFormPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentForm)) {
            return false;
        }
        PaymentForm other = (PaymentForm) object;
        if ((this.paymentFormPK == null && other.paymentFormPK != null) || (this.paymentFormPK != null && !this.paymentFormPK.equals(other.paymentFormPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.entities.PaymentForm[ paymentFormPK=" + paymentFormPK + " ]";
    }
    
}

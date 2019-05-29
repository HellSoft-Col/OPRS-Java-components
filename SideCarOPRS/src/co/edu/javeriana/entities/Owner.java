/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HellSoft
 */
@Entity
@Table(name = "OWNER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Owner.findAll", query = "SELECT o FROM Owner o"),
    @NamedQuery(name = "Owner.findById", query = "SELECT o FROM Owner o WHERE o.id = :id"),
    @NamedQuery(name = "Owner.findByLastName", query = "SELECT o FROM Owner o WHERE o.lastName = :lastName"),
    @NamedQuery(name = "Owner.findByName", query = "SELECT o FROM Owner o WHERE o.name = :name"),
    @NamedQuery(name = "Owner.findByNdi", query = "SELECT o FROM Owner o WHERE o.ndi = :ndi"),
    @NamedQuery(name = "Owner.findByEMail", query = "SELECT o FROM Owner o WHERE o.eMail = :eMail"),
    @NamedQuery(name = "Owner.findByUsername", query = "SELECT o FROM Owner o WHERE o.username = :username"),
    @NamedQuery(name = "Owner.findByPassword", query = "SELECT o FROM Owner o WHERE o.password = :password"),
    @NamedQuery(name = "Owner.findByLogin", query = "SELECT new co.edu.javeriana.dtos.LoginDTO (o.username, o.password, o.id, o.name, o.lastName, o.ndi, o.eMail) FROM Owner o WHERE o.username = :username AND o.password = :password")})
public class Owner implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "NAME")
    private String name;
    @Column(name = "NDI")
    private String ndi;
    @Column(name = "CORREO")
    private String eMail;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Collection<Property> propertyCollection;

    public Owner() {
    }

    public Owner(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNdi() {
        return ndi;
    }

    public void setNdi(String ndi) {
        this.ndi = ndi;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<Property> getPropertyCollection() {
        return propertyCollection;
    }

    public void setPropertyCollection(Collection<Property> propertyCollection) {
        this.propertyCollection = propertyCollection;
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
        if (!(object instanceof Owner)) {
            return false;
        }
        Owner other = (Owner) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.entities.Owner[ id=" + id + " ]";
    }
    
}

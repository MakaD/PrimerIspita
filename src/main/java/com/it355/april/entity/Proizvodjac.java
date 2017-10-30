/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.april.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author vasic
 */
@Entity
@Table(name = "proizvodjac")
@NamedQueries({
    @NamedQuery(name = "Proizvodjac.findAll", query = "SELECT p FROM Proizvodjac p")})
public class Proizvodjac implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "IME")
    private String ime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proizvodjacId")
    private List<Namestaj> namestajList;
    @JoinColumn(name = "GRAD_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Grad gradId;

    public Proizvodjac() {
    }

    public Proizvodjac(Integer id) {
        this.id = id;
    }

    public Proizvodjac(Integer id, String ime) {
        this.id = id;
        this.ime = ime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public List<Namestaj> getNamestajList() {
        return namestajList;
    }

    public void setNamestajList(List<Namestaj> namestajList) {
        this.namestajList = namestajList;
    }

    public Grad getGradId() {
        return gradId;
    }

    public void setGradId(Grad gradId) {
        this.gradId = gradId;
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
        if (!(object instanceof Proizvodjac)) {
            return false;
        }
        Proizvodjac other = (Proizvodjac) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ime;
    }
    
}

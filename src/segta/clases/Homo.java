/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segta.clases;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MODERNIZACION
 */
@Entity
@Table(name = "homo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Homo.findAll", query = "SELECT h FROM Homo h")
    , @NamedQuery(name = "Homo.findByIdHomo", query = "SELECT h FROM Homo h WHERE h.idHomo = :idHomo")
    , @NamedQuery(name = "Homo.findByIdLote", query = "SELECT h FROM Homo h WHERE h.idLote = :idLote")
    , @NamedQuery(name = "Homo.findByFecha", query = "SELECT h FROM Homo h WHERE h.fecha = :fecha")
    , @NamedQuery(name = "Homo.findByTambores", query = "SELECT h FROM Homo h WHERE h.tambores = :tambores")})
public class Homo implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idHomo")
    private Integer idHomo;
    @Column(name = "idLote")
    private String idLote;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "tambores")
    private Integer tambores;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHomo")
    private Collection<Tamboreshomo> tamboreshomoCollection;
    @Transient
    private float netoLote;

    public Homo() {
    }

    public Homo(Integer idHomo) {
        this.idHomo = idHomo;
    }

    public Integer getIdHomo() {
        return idHomo;
    }
    public Float getNetoLoteHomo() {
        netoLote = (float) 0.0;
        for (Tamboreshomo t : this.getTamboreshomoCollection()) {
            netoLote = netoLote + t.getNeto();
        }
        return netoLote;
    }

    public void setIdHomo(Integer idHomo) {
        Integer oldIdHomo = this.idHomo;
        this.idHomo = idHomo;
        changeSupport.firePropertyChange("idHomo", oldIdHomo, idHomo);
    }

    public String getIdLote() {
        return idLote;
    }

    public void setIdLote(String idLote) {
        String oldIdLote = this.idLote;
        this.idLote = idLote;
        changeSupport.firePropertyChange("idLote", oldIdLote, idLote);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        Date oldFecha = this.fecha;
        this.fecha = fecha;
        changeSupport.firePropertyChange("fecha", oldFecha, fecha);
    }

    public Integer getTambores() {
        return tambores;
    }

    public void setTambores(Integer tambores) {
        Integer oldTambores = this.tambores;
        this.tambores = tambores;
        changeSupport.firePropertyChange("tambores", oldTambores, tambores);
    }

    @XmlTransient
    public Collection<Tamboreshomo> getTamboreshomoCollection() {
        return tamboreshomoCollection;
    }

    public void setTamboreshomoCollection(Collection<Tamboreshomo> tamboreshomoCollection) {
        this.tamboreshomoCollection = tamboreshomoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHomo != null ? idHomo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Homo)) {
            return false;
        }
        Homo other = (Homo) object;
        if ((this.idHomo == null && other.idHomo != null) || (this.idHomo != null && !this.idHomo.equals(other.idHomo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "segta.clases.Homo[ idHomo=" + idHomo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

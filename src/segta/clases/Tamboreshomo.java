/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segta.clases;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MODERNIZACION
 */
@Entity
@Table(name = "tamboreshomo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tamboreshomo.findAll", query = "SELECT t FROM Tamboreshomo t")
    , @NamedQuery(name = "Tamboreshomo.findByIdTamboresHomo", query = "SELECT t FROM Tamboreshomo t WHERE t.idTamboresHomo = :idTamboresHomo")
    , @NamedQuery(name = "Tamboreshomo.findBySenasa", query = "SELECT t FROM Tamboreshomo t WHERE t.senasa = :senasa")
    , @NamedQuery(name = "Tamboreshomo.findByNumero", query = "SELECT t FROM Tamboreshomo t WHERE t.numero = :numero")
    , @NamedQuery(name = "Tamboreshomo.findByTara", query = "SELECT t FROM Tamboreshomo t WHERE t.tara = :tara")
    , @NamedQuery(name = "Tamboreshomo.findByBruto", query = "SELECT t FROM Tamboreshomo t WHERE t.bruto = :bruto")
    , @NamedQuery(name = "Tamboreshomo.findByNeto", query = "SELECT t FROM Tamboreshomo t WHERE t.neto = :neto")
    , @NamedQuery(name = "Tamboreshomo.findBySobrante", query = "SELECT t FROM Tamboreshomo t WHERE t.sobrante = :sobrante")})
public class Tamboreshomo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTamboresHomo")
    private Integer idTamboresHomo;
    @Column(name = "senasa")
    private String senasa;
    @Column(name = "numero")
    private String numero;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tara")
    private Float tara;
    @Column(name = "bruto")
    private Float bruto;
    @Column(name = "neto")
    private Float neto;
    @Column(name = "sobrante")
    private Boolean sobrante;
    @JoinColumn(name = "idHomo", referencedColumnName = "idHomo")
    @ManyToOne(optional = false)
    private Homo idHomo;
    @JoinColumn(name = "idHomoNuevo", referencedColumnName = "idHomo")
    @ManyToOne
    private Homo idHomoNuevo;

    public Tamboreshomo() {
    }

    public Tamboreshomo(Integer idTamboresHomo) {
        this.idTamboresHomo = idTamboresHomo;
    }

    public Integer getIdTamboresHomo() {
        return idTamboresHomo;
    }

    public void setIdTamboresHomo(Integer idTamboresHomo) {
        this.idTamboresHomo = idTamboresHomo;
    }

    public String getSenasa() {
        return senasa;
    }

    public void setSenasa(String senasa) {
        this.senasa = senasa;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Float getTara() {
        return tara;
    }

    public void setTara(Float tara) {
        this.tara = tara;
    }

    public Float getBruto() {
        return bruto;
    }

    public void setBruto(Float bruto) {
        this.bruto = bruto;
    }

    public Float getNeto() {
        return neto;
    }

    public void setNeto(Float neto) {
        this.neto = neto;
    }

    public Boolean getSobrante() {
        return sobrante;
    }

    public void setSobrante(Boolean sobrante) {
        this.sobrante = sobrante;
    }

    public Homo getIdHomo() {
        return idHomo;
    }

    public void setIdHomo(Homo idHomo) {
        this.idHomo = idHomo;
    }

    public Homo getIdHomoNuevo() {
        return idHomoNuevo;
    }

    public void setIdHomoNuevo(Homo idHomoNuevo) {
        this.idHomoNuevo = idHomoNuevo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTamboresHomo != null ? idTamboresHomo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tamboreshomo)) {
            return false;
        }
        Tamboreshomo other = (Tamboreshomo) object;
        if ((this.idTamboresHomo == null && other.idTamboresHomo != null) || (this.idTamboresHomo != null && !this.idTamboresHomo.equals(other.idTamboresHomo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "segta.clases.Tamboreshomo[ idTamboresHomo=" + idTamboresHomo + " ]";
    }
    
}

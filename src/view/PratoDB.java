/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author RawMa
 */
@Entity
@Table(name = "prato", catalog = "restaurante", schema = "")
@NamedQueries({
    @NamedQuery(name = "Prato.findAll", query = "SELECT p FROM Prato p")
    , @NamedQuery(name = "Prato.findByIdPrato", query = "SELECT p FROM Prato p WHERE p.idPrato = :idPrato")
    , @NamedQuery(name = "Prato.findByNome", query = "SELECT p FROM Prato p WHERE p.nome = :nome")
    , @NamedQuery(name = "Prato.findByDescricao", query = "SELECT p FROM Prato p WHERE p.descricao = :descricao")
    , @NamedQuery(name = "Prato.findByCreateAt", query = "SELECT p FROM Prato p WHERE p.createAt = :createAt")
    , @NamedQuery(name = "Prato.findByUpdateAt", query = "SELECT p FROM Prato p WHERE p.updateAt = :updateAt")})
public class PratoDB implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_prato")
    private Integer idPrato;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @Column(name = "update_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

    public PratoDB() {
    }

    public PratoDB(Integer idPrato) {
        this.idPrato = idPrato;
    }

    public PratoDB(Integer idPrato, String nome) {
        this.idPrato = idPrato;
        this.nome = nome;
    }

    public Integer getIdPrato() {
        return idPrato;
    }

    public void setIdPrato(Integer idPrato) {
        Integer oldIdPrato = this.idPrato;
        this.idPrato = idPrato;
        changeSupport.firePropertyChange("idPrato", oldIdPrato, idPrato);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        changeSupport.firePropertyChange("descricao", oldDescricao, descricao);
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        Date oldCreateAt = this.createAt;
        this.createAt = createAt;
        changeSupport.firePropertyChange("createAt", oldCreateAt, createAt);
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        Date oldUpdateAt = this.updateAt;
        this.updateAt = updateAt;
        changeSupport.firePropertyChange("updateAt", oldUpdateAt, updateAt);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrato != null ? idPrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PratoDB)) {
            return false;
        }
        PratoDB other = (PratoDB) object;
        if ((this.idPrato == null && other.idPrato != null) || (this.idPrato != null && !this.idPrato.equals(other.idPrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Prato[ idPrato=" + idPrato + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

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
@Table(name = "cardapio", catalog = "restaurante", schema = "")
@NamedQueries({
    @NamedQuery(name = "Cardapio_1.findAll", query = "SELECT c FROM Cardapio_1 c")
    , @NamedQuery(name = "Cardapio_1.findByIdCardapio", query = "SELECT c FROM Cardapio_1 c WHERE c.idCardapio = :idCardapio")
    , @NamedQuery(name = "Cardapio_1.findByCodidoPrato", query = "SELECT c FROM Cardapio_1 c WHERE c.codidoPrato = :codidoPrato")
    , @NamedQuery(name = "Cardapio_1.findByValor", query = "SELECT c FROM Cardapio_1 c WHERE c.valor = :valor")
    , @NamedQuery(name = "Cardapio_1.findByVersao", query = "SELECT c FROM Cardapio_1 c WHERE c.versao = :versao")
    , @NamedQuery(name = "Cardapio_1.findByCreateAt", query = "SELECT c FROM Cardapio_1 c WHERE c.createAt = :createAt")
    , @NamedQuery(name = "Cardapio_1.findByUpdateAt", query = "SELECT c FROM Cardapio_1 c WHERE c.updateAt = :updateAt")})
public class CardapioDB implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cardapio")
    private Integer idCardapio;
    @Basic(optional = false)
    @Column(name = "codido_prato")
    private int codidoPrato;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Float valor;
    @Basic(optional = false)
    @Column(name = "versao")
    private int versao;
    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @Column(name = "update_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

    public CardapioDB() {
    }

    public CardapioDB(Integer idCardapio) {
        this.idCardapio = idCardapio;
    }

    public CardapioDB(Integer idCardapio, int codidoPrato, int versao) {
        this.idCardapio = idCardapio;
        this.codidoPrato = codidoPrato;
        this.versao = versao;
    }

    public Integer getIdCardapio() {
        return idCardapio;
    }

    public void setIdCardapio(Integer idCardapio) {
        Integer oldIdCardapio = this.idCardapio;
        this.idCardapio = idCardapio;
        changeSupport.firePropertyChange("idCardapio", oldIdCardapio, idCardapio);
    }

    public int getCodidoPrato() {
        return codidoPrato;
    }

    public void setCodidoPrato(int codidoPrato) {
        int oldCodidoPrato = this.codidoPrato;
        this.codidoPrato = codidoPrato;
        changeSupport.firePropertyChange("codidoPrato", oldCodidoPrato, codidoPrato);
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        Float oldValor = this.valor;
        this.valor = valor;
        changeSupport.firePropertyChange("valor", oldValor, valor);
    }

    public int getVersao() {
        return versao;
    }

    public void setVersao(int versao) {
        int oldVersao = this.versao;
        this.versao = versao;
        changeSupport.firePropertyChange("versao", oldVersao, versao);
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
        hash += (idCardapio != null ? idCardapio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CardapioDB)) {
            return false;
        }
        CardapioDB other = (CardapioDB) object;
        if ((this.idCardapio == null && other.idCardapio != null) || (this.idCardapio != null && !this.idCardapio.equals(other.idCardapio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Cardapio_1[ idCardapio=" + idCardapio + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

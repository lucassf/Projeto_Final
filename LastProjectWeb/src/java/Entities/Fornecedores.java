/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "fornecedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fornecedores.findAll", query = "SELECT f FROM Fornecedores f"),
    @NamedQuery(name = "Fornecedores.findByIdfornecedores", query = "SELECT f FROM Fornecedores f WHERE f.idfornecedores = :idfornecedores"),
    @NamedQuery(name = "Fornecedores.findByNome", query = "SELECT f FROM Fornecedores f WHERE f.nome = :nome"),
    @NamedQuery(name = "Fornecedores.findByCnpj", query = "SELECT f FROM Fornecedores f WHERE f.cnpj = :cnpj"),
    @NamedQuery(name = "Fornecedores.findByEndereco", query = "SELECT f FROM Fornecedores f WHERE f.endereco = :endereco"),
    @NamedQuery(name = "Fornecedores.findByEstado", query = "SELECT f FROM Fornecedores f WHERE f.estado = :estado"),
    @NamedQuery(name = "Fornecedores.findByCidade", query = "SELECT f FROM Fornecedores f WHERE f.cidade = :cidade"),
    @NamedQuery(name = "Fornecedores.findByBairro", query = "SELECT f FROM Fornecedores f WHERE f.bairro = :bairro"),
    @NamedQuery(name = "Fornecedores.findByTelefone1", query = "SELECT f FROM Fornecedores f WHERE f.telefone1 = :telefone1"),
    @NamedQuery(name = "Fornecedores.findByTelefone2", query = "SELECT f FROM Fornecedores f WHERE f.telefone2 = :telefone2"),
    @NamedQuery(name = "Fornecedores.findByEmail", query = "SELECT f FROM Fornecedores f WHERE f.email = :email"),
    @NamedQuery(name = "Fornecedores.findByDataDeCadastro", query = "SELECT f FROM Fornecedores f WHERE f.dataDeCadastro = :dataDeCadastro")})
public class Fornecedores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfornecedores")
    private Integer idfornecedores;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Cnpj")
    private String cnpj;
    @Size(max = 45)
    @Column(name = "Endereco")
    private String endereco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Cidade")
    private String cidade;
    @Size(max = 45)
    @Column(name = "Bairro")
    private String bairro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Telefone1")
    private String telefone1;
    @Size(max = 45)
    @Column(name = "Telefone2")
    private String telefone2;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DataDeCadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDeCadastro;

    public Fornecedores() {
    }

    public Fornecedores(Integer idfornecedores) {
        this.idfornecedores = idfornecedores;
    }

    public Fornecedores(Integer idfornecedores, String nome, String cnpj, String estado, String cidade, String telefone1, String email, Date dataDeCadastro) {
        this.idfornecedores = idfornecedores;
        this.nome = nome;
        this.cnpj = cnpj;
        this.estado = estado;
        this.cidade = cidade;
        this.telefone1 = telefone1;
        this.email = email;
        this.dataDeCadastro = dataDeCadastro;
    }

    public Integer getIdfornecedores() {
        return idfornecedores;
    }

    public void setIdfornecedores(Integer idfornecedores) {
        this.idfornecedores = idfornecedores;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfornecedores != null ? idfornecedores.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedores)) {
            return false;
        }
        Fornecedores other = (Fornecedores) object;
        if ((this.idfornecedores == null && other.idfornecedores != null) || (this.idfornecedores != null && !this.idfornecedores.equals(other.idfornecedores))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Fornecedores[ idfornecedores=" + idfornecedores + " ]";
    }
    
}

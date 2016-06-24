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
@Table(name = "produtos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtos.findAll", query = "SELECT p FROM Produtos p"),
    @NamedQuery(name = "Produtos.findByIdProdutos", query = "SELECT p FROM Produtos p WHERE p.idProdutos = :idProdutos"),
    @NamedQuery(name = "Produtos.findByDescricao", query = "SELECT p FROM Produtos p WHERE p.descricao = :descricao"),
    @NamedQuery(name = "Produtos.findByIdCategoria", query = "SELECT p FROM Produtos p WHERE p.idCategoria = :idCategoria"),
    @NamedQuery(name = "Produtos.findByMargem", query = "SELECT p FROM Produtos p WHERE p.margem = :margem"),
    @NamedQuery(name = "Produtos.findByPrecoCusto", query = "SELECT p FROM Produtos p WHERE p.precoCusto = :precoCusto"),
    @NamedQuery(name = "Produtos.findByPrecoVenda", query = "SELECT p FROM Produtos p WHERE p.precoVenda = :precoVenda"),
    @NamedQuery(name = "Produtos.findByFabricante", query = "SELECT p FROM Produtos p WHERE p.fabricante = :fabricante"),
    @NamedQuery(name = "Produtos.findByFornecedor", query = "SELECT p FROM Produtos p WHERE p.fornecedor = :fornecedor"),
    @NamedQuery(name = "Produtos.findByDataDeCadastro", query = "SELECT p FROM Produtos p WHERE p.dataDeCadastro = :dataDeCadastro")})
public class Produtos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProdutos")
    private Integer idProdutos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCategoria")
    private int idCategoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Margem")
    private double margem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PrecoCusto")
    private double precoCusto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PrecoVenda")
    private double precoVenda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Fabricante")
    private String fabricante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Fornecedor")
    private String fornecedor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DataDeCadastro")
    @Temporal(TemporalType.DATE)
    private Date dataDeCadastro;

    public Produtos() {
    }

    public Produtos(Integer idProdutos) {
        this.idProdutos = idProdutos;
    }

    public Produtos(Integer idProdutos, String descricao, int idCategoria, double margem, double precoCusto, double precoVenda, String fabricante, String fornecedor, Date dataDeCadastro) {
        this.idProdutos = idProdutos;
        this.descricao = descricao;
        this.idCategoria = idCategoria;
        this.margem = margem;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.fabricante = fabricante;
        this.fornecedor = fornecedor;
        this.dataDeCadastro = dataDeCadastro;
    }

    public Integer getIdProdutos() {
        return idProdutos;
    }

    public void setIdProdutos(Integer idProdutos) {
        this.idProdutos = idProdutos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public double getMargem() {
        return margem;
    }

    public void setMargem(double margem) {
        this.margem = margem;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
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
        hash += (idProdutos != null ? idProdutos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtos)) {
            return false;
        }
        Produtos other = (Produtos) object;
        if ((this.idProdutos == null && other.idProdutos != null) || (this.idProdutos != null && !this.idProdutos.equals(other.idProdutos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Produtos[ idProdutos=" + idProdutos + " ]";
    }
    
}

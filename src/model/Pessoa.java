
package model;

import java.io.Serializable;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Pessoa")
public class Pessoa implements Serializable {

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", email=" + email + ", cpfCnpj=" + cpfCnpj + ", password=" + password
				+ ", nome_completo=" + nome_completo + ", anotacao=" + anotacao + ", telefone=" + telefone
				+ ", celular=" + celular + ", endereco=" + endereco + ", bairro=" + bairro + ", cep=" + cep
				+ ", numero=" + numero + ", estado=" + estado + ", cidade=" + cidade + ", complemento=" + complemento
				+ ", tpPerfil=" + tpPerfil + "]";
	}



	@Id
	@GeneratedValue
	private Long id;
	private String email;
	private String cpfCnpj;
	private String password;
	
	
	private String nome_completo;	
	private String anotacao;
	private String telefone;
	private String celular;

	private String endereco;
	private String bairro;
	private String cep;
	private String numero;
	private String estado;
	private String cidade;
	private String complemento;
	
	private String tpPerfil;
	

	public Pessoa() {
		super();

	}

	

	



	public Pessoa(Long id, String nome_completo, String email, String cpfCnpj, String anotacao, String telefone,
			String celular, String password, String endereco, String bairro, String cep, String numero, String estado,
			String cidade, String complemento, String tpPerfil) {
		super();
		this.id = id;
		this.nome_completo = nome_completo;
		this.email = email;
		this.cpfCnpj = cpfCnpj;
		this.anotacao = anotacao;
		this.telefone = telefone;
		this.celular = celular;
		this.password = password;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cep = cep;
		this.numero = numero;
		this.estado = estado;
		this.cidade = cidade;
		this.complemento = complemento;
		this.tpPerfil = tpPerfil;
	}







	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome_completo() {
		return nome_completo;
	}

	public void setNome_completo(String nome_completo) {
		this.nome_completo = nome_completo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	
	public String getAnotacao() {
		return anotacao;
	}

	public void setAnotacao(String anotacao) {
		this.anotacao = anotacao;
	}


	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
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

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getTpPerfil() {
		return tpPerfil;
	}



	public void setTpPerfil(String tpPerfil) {
		this.tpPerfil = tpPerfil;
	}
	
	

}

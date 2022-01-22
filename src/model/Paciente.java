
package model;

import java.io.Serializable;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Paciente")
public class Paciente implements Serializable {

	



	@Id
	@GeneratedValue
	private Long id;
	@Column(unique=true)
	private String email;
	@Column(unique=true)
	private String cpf;
	
	private String sexo;
	
	private String nome_completo;		
	private String celular;

	private String peso;
	private String altura;
	private String crm;
	private String solicitante;
	private String dtnascimento;
	private String dtexame;
	private String empresa;
	

	public Paciente() {
		super();

	}


	public Paciente(Long id, String email, String cpf, String sexo, String nome_completo, String celular, String peso,
			String altura, String crm, String solicitante, String dtnascimento, String dtexame, String empresa) {
		super();
		this.id = id;
		this.email = email;
		this.cpf = cpf;
		this.sexo = sexo;
		this.nome_completo = nome_completo;
		this.celular = celular;
		this.peso = peso;
		this.altura = altura;
		this.crm = crm;
		this.solicitante = solicitante;
		this.dtnascimento = dtnascimento;
		this.dtexame = dtexame;
		this.empresa = empresa;
	}


	@Override
	public String toString() {
		return "Paciente [id=" + id + ", email=" + email + ", cpf=" + cpf + ", sexo=" + sexo + ", nome_completo="
				+ nome_completo + ", celular=" + celular + ", peso=" + peso + ", altura=" + altura + ", crm=" + crm
				+ ", solicitante=" + solicitante + ", dtnascimento=" + dtnascimento + ", dtexame=" + dtexame
				+ ", empresa=" + empresa + "]";
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getNome_completo() {
		return nome_completo;
	}


	public void setNome_completo(String nome_completo) {
		this.nome_completo = nome_completo;
	}


	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}


	public String getPeso() {
		return peso;
	}


	public void setPeso(String peso) {
		this.peso = peso;
	}


	public String getAltura() {
		return altura;
	}


	public void setAltura(String altura) {
		this.altura = altura;
	}


	public String getCrm() {
		return crm;
	}


	public void setCrm(String crm) {
		this.crm = crm;
	}


	public String getSolicitante() {
		return solicitante;
	}


	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}


	public String getDtnascimento() {
		return dtnascimento;
	}


	public void setDtnascimento(String dtnascimento) {
		this.dtnascimento = dtnascimento;
	}


	public String getDtexame() {
		return dtexame;
	}


	public void setDtexame(String dtexame) {
		this.dtexame = dtexame;
	}


	public String getEmpresa() {
		return empresa;
	}


	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	


}

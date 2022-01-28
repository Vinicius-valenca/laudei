
package model;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.fileupload.FileItem;

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
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtnascimento;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtexame;
	private String empresa;
	

	public Paciente() {
		super();

	}


	public Paciente(Long id, String email, String cpf, String sexo, String nome_completo, String celular, String peso,
			String altura, String crm, String solicitante, Date dtnascimento, Date dtexame, String empresa) {
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


	public Date getDtnascimento() {
		return dtnascimento;
	}


	public void setDtnascimento(Date dtnascimento) {
		this.dtnascimento = dtnascimento;
	}


	public Date getDtexame() {
		return dtexame;
	}


	public void setDtexame(Date dtexame) {
		this.dtexame = dtexame;
	}


	public String getEmpresa() {
		return empresa;
	}


	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public void montarPaciente(FileItem item)
			throws NumberFormatException, UnsupportedEncodingException, ParseException {
		if (item.getFieldName().equals("id")) {
			if (!item.getString("UTF-8").trim().isEmpty()) {
				System.out.println("if");
				this.setId(Long.valueOf(item.getString("UTF-8").trim()));
			}
		} else if (item.getFieldName().equals("nome_completo")) {
			this.setNome_completo(item.getString("UTF-8").trim());
		} else if (item.getFieldName().equals("email")) {
			this.setEmail(item.getString("UTF-8").toLowerCase().trim());
		} else if (item.getFieldName().equals("cpf")) {
			this.setCpf(item.getString("UTF-8").trim());
		} else if (item.getFieldName().equals("dtnascimento")) {
			java.util.Date dtnascimento = new SimpleDateFormat("dd/MM/yyyy").parse(item.getString("UTF-8").trim());
			java.sql.Date dtnascimento1 = new java.sql.Date(dtnascimento.getTime());
			this.setDtnascimento(dtnascimento1);
		} else if (item.getFieldName().equals("sexo")) {
			this.setSexo(item.getString("UTF-8").trim());
		} else if (item.getFieldName().equals("celular")) {
			this.setCelular(item.getString("UTF-8").trim());
		} 
	}


	



}

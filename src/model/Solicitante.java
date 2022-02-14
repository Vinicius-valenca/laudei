
package model;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
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
@Table(name = "Solicitante")
public class Solicitante implements Serializable {

	



	@Id
	@GeneratedValue
	private Long id;	
	@Column(unique=true)
	private String crm;
	
	
	private String nome_completo;		
	

	

	public Solicitante() {
		super();

	}


	public Solicitante(Long id, String nome_completo, String crm) {
		super();
		this.id = id;
		
		this.nome_completo = nome_completo;
		
		this.crm = crm;
		
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



	public String getCrm() {
		return crm;
	}


	public void setCrm(String crm) {
		this.crm = crm;
	}


	@Override
	public String toString() {
		return "Solicitante [id=" + id + ", crm=" + crm + ", nome_completo=" + nome_completo + "]";
	}



	



}

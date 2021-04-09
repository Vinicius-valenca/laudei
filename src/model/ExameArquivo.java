
package model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ExameArquivo")
public class ExameArquivo implements Serializable {

	@Id
	@GeneratedValue
	private Long id;	
	private byte[] exame;
	private String nomeExame;
	
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	



	public ExameArquivo() {
		super();

	}


	public byte[] getExame() {
		return exame;
	}


	public void setExame(byte[] exame) {
		this.exame = exame;
	}


	public String getNomeExame() {
		return nomeExame;
	}


	public void setNomeExame(String nomeExame) {
		this.nomeExame = nomeExame;
	}

	






}

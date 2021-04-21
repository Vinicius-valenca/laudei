
package model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Exames")
public class Exame implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	private String nomePaciente;
	@OneToOne
    @JoinColumn(name = "nomeClinica", referencedColumnName = "id")
	private Pessoa nomeClinica;
	@OneToOne
    @JoinColumn(name = "nomeMedico", referencedColumnName = "id")
	private Pessoa nomeMedico;
	private Date dtEntrada;
	private Date dtLaudo;
	private String tpExame;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "exameArquivo", referencedColumnName = "id")
	@Transient
	private ExameArquivo exameArquivo;
	@Override
	public String toString() {
		return "Exame [id=" + id + ", nomePaciente=" + nomePaciente + ", nomeClinica=" + nomeClinica + ", nomeMedico="
				+ nomeMedico + ", dtEntrada=" + dtEntrada + ", dtLaudo=" + dtLaudo + ", tpExame=" + tpExame
				+ ", exameArquivo=" + exameArquivo + ", laudo=" + laudo + "]";
	}


	private String laudo;
	
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNomePaciente() {
		return nomePaciente;
	}


	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}


	public Pessoa getNomeClinica() {
		return nomeClinica;
	}


	public void setNomeClinica(Pessoa nomeClinica) {
		this.nomeClinica = nomeClinica;
	}


	public Pessoa getNomeMedico() {
		return nomeMedico;
	}


	public void setNomeMedico(Pessoa nomeMedico) {
		this.nomeMedico = nomeMedico;
	}


	public Date getDtEntrada() {
		return dtEntrada;
	}


	public void setDtEntrada(Date dtEntrada) {
		this.dtEntrada = dtEntrada;
	}


	public Date getDtLaudo() {
		return dtLaudo;
	}


	public void setDtLaudo(Date dtLaudo) {
		this.dtLaudo = dtLaudo;
	}


	public String getTpExame() {
		return tpExame;
	}


	public void setTpExame(String tpExame) {
		this.tpExame = tpExame;
	}




	public Exame() {
		super();

	}


	public ExameArquivo getExameArquivo() {
		return exameArquivo;
	}


	public void setExameArquivo(ExameArquivo exameArquivo) {
		this.exameArquivo = exameArquivo;
	}


	public String getLaudo() {
		return laudo;
	}


	public void setLaudo(String laudo) {
		this.laudo = laudo;
	}


	public Exame(Long id, String nomePaciente, Pessoa nomeClinica, Pessoa nomeMedico, Date dtEntrada, Date dtLaudo,
			String tpExame, ExameArquivo exameArquivo, String laudo) {
		super();
		this.id = id;
		this.nomePaciente = nomePaciente;
		this.nomeClinica = nomeClinica;
		this.nomeMedico = nomeMedico;
		this.dtEntrada = dtEntrada;
		this.dtLaudo = dtLaudo;
		this.tpExame = tpExame;
		this.exameArquivo = exameArquivo;
		this.laudo = laudo;
	}



	






}


package model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import java.util.UUID;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "Exames")
public class Exame implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	
	@Id  
	 @Type(type="org.hibernate.type.PostgresUUIDType")
	@Column(updatable = false, nullable = false, columnDefinition = "uuid DEFAULT uuid_generate_v4()",unique = true)
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID code;
	@OneToOne
	@JoinColumn(name = "nomeClinica", referencedColumnName = "id")
	private Pessoa nomeClinica;
	@OneToOne
	@JoinColumn(name = "nomeMedico", referencedColumnName = "id")
	private Pessoa nomeMedico;
	
	private String nPaciente;
	@OneToOne
	@JoinColumn(name = "nomePaciente", referencedColumnName = "id")
	private Paciente nomePaciente;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtEntrada;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtLaudo;
	private String tpExame;
	private String obs;
	private String examenome;
	private String exameLink;
	private Boolean laudoVisto;
	@OneToOne
	@JoinColumn(name = "Solicitante", referencedColumnName = "id")
	private Solicitante solicitante;

	

	



	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}







	private String laudo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	

	public String getLaudo() {
		return laudo;
	}

	public void setLaudo(String laudo) {
		this.laudo = laudo;
	}

	


	

	public Paciente getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(Paciente nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	

	public String getNpaciente() {
		return nPaciente;
	}

	public void setNpaciente(String npaciente) {
		this.nPaciente = npaciente;
	}

	public Exame(Long id, UUID code, Pessoa nomeClinica, Pessoa nomeMedico, String nPaciente, Date dtEntrada,
			Date dtLaudo, String tpExame, String obs, String examenome, String exameLink, Boolean laudoVisto,
			Solicitante solicitante, String laudo, Paciente nomePaciente) {
		super();
		this.id = id;
		this.code = code;
		this.nomeClinica = nomeClinica;
		this.nomeMedico = nomeMedico;
		this.nomePaciente = nomePaciente;
		this.nPaciente = nPaciente;
		this.dtEntrada = dtEntrada;
		this.dtLaudo = dtLaudo;
		this.tpExame = tpExame;
		this.obs = obs;
		this.examenome = examenome;
		this.exameLink = exameLink;
		this.laudoVisto = laudoVisto;
		this.solicitante = solicitante;
		this.laudo = laudo;
	}

	@Override
	public String toString() {
		return "Exame [id=" + id + ", code=" + code + ", nomeClinica=" + nomeClinica + ", nomeMedico=" + nomeMedico
				+ ", nomePaciente=" + nomePaciente + ", dtEntrada=" + dtEntrada + ", dtLaudo=" + dtLaudo + ", tpExame="
				+ tpExame + ", obs=" + obs + ", examenome=" + examenome + ", exameLink=" + exameLink + ", laudoVisto="
				+ laudoVisto + ", solicitante=" + solicitante + ", laudo=" + laudo + "]";
	}

	public Solicitante getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Solicitante solicitante) {
		this.solicitante = solicitante;
	}

	public UUID getCode() {
		return code;
	}

	public void setCode(UUID code) {
		this.code = code;
	}

	public String getExamenome() {
		if(nomePaciente.getId() != null){
			return nomePaciente.getNome_completo();
		}else{
			return examenome;
		}
	}

	public void setExamenome(String examenome) {
		this.examenome = examenome;
	}

	public String getExameLink() {
		return exameLink;
	}

	public void setExameLink(String exameLink) {
		this.exameLink = exameLink;
	}

	public Boolean getLaudoVisto() {
		return laudoVisto;
	}

	public void setLaudoVisto(Boolean laudoVisto) {
		this.laudoVisto = laudoVisto;
	}



}

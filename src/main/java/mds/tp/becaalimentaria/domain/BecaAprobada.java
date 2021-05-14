package mds.tp.becaalimentaria.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = 
{@UniqueConstraint(columnNames={"ID_BECAAPROBADA"})})
public class BecaAprobada {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //valor autonumerico
	@Column(name="ID_BECAAPROBADA")
	private Integer id;
	private Date fechaInicio;
	private Date fechaFin;
	
	@OneToOne(mappedBy = "becaAprobada")
	private Solicitud solicitud;
	
	public BecaAprobada(Date fechaInicio, Date fechaFin, Solicitud solicitud) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.solicitud = solicitud;
	}

	public BecaAprobada() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	@Override
	public String toString() {
		return "BecaAprobada [id=" + id + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", solicitud="
				+ solicitud + "]";
	}
	
	

}

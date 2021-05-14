package mds.tp.becaalimentaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = 
{@UniqueConstraint(columnNames={"ID_PROGENITOR"})})
public class ProgenitorTutor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //valor autonumerico
	@Column(name="ID_PROGENITOR")
	private Integer id;
	private String nombre;
	private String apellido;
	private Double ingresoNeto;
	private Integer edad;
	private String ocupacion;
	private String lugarDeTrabajo;
	private Boolean convive;
	

	@ManyToOne
	@JoinColumn(name= "ID_GRUPOFAMILIAR")
	private GrupoFamiliar grupoFamiliar;
	
	
	public ProgenitorTutor(String nombre, String apellido, Double ingresoNeto, Integer edad, String ocupacion,
			String lugarDeTrabajo, Boolean convive,GrupoFamiliar grFamiliar) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.ingresoNeto = ingresoNeto;
		this.edad = edad;
		this.ocupacion = ocupacion;
		this.lugarDeTrabajo = lugarDeTrabajo;
		this.convive = convive;
		this.grupoFamiliar = grFamiliar;
	}


	public ProgenitorTutor() {
		super();
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public Double getIngresoNeto() {
		return ingresoNeto;
	}


	public void setIngresoNeto(Double ingresoNeto) {
		this.ingresoNeto = ingresoNeto;
	}


	public Integer getEdad() {
		return edad;
	}


	public void setEdad(Integer edad) {
		this.edad = edad;
	}


	public String getOcupacion() {
		return ocupacion;
	}


	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}


	public String getLugarDeTrabajo() {
		return lugarDeTrabajo;
	}


	public void setLugarDeTrabajo(String lugarDeTrabajo) {
		this.lugarDeTrabajo = lugarDeTrabajo;
	}


	public Boolean getConvive() {
		return convive;
	}


	public void setConvive(Boolean convive) {
		this.convive = convive;
	}

	

	public GrupoFamiliar getGrupoFamiliar() {
		return grupoFamiliar;
	}


	public void setGrupoFamiliar(GrupoFamiliar grupoFamiliar) {
		this.grupoFamiliar = grupoFamiliar;
	}


	@Override
	public String toString() {
		return "ProgenitorTutor [nombre=" + nombre + ", apellido=" + apellido + ", ingresoNeto=" + ingresoNeto
				+ ", edad=" + edad + ", ocupacion=" + ocupacion + ", lugarDeTrabajo=" + lugarDeTrabajo + ", convive="
				+ convive + "]";
	}
	
	
	
}

package mds.tp.becaalimentaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = 
{@UniqueConstraint(columnNames={"ID_HERMANO"})})
public class Hermano {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //valor autonumerico
	@Column(name="ID_HERMANO")
	private Integer id;
	private String nombre;
	private String apellido;
	private Integer edad;
	private String ocupacion; 
	private String escuela;
	private Boolean convive;
	
	
	@ManyToOne
	@JoinColumn(name= "ID_GRUPOFAMILIAR")
	private GrupoFamiliar grupoFamiliar;
	
	public Hermano(Integer edad, String ocupacion, String escuela, Boolean convive,GrupoFamiliar grFamiliar, 
			String nombre, String apellido) {
		super();
		this.edad = edad;
		this.ocupacion = ocupacion;
		this.escuela = escuela;
		this.convive = convive;
		this.grupoFamiliar = grFamiliar;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Hermano() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getEscuela() {
		return escuela;
	}

	public void setEscuela(String escuela) {
		this.escuela = escuela;
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
		return "Hermano [id=" + id + ", edad=" + edad + ", ocupacion=" + ocupacion + ", escuela=" + escuela
				+ ", convive=" + convive + "]";
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
	
	
	
}

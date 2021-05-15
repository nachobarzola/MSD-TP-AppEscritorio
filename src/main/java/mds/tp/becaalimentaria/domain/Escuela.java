package mds.tp.becaalimentaria.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = 
{@UniqueConstraint(columnNames={"codigoUnicoEstablecimiento"})})
public class Escuela {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //valor autonumerico
	@Column(name="ID_ESCUELA")
	private Integer id;
	@Column(name="codigoUnicoEstablecimiento")
	private String codigoUnicoEstablecimiento;
	private String clave;
	private String nombre;
	
	@OneToMany(mappedBy = "escuela", fetch = FetchType.EAGER)
	private List<Alumno> listaAlumnos;
	
	
	public Escuela(String codigoUnicoEstablecimiento, String clave, String nombre) {
		super();
		this.codigoUnicoEstablecimiento = codigoUnicoEstablecimiento;
		this.clave = clave;
		this.nombre = nombre;

		this.listaAlumnos = new ArrayList<>();
	}
	public Escuela() {
		this.listaAlumnos = new ArrayList<>();
	}
	
	public String getCodigoUnicoEstablecimiento() {
		return codigoUnicoEstablecimiento;
	}
	public void setCodigoUnicoEstablecimiento(String codigoUnicoEstablecimiento) {
		this.codigoUnicoEstablecimiento = codigoUnicoEstablecimiento;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Alumno> getListaAlumnos() {
		return listaAlumnos;
	}
	public void setListaAlumnos(List<Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}
	public void addAlumnos(List<Alumno> listaAlumnos) {
		this.listaAlumnos.addAll(listaAlumnos);
	}
	public void addAlumno(Alumno alumno) {
		this.listaAlumnos.add(alumno);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Escuela [id=" + id + ", codigoUnicoEstablecimiento=" + codigoUnicoEstablecimiento + ", clave=" + clave
				+ ", listaAlumnos=" + listaAlumnos + "]";
	}
	
	
	

}

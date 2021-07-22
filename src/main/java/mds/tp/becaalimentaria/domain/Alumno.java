package mds.tp.becaalimentaria.domain;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="ALUMNO", uniqueConstraints = 
{@UniqueConstraint(columnNames={"dni"})})
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //valor autonumerico
	@Column(name="ID_ALUMNO")
	private Integer id;
	
	private String nombre;
	private String apellido;
	private String nacionalidad;
	private String dni;
	private String email;
	private String telefono;
	private String cuit;
	
	@Temporal(TemporalType.DATE)
	private Date fechaDeNacimiento;
	
	private String grado;
	private Turno turno;
	
	@OneToOne
	@JoinColumn(name="ID_GRUPOFAMILIAR")
	private GrupoFamiliar grupoFamiliar;
	
	@OneToMany(mappedBy = "alumnoSolicitante", fetch = FetchType.EAGER)
	private List<Solicitud> solicitudes;
	
	@OneToOne
	@JoinColumn(name="ID_DIRECCION")
	private Direccion direccion;

	@ManyToOne
	@JoinColumn(name="ID_ESCUELA")
	private Escuela escuela;
	
	
	
	public Alumno(String nombre, String apellido, String nacionalidad, String dni, String email,
			String telefono, String cuit, Date fechaDeNacimiento, String grado, Turno turno,
			GrupoFamiliar grupoFamiliar, Direccion direccion, Escuela esc) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacionalidad = nacionalidad;
		this.dni = dni;
		this.email = email;
		this.telefono = telefono;
		this.cuit = cuit;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.grado = grado;
		this.turno = turno;
		this.grupoFamiliar = grupoFamiliar;
		this.solicitudes = new ArrayList<>();
		this.direccion = direccion;
		this.escuela = esc;
	}
	public Alumno() {super();}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public String getGrado() {
		return grado;
	}
	public void setGrado(String grado) {
		this.grado = grado;
	}
	public Turno getTurno() {
		return turno;
	}
	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	public GrupoFamiliar getGrupoFamiliar() {
		return grupoFamiliar;
	}
	public void setGrupoFamiliar(GrupoFamiliar grupoFamiliar) {
		this.grupoFamiliar = grupoFamiliar;
	}
	public List<Solicitud> getSolicitudes() {
		return solicitudes;
	}
	public void setSolicitudes(List<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	
	
	public Escuela getEscuela() {
		return escuela;
	}
	public void setEscuela(Escuela escuela) {
		this.escuela = escuela;
	}
	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", nacionalidad=" + nacionalidad
				+ ", dni=" + dni + ", email=" + email + ", telefono=" + telefono + ", cuit=" + cuit
				+ ", fechaDeNacimiento=" + fechaDeNacimiento + ", grado=" + grado + ", turno=" + turno
				+ ", grupoFamiliar=" + grupoFamiliar + ", solicitudes=" + solicitudes + ", direccion=" + direccion
				+ "]";
	}
	
		
	
	
}

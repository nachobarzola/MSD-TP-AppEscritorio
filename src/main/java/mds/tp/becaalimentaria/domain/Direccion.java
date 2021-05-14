package mds.tp.becaalimentaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = 
{@UniqueConstraint(columnNames={"ID_DIRECCION"})})
public class Direccion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //valor autonumerico
	@Column(name="ID_DIRECCION")
	private Integer id;
	private String domicilio;
	private String localidad;
	private String codigoPostal;
	public Direccion(String domicilio, String localidad, String codigoPostal) {
		super();
		this.domicilio = domicilio;
		this.localidad = localidad;
		this.codigoPostal = codigoPostal;
	}
	public Direccion() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	@Override
	public String toString() {
		return "Direccion [id=" + id + ", domicilio=" + domicilio + ", localidad=" + localidad + ", codigoPostal="
				+ codigoPostal + "]";
	}
	
	
}

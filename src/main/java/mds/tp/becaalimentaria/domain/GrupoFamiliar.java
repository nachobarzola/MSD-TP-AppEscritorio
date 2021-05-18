package mds.tp.becaalimentaria.domain;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name= "GRUPOFAMILIAR",uniqueConstraints = 
{@UniqueConstraint(columnNames={"ID_GRUPOFAMILIAR"})})
public class GrupoFamiliar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //valor autonumerico
	@Column(name="ID_GRUPOFAMILIAR")
	private Integer id;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "grupoFamiliar")
	private List<Hermano> listaHermano;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "grupoFamiliar")
	private List<ProgenitorTutor> listaProgenitorTutor;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "grupoFamiliar")
	private List<EnfermedadCronica> listaEnfermedadCronica;
	
	

	public GrupoFamiliar() {
		super();
		this.listaHermano = new ArrayList<>();
		this.listaProgenitorTutor = new ArrayList<>();
		this.listaEnfermedadCronica = new ArrayList<>();
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Hermano> getListaHermano() {
		return listaHermano;
	}

	public void setListaHermano(List<Hermano> listaHermano) {
		this.listaHermano = listaHermano;
	}
	public void addHermano(Hermano hermano) {
		this.listaHermano.add(hermano);
	}

	public List<ProgenitorTutor> getListaProgenitorTutor() {
		return listaProgenitorTutor;
	}

	public void setListaProgenitorTutor(List<ProgenitorTutor> listaProgenitorTutor) {
		this.listaProgenitorTutor = listaProgenitorTutor;
	}
	public void addProgenitorTutor(ProgenitorTutor progenitorTutor) {
		this.listaProgenitorTutor.add(progenitorTutor);
	}
	public List<EnfermedadCronica> getListaEnfermedadCronica() {
		return listaEnfermedadCronica;
	}

	public void setListaEnfermedadCronica(List<EnfermedadCronica> listaEnfermedadCronica) {
		this.listaEnfermedadCronica = listaEnfermedadCronica;
	}
	public void addEnfermedadCronica(EnfermedadCronica enfermedadCronica) {
		this.listaEnfermedadCronica.add(enfermedadCronica);
	}

	@Override
	public String toString() {
		return "GrupoFamiliar [id=" + id + ", listaHermano=" + listaHermano + ", listaProgenitorTutor="
				+ listaProgenitorTutor + ", listaEnfermedadCronica=" + listaEnfermedadCronica + "]";
	}
	
	
	
}

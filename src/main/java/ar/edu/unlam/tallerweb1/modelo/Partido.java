package ar.edu.unlam.tallerweb1.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Partido {
	
	@Id
	@GeneratedValue
	private Long id;
	private Date horario;
	@ManyToOne
	private Equipo equipo1;
	@ManyToOne
	private Equipo equipo2;
	private Boolean finalizado;
	private Long golesEquipo1;
	private Long golesEquipo2;
	@ManyToOne()
	private Fecha fecha;

	public Partido(){
		this.finalizado = false;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public Equipo getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}

	public Equipo getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}

	public Boolean getFinalizado() {
		return finalizado;
	}

	public void setFinalizado(Boolean finalizado) {
		this.finalizado = finalizado;
	}

	public Long getGolesEquipo1() {
		return golesEquipo1;
	}

	public void setGolesEquipo1(Long golesEquipo1) {
		this.golesEquipo1 = golesEquipo1;
	}

	public Long getGolesEquipo2() {
		return golesEquipo2;
	}

	public void setGolesEquipo2(Long golesEquipo2) {
		this.golesEquipo2 = golesEquipo2;
	}

	public Fecha getFecha() {
		return fecha;
	}

	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partido other = (Partido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}

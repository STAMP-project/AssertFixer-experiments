package dev.controller.api.viewModels.passageConcours;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultatConcoursVm {

	@JsonProperty("concours_id")
	private Long idConcours;
	@JsonProperty("concours_titre")
	private String titreConcours;

	private int rang;
	
	public ResultatConcoursVm(Long id, String titre, int rang){
		idConcours = id;
		titreConcours = titre;
		this.rang = rang;
	}

	public Long getIdConcours() {
		return idConcours;
	}

	public void setIdConcours(Long idConcours) {
		this.idConcours = idConcours;
	}

	public String getTitreConcours() {
		return titreConcours;
	}

	public void setTitreConcours(String titreConcours) {
		this.titreConcours = titreConcours;
	}

	public int getRang() {
		return rang;
	}

	public void setRang(int rang) {
		this.rang = rang;
	}
	
	
	
}

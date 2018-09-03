package ar.com.utn.dds.sge.factory;

import ar.com.utn.dds.sge.models.Dispositivo;
import ar.com.utn.dds.sge.models.DispositivoAdaptado;
import ar.com.utn.dds.sge.models.DispositivoEstandar;
import ar.com.utn.dds.sge.models.DispositivoInteligente;

public class DispositivoFactory {
	
	public static Dispositivo createDispositivo(String tipo){
		if(tipo.equals("estandar"))
			return new DispositivoEstandar(); 
		if(tipo.equals("inteligente"))
			return new DispositivoInteligente(); 
		if(tipo.equals("adaptado"))
			return new DispositivoAdaptado(); 
		
		return null;
	}
}

package ar.com.utn.dds.sge.util;

import java.util.Calendar;

public class FechaUtil {

	 /**
	  * Metodo que compara dia mes y aÃ±o entre 2 fechas
	   * @param fecha1 
	   * @param fecha2
	   * @return Valor de verdad de la igualdad de las fechas
	  **/
	  public static boolean fechasIguales(Calendar fecha1, Calendar fecha2) {
	    return fecha1.get(Calendar.YEAR) == fecha2.get(Calendar.YEAR) &&
	         fecha1.get(Calendar.MONTH) == fecha2.get(Calendar.MONTH) &&
	         fecha1.get(Calendar.DAY_OF_MONTH) == fecha2.get(Calendar.DAY_OF_MONTH);
	  }	
	  
	  /**
	   * Metodo que devuelve diferencia de meses entre 2 fechas
	   * @param fecha1 
	   * @param fecha2
	   * @return Diferencia de meses entre las 2 fechas
	   */
	  public static int obtenerMesesDeDiferencia(Calendar fecha1, Calendar fecha2) {
		  int difA = fecha1.get(Calendar.YEAR) - fecha2.get(Calendar.YEAR);
		  int difM = difA * 12 + fecha1.get(Calendar.MONTH) - fecha2.get(Calendar.MONTH);

		  return Math.abs(difM);
	  }
	  
	  /**
	   * Metodo que devuelve diferencia de años entre 2 fechas
	   * @param fecha1 
	   * @param fecha2
	   * @return Diferencia de años entre las 2 fechas
	   */
	  public static int obtenerYearsDeDiferencia(Calendar fecha1, Calendar fecha2) {
		  int difA = fecha1.get(Calendar.YEAR) - fecha2.get(Calendar.YEAR);
		  
		  return Math.abs(difA);
	  }
	  
}

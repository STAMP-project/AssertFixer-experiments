package ar.com.utn.dds.sge.models;

public class DispositivoEstandar extends Dispositivo {

		private Float hsDeUsoXDia;
		
		public DispositivoEstandar(String tipo, String nombre, Float consumo, double mensualMin, double mensualMax, boolean optimizable) {
			super( tipo, nombre, consumo, mensualMin, mensualMax, optimizable);
		}
		
		public Float gethsDeUsoXDia() {
			return hsDeUsoXDia;
		}

		/**
		 * @param estado the estado to set
		 */
		public void sethsDeUsoXDia(Float hsDeUsoXDia) {
			this.hsDeUsoXDia = hsDeUsoXDia;
		}
}

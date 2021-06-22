package unq;

import java.util.ArrayList;
import java.util.List;

public class AdministadorOcupacionDeInmueble {

	private List<OcupacionDeInmueble> ocupacionesDeInmuebles;
	private SitioWeb sitio;


	public AdministadorOcupacionDeInmueble(SitioWeb sitio) {
		this.setSitioAdministrar(sitio);
		this.setOcupaciones(new ArrayList<OcupacionDeInmueble>() ); 
	}

	private void setSitioAdministrar(SitioWeb sitio) {
		this.sitio =sitio;
		
	}

	private void setOcupaciones(ArrayList<OcupacionDeInmueble> ocupaciones) {
		this.ocupacionesDeInmuebles = ocupaciones;
	}

	public List<OcupacionDeInmueble> getOcupaciones() {
		return (this.ocupacionesDeInmuebles);
	}

	public void addOcupacion(OcupacionDeInmueble ocupacion) {
			this.getOcupaciones().add(ocupacion);
	}

	public void addOcupacionConReserva(Reserva reserva) {
		this.addOcupacion(this.generarOcupacionConReserva(reserva));
	}

	private OcupacionDeInmueble generarOcupacionConReserva(Reserva reserva) {
		OcupacionDeInmueble ocupacion = new OcupacionDeInmueble(reserva.getInmueble(),
																reserva.getInicioDeAlquiler(),
																reserva.getFinalDeAlquiler(),
																reserva.getInquilino() ) 	;														
		return (ocupacion);
	}

	public Boolean registraOcupacionDe(Inmueble inmueble) {
		// TODO Auto-generated method stub
		return null;
	}

}

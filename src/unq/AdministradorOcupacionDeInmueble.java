package unq;

import java.util.ArrayList;
import java.util.List;

public class AdministradorOcupacionDeInmueble implements Administradores, Registrable{
	// Atributos
	private List<OcupacionDeInmueble> ocupacionesDeInmuebles;
	private SitioWeb sitioweb;

	// Constructor
	public AdministradorOcupacionDeInmueble() {
		this.setSitioWeb(null);
		this.setOcupaciones(new ArrayList<OcupacionDeInmueble>() ); 
	}
	// Gets y sets
	private void setSitioWeb(SitioWeb sitio) {
		this.sitioweb =sitio;
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
		return(this.getOcupaciones().stream().anyMatch(o -> o.getInmueble().equals(inmueble) ) );
	}

	@Override
	public void administrar(SitioWeb sitioWeb) {
		sitioWeb.setAdminOcupaciones(this);
	}
	
	@Override
	public void registrarseEn(SitioWeb sitioWeb) {
		this.setSitioWeb(sitioWeb);
	}
}

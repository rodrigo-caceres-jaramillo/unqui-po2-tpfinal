package unq;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdministradorReserva {
	// Atributos
	private SitioWeb sitioWeb;
	private List<Reserva> reservas;
	
	// Constructor
	public AdministradorReserva(SitioWeb sitioWeb) {
		super();
		this.setSitioWeb(sitioWeb);
		this.setReservas(new ArrayList<Reserva> ());
	}
	
	// Gets y sets
	public SitioWeb getSitioWeb() {
		return sitioWeb;
	}
	
	public void setSitioWeb(SitioWeb sitioWeb) {
		this.sitioWeb = sitioWeb;
	}
	public List<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	// Metodos
	public void agregar(Reserva reserva) {
		this.getReservas().add(reserva);
	}
	
	public List<Reserva> obtenerReservasDelUsuario(Usuario inquilino) {
		List<Reserva> reservasDelUsuario = getReservas().stream()
				.filter(p -> p.getInquilino().equals(inquilino)).collect(Collectors.toList());
		return reservasDelUsuario;
	}
	
	public List<Reserva> obtenerReservasFuturasDelUsuario(Usuario inquilino) {
		List<Reserva> reservasFuturas = this.obtenerReservasDelUsuario(inquilino).stream()
				.filter(p -> p.getInicioDeAlquiler().equals(LocalDate.now())).collect(Collectors.toList());
		return reservasFuturas;
	}
 
	
	public List<Reserva> obtenerReservasEnLaCiudadDelUsuario(Usuario inquilino, String ciudad) {
		List<Reserva> reservasDelUsuarioEnLaCiudad = this.obtenerReservasDelUsuario(inquilino).stream()
				.filter(p -> p.getPublicacion().getInmueble().getCiudad()
						.equals(ciudad)).collect(Collectors.toList());
		return reservasDelUsuarioEnLaCiudad;
	}

	public Integer cantidadDeReservas() {
		
		return getReservas().size();
	}

	public List<String> getCiudadadesConReservasDe(Usuario usuario) {
				
		return null;
	}

	public void eliminar(Reserva reserva) {
		getReservas().remove(reserva);
		
	}
}

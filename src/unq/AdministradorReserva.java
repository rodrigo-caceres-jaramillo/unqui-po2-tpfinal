package unq;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdministradorReserva {
	// Atributos
	private SitioWeb sitioWeb;
	private ArrayList<Reserva> reservas;
	
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
	public ArrayList<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(ArrayList<Reserva> reservas) {
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
				.filter(p -> p.getInicioDeAlquiler().equals(/*fecha de hoy*/)).collect(Collectors.toList());
		return reservasFuturas;
	}
	
	public List<Reserva> obtenerReservasEnLaCiudadDelUsuario(Usuario inquilino, String ciudad) {
		List<Reserva> reservasDelUsuarioEnLaCiudad = this.obtenerReservasDelUsuario(inquilino).stream()
				.filter(p -> p.getPublicacion().getInmueble().getCiudad()
						.equals(ciudad)).collect(Collectors.toList());
		return reservasDelUsuarioEnLaCiudad;
	}
}

package unq;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdministradorReserva implements Administradores, Registrable{
	// Atributos
	private SitioWeb sitioWeb;
	private List<Reserva> reservas;

	// Constructor
	public AdministradorReserva() {
		super();
		this.setSitioWeb(null);
		this.setReservas(new ArrayList<Reserva>());
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
		List<Reserva> reservasDelUsuario = getReservas().stream().filter(p -> p.getInquilino().equals(inquilino))
				.collect(Collectors.toList());
		return reservasDelUsuario;
	}

	public List<Reserva> obtenerReservasFuturasDelUsuario(Usuario inquilino) {
		List<Reserva> reservasFuturas = this.obtenerReservasDelUsuario(inquilino).stream()
				.filter(p -> p.getInicioDeAlquiler().equals(LocalDate.now())).collect(Collectors.toList());
		return reservasFuturas;
	}

	public List<Reserva> obtenerReservasEnLaCiudadDelUsuario(Usuario inquilino, String ciudad) {
		List<Reserva> reservasDelUsuarioEnLaCiudad = this.obtenerReservasDelUsuario(inquilino).stream()
				.filter(p -> p.getPublicacion().getInmueble().getCiudad().equals(ciudad)).collect(Collectors.toList());
		return reservasDelUsuarioEnLaCiudad;
	}

	public List<String> getCiudadadesConReservasDe(Usuario inquilino) {
		List<String> ciudadesConReservas = new ArrayList<String>();
			for(Reserva reserva : this.obtenerReservasDelUsuario(inquilino))
				ciudadesConReservas.add(reserva.getPublicacion().getInmueble().getCiudad());
		List<String> ciudadadesSinRepetidos = ciudadesConReservas.stream().distinct().collect(Collectors.toList());
		return ciudadadesSinRepetidos;
	}
	
	public Integer cantidadDeReservas() {
		return getReservas().size();
	}

	public void eliminar(Reserva reserva) {
		getReservas().remove(reserva);
	}

	@Override
	public void administrar(SitioWeb sitioWeb) {
		sitioWeb.setAdminReserva(this);
	}
	
	@Override
	public void registrarseEn(SitioWeb sitioWeb) {
		this.setSitioWeb(sitioWeb);
	}
}

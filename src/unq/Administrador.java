package unq;

import java.util.List;

public class Administrador {
	// Atributos
	private SitioWeb sitioAcargo;
	private List<ServiciosEnum> servicios;


	// Constructor
	public Administrador() {
		this.sitioAcargo = null;
	}

	// Gets y sets
	public SitioWeb getSitioAcargo() {
		return sitioAcargo;
	}

	public void setSitioAcargo(SitioWeb sitioAcargo) {
		this.sitioAcargo = sitioAcargo;
	}

	// Metodos
	public void registrarse(SitioWeb sitioWeb) {
		this.setSitioAcargo(sitioWeb);
	}

	public void agregarCategoriaDePuntaje(CategoriaDePuntaje categoriaDePuntaje) {
		this.sitioAcargo.agregarCategoriaDePuntaje(categoriaDePuntaje);
	}

	public void agregarTipoDeInmmueble(TipoDeInmueble tipo) {
		this.sitioAcargo.agregarTipoDeInmueble(tipo);
	}

	public List<ServiciosEnum> getServicios() {
		return servicios;
	}

	public void setServicios(List<ServiciosEnum> servicios) {
		this.servicios = servicios;
	}

//	public void agregarTipoDeServicio(Servicio servicio) {
//		this.sitioAcargo.agregarTipoDeServicio(servicio);
//	}
}

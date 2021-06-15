package unq;

import java.util.ArrayList;
import java.util.List;

public class Administrador {
	// Atributos
	private SitioWeb sitioAcargo;
	private List<ServiciosEnum> servicios;


	// Constructor
	public Administrador() {
		this.sitioAcargo = null;
		this.setServicios( new ArrayList<ServiciosEnum>()  );
	}

	// Gets y sets
	public SitioWeb getSitioAcargo() {
		return sitioAcargo;
	}

	public void setSitioAcargo(SitioWeb sitioAcargo) {
		this.sitioAcargo = sitioAcargo;
	}
	public List<ServiciosEnum> getServicios() {
		return (this.servicios);
	}

	public void setServicios(List<ServiciosEnum> servicios) {
		this.servicios = servicios;
	}

	// test
	
	public void agregarCategoriaDePuntajeAlSitio(CategoriaDePuntaje categoriaDePuntaje) {
		this.getSitioAcargo().addCategoriaDePuntaje(categoriaDePuntaje);
	}

	public void agregarTipoDeInmmuebleAlSitio(TipoDeInmueble tipo) {
		this.getSitioAcargo().addTipoDeInmueble(tipo);
	}
	public void agregarTipoDeServicioAlSitio(ServiciosEnum servicio) {
		this.addTiposDeServicios(servicio);
		}

	
	public void addTiposDeServicios(ServiciosEnum servicio  ) {
			this.getServicios().add(servicio);
	}

	public Boolean registraElTipoDeServicio(ServiciosEnum servicio) {
		return (this.getServicios().contains(servicio));
	}

	public Boolean elSitioWebRegistraLaCategoria(CategoriaDePuntaje categoriaDePuntaje) {
		return (this.getSitioAcargo().registraCategoriaDePuntaje(categoriaDePuntaje));
	}
	
		
	
	
	
}

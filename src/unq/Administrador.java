package unq;

import java.util.ArrayList;
import java.util.List;

public class Administrador implements Registrable{
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

	public void agregarCategoriaDePuntajeAlSitio(CategoriaDePuntaje categoriaDePuntaje) {
		this.getSitioAcargo().addCategoriaDePuntaje(categoriaDePuntaje);
	}

	public void agregarTipoDeInmmuebleAlSitio(TipoDeInmueble tipo) {
		this.getSitioAcargo().addTipoDeInmueble(tipo);
	}
	public void agregarTipoDeServicioAlSitio(ServiciosEnum servicio) {
		this.addTipoDeServicios(servicio);
		//acordarse que añadir un nuevo tipo de servicio al sitio es igual que añadirse a
		//admin y que el sitio le pregunte 
	}
	
	public void addTipoDeServicios(ServiciosEnum servicio  ) {
		this.getServicios().add(servicio);
	}

	public Boolean registraElTipoDeServicio(ServiciosEnum servicio) {
		return (this.getServicios().contains(servicio));
	}
	
	public Boolean elSitioWebRegistraElServicio(ServiciosEnum servicio) {
		return (this.getSitioAcargo().registraTipoDeServicio(servicio));
	}
	
	public Boolean elSitioWebRegistraLaCategoria(CategoriaDePuntaje categoriaDePuntaje) {
		return (this.getSitioAcargo().registraCategoriaDePuntaje(categoriaDePuntaje));
	}

	@Override
	public void registrarseEn(SitioWeb sitioWeb) {
		sitioWeb.setAdministrador(this);
	}
	
}

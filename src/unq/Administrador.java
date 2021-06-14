package unq;

public class Administrador {
	//Atributos
	private SitioWeb sitioAcargo;
	//Constructor
	public Administrador() {
		this.sitioAcargo = null;
	}
	//Gets y sets
	public SitioWeb getSitioAcargo() {
		return sitioAcargo;
	}
	public void setSitioAcargo(SitioWeb sitioAcargo) {
		this.sitioAcargo = sitioAcargo;
	}
	//Metodos 
	public void registrarse(SitioWeb sitioWeb) {
		this.setSitioAcargo(sitioWeb);
	}
	public void agregarCategoriaDeRankeo(CategoriaDePuntaje categoriaDePuntaje) {
		this.sitioAcargo.agregarCategoriaDeRankeo(categoriaDePuntaje);
	}
	public void agregarTipoDeInmmueble(TipoDeInmueble tipo ) {
		this.sitioAcargo.agregarTipoDeInmueble(tipo);
	}
	public void agregarTipoDeServicio(Servicio servicio) {
		this.sitioAcargo.agregarTipoDeServicio(servicio);	
	}
}

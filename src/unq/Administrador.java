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
	public void agregarCategoriaDeRankeo(CategoriaDeRankeo rank) {
		this.sitioAcargo.agregarCategoriaDeRankeo(rank);
	}
	public void agregarTipoDeInmmueble(TipoDeInmueble tipo ) {
		this.sitioAcargo.agregarTipoDeInmueble(tipo);
	}
	public void agregarTipoDeServicio(TipoDeServicio servicio) {
		this.sitioAcargo.agregarTipoDeServicio(servicio);	
	}
}

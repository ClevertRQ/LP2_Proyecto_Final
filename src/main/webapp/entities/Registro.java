package entities;


public class Registro {
	private String nombre_Usu; 
	private String apellidos_Usu; 
	private String fecNac_Usu;
	private String correo_Usu; 
	private String contrase�a;
		
	public Registro(String nombre_Usu, String apellidos_Usu, String fecNac_Usu, String correo_Usu, String contrase�a) {
		this.nombre_Usu = nombre_Usu;
		this.apellidos_Usu = apellidos_Usu;
		this.fecNac_Usu = fecNac_Usu;
		this.correo_Usu = correo_Usu;
		this.contrase�a = contrase�a;
	}
	public Registro() {
	}
	public String getNombre_Usu() {
		return nombre_Usu;
	}
	public void setNombre_Usu(String nombre_Usu) {
		this.nombre_Usu = nombre_Usu;
	}
	public String getApellidos_Usu() {
		return apellidos_Usu;
	}
	public void setApellidos_Usu(String apellidos_Usu) {
		this.apellidos_Usu = apellidos_Usu;
	}
	public String getFecNac_Usu() {
		return fecNac_Usu;
	}
	public void setFecNac_Usu(String fecNac_Usu) {
		this.fecNac_Usu = fecNac_Usu;
	}
	public String getCorreo_Usu() {
		return correo_Usu;
	}
	public void setCorreo_Usu(String correo_Usu) {
		this.correo_Usu = correo_Usu;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	
	
}

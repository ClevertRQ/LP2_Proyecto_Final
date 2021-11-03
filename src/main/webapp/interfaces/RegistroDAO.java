package interfaces;

import java.util.List;

import entities.Registro;

public interface RegistroDAO {

	public List<Registro> getListRegistro(String correo, String contraseña);
	public int createRegistro(Registro usu);

}

package interfaces;

import java.util.List;

import entities.Registro;

public interface RegistroDAO {

	public List<Registro> getListRegistro(String correo, String contrase�a);
	public int createRegistro(Registro usu);

}

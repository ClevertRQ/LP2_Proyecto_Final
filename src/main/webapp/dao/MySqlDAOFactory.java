package dao;

import interfaces.RegistroDAO;

public class MySqlDAOFactory extends DAOFactory{

	@Override
	public RegistroDAO getRegistroDAO() {
		return new MySqlRegistroDAO();
	}

}

package dao;

import interfaces.RegistroDAO;

public abstract class DAOFactory {

	public static final int MYSQL = 1;
	public static final int SQLSERVER = 2;
	public static final int ORACLE = 3;
	public static final int AZURECOSMOS = 4;
	
	public abstract RegistroDAO getRegistroDAO();
	
	public static DAOFactory getDAOFactory(int dba) {
		switch(dba) {
			case MYSQL:
				return new MySqlDAOFactory();
			case SQLSERVER:
				return null;
			case ORACLE:
				return null;
			case AZURECOSMOS:
				return null;
		}
		return null;
	}
}

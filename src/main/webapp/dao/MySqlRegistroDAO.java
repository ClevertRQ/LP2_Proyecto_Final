package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.MysqlDBConexion;
import entities.Registro;
import interfaces.RegistroDAO;

public class MySqlRegistroDAO implements RegistroDAO{

	@Override
	public List<Registro> getListRegistro(String correo, String contraseña) {
		List<Registro> lista=new ArrayList<Registro>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
		cn=MysqlDBConexion.getConexion();
		String sql="select * from Usuarios where correo_Usu=? and contraseña=? ";
		pstm=cn.prepareStatement(sql);
		pstm.setString(1, correo);
		pstm.setString(2, contraseña);
		rs=pstm.executeQuery();
		while(rs.next()) {
			Registro usu=new Registro();			
			usu.setNombre_Usu(rs.getString(1));
			usu.setApellidos_Usu(rs.getString(2));
			usu.setFecNac_Usu(rs.getString(3));
			usu.setCorreo_Usu(rs.getString(4));
			usu.setContraseña(rs.getString(5));
			lista.add(usu);
		}
	}catch(SQLException e) {
		System.out.println("ERROR AL BUSCAR: "+e.getMessage());
	}finally {
		try {
			if(cn!=null)cn.close();
			if(pstm!=null)pstm.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		return lista;
	}

	@Override
	public int createRegistro(Registro usu) {
		int reg = 0;
		Connection cn = null;
		PreparedStatement pstm = null;
		
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "insert into Usuarios values(?,?,?,?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, usu.getNombre_Usu());
			pstm.setString(2, usu.getApellidos_Usu());
			pstm.setString(3, usu.getFecNac_Usu());
			pstm.setString(4, usu.getCorreo_Usu());
			pstm.setString(5, usu.getContraseña());

			reg = pstm.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println("ERROR AL BUSCAR: "+e.getMessage());
		}finally {
			try {
				if(cn!=null)cn.close();
				if(pstm!=null)pstm.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return reg;
	}

}

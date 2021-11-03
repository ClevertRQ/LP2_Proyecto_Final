package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import dao.MySqlRegistroDAO;
import entities.Registro;
import interfaces.RegistroDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String type = request.getParameter("type");	
    		if (type.equals("entrar")) {
    			entrar(request, response);
    		
    	}
    }
    
    protected void entrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String correo=request.getParameter("txtCorreo");
    	String contraseña=request.getParameter("txtContraseña");
    	
    	DAOFactory daoF=DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    	RegistroDAO RegD=daoF.getRegistroDAO();
   
    	MySqlRegistroDAO model=new MySqlRegistroDAO();
    	if(RegD.getListRegistro(correo, contraseña).isEmpty()==false) {
    		List<Registro> data=model.getListRegistro(correo, contraseña);
    		Registro usu=new Registro();
    		for (Registro list : data) {
				usu.setNombre_Usu(list.getNombre_Usu());
				usu.setApellidos_Usu(list.getApellidos_Usu());
				usu.setFecNac_Usu(list.getFecNac_Usu());
				usu.setCorreo_Usu(list.getCorreo_Usu());
				usu.setContraseña(list.getContraseña());
			}
    		request.setAttribute("RegistroObject", usu);
            request.getRequestDispatcher("Registro.jsp").forward(request, response);
    	}else {
    		request.setAttribute("msj", "Correo y/o Contraseña incorrectos");
    		request.getRequestDispatcher("login.jsp").forward(request, response);
    	}    	
     }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

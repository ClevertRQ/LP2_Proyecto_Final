package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import entities.Registro;
import interfaces.RegistroDAO;

/**
 * Servlet implementation class RegistroServlet
 */
@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DAOFactory daoFactory=DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	RegistroDAO regDAO=daoFactory.getRegistroDAO();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroServlet() {
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String type = request.getParameter("type");
    	
    	if (type.equals("register")) {
    		register(request, response);
    	}
    }
    
    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String name = request.getParameter("txtNombre");
    	String ape = request.getParameter("txtApellido");
    	String fec = request.getParameter("txtFecha");
    	String ema = request.getParameter("txtCorreo");
    	String pass = request.getParameter("txtContraseña");
    	
    	SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/mm/yyyy");
    	SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy/mm/dd");
    	
    	try {
			Date inputDate = inputDateFormat.parse(fec);
			fec = outputDateFormat.format(inputDate);
			
			Registro reg = new Registro();
        	reg.setNombre_Usu(name);
        	reg.setApellidos_Usu(ape);
        	reg.setFecNac_Usu(fec);
        	reg.setCorreo_Usu(ema);
        	reg.setContraseña(pass);
       	
        	DAOFactory daoFactory=DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        	RegistroDAO RegDao=daoFactory.getRegistroDAO();
        	int resultado= RegDao.createRegistro(reg);
        	if (resultado == 1) {
        		request.getRequestDispatcher("Registro.jsp").forward(request, response);
        	} else {
        		request.setAttribute("msj", "Ocurrió un problema");
        		request.getRequestDispatcher("Registro.jsp").forward(request, response);
        	}
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	
    	/** 	
    	String[] dateSplited = fec.split("/");
    	if (dateSplited.length == 3) {
    		fec = dateSplited[2] + "/" + dateSplited[1] + "/" + dateSplited[0];
    		
    		Registro reg = new Registro();
        	reg.setNombre_Usu(name);
        	reg.setApellidos_Usu(ape);
        	reg.setFecNac_Usu(fec);
        	reg.setCorreo_Usu(ema);
        	reg.setContraseña(pass);
       	
        	DAOFactory daoFactory=DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        	RegistroDAO RegDao=daoFactory.getRegistroDAO();
        	int resultado= RegDao.createRegistro(reg);
        	if (resultado == 1) {
        		request.getRequestDispatcher("Registro.jsp").forward(request, response);
        	} else {
        		request.setAttribute("msj", "Ocurrió un problema");
        		request.getRequestDispatcher("Registro.jsp").forward(request, response);
        	}
    	} 	
    	**/
    	
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

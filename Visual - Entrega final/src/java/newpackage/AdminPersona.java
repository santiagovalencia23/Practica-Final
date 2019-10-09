import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Persona;
import models.PersonaDAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mateo.llano
 */
public class AdminPersona extends HttpServlet { 
    
    PersonaDAO perDAO = new PersonaDAO();
    Persona per = new Persona();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException { 
        RequestDispatcher view = request.getRequestDispatcher("registro.jsp");
        view.forward(request, response);
    } 
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String n = request.getParameter("nombre");
        String c = request.getParameter("correo");
        String t = request.getParameter("telefono");
        String m = request.getParameter("mensaje");

        per.setNombre(n);
        per.setCorreo(c);
        per.setTelefono(t);
        per.setMensaje(m);
        perDAO.agregar(per);

        RequestDispatcher view = request.getRequestDispatcher("registro.jsp");
        request.setAttribute("mensaje", "Solicitud enviada correctamente ");
        view.forward(request, response);
    }

}

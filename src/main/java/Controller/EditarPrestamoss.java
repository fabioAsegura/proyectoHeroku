/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ActivoDAO;
import DAO.PrestamoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anfeg
 */
public class EditarPrestamoss extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            PrestamoDAO dao = new PrestamoDAO();

        
            String fecha_entrada = (String) request.getParameter("fecha_entrada");
            String fecha_salida = (String) request.getParameter("fecha_salida");
            String tipo = (String) request.getParameter("tipo");
            String activo1 = (String) request.getParameter("activo1");
            String activo2 = (String) request.getParameter("activo2");
            String activo3 = (String) request.getParameter("activo3");
            String activo4 = (String) request.getParameter("activo4");
            String activo5 = (String) request.getParameter("activo5");
            int id_solicitante = Integer.parseInt(request.getParameter("id_solicitante"));
            int id_trabajador = Integer.parseInt(request.getParameter("id_trabajador"));

          
            request.setAttribute("fecha_entrada", fecha_entrada);
            request.setAttribute("fecha_salida", fecha_salida);
            request.setAttribute("tipo", tipo);
            request.setAttribute("activo1", activo1);
            request.setAttribute("activo2", activo2);
            request.setAttribute("activo3", activo3);
            request.setAttribute("activo4", activo4);
            request.setAttribute("activo5", activo5);
            request.setAttribute("id_solicitante", id_solicitante);
            request.setAttribute("id_trabajador", id_trabajador);
            
            

            request.getRequestDispatcher("EditarPrestamo.jsp").forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(EditarActivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(EditarActivos.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
          try {
              
              
            String fecha_entrada = (String) request.getParameter("fecha_entrada");
            String fecha_salida = (String) request.getParameter("fecha_salida");
            String tipo = (String) request.getParameter("tipo");
            String activo1 = (String) request.getParameter("activo1");
            String activo2 = (String) request.getParameter("activo2");
            String activo3 = (String) request.getParameter("activo3");
            String activo4 = (String) request.getParameter("activo4");
            String activo5 = (String) request.getParameter("activo5");
            int id_solicitante = Integer.parseInt(request.getParameter("id_solicitante"));
            int id_trabajador = Integer.parseInt(request.getParameter("id_trabajador"));
              
              
           
      

            PrestamoDAO dao = new PrestamoDAO();
            dao.updateActivo(id_trabajador, fecha_entrada, fecha_salida, tipo, activo1, activo2, activo3, activo4, activo5, id_solicitante, id_trabajador);

        } catch (SQLException ex) {
            Logger.getLogger(EditarActivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(EditarActivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("Prestamoo");

     
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

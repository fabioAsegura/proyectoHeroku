 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.SupervisorDAO;
import DAO.mantenimientoCoDAO;
import Model.mantenimientos;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabio
 */

public class mantenimientosCo extends HttpServlet {

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
            mantenimientoCoDAO obj = new mantenimientoCoDAO();

            ArrayList<mantenimientos> lista = (ArrayList<mantenimientos>) obj.getAllMantenimiento();

            request.setAttribute("listaMantenimiento", lista);

            request.getRequestDispatcher("mantenimientoCorrectivo.jsp").forward(request, response);
 
        } catch (SQLException ex) {
            Logger.getLogger(mantenimientosCo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(mantenimientosCo.class.getName()).log(Level.SEVERE, null, ex);
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
            int id = Integer.parseInt(request.getParameter("id"));
            int idActivo = Integer.parseInt(request.getParameter("idActivo"));
            String descripcion = (String) request.getParameter("descripcion");
            String piezasCambiadas = (String) request.getParameter("piezasCambiadas");

            mantenimientoCoDAO dao = new mantenimientoCoDAO();
            mantenimientos tab = new mantenimientos(id, idActivo, descripcion, piezasCambiadas);

            dao.addmantenimiento(tab);

            response.sendRedirect("mantenimientosCo");

           } catch (SQLException ex) {
            Logger.getLogger(mantenimientosCo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(mantenimientosCo.class.getName()).log(Level.SEVERE, null, ex);
        }
            
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

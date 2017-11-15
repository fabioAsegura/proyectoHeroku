/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AuxiliarDAO;
import DAO.SupervisorDAO;
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
public class EditarSupervisores extends HttpServlet {

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
            SupervisorDAO dao = new SupervisorDAO();

            int id_supervisor = Integer.parseInt(request.getParameter("id_supervisor"));
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String fechaEntrada = request.getParameter("fechaEntrada");

            request.setAttribute("id_supervisor", id_supervisor);
            request.setAttribute("nombre", nombre);
            request.setAttribute("apellido", apellido);
            request.setAttribute("fechaEntrada", fechaEntrada);

            request.getRequestDispatcher("EditarSupervisor.jsp").forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(EditarSupervisores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(EditarSupervisores.class.getName()).log(Level.SEVERE, null, ex);
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

            int id_supervisor = Integer.parseInt(request.getParameter("id_supervisor"));
            String nombre = (String) request.getParameter("nombre");
            String apellido = (String) request.getParameter("apellido");
            String fechaEntrada = (String) request.getParameter("fechaEntrada");

            SupervisorDAO dao = new SupervisorDAO();
            dao.updateSupervisor(id_supervisor, nombre, apellido, fechaEntrada);

        } catch (SQLException ex) {
            Logger.getLogger(EditarSupervisores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(EditarSupervisores.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("Supervisorr");

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

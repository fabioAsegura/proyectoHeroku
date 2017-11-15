/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ActivoDAO;
import DAO.SupervisorDAO;
import Model.Supervisor;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class Supervisorr extends HttpServlet {

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
            SupervisorDAO obj = new SupervisorDAO();

            ArrayList<Supervisor> lista = (ArrayList<Supervisor>) obj.getAllSupervisor();

            request.setAttribute("listaSupervisores", lista);

            request.getRequestDispatcher("Supervisor.jsp").forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(Supervisorr.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Supervisorr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id_supervisor = Integer.parseInt(request.getParameter("idSupervisor"));
            String nombre = (String) request.getParameter("nombre");
            String apellido = (String) request.getParameter("apellido");
            String fechaEntrada = (String) request.getParameter("fechaE");

            SupervisorDAO dao = new SupervisorDAO();
            Supervisor tab = new Supervisor(id_supervisor, nombre, apellido, fechaEntrada);

            dao.addSupervisor(tab);

            response.sendRedirect("Supervisorr");

        } catch (SQLException ex) {
            Logger.getLogger(Supervisorr.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Supervisorr.class.getName()).log(Level.SEVERE, null, ex);
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

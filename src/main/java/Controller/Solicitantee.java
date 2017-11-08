/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ActivoDAO;
import DAO.SolicitanteDAO;
import Model.Activo;
import Model.Solicitante;
import java.io.IOException;
import java.io.PrintWriter;
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
public class Solicitantee extends HttpServlet {

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
            SolicitanteDAO obj = new SolicitanteDAO();

            ArrayList<Solicitante> lista = (ArrayList<Solicitante>) obj.getAllSolicitante();

            request.setAttribute("listaSolicitantess", lista);

            request.getRequestDispatcher("Solicitantes.jsp").forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(Solicitantee.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id_solicitante = Integer.parseInt(request.getParameter("id_Solicitante"));
            String nombre = (String) request.getParameter("nombre_solicitante");
            String apellido = (String) request.getParameter("apellido_solicitante");
            String escuela = (String) request.getParameter("escuela");
            String tipo = (String) request.getParameter("tipo");

            SolicitanteDAO dao = new SolicitanteDAO();
            Solicitante tab = new Solicitante(id_solicitante, nombre, apellido, escuela, tipo);
            dao.addSolicitante(tab);

            response.sendRedirect("Solicitantee");

        } catch (SQLException ex) {
            Logger.getLogger(Solicitantee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

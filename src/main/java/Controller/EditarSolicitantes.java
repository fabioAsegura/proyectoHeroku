/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.SolicitanteDAO;
import Model.Solicitante;
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
public class EditarSolicitantes extends HttpServlet {

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
            SolicitanteDAO dao = new SolicitanteDAO();

            int id_solicitante = Integer.parseInt(request.getParameter("id_solicitante"));
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String escuela = request.getParameter("escuela");
            String tipo = request.getParameter("tipo");

            request.setAttribute("id_solicitante", id_solicitante);
            request.setAttribute("nombre", nombre);
            request.setAttribute("apellido", apellido);
            request.setAttribute("escuela", escuela);
            request.setAttribute("tipo", tipo);

            request.getRequestDispatcher("EditarSolicitante.jsp").forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(EditarSolicitantes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(EditarSolicitantes.class.getName()).log(Level.SEVERE, null, ex);
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

            int id_solicitante = Integer.parseInt(request.getParameter("id_solicitante"));
            String nombre = (String) request.getParameter("nombre");
            String apellido = (String) request.getParameter("apellido");
            String escuela = (String) request.getParameter("escuela");
            String tipo = (String) request.getParameter("tipo");

            SolicitanteDAO dao = new SolicitanteDAO();
            dao.updateSolicitante(id_solicitante, nombre, apellido, escuela, tipo);

        } catch (SQLException ex) {
            Logger.getLogger(EditarSolicitantes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(EditarSolicitantes.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("Solicitantee");

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

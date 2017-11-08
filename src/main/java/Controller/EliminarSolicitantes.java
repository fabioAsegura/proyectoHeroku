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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anfeg
 */
public class EliminarSolicitantes extends HttpServlet {

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

        ArrayList solicitantes = new ArrayList();//asasdadadas
        try {
            SolicitanteDAO a = new SolicitanteDAO();
            solicitantes = a.getAllSolicitante();
            request.setAttribute("solicitantes", solicitantes);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/EliminarSolicitante.jsp");
            rd.forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(EliminarSolicitantes.class.getName()).log(Level.SEVERE, null, ex);
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

        int idS = Integer.parseInt(request.getParameter("idSolicitante"));
        System.out.println("sadsad" + idS);
        try {
            SolicitanteDAO a = new SolicitanteDAO();
            a.deleteSolicitante(idS);
        } catch (SQLException ex) {
            Logger.getLogger(EliminarSolicitantes.class.getName()).log(Level.SEVERE, null, ex);
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

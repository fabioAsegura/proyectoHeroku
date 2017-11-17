/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import DAO.PrestamoDAO;

import Model.Prestamo;
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
public class Prestamoo extends HttpServlet {

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
            PrestamoDAO obj = new PrestamoDAO();

            ArrayList<Prestamo> lista = (ArrayList<Prestamo>) obj.getAllPrestamo();

            request.setAttribute("listaPrestamos", lista);

            request.getRequestDispatcher("Prestamos.jsp").forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(Prestamoo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Prestamoo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id_prestamo = Integer.parseInt(request.getParameter("id_solicitante"));
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
            Prestamo tab = new Prestamo(id_prestamo, fecha_entrada, fecha_salida, tipo, activo1, activo2, activo3, activo4, activo5, id_solicitante, id_trabajador);

            dao.addPrestamo(tab);

            response.sendRedirect("Prestamoo");

        } catch (SQLException ex) {
            Logger.getLogger(Prestamoo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Prestamoo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ActivoDAO;
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
public class EditarActivos extends HttpServlet {

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
            ActivoDAO dao = new ActivoDAO();

            int id_activo = Integer.parseInt(request.getParameter("id_activo"));
            String tipo = request.getParameter("tipo");
            String fabricante = request.getParameter("fabricante");
            String fecha_compra = request.getParameter("fecha_compra");
            String ultimo_mantenimiento = request.getParameter("ultimo_mantenimiento");
            String estado = request.getParameter("estado");
            String prestado = request.getParameter("prestado");
          
            //String calificacion = request.getParameter("calificacion");
            int calificacion = Integer.parseInt(request.getParameter("calificacion"));
            String categoria =  request.getParameter("categoria");

            request.setAttribute("id_activo", id_activo);
            request.setAttribute("tipo", tipo);
            request.setAttribute("fabricante", fabricante);
            request.setAttribute("fecha_compra", fecha_compra);
            request.setAttribute("ultimo_mantenimiento", ultimo_mantenimiento);
            request.setAttribute("estado", estado);
            request.setAttribute("prestado", prestado);
            request.setAttribute("categoria", categoria);
            request.setAttribute("calificacion", calificacion);
            

            request.getRequestDispatcher("EditarActivo.jsp").forward(request, response);

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
            int idActivo = Integer.parseInt(request.getParameter("idActivo"));
            String tipo = (String) request.getParameter("tipo");
            String fabricante = (String) request.getParameter("fabricante");
            String fechaC = (String) request.getParameter("fechaC");
            String mantenimiento = (String) request.getParameter("mantenimiento");
            String estado = (String) request.getParameter("estado");
            String prestado = (String) request.getParameter("prestado");
            int calificacion = Integer.parseInt(request.getParameter("calificacion"));
            String categoria = (String) request.getParameter("categoria");

            ActivoDAO dao = new ActivoDAO();
            dao.updateActivo(idActivo, tipo, fabricante, fechaC, mantenimiento, estado, prestado, calificacion, categoria);

        } catch (SQLException ex) {
            Logger.getLogger(EditarActivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(EditarActivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("Activoo");

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

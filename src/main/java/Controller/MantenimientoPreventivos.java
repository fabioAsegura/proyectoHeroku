/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.MantenimientoDAO;
import Model.Activo;
import Model.Mantenimiento;
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
public class MantenimientoPreventivos extends HttpServlet {

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
            MantenimientoDAO obj = new MantenimientoDAO();

            ArrayList<Mantenimiento> lista = (ArrayList<Mantenimiento>) obj.getAllMantenimiento();

            request.setAttribute("listaMantenimientos", lista);

            request.getRequestDispatcher("MantenimientoPreventivo.jsp").forward(request, response);
           

        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoPreventivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(MantenimientoPreventivos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id_activo = Integer.parseInt(request.getParameter("idActivo"));
            String tipo = (String) request.getParameter("tipo");
            String descripcion = (String) request.getParameter("descripcion");
            String materiales = (String) request.getParameter("materiales");
           
            MantenimientoDAO dao = new MantenimientoDAO();
            Mantenimiento tab = new Mantenimiento(id_activo, tipo, descripcion, materiales);

            dao.addMantenimiento(tab);

            response.sendRedirect("MantenimientoPreventivos");

        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoPreventivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(MantenimientoPreventivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

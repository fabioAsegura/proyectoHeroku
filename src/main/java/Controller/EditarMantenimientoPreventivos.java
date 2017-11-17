/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.MantenimientoDAO;
import java.io.IOException;
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
public class EditarMantenimientoPreventivos extends HttpServlet {

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
            MantenimientoDAO dao = new MantenimientoDAO();

            int id_activo = Integer.parseInt(request.getParameter("id_activo"));
            String tipo = request.getParameter("tipo");
            String descripcion = request.getParameter("descripcion");
            String materiales = request.getParameter("materiales");
            

            request.setAttribute("id_activo", id_activo);
            request.setAttribute("tipo", tipo);
            request.setAttribute("descripcion", descripcion);
            request.setAttribute("materiales", materiales);
          

            request.getRequestDispatcher("EditarMantenimientoPreventivo.jsp").forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(EditarMantenimientoPreventivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(EditarMantenimientoPreventivos.class.getName()).log(Level.SEVERE, null, ex);
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
            String descripcion = (String) request.getParameter("descripcion");
            String materiales = (String) request.getParameter("materiales");
           

            MantenimientoDAO dao = new MantenimientoDAO();
            dao.updateMantenimiento(idActivo, tipo, descripcion, materiales);

        } catch (SQLException ex) {
            Logger.getLogger(EditarMantenimientoPreventivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(EditarMantenimientoPreventivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("MantenimientoPreventivos");

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

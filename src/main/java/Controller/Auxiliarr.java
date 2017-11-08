/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AuxiliarDAO;
import Model.Auxiliar;
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
public class Auxiliarr extends HttpServlet {

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
            AuxiliarDAO obj = new AuxiliarDAO();

            ArrayList<Auxiliar> lista = (ArrayList<Auxiliar>) obj.getAllAuxiliar();

            request.setAttribute("listaAuxiliares", lista);

            request.getRequestDispatcher("Auxiliar.jsp").forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(Auxiliarr.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id_auxiliar = Integer.parseInt(request.getParameter("idAuxiliar"));
            String nombre = (String) request.getParameter("nombre");
            String apellido = (String) request.getParameter("apellido");
            String fecha_entrada = (String) request.getParameter("fechaE");
            String turno = (String) request.getParameter("turno");
            int id_supervisor = Integer.parseInt(request.getParameter("idSupervisor"));

            AuxiliarDAO dao = new AuxiliarDAO();
            Auxiliar tab = new Auxiliar(id_auxiliar, nombre, apellido, fecha_entrada, turno, id_supervisor);
            dao.addAuxiliar(tab);

            response.sendRedirect("Auxiliarr");

        } catch (SQLException ex) {
            Logger.getLogger(Auxiliarr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

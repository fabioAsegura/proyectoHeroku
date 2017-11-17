/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CategoriaDAO;
import Model.Categoria;
import java.io.IOException;
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
 * @author LabingXEON
 */
public class Categoriaa extends HttpServlet{
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            CategoriaDAO obj = new CategoriaDAO();

            ArrayList<Categoria> lista = (ArrayList<Categoria>) obj.getAllCategoria();

            request.setAttribute("listaCategorias", lista);

            request.getRequestDispatcher("Categorias.jsp").forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(Activoo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Activoo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id_categoria = Integer.parseInt(request.getParameter("idCategoria"));
            String nombre = (String) request.getParameter("nombre");
            String ubicacion = (String) request.getParameter("ubicacion");
          

            CategoriaDAO dao = new CategoriaDAO();
            Categoria tab = new Categoria(id_categoria, nombre, ubicacion);

            dao.addCategoria(tab);

            response.sendRedirect("Categoriaa");

        } catch (SQLException ex) {
            Logger.getLogger(Activoo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Activoo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    
}

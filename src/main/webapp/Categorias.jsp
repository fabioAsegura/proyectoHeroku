<%@page import="Model.Categoria"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Categorias</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            /* Remove the navbar's default margin-bottom and rounded borders */ 
            .navbar {
                margin-bottom: 0;
                border-radius: 0;
            }

            /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
            .row.content {height: 450px}

            /* Set gray background color and 100% height */
            .sidenav {
                padding-top: 20px;
                background-color: #f1f1f1;
                height: 100%;
            }

            /* Set black background color, white text and some padding */
            footer {
            
                background-color: #555;
                color: white;
                padding: 15px;
            }

            /* On small screens, set height to 'auto' for sidenav and grid */
            @media screen and (max-width: 767px) {
                .sidenav {
                    height: auto;
                    padding: 15px;
                }
                .row.content {height:auto;} 
            }
        </style>
    </head>
    <body>

         <%@include file="Header.jsp" %>

        <div class="container-fluid text-center">    
            <div class="row content">
                <div class="col-sm-2 sidenav">
                </div>
                <div class="col-sm-8 text-left"> 
                    <h1>Categorias</h1>
                    <div class="span12">&nbsp;</div>
                    <button onclick="window.location.href = 'AnadirCategoria.jsp'" type="button" type="button" class="btn-sm btn-success">Añadir Categoria</button>
                   
                    <div class="span12">&nbsp;</div>



                    <div class="container">           
                        <table class="table table-striped">
                            <tr>
                                <th>ID Categoria</th>
                                <th>Nombre</th>
                                <th>Ubicacion</th>
                              
                            </tr>
                            <% if (request.getAttribute("listaCategorias") != null) {
                                    ArrayList<Categoria> list = (ArrayList<Categoria>) request.getAttribute("listaCategorias");
                                    if (list != null)
                                        for (Categoria categoria : list) {


                            %>
                            <tr>
                                <td><%=categoria.getId()%></td>
                                <td><%=categoria.getNombre()%></td>
                                <td><%=categoria.getUbicacion()%></td>
                               
                                <td>
                                    <button onclick="window.location.href = 'EliminarCategoriaa?id_categoria=<%=categoria.getId()%>'" class="btn btn-info">Eliminar</button>
                                </td>
                            </tr>
                            <% }
                                }
                            %>
                        </table>
                    </div>
                    <hr>

                </div>

            </div>
        </div>

        <footer class="container-fluid text-center">
            <p>Universidad Sergio Arboleda</p>
        </footer>

    </body>
</html>
<%@page import="Model.Prestamo"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Buscar Prestamo</title>
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

       <%@include file="Header.jsp"%>
       
        <div class="container-fluid text-center">    
            <div class="row content">
                <div class="col-sm-2 sidenav">

                </div>
                <div class="col-sm-8 text-left"> 
                    <h1>Buscar Prestamo</h1>
                    <p></p>
                    <hr>
                    <div class="container">   
                        <form class="form-inline" action="BuscarPrestamo" method="GET">

                            <div class="form-group">
                                <label for="idPrestamo">ID Prestamo:</label>
                                <input  class="form-control" name="idPrestamo">
                            </div>

                            <br>
                            <div class="span12">&nbsp;</div>
                            <button type="submit" class="btn btn-default">Enviar</button>
                            <button onclick="window.location.href = 'Prestamoo'" type="button" type="button" class="btn-sm btn-warning">Volver</button>

                        </form>
                    </div>
                    <div class="span12">&nbsp;</div>
                    <div class="container">           
                        <table class="table table-striped">
                            <tr>
                             
                                <th>ID Prestamo</th>
                                <th>Fecha Entrada</th>
                                <th>Fecha salida</th>
                                <th>Tipo</th>
                                <th>Activo 1</th>
                                <th>Activo 2</th>
                                <th>Activo 3</th>
                                <th>Activo 4</th>
                                <th>Activo 5</th>
                               <th>ID Solicitante</th>
                               <th>ID Trabajador</th>
                                
                            
                            </tr>
                              <% if (request.getAttribute("listaPrestamosBusqueda") != null) {
                                ArrayList<Prestamo> list = (ArrayList<Prestamo>) request.getAttribute("listaPrestamosBusqueda");
                                if (list != null)
                                    for (Prestamo prestamo : list) {


                            %>
                            <tr>
                                <td><%=prestamo.getId_prestamo()%></td>
                                <td><%=prestamo.getFecha_entrada()%></td>
                                <td><%=prestamo.getFecha_salida()%></td>
                                <td><%=prestamo.getTipo()%></td>
                                <td><%=prestamo.getActivo1()%></td>
                                <td><%=prestamo.getActivo2()%></td>
                                <td><%=prestamo.getActivo3()%></td>
                                <td><%=prestamo.getActivo4()%></td>
                                <td><%=prestamo.getActivo5()%></td>
                                <td><%=prestamo.getId_solicitante()%></td>
                                <td><%=prestamo.getId_trabajador()%></td>

                                <td>
                                </td>
                            </tr>
                            <% }
                                }
                            %>
                        </table>
                    </div>
                </div>

            </div>
        </div>

        <footer class="container-fluid text-center">
            <p>Universidad Sergio Arboleda</p>
        </footer>

    </body>
</html>
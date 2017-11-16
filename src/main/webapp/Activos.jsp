<%@page import="Model.Activo"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Activos</title>
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
    <%@include file="includes/Header.jsp" %>
        

        <div class="container-fluid text-center">    
            <div class="row content">
                <div class="col-sm-2 sidenav">
                </div>
                <div class="col-sm-8 text-left"> 
                    <h1>Activos</h1>
                    <div class="span12">&nbsp;</div>
                    <button onclick="window.location.href = 'AnadirActivo.jsp'" type="button" type="button" class="btn-sm btn-success">Añadir Activo</button>
                    <button onclick="window.location.href = 'EliminarActivo?action=delete'" type="button" type="button" class="btn-sm btn-danger">Eliminar Activo</button>
                    <button onclick="window.location.href = 'BuscarActivo.jsp'" type="button" type="button" class="btn-sm btn-warning">Buscar Activo</button>
                    <div class="span12">&nbsp;</div>



                    <div class="container">           
                        <table class="table table-striped">
                            <tr>
                                <th>ID Activo</th>
                                <th>Tipo</th>
                                <th>Fabricante</th>
                                <th>Fecha compra</th>
                                <th>Ultimo Mant.</th>
                                <th>Estado</th>
                                <th>Prestado</th>
                                <th>Calificacion</th>
                            </tr>
                            <% if (request.getAttribute("listaActivos") != null) {
                                    ArrayList<Activo> list = (ArrayList<Activo>) request.getAttribute("listaActivos");
                                    if (list != null)
                                        for (Activo activo : list) {


                            %>
                            <tr>
                                <td><%=activo.getId_activo()%></td>
                                <td><%=activo.getTipo()%></td>
                                <td><%=activo.getFabricante()%></td>
                                <td><%=activo.getFecha_compra()%></td>
                                <td><%=activo.getUltimo_mantenimiento()%></td>
                                <td><%=activo.getEstado()%></td>
                                <td><%=activo.getPrestado()%></td>
                                <td><%=activo.getCalificacion()%></td>

                                <td>
                                    <button onclick="window.location.href = 'EditarActivos?id_activo=<%=activo.getId_activo()%>&tipo=<%=activo.getTipo()%>&fabricante=<%=activo.getFabricante()%>&fecha_compra=<%=activo.getFecha_compra()%>&ultimo_mantenimiento=<%=activo.getUltimo_mantenimiento()%>&estado=<%=activo.getEstado()%>&prestado=<%=activo.getPrestado()%>&calificacion=<%=activo.getCalificacion()%>'" class="btn btn-info">Editar</button>
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
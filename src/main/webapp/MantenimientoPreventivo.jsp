<%@page import="Model.Activo"%>
<%@page import="Model.Trabajador"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Mantenimiento Preventivo</title>
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
                    <h1>Mantenimiento Preventivo</h1>
                   
                    
                    <div class="container">   
                        <form class="form-inline" action="MantenimientoPreventivos" method="POST">
                            <div class="form-group">
                                <label for="tipo">Id Activo:</label>
                                <select class="form-control" name="mantenimientoP">
                                    <%
                                        if (request.getAttribute("activos") != null) {
                                            ArrayList<Activo> array = (ArrayList<Activo>) request.getAttribute("activos");
                                            for (Activo a : array) {
                                    %> 
                                    <option value="<%=a.getId_activo()%>"><%=a.getId_activo()%></option> 
                                    <%      }
                                        }
                                    %> 
                                </select>   
                                <br> 

                            </div>
        
                            <button type="submit" class="btn btn-default" name="Enviar">Enviar</button>
                        </form>
                                <br>
                                <br>
                                <form class="form-inline" action="" method="POST">
                            <div class="form-group">
                                <label for="idequipo">ID Activo:</label>
                                <input  class="form-control" name="idActivo">
                            </div>
                            <div class="form-group">
                                <label for="nombre">Nombre:</label>
                                <input  class="form-control" name="nombre">
                            </div>
                            <div class="form-group">
                                <label for="calificacion">Descripcion:</label>
                                <input  class="form-control" name="descripcion">
                            </div>
                            <div class="span12">&nbsp;</div>
                            <div class="form-group">
                                <label for="fechaC">Materiales:</label>
                                <input  class="form-control" name="materiales">
                            </div>
                        
        
                            <button type="submit" class="btn btn-default" name="Enviar">Enviar</button>
                        </form>
                    </div>
                </div>

            </div>
        </div>

        <footer class="container-fluid text-center">
            <p>Universidad Sergio Arboleda</p>
        </footer>

    </body>
</html>
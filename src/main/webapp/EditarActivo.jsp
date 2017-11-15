<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Editar Activo</title>
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

        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>                        
                    </button>
                    <a class="navbar-brand" href="index.jsp">Laboratorio</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li><a href="index.jsp">Inicio</a></li>
                        <li><a href="Prestamos.jsp">Prestamos</a></li>
                        <li><a href="Activoo">Activos</a></li>
                        <li><a href="Solicitantee">Solicitante</a></li>
                        <li><a href="Auxiliarr">Auxiliar</a></li>
                        <li><a href="Supervisorr">Supervisor</a></li>
                    </ul>

                </div>
            </div>
        </nav>

        <div class="container-fluid text-center">    
            <div class="row content">
                <div class="col-sm-2 sidenav">

                </div>
                <div class="col-sm-8 text-left"> 
                    <h1>Editar Activo</h1>
                    <p></p>
                    <hr>
                    <div class="container">   
                        <%
                            int id_activo = (Integer) request.getAttribute("id_activo");
                            String tipo = (String) request.getAttribute("tipo");
                            String fabricante = (String) request.getAttribute("fabricante");
                            String fecha_compra = (String) request.getAttribute("fecha_compra");
                            String ultimo_mantenimiento = (String) request.getAttribute("ultimo_mantenimiento");
                            String estado = (String) request.getAttribute("estado");
                            String prestado = (String) request.getAttribute("prestado");
                            int calificacion = (Integer) request.getAttribute("calificacion");

                        %>
                        <form class="form-inline" action="EditarActivos" method="POST">
                            <div class="form-group">
                                <label for="idequipo">ID Activo:</label>
                                <input  class="form-control" name="idActivo" value="<%=id_activo%>" readonly="readonly">
                            </div>
                            <div class="form-group">
                                <label for="nombre">Tipo:</label>
                                <input  class="form-control" name="tipo" value="<%=tipo%>">
                            </div>
                            <div class="form-group">
                                <label for="calificacion">Fabricante:</label>
                                <input  class="form-control" name="fabricante" value="<%=fabricante%>">
                            </div>
                            <div class="span12">&nbsp;</div>
                            <div class="form-group">
                                <label for="fechaC">Fecha Compra:</label>
                                <input  class="form-control" name="fechaC" value="<%=fecha_compra%>">
                            </div>
                            <div class="form-group">
                                <label for="prestaso">Ultimo Mant.:</label>
                                <input  class="form-control" name="mantenimiento"value="<%=ultimo_mantenimiento%>">
                            </div>
                            <div class="form-group">
                                <label for="tipo">Estado</label>
                                <select class="form-control" name="estado" value="<%=estado%>">
                                    <option>Excelente</option>
                                    <option>Bueno</option>
                                    <option>Regula</option>
                                    <option>Malo</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="tipo">Prestado</label>
                                <select class="form-control" name="prestado" value="<%=prestado%>">
                                    <option>True</option>
                                    <option>False</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="tipo">Calificación</label>
                                <select class="form-control" name="calificacion" value="<%=calificacion%>">
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                </select>
                            </div>


                            <br>
                            <div class="span12">&nbsp;</div>
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
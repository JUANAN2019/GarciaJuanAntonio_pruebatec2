<%@page import="java.util.List" %>
    <%@page import="java.util.ArrayList" %>
        <%@page import="jagg.turnero.logica.Ciudadano" %>
            <%@page import="jagg.turnero.logica.Turno" %>
                <%@page contentType="text/html" pageEncoding="UTF-8" %>
                    <!DOCTYPE html>
                    <html lang="en">

                    <head>
                        <meta charset="UTF-8">
                        <title>Formulario Persona</title>
                        <!-- Agregar estilos de Bootstrap -->
                        <link rel="stylesheet"
                            href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
                    </head>

                    <body>
                        <div class="container mt-4">
                            <h2>Introduzca sus datos </h2>
                            <form action="CiudadanoSv" method="POST">

                                <div class="form-group">
                                    <label for="nombre">Nombre:</label>
                                    <input type="text" class="form-control" id="nombre" name="nombre">
                                </div>
                                <div class="form-group">
                                    <label for="apellidos">apellidos:</label>
                                    <input type="text" class="form-control" id="apellidos" name="apellidos">
                                </div>
                                <div class="form-group">
                                    <label for="dni">DNI:</label>
                                    <input type="text" class="form-control" id="dni" name="dni">
                                </div>
                                <div class="form-group">
                                    <label for="telefono">Telefono:</label>
                                    <input type="text" class="form-control" id="telefono" name="telefono">
                                </div>
                                <div class="form-group">
                                    <label for="email">Email:</label>
                                    <input type="text" class="form-control" id="email" name="email">
                                </div>


                                <button type="submit" class="btn btn-primary">Guardar</button>
                            </form>

                            <br>
                            <h2>Sacar turno</h2>
                            <form action="TurnoSv" method="POST">
                                <div class="form-group">
                                    <label for="tramite">Trámite:</label>
                                    <select class="form-control" id="tramite" name="tramite">
                                        <option value="">Seleccione un trámite...</option>
                                        <option value="alta_sepe">Darse de alta en el SEPE</option>
                                        <option value="sellar_paro">Sellar paro</option>
                                        <option value="inscripcion_cursos">Inscribirse a cursos</option>
                                        <option value="ayuda_familia">Solicitar ayuda familia numerosa</option>
                                        <option value="otros">Otros tramites</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="date">Fecha:</label>
                                    <input type="date" class="form-control" id="fecha" name="fecha">
                                </div>
                                <div class="form-group">
                                    <label for="id">Ciudadano ID:</label>
                                    <input type="text" class="form-control" id="fecha" name="id">
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary">Guardar</button>
                                </div>

                            </form>

                            <br>

                            <h2>Visualizar turnos</h2>
                            <form action="TurnoSv" method="GET">
                                <div class="form-group">
                                    <label for="date">Fecha:</label>
                                    <input type="date" class="form-control" id="fecha" name="fecha">
                                </div>
                                <div class="form-group">
                                    <label for="estado">Estado:</label>
                                    <select class="form-control" id="estado" name="estado">
                                        <option value="">Seleccione estado turno</option>
                                        <option value="false">En espera</option>
                                        <option value="true">Atendido</option>
                                        <option value="">Todos</option>
                                        
                                    </select>
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary">Mostrar</button>
                                </div>

                            </form>

                            <br>
                            <br>
                            <!-- Resultados en tabla -->
                            <div class="results-table">
                                <% if (request.getAttribute("turnos") !=null) { %>
                                    <h3>Turnos</h3>
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th>Turno ID:</th>
                                                <th>Fecha:</th>
                                                <th>Ciudadano Nombre</th>
                                                <th>Ciudadano Id</th>
                                                <th>Tramite</th>
                                                <th>Estado tramite</th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                            <% for (Turno turno : (List<Turno>) request.getAttribute("turnos")) {%>
                                                <tr>
                                                    <td>
                                                        <%= turno.getId()%>
                                                    </td>
                                                    <td>
                                                        <%= turno.getFecha()%>
                                                    </td>
                                                    <td>
                                                        <%= turno.getCiudadano().getNombre()%>
                                                    </td>
                                                    <td>
                                                        <%= turno.getCiudadano().getId()%>
                                                    </td>
                                                    <td>
                                                        <%= turno.getTramite()%>
                                                    </td>
                                                    <td>
                                                        <%= turno.isEstadoTramite() ? "Atendido" : "En espera" %>
                                                    </td>
                                                    

                                                </tr>
                                                <% } %>
                                        </tbody>
                                    </table>
                                    <% }%>
                            </div>

                            <br><br>
                            <h2>Atender Turno</h2>
                            <form action="AtenderTurnoSv" method="POST">
                                <div class="form-group">
                                    <label for="idAtender">ID turno:</label>
                                    <input type="text" class="form-control" id="idAtender" name="idAtender">
                                </div>

                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary">Atender</button>
                                </div>

                            </form>

                            <br>
                            <br>
                            <!-- Resultados en tabla -->
                        </div>


                        <!-- Scripts de Bootstrap -->
                        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
                        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
                    </body>

                    </html>
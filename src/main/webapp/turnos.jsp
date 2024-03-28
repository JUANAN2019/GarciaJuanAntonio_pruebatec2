    <%@page import="java.util.List" %>
        <%@page import="jagg.turnero.logica.Turno" %>
            <%@page contentType="text/html" pageEncoding="UTF-8" %>
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                    <title>JSP Page</title>
                    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
                </head>
                <body>
                    <jsp:include page="menu.jsp" />

                    <form action="TurnoSv" method="GET">
                        <h2>Visualizar turnos</h2>
                        <div class="form-group">
                            <label for="date">Fecha:</label>
                            <input type="date" class="form-control" id="fecha" name="fecha">
                        </div>
                        <div class="form-group">
                            <label for="estado">Estado:</label>
                            <select class="form-control" id="estado" name="estado" required>
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
                    <!-- Resultados en tabla -->
                    <div class="results-table col-md-10 offset-md-1">
                        <% if (request.getAttribute("turnos") !=null) { %>
                            <h2>Turnos</h2>
                            <table class="table table-striped ">
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
                    <form action="AtenderTurnoSv" method="POST">
                        <h2>Atender Turno</h2>
                        <div class="form-group">
                            <label for="idAtender">ID turno:</label>
                            <input type="text" class="form-control" id="idAtender" name="idAtender" required>
                            <% String mensaje = (String) request.getAttribute("mensaje"); %>
                                <% if (mensaje !=null) { %>
                                    <h3><%= mensaje %> </h3>
                                    <% } %>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary">Atender</button>
                        </div>
                    </form>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
                    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
                </body>

                </html>
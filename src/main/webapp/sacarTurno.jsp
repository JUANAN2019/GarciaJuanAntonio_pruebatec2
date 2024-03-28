<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <jsp:include page="menu.jsp" />

        <form action="TurnoSv" method="POST">
            <h2>Sacar turno</h2>
            <div class="form-group">
                <label for="tramite">Trámite:</label>
                <select class="form-control" id="tramite" name="tramite" required>
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
                <input type="date" class="form-control" id="fecha" name="fecha" required>
            </div>
            <div class="form-group">
                <label for="id">Ciudadano ID:</label>
                <input type="text" class="form-control" id="fecha" name="id" required>
                <% if (request.getAttribute("error") == "error") { %>
                <h3>No existe ciudadano con ese ID introduzca otro</h3>
                <% }%>
            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-primary">Guardar</button>
            </div>
        </form>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </body>
</html>

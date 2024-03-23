<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jagg.turnero.logica.Ciudadano"%>
<%@page import="jagg.turnero.logica.Turno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Formulario Persona</title>
        <!-- Agregar estilos de Bootstrap -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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
                    <label for="nombre">Nombre:</label>
                    <input type="text" class="form-control" id="nombre" name="nombre">
                </div>
                <div class="form-group">
                    <label for="ciudad">Ciudad:</label>
                    <input type="text" class="form-control" id="ciudad" name="ciudad">
                </div>

                <button type="submit" class="btn btn-primary">Guardar</button>
            </form>

            <br>

            <h2>Mostrar equipos</h2>
            <form action="EquipoSv" method="GET">

                <button type="submit" class="btn btn-primary">Mostrar</button>
            </form>

            <br>
            <br>
            <!-- Resultados en tabla -->
          

            <!-- Scripts de Bootstrap -->
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </body>
</html>
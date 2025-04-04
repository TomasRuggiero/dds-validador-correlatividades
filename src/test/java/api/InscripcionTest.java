package api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class InscripcionTest {
    Materia Algoritmos = new MateriaSimple();
    Materia AnalisisDeSistemas = new MateriaConCorrelativas(List.of(Algoritmos));
    Materia PdeP = new MateriaConCorrelativas(List.of(Algoritmos));
    Materia DisenioDeSistemas = new MateriaConCorrelativas(List.of(PdeP, AnalisisDeSistemas));

    @Test
    @DisplayName("Alumno puede inscribirse")
    void aprobada() {
        // Arrange
        Inscripcion inscripcion = new Inscripcion();

        Alumno alumno = new Alumno();
        alumno.setMateriasAprobadas(List.of(Algoritmos, PdeP, AnalisisDeSistemas));
        inscripcion.setAlumno(alumno);

        inscripcion.setMaterias(List.of(DisenioDeSistemas));

        // Act & Assert
        Assertions.assertTrue(inscripcion.aprobada());
    }

    @Test
    @DisplayName("Alumno no puede inscribirse por falta de correlativas")
    void noAprobadaPorFaltaDeCorrelativas() {
        // Arrange
        Inscripcion inscripcion = new Inscripcion();

        Alumno alumno = new Alumno();
        alumno.setMateriasAprobadas(List.of(Algoritmos, AnalisisDeSistemas));
        inscripcion.setAlumno(alumno);

        inscripcion.setMaterias(List.of(DisenioDeSistemas));

        // Act && Assert
        Assertions.assertFalse(inscripcion.aprobada());
    }

    @Test
    @DisplayName("Alumno no puede inscribirse por falta de correlativas de correlativas")
    void noAprobadaPorFaltaDeCorrelativasDeCorrelativas() {
        // Arrange
        Inscripcion inscripcion = new Inscripcion();

        Alumno alumno = new Alumno();
        alumno.setMateriasAprobadas(List.of(PdeP, AnalisisDeSistemas));
        inscripcion.setAlumno(alumno);

        inscripcion.setMaterias(List.of(DisenioDeSistemas));

        // Act && Assert
        Assertions.assertFalse(inscripcion.aprobada());
    }
}
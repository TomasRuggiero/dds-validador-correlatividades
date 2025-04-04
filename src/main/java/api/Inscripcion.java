package api;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Inscripcion {
    private Alumno alumno;
    private List<Materia> materias;

    public Boolean aprobada() {
        return materias.stream().allMatch(materia -> materia.puedeAnotarse(alumno));
    }
}

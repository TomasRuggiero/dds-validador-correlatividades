package api;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Alumno {
    private List<Materia> materiasAprobadas;
}

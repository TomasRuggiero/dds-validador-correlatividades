package api;

import lombok.Setter;

import java.util.List;

@Setter
public class MateriaConCorrelativas implements Materia {
    private List<Materia> materiasCorrelativas;

    public MateriaConCorrelativas(List<Materia> correlativas) {
        this.materiasCorrelativas = correlativas;
    }

    @Override
    public Boolean puedeAnotarse(Alumno alumno) {
        return (alumno.getMateriasAprobadas().containsAll(materiasCorrelativas) &&
                materiasCorrelativas.stream().allMatch(materia -> materia.puedeAnotarse(alumno)));
    }
}

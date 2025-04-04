package api;

public class MateriaSimple implements Materia {
    @Override
    public Boolean puedeAnotarse(Alumno alumno) {
        return true;
    }
}

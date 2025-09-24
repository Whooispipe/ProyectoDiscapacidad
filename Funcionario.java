import exceptions.PersonaNoEncontradaException;
import exceptions.RutInvalidoException;

public class Funcionario extends Persona {
    private String areaTrabajo;

    public Funcionario(String rut, String nombre, String fechaNacimiento, String areaTrabajo) {
        super(rut, nombre, fechaNacimiento);
        this.areaTrabajo = areaTrabajo;
    }

    public String getAreaTrabajo() {
        return areaTrabajo;
    }
    public void setAreaTrabajo(String areaTrabajo) {
        this.areaTrabajo = areaTrabajo;
    }

    @Override
    public String buscarPorRut(String rut) throws PersonaNoEncontradaException{
        if (this.getRut().equalsIgnoreCase(rut)) {
            return "Funcionario encontrado: " + this.getNombre() + " | Área de Trabajo: " + areaTrabajo;
        }
        throw new PersonaNoEncontradaException("No se encontró al funcionario con RUT: " + rut);
    }
}

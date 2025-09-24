import exceptions.PersonaNoEncontradaException;
import exceptions.RutInvalidoException;

public abstract class Persona {
    private String rut;
    private String nombre;
    private String fechaNacimiento;

    public Persona(String rut, String nombre, String fechaNacimiento) throws RutInvalidoException {
        if (!ValidadorRut.validarRut(rut)) {
            throw new RutInvalidoException("RUT inválido: " + rut);
        }
        
        this.rut = rut;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getters y Setters
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    //Método a sobrescribir
    public String buscarPorRut(String rut) {
        if (this.rut.equalsIgnoreCase(rut)) {
            return "Persona encontrada: " + this.rut + ", RUT: " + this.rut;
        }
        return "No coincide.";
    }

    //Método abstracto
    public abstract String buscarPorRut(String rut) throws PersonaNoEncontradaException;

}
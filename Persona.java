public abstract class Persona {
    private String rut;
    private String nombre;
    private String fechaNacimiento;

    public Persona(String rut, String nombre, String fechaNacimiento) {
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
    public String buscarPorNombre(String nombre) {
        if (this.nombre.equalsIgnoreCase(nombre)) {
            return "Persona encontrada: " + this.nombre + ", RUT: " + this.rut;
        }
        return "No coincide.";
    }
}
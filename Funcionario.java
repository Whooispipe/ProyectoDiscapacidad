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
    public String buscarPorNombre(String nombre) {
        if (this.getNombre().equalsIgnoreCase(nombre)) {
            return "Funcionario encontrado: " + this.getNombre() + " | Área de Trabajo: " + areaTrabajo;
        }
        return "No coincide.";
    }
}

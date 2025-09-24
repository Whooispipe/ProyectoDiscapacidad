import java.util.ArrayList;
import java.util.List;

public class Beneficiario extends Persona {
    private String rut;
    private String nombre;
    private String fechaNacimiento;
    private String discapacidad;
    private List<ServiciodeApoyo> serviciosDeApoyo;
    private List<SeguimientoImpacto> seguimientoImpacto;

    public Beneficiario(String rut, String nombre, String fechaNacimiento, String discapacidad) {
        super(rut, nombre, fechaNacimiento);
        this.discapacidad = discapacidad;
        this.serviciosDeApoyo = new ArrayList<>();
        this.seguimientoImpacto = new ArrayList<>();
    }


    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

    public List<ServiciodeApoyo> getServiciosDeApoyo() {
        return serviciosDeApoyo;
    }

    public void setServiciosDeApoyo(List<ServiciodeApoyo> serviciosDeApoyo) {
        if (serviciosDeApoyo != null) {
            this.serviciosDeApoyo = serviciosDeApoyo;
        }
    }

    public List<SeguimientoImpacto> getSeguimientoImpacto() {
        return seguimientoImpacto;
    }

    public void setSeguimientoImpacto(List<SeguimientoImpacto> seguimientoImpacto) {
        if (seguimientoImpacto != null) {
            this.seguimientoImpacto = seguimientoImpacto;
        }
    }
    
    public void agregarServicioDeApoyo(ServiciodeApoyo servicio) {
        if (servicio != null) {
            this.serviciosDeApoyo.add(servicio);
        }
    }
     public void agregarServicioDeApoyo(String tipo, String descripcion) {
        ServiciodeApoyo servicio = new ServiciodeApoyo(tipo, descripcion);
        this.serviciosDeApoyo.add(servicio);
    }

    //Sobrecarga de métodos
    @Override
    public String buscarPorNombre(String nombre) {
        if (this.getNombre().equalsIgnoreCase(nombre)) {
            return "Beneficiario encontrado: " + this.getNombre() + " | Discapacidad: " + discapacidad;
        }
        return "No coincide.";
    }
}


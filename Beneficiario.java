import java.util.ArrayList;
import java.util.List;

public class Beneficiario {
    private String rut;
    private String nombre;
    private String fechaNacimiento;
    private String discapacidad;
    private List<ServiciodeApoyo> serviciosDeApoyo;
    private List<SeguimientoImpacto> seguimientoImpacto;

    public Beneficiario(String rut, String nombre, String fechaNacimiento, String discapacidad) {
        this.rut = rut;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.discapacidad = discapacidad;
        this.serviciosDeApoyo = new ArrayList<>();
        this.seguimientoImpacto = new ArrayList<>();
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
}


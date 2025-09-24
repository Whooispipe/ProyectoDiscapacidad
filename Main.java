

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class Main{
    public static HashMap<String, Beneficiario> beneficiarios = new HashMap<>();

    public static void main(String[] args) {
        // abrir la ventana principal en el hilo de Swing
        javax.swing.SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
    
    public static void llenarDatosDePrueba(){
        Beneficiario b1 = new Beneficiario("12345678-9", "Juan Perez", "15/04/1980", "Visual");
        Beneficiario b2 = new Beneficiario("98765432-1", "Maria Gomez", "22/11/1990", "Auditiva");
        Beneficiario b3 = new Beneficiario("11111111-1", "Pedro Martinez", "05/06/1975", "Motriz");
        Beneficiario b4 = new Beneficiario("22222222-2", "Ana Torres", "30/09/1985", "Cognitiva");
        beneficiarios.put(b1.getRut(), b1);
        beneficiarios.put(b2.getRut(), b2);
        beneficiarios.put(b3.getRut(), b3);
        beneficiarios.put(b4.getRut(), b4);
    }

    public static void menuPrincipal() {
        System.out.println("=== Menu Principal ===");
        System.out.println("1) Beneficiarios");
        System.out.println("2) Servicios y Notas");
        System.out.println("3) Salir");
    }
    public static java.util.List<String> obtenerBeneficiariosTexto() {
    java.util.List<String> lista = new java.util.ArrayList<>();
    if (beneficiarios.isEmpty()) {
        lista.add("No hay beneficiarios registrados.");
        return lista;
    }
    for (Beneficiario b : beneficiarios.values()) {
        lista.add("RUT: " + b.getRut());
        lista.add("Nombre: " + b.getNombre());
        lista.add("Fecha de Nacimiento: " + b.getFechaNacimiento());
        lista.add("Discapacidad: " + b.getDiscapacidad());
        lista.add("---------------------------");
    }
    return lista;
}

   
    public static void menuServicios(BufferedReader br) throws IOException {
        System.out.println("=== MENÚ SERVICIOS Y NOTAS ===");
        System.out.println("1) Agregar Servicio de Apoyo");
        System.out.println("2) Agregar Nota");
        System.out.println("3) Listar Servicios de Apoyo");
        System.out.println("4) Listar Notas");
        System.out.println("5) Volver");

        System.out.print("Seleccione una opción: ");
        int opcion = Integer.parseInt(br.readLine());
        switch (opcion) {
            case 1:
                agregarServicioApoyo(br);
                break;
            case 2:
                agregarNota(br);
                break;
            case 3:
                listarServiciosApoyo();
                break;
            case 4:
                listarNotas();
                break;
            case 5:
                return;
            default:
                System.out.println("Opción no válida.");
        }
    }

       public static void agregarBeneficiario(String rut, String nombre, String fechaNacimiento, String discapacidad) {
    if (beneficiarios.get(rut) == null) {
        Beneficiario nuevo = new Beneficiario(rut, nombre, fechaNacimiento, discapacidad);
        beneficiarios.put(rut, nuevo);
        JOptionPane.showMessageDialog(null, "Beneficiario agregado exitosamente.");
    } else {
        JOptionPane.showMessageDialog(null, "El RUT ya está registrado.");
    }
}


    public static void modificarBeneficiario(String rut, String nombre, String fechaNacimiento, String discapacidad) {
    Beneficiario b = beneficiarios.get(rut);
    if (b == null) {
        JOptionPane.showMessageDialog(null, "Beneficiario no encontrado.");
        return;
    }
    if (nombre != null && !nombre.isEmpty()) b.setNombre(nombre);
    if (fechaNacimiento != null && !fechaNacimiento.isEmpty()) b.setFechaNacimiento(fechaNacimiento);
    if (discapacidad != null && !discapacidad.isEmpty()) b.setDiscapacidad(discapacidad);

    JOptionPane.showMessageDialog(null, "Beneficiario modificado exitosamente.");
}

    public static void eliminarBeneficiario(String rut) {
    Beneficiario eliminado = beneficiarios.remove(rut);
    if (eliminado == null) {
        JOptionPane.showMessageDialog(null, "Beneficiario no encontrado.");
    } else {
        JOptionPane.showMessageDialog(null, "Beneficiario eliminado exitosamente.");
    }
}

    public static void listarBeneficiarios() {
        if (beneficiarios.isEmpty()) {
            System.out.println("No hay beneficiarios registrados.");
            return;
        }
        for (Beneficiario b : beneficiarios.values()) {
            System.out.println("RUT: " + b.getRut());
            System.out.println("Nombre: " + b.getNombre());
            System.out.println("Fecha de Nacimiento: " + b.getFechaNacimiento());
            System.out.println("Discapacidad: " + b.getDiscapacidad());
            System.out.println("---------------------------");
        }
    }

    public static void agregarServicioApoyo(BufferedReader br) throws IOException {
        System.out.print("Ingrese RUT(con este formato 11111111-4):  "); 
        String rut = br.readLine();
        Beneficiario b = beneficiarios.get(rut);

        if (b == null) {
            System.out.println("Beneficiario no encontrado.");
            return;
        }
        System.out.println("Opciones de Servicio: Fisioterapia, Terapia Ocupacional, Psicologia, Asistencia Laboral, Transporte Especializado, Logopedia, Otro");
        System.out.print("Ingrese Tipo de Servicio: ");
        String tipoServicio = br.readLine();

        System.out.print("Ingrese Descripcion: ");
        String descripcion = br.readLine();

        ServiciodeApoyo nuevoServicio = new ServiciodeApoyo(tipoServicio, descripcion);
        b.getServiciosDeApoyo().add(nuevoServicio);
        System.out.println("Servicio de Apoyo agregado exitosamente.");
    }

    public static void agregarNota(BufferedReader br) throws IOException {
        System.out.print("Ingrese RUT(con este formato 11111111-4):  "); 
        String rut = br.readLine();
        Beneficiario b = beneficiarios.get(rut);

        if (b == null){
            System.out.println("Beneficiario no encontrado.");
            return;
        }

        System.out.print("Ingrese Contenido de la Nota (Positivo/Negativo): ");
        String contenido = br.readLine();

        SeguimientoImpacto nuevaNota = new SeguimientoImpacto(contenido);
        b.getSeguimientoImpacto().add(nuevaNota);
        System.out.println("Nota agregada exitosamente.");
    }

    public static void listarServiciosApoyo(){
        for (Beneficiario b : beneficiarios.values()){
            System.out.println("Beneficiario: " + b.getNombre() + " (" + b.getRut() + ")");
            if (b.getServiciosDeApoyo().isEmpty()) {
                System.out.println("  No tiene servicios de apoyo.");
            } else {
                for (ServiciodeApoyo s : b.getServiciosDeApoyo()) {
                    System.out.println("  - " + s.getTipoServicio() + ": " + s.getDescripcion());
                }
            }
            System.out.println("---------------------------");

        }
    }

    public static void listarNotas(){
        for (Beneficiario b : beneficiarios.values()){
            System.out.println("Beneficiario: " + b.getNombre() + " (" + b.getRut() + ")");
            if (b.getSeguimientoImpacto().isEmpty()) {
                System.out.println("  No tiene notas registradas.");
            } else {
                for (SeguimientoImpacto s : b.getSeguimientoImpacto()) {
                    System.out.println("  - Nota: " + s.getEfecto());
                }
            }
            System.out.println("---------------------------");
        }
    }

    // Funciones de utilidad
    // Para limpiar pantalla y poder avanzar con una tecla
    public static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void presioneParaContinuar() throws IOException {
        System.out.print("Presione Enter para continuar...");
        while (System.in.read() != '\n') {
        }
    }
}
    
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class Main{
    private static HashMap<String, Beneficiario> beneficiarios = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        llenarcondatosdepruebea();
        while (true) {

            MenuAdministrador();
            
            System.out.print("Seleccione una opcion: ");
            int opcion = Integer.parseInt(br.readLine());

            switch (opcion) {
                case 1:
                    limpiarPantalla();
                    mostrarMenuBeneficiario();
                    opcionadministrador(br);
                    break;
                case 2:
                    // Apartado de Servicios
                    limpiarPantalla();
                    mostrarMenuServicios();
                    opcionServicios(br);
                    break;
               
                case 3:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        presioneParaContinuar();
        limpiarPantalla();
        }
    }
    public static void llenarcondatosdepruebea()
    {
        Beneficiario b1 = new Beneficiario("12345678-9", "Juan Perez", "15/04/1980", "Visual");
        Beneficiario b2 = new Beneficiario("98765432-1", "Maria Gomez", "22/11/1990", "Auditiva");
        Beneficiario b3 = new Beneficiario("11111111-1", "Pedro Martinez", "05/06/1975", "Motriz");
        Beneficiario b4 = new Beneficiario("22222222-2", "Ana Torres", "30/09/1985", "Cognitiva");
        beneficiarios.put(b1.getRut(), b1);
        beneficiarios.put(b2.getRut(), b2);
        beneficiarios.put(b3.getRut(), b3);
        beneficiarios.put(b4.getRut(), b4);
    }
    public static void opcionadministrador(BufferedReader br) throws IOException
    {   
        System.out.print("Seleccione una opcion del apartado Beneficiarios: ");
        int n = Integer.parseInt(br.readLine());
        switch (n){
                case 1:
                    agregarBeneficiario(br);
                    break;
                case 2:
                    ModificarBeneficiario(br);
                    break;
                case 3:
                    eliminarbeneficiario(br);
                    break;
                case 4:
                    mostrarbeneficiarios();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        // pausa y limpieza se realizan en el main para evitar duplicar


    }
    public static void eliminarbeneficiario(BufferedReader br) throws IOException {
        System.out.print("Ingrese RUT del beneficiario a eliminar(con este formato 11111111-4): ");
        String rutInput = br.readLine();
        Beneficiario eliminado = beneficiarios.remove(rutInput);
        
        if (eliminado == null) {
            System.out.println("Beneficiario no encontrado.");
        } else {
            System.out.println("Beneficiario eliminado exitosamente.");
        }
    }
    public static void MenuAdministrador()
    {
        System.out.println("=== Menu Administrador ===");
        System.out.println("1) Apartado de Beneficiarios");
        System.out.println("2) Apartado de Servicios y Notas");
        System.out.println("3) Salir");

    }
    public static void mostrarMenuBeneficiario() {
        System.out.println("=== Menu Beneficiarios ===");
        System.out.println("1. Agregar Beneficiario");
        System.out.println("2. Modificar Beneficiario");
        System.out.println("3. Eliminar Beneficiario");
        System.out.println("4. Listar Beneficiarios");
        System.out.println("5. Salir");
    }

    public static void agregarBeneficiario(BufferedReader br) throws IOException {
        System.out.print("Ingrese RUT(con este formato 11111111-4): ");
        String rut = br.readLine();
        if(beneficiarios.get(rut) == null){
            System.out.print("Ingrese Nombre: ");
            String nombre = br.readLine();

            System.out.print("Ingrese Fecha de Nacimiento (dd/mm/yyyy): ");
            String fechaNacimiento = br.readLine();

            System.out.print("Ingrese Tipo de Discapacidad: ");
            System.out.print("Opciones: Visual, Auditiva, Motriz, Cognitiva, Multiple, Otra");
            String discapacidad = br.readLine();

            Beneficiario nuevoBeneficiario = new Beneficiario(rut, nombre, fechaNacimiento, discapacidad);
            beneficiarios.put(rut, nuevoBeneficiario);
            System.out.println("Beneficiario agregado exitosamente.");
        }
        else{
            System.out.println(("EL rut ya esta registrado..."));
        }
    }

    public static void ModificarBeneficiario(BufferedReader br) throws IOException {
        System.out.print("Ingrese RUT(con este formato 11111111-4): ");
        String rutInput = br.readLine();
        Beneficiario encontrado = beneficiarios.get(rutInput);
        
        if (encontrado == null) {
            System.out.println("Beneficiario no encontrado.");
            return;
        } else {
            System.out.print("Ingrese Nuevo Nombre (enter para mantener actual: " + encontrado.getNombre() + "): ");
            String nombres = br.readLine();
            System.out.print("Ingrese Nueva Fecha de Nacimiento (dd/mm/yyyy) (enter para mantener actual: " + encontrado.getFechaNacimiento() + "): ");
            String fechaNacimientos = br.readLine();
            System.out.print("Ingrese Nuevo Tipo de Discapacidad (enter para mantener actual: " + encontrado.getDiscapacidad() + "): ");
            String discapacidadd = br.readLine();

            if (nombres != null && !nombres.isEmpty()) {
                encontrado.setNombre(nombres);
            }
            if (fechaNacimientos != null && !fechaNacimientos.isEmpty()) {
                encontrado.setFechaNacimiento(fechaNacimientos);
            }
            if (discapacidadd != null && !discapacidadd.isEmpty()) {
                encontrado.setDiscapacidad(discapacidadd);
            }

            beneficiarios.put(rutInput, encontrado);
            System.out.println("Beneficiario modificado exitosamente.");
        }
    }

    public static void mostrarbeneficiarios() {
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

    public static void mostrarMenuServicios() {
        System.out.println("=== Menu Servicios y Notas ===");
        System.out.println("1. Agregar Servicio de Apoyo");
        System.out.println("2. Agregar Nota");
        System.out.println("3. Listar Servicios de Apoyo");
        System.out.println("4. Listar Notas");
        System.out.println("5. Salir");
    }

    public static void opcionServicios(BufferedReader br) throws IOException {
        System.out.print("Seleccione una opcion del apartado Servicios y Notas: ");
        int n = Integer.parseInt(br.readLine());

        switch (n){
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
                System.out.println("Volviendo al menu principal...");
                return;
            default:
                System.out.println("Opcion no valida. Intente de nuevo.");
        } 
    }

    public static void agregarServicioApoyo(BufferedReader br) throws IOException {
        System.out.print("Ingrese RUT(con este formato 11111111-4):  "); 
        String rut = br.readLine();
        Beneficiario b = beneficiarios.get(rut);

        if (b == null){
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
    

//holi
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    private static HashMap<String, Beneficiario> beneficiarios = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            mostrarMenu();
            System.out.print("Seleccione una opcion: ");
            int opcion = Integer.parseInt(br.readLine());

            switch (opcion) {
                case 1:
                    agregarBeneficiario(br);
                    limpiarPantalla();
                    break;
                case 2:
                    ModificarBeneficiario(br);
                    limpiarPantalla();
                    break;
                case 3:
                    // Eliminar Beneficiario
                    limpiarPantalla();
                    break;
                case 4:
                    // Listar Beneficiarios
                    limpiarPantalla();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("1. Agregar Beneficiario");
        System.out.println("2. Modificar Beneficiario");
        System.out.println("3. Eliminar Beneficiario");
        System.out.println("4. Listar Beneficiarios");
        System.out.println("5. Salir");
    }

    public static void agregarBeneficiario(BufferedReader br) throws IOException {
        System.out.print("Ingrese RUT: ");
        String rut = br.readLine();
        System.out.print("Ingrese Nombre: ");
        String nombre = br.readLine();
        System.out.print("Ingrese Fecha de Nacimiento (dd/mm/yyyy): ");
        String fechaNacimiento = br.readLine();
        System.out.print("Ingrese Tipo de Discapacidad: ");
        String discapacidad = br.readLine();

        Beneficiario nuevoBeneficiario = new Beneficiario(rut, nombre, fechaNacimiento, discapacidad);
        beneficiarios.put(rut, nuevoBeneficiario);
        System.out.println("Beneficiario agregado exitosamente.");
    }

    public static void ModificarBeneficiario(BufferedReader br) throws IOException {
        System.out.print("Ingrese RUT: ");
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

    public static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
    

//holi
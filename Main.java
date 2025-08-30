import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class Main{
    private static HashMap<String, Beneficiario> beneficiarios = new HashMap<>();

    
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
            mostrarMenu();
            System.out.print("Seleccione una opcion: ");
            int opcion = 0;
            try {
                opcion = Integer.parseInt(br.readLine());
            } catch (Exception e) {
                System.out.println("Entrada no válida. Intente de nuevo.");
                continue;
            }
        
            switch(opcion)
            {
                case 1:
                    
                    agregarBeneficiario(br);
                    limpiarPantalla();
                    break;
                case 2:
                    //Modificar Beneficiario
                    limpiarPantalla();
                    break;
                case 3:
                    //Eliminar Beneficiario
                    limpiarPantalla();
                    break;
                case 4:
                    //Listar Beneficiarios
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
    public static void agregarBeneficiario(BufferedReader br) {
        try {
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
        } catch (IOException e) {
            System.out.println("Error al leer la entrada. Intente de nuevo.");
        }
    }

    public static void limpiarPantalla() {
        System.out.print("\033[H\033[2J"); 
        System.out.flush(); 
    }


    
}


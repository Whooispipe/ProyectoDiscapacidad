import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
//import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;

public class Main{
    //private HashMap<String, Beneficiario> beneficiario;

    
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
                    //Agregar Beneficiario
                    break;
                case 2:
                    //Modificar Beneficiario
                    break;
                case 3:
                    //Eliminar Beneficiario
                    break;
                case 4:
                    //Listar Beneficiarios
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
    public static void limpiarPantalla() {
        System.out.print("\033[H\033[2J"); 
        System.out.flush(); 
    }


    
}

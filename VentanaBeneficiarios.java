
import javax.swing.*;
import java.awt.*;

public class VentanaBeneficiarios extends JFrame {

    private JButton btnAgregar, btnEditar, btnEliminar, btnMostrar;

    public VentanaBeneficiarios() {
        setTitle("Gestión de Beneficiarios");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Botones
        btnAgregar = new JButton("Agregar");
        btnEditar = new JButton("Editar");
        btnEliminar = new JButton("Eliminar");
        btnMostrar = new JButton("Mostrar");

        JPanel panelBotones = new JPanel(new GridLayout(4, 1, 10, 10));
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnMostrar);

        add(panelBotones, BorderLayout.CENTER);

        // --- Acciones de botones ---
        btnAgregar.addActionListener(e -> agregarBeneficiarioVentana());
        btnEditar.addActionListener(e -> modificarBeneficiarioVentana());
        btnEliminar.addActionListener(e -> eliminarBeneficiarioVentana());
        btnMostrar.addActionListener(e -> mostrarBeneficiariosVentana());
    }

    private void agregarBeneficiarioVentana() {
        String rut = JOptionPane.showInputDialog(this, "Ingrese RUT:");
        String nombre = JOptionPane.showInputDialog(this, "Ingrese Nombre:");
        String fecha = JOptionPane.showInputDialog(this, "Ingrese Fecha Nacimiento (dd/mm/yyyy):");
        String discapacidad = JOptionPane.showInputDialog(this, "Ingrese Discapacidad:");

        if (rut != null && nombre != null && fecha != null && discapacidad != null) {
            Main.agregarBeneficiario(rut, nombre, fecha, discapacidad);
        }
    }

    private void modificarBeneficiarioVentana() {
        String rut = JOptionPane.showInputDialog(this, "Ingrese RUT a modificar:");
        if (rut == null || rut.isEmpty()) return;

        String nombre = JOptionPane.showInputDialog(this, "Nuevo Nombre (dejar vacío para mantener):");
        String fecha = JOptionPane.showInputDialog(this, "Nueva Fecha Nacimiento (dejar vacío para mantener):");
        String discapacidad = JOptionPane.showInputDialog(this, "Nueva Discapacidad (dejar vacío para mantener):");

        Main.modificarBeneficiario(rut, nombre, fecha, discapacidad);
    }

    private void eliminarBeneficiarioVentana() {
        String rut = JOptionPane.showInputDialog(this, "Ingrese RUT a eliminar:");
        if (rut != null && !rut.isEmpty()) {
            Main.eliminarBeneficiario(rut);
        }
    }

    private void mostrarBeneficiariosVentana() {
        java.util.List<String> lista = Main.obtenerBeneficiariosTexto();

        JTextArea textArea = new JTextArea();
        for (String linea : lista) {
            textArea.append(linea + "\n");
        }
        textArea.setEditable(false);

        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setPreferredSize(new Dimension(400, 300));

        JOptionPane.showMessageDialog(this, scroll, "Lista de Beneficiarios", JOptionPane.INFORMATION_MESSAGE);
    }
}

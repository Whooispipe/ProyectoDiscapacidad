
import javax.swing.*;
import java.awt.*;

public class VentanaServicios extends JFrame {

    private JButton btnAgregarServicio, btnAgregarNota, btnListarServicios, btnListarNotas;

    public VentanaServicios() {
        setTitle("Gestión de Servicios y Notas");
        setSize(300, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Botones
        btnAgregarServicio = new JButton("Agregar Servicio de Apoyo");
        btnAgregarNota = new JButton("Agregar Nota");
        btnListarServicios = new JButton("Listar Servicios de Apoyo");
        btnListarNotas = new JButton("Listar Notas");

        JPanel panelBotones = new JPanel(new GridLayout(4, 1, 10, 10));
        panelBotones.add(btnAgregarServicio);
        panelBotones.add(btnAgregarNota);
        panelBotones.add(btnListarServicios);
        panelBotones.add(btnListarNotas);

        add(panelBotones, BorderLayout.CENTER);

        // --- Acciones de los botones ---
        btnAgregarServicio.addActionListener(e -> agregarServicioVentana());
        btnAgregarNota.addActionListener(e -> agregarNotaVentana());
        btnListarServicios.addActionListener(e -> listarServiciosVentana());
        btnListarNotas.addActionListener(e -> listarNotasVentana());
    }

    private void agregarServicioVentana() {
        String rut = JOptionPane.showInputDialog(this, "Ingrese RUT:");
        if (rut == null || rut.isEmpty()) return;

        String tipo = JOptionPane.showInputDialog(this, "Ingrese Tipo de Servicio:");
        String descripcion = JOptionPane.showInputDialog(this, "Ingrese Descripción:");

        if (tipo != null && descripcion != null) {
            Beneficiario b = Main.beneficiarios.get(rut);
            if (b == null) {
                JOptionPane.showMessageDialog(this, "Beneficiario no encontrado.");
                return;
            }
            ServiciodeApoyo nuevo = new ServiciodeApoyo(tipo, descripcion);
            b.getServiciosDeApoyo().add(nuevo);
            JOptionPane.showMessageDialog(this, "Servicio agregado exitosamente.");
        }
    }

    private void agregarNotaVentana() {
        String rut = JOptionPane.showInputDialog(this, "Ingrese RUT:");
        if (rut == null || rut.isEmpty()) return;

        String contenido = JOptionPane.showInputDialog(this, "Ingrese Nota:");
        if (contenido != null) {
            Beneficiario b = Main.beneficiarios.get(rut);
            if (b == null) {
                JOptionPane.showMessageDialog(this, "Beneficiario no encontrado.");
                return;
            }
            SeguimientoImpacto nota = new SeguimientoImpacto(contenido);
            b.getSeguimientoImpacto().add(nota);
            JOptionPane.showMessageDialog(this, "Nota agregada exitosamente.");
        }
    }

    private void listarServiciosVentana() {
        JTextArea textArea = new JTextArea();
        for (Beneficiario b : Main.beneficiarios.values()) {
            textArea.append("Beneficiario: " + b.getNombre() + " (" + b.getRut() + ")\n");
            if (b.getServiciosDeApoyo().isEmpty()) {
                textArea.append("  No tiene servicios de apoyo.\n");
            } else {
                for (ServiciodeApoyo s : b.getServiciosDeApoyo()) {
                    textArea.append("  - " + s.getTipoServicio() + ": " + s.getDescripcion() + "\n");
                }
            }
            textArea.append("---------------------------\n");
        }
        textArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setPreferredSize(new Dimension(400, 300));
        JOptionPane.showMessageDialog(this, scroll, "Lista de Servicios de Apoyo", JOptionPane.INFORMATION_MESSAGE);
    }

    private void listarNotasVentana() {
        JTextArea textArea = new JTextArea();
        for (Beneficiario b : Main.beneficiarios.values()) {
            textArea.append("Beneficiario: " + b.getNombre() + " (" + b.getRut() + ")\n");
            if (b.getSeguimientoImpacto().isEmpty()) {
                textArea.append("  No tiene notas registradas.\n");
            } else {
                for (SeguimientoImpacto s : b.getSeguimientoImpacto()) {
                    textArea.append("  - Nota: " + s.getEfecto() + "\n");
                }
            }
            textArea.append("---------------------------\n");
        }
        textArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setPreferredSize(new Dimension(400, 300));
        JOptionPane.showMessageDialog(this, scroll, "Lista de Notas", JOptionPane.INFORMATION_MESSAGE);
    }
}

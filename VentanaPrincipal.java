
public class VentanaPrincipal extends javax.swing.JFrame {

    public VentanaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        // Botones
        javax.swing.JButton btnBeneficiarios = new javax.swing.JButton();
        javax.swing.JButton btnServicios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Gestión");

        btnBeneficiarios.setText("Beneficiarios");
        btnServicios.setText("Servicios de Apoyo");

        // Eventos de los botones
        btnBeneficiarios.addActionListener(evt -> {
            new VentanaBeneficiarios().setVisible(true); 
        });

        btnServicios.addActionListener(evt -> {
            new VentanaServicios().setVisible(true);
        });

        // Layout automático
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addGap(50, 50, 50)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(btnBeneficiarios, 150, 150, 150)
                    .addGap(30, 30, 30)
                    .addComponent(btnServicios, 150, 150, 150))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                    .addGap(120, 120, 120)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBeneficiarios, 50, 50, 50)
                        .addComponent(btnServicios, 50, 50, 50)))
        );

        pack();
        setLocationRelativeTo(null); 
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
}

package managerApp.managerView.UI;

import managerApp.managerController.vehicles.VehicleRegisterController;
import managerApp.MainManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

public class ConfirmationModal extends JDialog {

    private JFormattedTextField plateTextField;

    public ConfirmationModal(JFrame parent, String title, String confirmationLabel) {
        super(parent, title, true);
        createUI(confirmationLabel);
    }

    private void createUI(String confirmationLabel) {

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Carregar imagem de um arquivo local
        ImageIcon imageIcon = new ImageIcon("./mustang.jpg");
        Image image = imageIcon.getImage(); // Transformar ImageIcon em Image
        Image newImage = image.getScaledInstance(300, 300, Image.SCALE_SMOOTH); // Redimensionar a imagem
        ImageIcon newImageIcon = new ImageIcon(newImage); // Transformar Image de volta em ImageIcon

        // Adicionar JLabel para exibir a imagem
        JLabel imageLabel = new JLabel(newImageIcon);
        add(imageLabel, BorderLayout.CENTER);

        // Adicionar JLabel para exibir o texto de confirmação
        JLabel confirmationTextLabel = new JLabel("<html>" + confirmationLabel + "<br/>Caso não seja passado nenhum parâmetro, serão listados todos os veículos disponíveis.</html>");
        confirmationTextLabel.setHorizontalAlignment(JLabel.CENTER);
        add(confirmationTextLabel, BorderLayout.NORTH);

        // Adicionar JFormattedTextField para a placa
        plateTextField = new JFormattedTextField() {
            @Override
            protected void processFocusEvent(FocusEvent e) {
                super.processFocusEvent(e);
                if (e.getID() == FocusEvent.FOCUS_GAINED) {
                    setText(""); // Limpar o texto quando o campo ganha foco
                }
            }
        };

        // Definir a cor da borda
        plateTextField.setBorder(BorderFactory.createCompoundBorder(
          new LineBorder(Color.RED, 2), // Borda vermelha com espessura 2
          new EmptyBorder(10, 10, 10, 10) // Preenchimento interno
        ));

        // Definir o tamanho do campo
        plateTextField.setPreferredSize(new Dimension(200, 10)); // Largura de 200 e altura de 30

        // Adicionar o campo de texto à parte central do layout
        add(plateTextField, BorderLayout.CENTER);

        // Definir a cor do texto para preto
        plateTextField.setForeground(Color.BLACK);

        // Criar painel para os botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Adicionar botão "Confirmar"
        JButton confirmButton = new JButton("Confirmar");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String plateText = plateTextField.getText();
                ArrayList<VehicleRegisterController> vehiclesArray = MainManager.getVehiclesArray();
                boolean isValid = VehicleRegisterController.verifyVehicleExistence(plateText, vehiclesArray);

                if (isValid) {
                    JOptionPane.showMessageDialog(ConfirmationModal.this, "Placa válida! Confirmação bem-sucedida");
                    dispose(); // Fechar o modal após confirmação bem-sucedida
                } else {
                    JOptionPane.showMessageDialog(ConfirmationModal.this, "Placa inválida. Tente novamente.");
                    // Você pode optar por não fechar o modal aqui se desejar
                }
            }
        });

        // Botão de cancelamento
        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fechar o modal
            }
        });

        // Adicionar botões ao painel
        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);

        // Adicionar o painel de botões ao sul do layout
        add(buttonPanel, BorderLayout.SOUTH);

        // Definir o tamanho do modal (metade do tamanho do JFrame pai)
        int parentWidth = getParent().getWidth();
        int parentHeight = getParent().getHeight();
        setSize(parentWidth / 2, parentHeight / 2);

        // Centralizar o modal na tela
        setLocationRelativeTo(getParent());

        // Tornar o modal visível
        setVisible(true);

        // Adicionar o
  }
}
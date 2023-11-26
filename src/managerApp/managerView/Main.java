package managerApp.managerView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import managerApp.managerView.UI.Button;
import managerApp.managerView.UI.ConfirmationModal;

public class Main extends JFrame {

    private static final int FIXED_WIDTH = 1200;
    private static final int FIXED_HEIGHT = 700;

    public Main() {
        createUI();
    }

    private void createUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Administração Locadora");
        setSize(FIXED_WIDTH, FIXED_HEIGHT);
        setResizable(false);

        // ... (código do menu e outros componentes)

        // Criar um painel com layout GridLayout
        JPanel panel = new JPanel(new GridLayout(4, 1, 5, 5)); 

        // Criar botões
        Button cadastrarButton = new Button("Cadastrar novo veículo");
        Button excluirButton = new Button("Excluir veículo");
        Button relatorioButton = new Button("Gerar relatório de locação");
        Button alterarParametrosButton = new Button("Alterar parâmetros operacionais");


        
        // Adicionar ação aos botões (você pode implementar suas próprias ações)
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Main.this, "Botão Cadastrar Pressionado");
            }
        });

        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Main.this, "Botão Excluir Pressionado");
                ConfirmationModal confirmationModal = new ConfirmationModal(Main.this, "Confirmação", "Informe a placa do veículo a ser excluído:");
            }
        });

        relatorioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Main.this, "Botão Gerar Relatório Pressionado");
            }
        });

        alterarParametrosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(Main.this, "Botão Alterar Parâmetros Pressionado");
            }
        });

        // Adicionar botões ao painel
        panel.add(cadastrarButton);
        panel.add(excluirButton);
        panel.add(relatorioButton);
        panel.add(alterarParametrosButton);

        // Adicionar painel ao frame
        add(panel);

        // Centralizar o frame na tela
        setLocationRelativeTo(null);

        // Tornar o frame visível
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}

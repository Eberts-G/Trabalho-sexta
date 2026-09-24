package br.com.sistema.view;

import javax.swing.JOptionPane;

public class FrmMenu extends javax.swing.JFrame {

    public FrmMenu() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH); // Abre em tela cheia
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        lblBoasVindas = new javax.swing.JLabel();
        menuBarra = new javax.swing.JMenuBar();
        menuCadastros = new javax.swing.JMenu();
        menuItemCliente = new javax.swing.JMenuItem();
        menuItemProduto = new javax.swing.JMenuItem();
        menuLancamentos = new javax.swing.JMenu();
        menuItemVendas = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenu();
        menuItemSairSystem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Gestão de Loja - Menu Principal");

        lblBoasVindas.setFont(new java.awt.Font("Segoe UI", 1, 28)); 
        lblBoasVindas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBoasVindas.setText("Sistema de Gestão de Loja");

        menuCadastros.setText("Cadastros");

        menuItemCliente.setText("Clientes");
        menuItemCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemClienteActionPerformed(evt);
            }
        });
        menuCadastros.add(menuItemCliente);

        menuItemProduto.setText("Produtos");
        menuItemProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemProdutoActionPerformed(evt);
            }
        });
        menuCadastros.add(menuItemProduto);

        menuBarra.add(menuCadastros);

        menuLancamentos.setText("Lançamentos");

        menuItemVendas.setText("Vendas");
        menuItemVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemVendasActionPerformed(evt);
            }
        });
        menuLancamentos.add(menuItemVendas);

        menuBarra.add(menuLancamentos);

        menuSair.setText("Sair");

        menuItemSairSystem.setText("Sair do Sistema");
        menuItemSairSystem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSairSystemActionPerformed(evt);
            }
        });
        menuSair.add(menuItemSairSystem);

        menuBarra.add(menuSair);

        setJMenuBar(menuBarra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBoasVindas, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(lblBoasVindas)
                .addContainerGap(250, Short.MAX_VALUE))
        );

        pack();
    }

    private void menuItemClienteActionPerformed(java.awt.event.ActionEvent evt) {
        FrmCliente tela = new FrmCliente();
        tela.setVisible(true);
    }

    private void menuItemProdutoActionPerformed(java.awt.event.ActionEvent evt) {
        FrmProduto tela = new FrmProduto();
        tela.setVisible(true);
    }

    private void menuItemVendasActionPerformed(java.awt.event.ActionEvent evt) {
        FrmVenda tela = new FrmVenda();
        tela.setVisible(true);
    }

    private void menuItemSairSystemActionPerformed(java.awt.event.ActionEvent evt) {
        int confirma = JOptionPane.showConfirmDialog(this, "Deseja realmente sair?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private javax.swing.JLabel lblBoasVindas;
    private javax.swing.JMenuBar menuBarra;
    private javax.swing.JMenu menuCadastros;
    private javax.swing.JMenuItem menuItemCliente;
    private javax.swing.JMenuItem menuItemProduto;
    private javax.swing.JMenuItem menuItemVendas;
    private javax.swing.JMenuItem menuItemSairSystem;
    private javax.swing.JMenu menuLancamentos;
    private javax.swing.JMenu menuSair;
}
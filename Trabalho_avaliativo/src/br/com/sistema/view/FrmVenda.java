package br.com.sistema.view;

import br.com.sistema.dao.ClienteDAO;
import br.com.sistema.dao.VendaDAO;
import br.com.sistema.model.Cliente;
import br.com.sistema.model.Venda;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmVenda extends javax.swing.JFrame {

    public void carregarClientesCombo() {
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> lista = dao.listar();
        cbCliente.removeAllItems();

        for (Cliente c : lista) {
            cbCliente.addItem(c);
        }
    }

    public void listarTabela() {
        VendaDAO dao = new VendaDAO();
        List<Venda> lista = dao.listar();
        DefaultTableModel dados = (DefaultTableModel) tabelaVendas.getModel();
        dados.setNumRows(0);

        for (Venda v : lista) {
            dados.addRow(new Object[]{
                v.getId(),
                v.getCliente().getNome(),
                v.getDataVenda(),
                v.getTotalVenda(),
                v.getObservacoes()
            });
        }
    }

    public void limparCampos() {
        txtCodigo.setText("");
        txtTotal.setText("");
        txtObservacoes.setText("");
    }

    public FrmVenda() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblObservacoes = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        cbCliente = new javax.swing.JComboBox<>();
        txtTotal = new javax.swing.JTextField();
        txtObservacoes = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaVendas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lançamento de Vendas");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 20)); 
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Lançamento de Vendas");

        lblCodigo.setText("Código:");
        lblCliente.setText("Cliente:");
        lblTotal.setText("Total:");
        lblObservacoes.setText("Observações:");

        txtCodigo.setEditable(false);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        tabelaVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] { "Código", "Cliente", "Data", "Total", "Observações" }
        ));
        tabelaVendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaVendasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaVendas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCodigo)
                            .addComponent(lblCliente)
                            .addComponent(lblTotal)
                            .addComponent(lblObservacoes))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCliente, 0, 230, Short.MAX_VALUE)
                            .addComponent(txtTotal)
                            .addComponent(txtObservacoes)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitulo)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodigo)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCliente)
                            .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotal)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblObservacoes)
                            .addComponent(txtObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalvar)
                            .addComponent(btnEditar)
                            .addComponent(btnExcluir)
                            .addComponent(btnLimpar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }

    private void formWindowActivated(java.awt.event.WindowEvent evt) {
        carregarClientesCombo();
        listarTabela();
    }

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        Venda obj = new Venda();
        obj.setCliente((Cliente) cbCliente.getSelectedItem());
        obj.setTotalVenda(Double.parseDouble(txtTotal.getText()));
        obj.setObservacoes(txtObservacoes.getText());

        VendaDAO dao = new VendaDAO();
        dao.salvar(obj);

        JOptionPane.showMessageDialog(this, "Venda salva com sucesso!");
        limparCampos();
    }

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
        if (txtCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione uma venda na tabela!");
            return;
        }

        Venda obj = new Venda();
        obj.setId(Integer.parseInt(txtCodigo.getText()));
        obj.setCliente((Cliente) cbCliente.getSelectedItem());
        obj.setTotalVenda(Double.parseDouble(txtTotal.getText()));
        obj.setObservacoes(txtObservacoes.getText());

        VendaDAO dao = new VendaDAO();
        dao.editar(obj);

        JOptionPane.showMessageDialog(this, "Venda atualizada com sucesso!");
        limparCampos();
    }

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        if (txtCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione uma venda na tabela!");
            return;
        }

        Venda obj = new Venda();
        obj.setId(Integer.parseInt(txtCodigo.getText()));

        VendaDAO dao = new VendaDAO();
        dao.excluir(obj);

        JOptionPane.showMessageDialog(this, "Venda excluída com sucesso!");
        limparCampos();
    }

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {
        limparCampos();
    }

    private void tabelaVendasMouseClicked(java.awt.event.MouseEvent evt) {
        txtCodigo.setText(tabelaVendas.getValueAt(tabelaVendas.getSelectedRow(), 0).toString());
        txtTotal.setText(tabelaVendas.getValueAt(tabelaVendas.getSelectedRow(), 3).toString());
        txtObservacoes.setText(tabelaVendas.getValueAt(tabelaVendas.getSelectedRow(), 4).toString());
    }

    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<Cliente> cbCliente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblObservacoes;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tabelaVendas;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtObservacoes;
    private javax.swing.JTextField txtTotal;
}
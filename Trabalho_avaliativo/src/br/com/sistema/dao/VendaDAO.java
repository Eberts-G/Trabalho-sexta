package br.com.sistema.dao;

import br.com.sistema.jdbc.ConnectionFactory;
import br.com.sistema.model.Cliente;
import br.com.sistema.model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {

    private Connection conn;

    public VendaDAO() {
        this.conn = new ConnectionFactory().getConnection();
    }

    // 1. Salvar
    public void salvar(Venda obj) {
        try {
            String sql = "INSERT INTO tb_vendas (cliente_id, total_venda, observacoes) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getCliente().getId());
            stmt.setDouble(2, obj.getTotalVenda());
            stmt.setString(3, obj.getObservacoes());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar venda: " + e.getMessage(), e);
        }
    }

    // 2. Editar
    public void editar(Venda obj) {
        try {
            String sql = "UPDATE tb_vendas SET cliente_id = ?, total_venda = ?, observacoes = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getCliente().getId());
            stmt.setDouble(2, obj.getTotalVenda());
            stmt.setString(3, obj.getObservacoes());
            stmt.setInt(4, obj.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao editar venda: " + e.getMessage(), e);
        }
    }

    // 3. Excluir
    public void excluir(Venda obj) {
        try {
            String sql = "DELETE FROM tb_vendas WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir venda: " + e.getMessage(), e);
        }
    }

    // 4. Listar
    public List<Venda> listar() {
        try {
            List<Venda> lista = new ArrayList<>();
            String sql = "SELECT v.id, v.data_venda, v.total_venda, v.observacoes, c.id AS cliente_id, c.nome AS cliente_nome "
                       + "FROM tb_vendas v INNER JOIN tb_clientes c ON (v.cliente_id = c.id)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Venda obj = new Venda();
                obj.setId(rs.getInt("id"));
                obj.setDataVenda(rs.getString("data_venda"));
                obj.setTotalVenda(rs.getDouble("total_venda"));
                obj.setObservacoes(rs.getString("observacoes"));

                Cliente c = new Cliente();
                c.setId(rs.getInt("cliente_id"));
                c.setNome(rs.getString("cliente_nome"));
                obj.setCliente(c);

                lista.add(obj);
            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar vendas: " + e.getMessage(), e);
        }
    }
}
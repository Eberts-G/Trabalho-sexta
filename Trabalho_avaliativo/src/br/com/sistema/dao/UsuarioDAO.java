package br.com.sistema.dao;

import br.com.sistema.jdbc.ConnectionFactory;
import br.com.sistema.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    private Connection conn;

    public UsuarioDAO() {
        this.conn = new ConnectionFactory().getConnection();
    }

    // Método para validar o Login
    public boolean efetuarLogin(String login, String senha) {
        try {
            String sql = "SELECT * FROM tb_usuarios WHERE login = ? AND senha = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return true; // Login correto
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao efetuar login: " + e.getMessage(), e);
        }
        return false; // Login inválido
    }
}
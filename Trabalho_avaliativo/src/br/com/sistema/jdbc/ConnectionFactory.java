package br.com.sistema.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() {
        try {
            // URL, Usuário e Senha do seu PostgreSQL local
            return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/bdloja", 
                "postgres", 
                "altf4"
            );
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados: " + e.getMessage(), e);
        }
    }
}
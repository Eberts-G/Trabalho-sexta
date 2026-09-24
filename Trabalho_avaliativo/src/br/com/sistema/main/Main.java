package br.com.sistema.main;

import br.com.sistema.view.FrmLogin;

public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new FrmLogin().setVisible(true);
        });
    }
}
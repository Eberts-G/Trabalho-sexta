package trabalho_avaliativo;

import br.com.sistema.view.FrmLogin;

public class Trabalho_avaliativo {

    public static void main(String[] args) {
        // Inicializa o formulário de Login do sistema
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }
}
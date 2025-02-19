package conexao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author aikel
 */
public class Conexao {
        private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=SistemaLogin;encrypt=false";
        private static final String USUARIO = "usuario_teste";
        private static final String SENHA = "123456";

    public static Connection conectar (){
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA); 
        } catch (SQLException e) {
            System.out.println("Erro de conexão: " + e.getMessage());
            return null;
        }
    }
    
}

package modelo.dao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aikel
 */

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginDAO {
    public boolean registrarUsuario (String nome, String email, String senha){
       Connection conexao = Conexao.conectar();
       String sql = "INSERT INTO cadastrousuario (nome, email, senha) VALUES (?, ?, ?)";
       
       try {
           PreparedStatement stmt = conexao.prepareStatement(sql);
           stmt.setString(1,nome);
           stmt.setString(2,email);
           stmt.setString(3,senha);
           stmt.executeUpdate();
           return true;
       }catch (SQLException e){
           System.out.println("ERRO ao cadastrar usuario: " + e.getMessage());
           return false;
       }
    }
    
    public boolean verificarLogin (String email, String senha){
       Connection conexao = Conexao.conectar();
       String sql = "SELECT * FROM cadastrousuario WHERE email = ? AND senha = ?";
       try {
           PreparedStatement stmt = conexao.prepareStatement(sql);
           stmt.setString(1,email);
           stmt.setString(2,senha);
           ResultSet rs = stmt.executeQuery();
           return rs.next();
       }catch (SQLException e){
           System.out.println("ERRO ao verificar login: " + e.getMessage());
           return false;
       }
    }
    
}

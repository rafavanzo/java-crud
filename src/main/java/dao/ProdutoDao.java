package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;
import model.Produto;

public class ProdutoDao implements CRUD {
	
	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;
	
	public static void create(Produto produto) {
		 sql = "INSERT INTO produtos (codigo, descricao, unidade, localizacao, preço_de_aquisicao, fabricante, departamento) VALUES (?, ?, ?, ?, ?, ?, ?)";

		 try {
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 
	         preparedStatement.setString(1, produto.getCodigo());
	         preparedStatement.setString(2, produto.getDescricao());
	         preparedStatement.setString(3, produto.getUnidade());
	         preparedStatement.setString(4, produto.getLocalizacao());
	         preparedStatement.setString(5, produto.getPreco_de_aquisicao());
	         preparedStatement.setString(6, produto.getFabricante());
	         preparedStatement.setString(7, produto.getDepartamento());
			 
			 preparedStatement.executeUpdate();
			 
			 System.out.println("--correct insert on database");
			 
		 } catch(SQLException e) {
			 System.out.println("--incorrect insert on database. " + e.getMessage());
		 }
	}
	
	public static void delete(String produtoCodigo) {
		sql = "DELETE FROM produtos WHERE codigo = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, produtoCodigo);
			preparedStatement.executeUpdate();
			
			System.out.println("--correct delete on produto");
			
		} catch (SQLException e) {
			System.out.println("--incorrect delete on produto. " + e.getMessage());
		}
	}
	
	public static List<Produto> find(String pesquisa) {
		
		sql = String.format("SELECT * FROM produtos WHERE codigo LIKE '%s%%'", pesquisa);
	    List<Produto> produtos = new ArrayList<>();

	    try {
	        Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery(sql);

	        while (resultSet.next()) {
	            Produto produto = new Produto();

	            produto.setCodigo(resultSet.getString("codigo"));
	            produto.setDescricao(resultSet.getString("descricao"));
	            produto.setUnidade(resultSet.getString("unidade"));
	            produto.setLocalizacao(resultSet.getString("localizacao"));
	            produto.setPreco_de_aquisicao(resultSet.getString("preço_de_aquisicao"));
	            produto.setFabricante(resultSet.getString("fabricante"));
	            produto.setData_de_cadastro(resultSet.getString("data_de_cadastro"));
	            produto.setDepartamento(resultSet.getString("departamento"));

	            produtos.add(produto);
	        }

	        System.out.println(sql);
	        System.out.println("--correct find produtos");
	        return produtos;
	    } catch(SQLException e) {
	        System.out.println("--incorrect find produtos. " + e.getMessage());
	        return null;
	    }
	}

	
	public static Produto findByPk(String produtoCodigo) {
		sql = String.format("SELECT * FROM produtos WHERE codigo = '%s'", produtoCodigo);

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Produto produto = new Produto();
			
			while (resultSet.next()) {
	            produto.setCodigo(resultSet.getString("codigo"));
	            produto.setDescricao(resultSet.getString("descricao"));
	            produto.setUnidade(resultSet.getString("unidade"));
	            produto.setLocalizacao(resultSet.getString("localizacao"));
	            produto.setPreco_de_aquisicao(resultSet.getString("preço_de_aquisicao"));
	            produto.setFabricante(resultSet.getString("fabricante"));
	            produto.setDepartamento(resultSet.getString("departamento"));
			}

			System.out.println("--correct find by pk clientes");
			return produto;
			
		} catch(SQLException e) {
			System.out.println("--incorrect find by pk clientes. " + e.getMessage());
			return null;
		}
	}

	
	public static void update(Produto produto) {
		sql = "UPDATE produtos SET descricao=?, unidade=?, localizacao=?, preço_de_aquisicao=?, fabricante=?, departamento=? WHERE codigo=?";
		 
		 try {
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 
	         preparedStatement.setString(1, produto.getDescricao());
	         preparedStatement.setString(2, produto.getUnidade());
	         preparedStatement.setString(3, produto.getLocalizacao());
	         preparedStatement.setString(4, produto.getPreco_de_aquisicao());
	         preparedStatement.setString(5, produto.getFabricante());
	         preparedStatement.setString(6, produto.getDepartamento());
	         preparedStatement.setString(7, produto.getCodigo());
			 
			 preparedStatement.executeUpdate();
			 
			 System.out.println("--correct update on database");
			 
		 } catch(SQLException e) {
			 System.out.println("--incorrect update on database. " + e.getMessage());
		 }
	}
}

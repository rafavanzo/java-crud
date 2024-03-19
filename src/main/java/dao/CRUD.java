package dao;

import java.util.List;

import model.Produto;

public interface CRUD {
	
	public static void create(Produto produto) {};
	public static void delete(String produtoCodigo) {};
	public static List<Produto> find(String pesquisa){return null;}
	public static Produto findByPk(int produtoCodigo) {return null;}
	public static void update(Produto produto) {}
}

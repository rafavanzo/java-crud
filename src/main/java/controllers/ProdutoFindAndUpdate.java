package controllers;

import java.io.IOException;

import dao.ProdutoDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Produto;

@WebServlet("/ProdutoUpdate")
public class ProdutoFindAndUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	 
    public ProdutoFindAndUpdate() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String produtoCodigo = request.getParameter("produtoCodigo");
		Produto produto = ProdutoDao.findByPk(produtoCodigo);
		
		request.setAttribute("produto", produto);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("formUpdate.jsp");
		requestDispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Produto produto = new Produto();
		
        produto.setCodigo(request.getParameter("codigo"));
        produto.setDescricao(request.getParameter("descricao"));
        produto.setUnidade(request.getParameter("unidade"));
        produto.setLocalizacao(request.getParameter("localizacao"));
        produto.setPreco_de_aquisicao(request.getParameter("preco_de_aquisicao"));
        produto.setFabricante(request.getParameter("fabricante"));
        produto.setDepartamento(request.getParameter("departamento"));
		
		ProdutoDao.update(produto);
		
		ProdutoCreateAndFind produtoCreateAndFind = new ProdutoCreateAndFind();
		produtoCreateAndFind.doGet(request, response);
	}

}

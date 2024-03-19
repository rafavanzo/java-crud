package controllers;

import java.io.IOException;
import java.util.List;

import dao.ProdutoDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Produto;

@WebServlet("/CreateAndFind")
public class ProdutoCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProdutoCreateAndFind() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String pesquisa = request.getParameter("pesquisa");
    	
		if(pesquisa == null) {
			pesquisa="";
		}
		
		List<Produto> produtos = ProdutoDao.find(pesquisa);
		
		request.setAttribute("produtos", produtos);
		RequestDispatcher resquesDispatcher = request.getRequestDispatcher("lista.jsp");
		resquesDispatcher.forward(request, response);
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

        ProdutoDao.create(produto);

        doGet(request, response);
    }
}

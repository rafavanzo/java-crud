package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.ProdutoDao;

@WebServlet("/ProdutoDestroy")
public class ProdutoDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public ProdutoDelete() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String produtoCodigo = request.getParameter("produtoCodigo");
		ProdutoDao.delete(produtoCodigo);
		
		ProdutoCreateAndFind produtoCreateAndFind = new ProdutoCreateAndFind();
		produtoCreateAndFind.doGet(request, response);
		
	}
}

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CRUD Java - Atualizar Produto</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="index.html">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="CreateAndFind">Lista de Produtos</a>
        </li>
      </ul>
      <form action="CreateAndFind" method="GET" class="d-flex">
        <input name="pesquisa" class="form-control me-2" type="search" placeholder="Digite o código do produto" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Buscar</button>
      </form>
    </div>
  </div>
</nav>
<br>
<div class="container">
	<div class="row">
		<div class="cold-md-7">
			<hr>
			<h3>Atualizar Produto</h3>
			<hr>
			<form action="ProdutoUpdate" method="POST">
					<div class="form-floating mb-3">
						<h6>Codigo do Produto</h6>
						<input value="${produto.codigo}" type="text" disabled> 
					</div>
					<input value="${produto.codigo}" name="codigo" type="text" style="visibility:hidden">
					<div class="form-floating mb-3">
						<input value="${produto.descricao}" name="descricao" maxlength="100" type="text" class="form-control"> 
						<label>Descricao do Produto</label>
					</div>
					<div class="form-floating mb-3">
						<input value="${produto.unidade}" name="unidade" maxlength="2" type="text" class="form-control"> 
						<label>Unidade</label>
					</div>
					<div class="form-floating mb-3">
						<input value="${produto.localizacao}" name="localizacao" maxlength="100" type="text" class="form-control"> 
						<label>Localizacao</label>
					</div>
					<div class="form-floating mb-3">
						<input value="${produto.preco_de_aquisicao}" name="preco_de_aquisicao" maxlength="9" type="text" class="form-control"> 
						<label>Preco de aquisicao</label>
					</div>
					<div class="form-floating mb-3">
						<input value="${produto.fabricante}" name="fabricante" maxlength="100" type="text" class="form-control"> 
						<label>Fabricante</label>
					</div>
					<div class="form-floating mb-3">
						<input value="${produto.departamento}" name="departamento" maxlength="100" type="text" class="form-control"> 
						<label>Departamento</label>
					</div>

					<button class="btn btn-success" type="submit">Atualizar
						Dados</button>
					<button class="btn btn-secondary" type="reset">Limpar
						Formulario</button>
			</form>
			<br>
		</div>
		
	</div>
</div>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
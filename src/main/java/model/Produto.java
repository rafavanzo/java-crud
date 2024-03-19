package model;

public class Produto {
	private String codigo;
	private String descricao;
	private String unidade;
	private String localizacao;
	private String preco_de_aquisicao;
	private String fabricante;
	private String data_de_cadastro;
	private String departamento;
	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
	
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	
	public String getPreco_de_aquisicao() {
		return preco_de_aquisicao;
	}
	public void setPreco_de_aquisicao(String preco_de_aquisicao) {
		this.preco_de_aquisicao = preco_de_aquisicao;
	}
	
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
	public String getData_de_cadastro() {
		return data_de_cadastro;
	}
	public void setData_de_cadastro(String data_de_cadastro) {
		this.data_de_cadastro = data_de_cadastro;
	}
	
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", descricao=" + descricao + ", unidade=" + unidade + ", localizacao="
				+ localizacao + ", preco_de_aquisicao=" + preco_de_aquisicao + ", fabricante=" + fabricante
				+ ", data_de_cadastro=" + data_de_cadastro + ", departamento=" + departamento + "]";
	}
}

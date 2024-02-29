package br.ifgoiano.dto;

import java.util.List;

import br.ifgoiano.model.Livro;

public class AutorDTO {

	private Integer id;
	private String nome;
	private List<Livro> livros;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	@Override
	public String toString() {
		return "AutorDTO [id=" + id + ", nome=" + nome + ", livros=" + livros + "]";
	}

}

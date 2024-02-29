package br.ifgoiano.dto;

import br.ifgoiano.model.Autor;
import br.ifgoiano.model.Editora;

public class LivroDTO {

	private Integer id;
	private String titulo;
	private int anoPub;
	private String isbn;
	private Autor autor;
	private Editora editora;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnoPub() {
		return anoPub;
	}

	public void setAnoPub(int anoPub) {
		this.anoPub = anoPub;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	@Override
	public String toString() {
		return "LivroDTO [id=" + id + ", titulo=" + titulo + ", anoPub=" + anoPub + ", isbn=" + isbn + ", autor="
				+ autor + ", editora=" + editora + "]";
	}

//	@Override
//	public String toString() {
//		return "LivroDTO [id=" + id + ", titulo=" + titulo + ", anoPub=" + anoPub + ", isbn=" + isbn + "]";
//	}

}

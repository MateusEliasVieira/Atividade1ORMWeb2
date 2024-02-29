package br.ifgoiano.service;

import java.util.List;

import br.ifgoiano.dto.LivroDTO;
import br.ifgoiano.model.Livro;

public interface LivroService {

	public boolean save(Livro livro);

	public boolean update(Livro livro);

	public Livro findLivroById(Integer id);

	public List<LivroDTO> findAll();

	public boolean deleteById(Integer id);
}

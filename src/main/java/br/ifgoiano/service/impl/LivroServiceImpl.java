package br.ifgoiano.service.impl;

import java.util.List;

import br.ifgoiano.dto.LivroDTO;
import br.ifgoiano.model.Livro;
import br.ifgoiano.repository.LivroRepository;
import br.ifgoiano.service.LivroService;

public class LivroServiceImpl implements LivroService {

	private LivroRepository livroRepository;

	public LivroServiceImpl() {
		livroRepository = new LivroRepository();
	}

	@Override
	public boolean save(Livro livro) {
		return livroRepository.save(livro);
	}

	@Override
	public boolean update(Livro livro) {
		return livroRepository.update(livro);
	}

	@Override
	public Livro findLivroById(Integer id) {
		try {
			return livroRepository.findLivroById(id)
					.orElseThrow(() -> new Exception("Livro com id " + id + ", não foi encontrado."));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<LivroDTO> findAll() {
		return livroRepository.findAll();
	}

	@Override
	public boolean deleteById(Integer id) {
		return livroRepository.deleteById(id);
	}
}

package br.ifgoiano.service.impl;

import java.util.List;

import br.ifgoiano.dto.AutorDTO;
import br.ifgoiano.model.Autor;
import br.ifgoiano.repository.AutorRepository;
import br.ifgoiano.service.AutorService;

public class AutorServiceImpl implements AutorService{

	private AutorRepository autorRepository;
	
	public AutorServiceImpl() {
		autorRepository = new AutorRepository();
	}
	
	public boolean save(Autor autor) {
		return autorRepository.save(autor);
	}

	public boolean update(Autor autor) {
		return autorRepository.update(autor);
	}

	public Autor findAutorById(Integer id) {
		try {
			return autorRepository.findAutorById(id).orElseThrow(() -> new Exception("Autor de id "+id+", não foi encontrado."));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<AutorDTO> findAll() {
		return autorRepository.findAll();
	}

	@Override
	public boolean deleteById(Integer id) {
		return autorRepository.deleteById(id);
	}

}

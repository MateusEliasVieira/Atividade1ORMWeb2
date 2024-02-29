package br.ifgoiano.service;

import java.util.List;

import br.ifgoiano.dto.AutorDTO;
import br.ifgoiano.model.Autor;

public interface AutorService {

	public boolean save(Autor autor);

	public boolean update(Autor autor);

	public Autor findAutorById(Integer id);
	
	public List<AutorDTO> findAll();
	
	public boolean deleteById(Integer id);
	

}

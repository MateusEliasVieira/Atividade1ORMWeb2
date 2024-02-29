package br.ifgoiano.service;

import java.util.List;

import br.ifgoiano.dto.EditoraDTO;
import br.ifgoiano.model.Editora;

public interface EditoraService {

	public boolean save(Editora editora);

	public boolean update(Editora editora);

	public Editora findEditoraById(Integer id);

	public List<EditoraDTO> findAll();

	public boolean deleteById(Integer id);
}

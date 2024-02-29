package br.ifgoiano.service.impl;

import java.util.List;

import br.ifgoiano.dto.EditoraDTO;
import br.ifgoiano.model.Editora;
import br.ifgoiano.repository.EditoraRepository;
import br.ifgoiano.service.EditoraService;

public class EditoraServiceImpl implements EditoraService {

	private EditoraRepository editoraRepository;

	public EditoraServiceImpl() {
		editoraRepository = new EditoraRepository();
	}

	@Override
	public boolean save(Editora editora) {
		return editoraRepository.save(editora);
	}

	@Override
	public boolean update(Editora editora) {
		return editoraRepository.update(editora);
	}

	@Override
	public Editora findEditoraById(Integer id) {
		try {
			return editoraRepository.findEditoraById(id).orElseThrow(() -> new Exception("Editora com id "+id+", não foi encontada."));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<EditoraDTO> findAll() {
		return editoraRepository.findAll();
	}

	@Override
	public boolean deleteById(Integer id) {
		return editoraRepository.deleteById(id);
	}
}

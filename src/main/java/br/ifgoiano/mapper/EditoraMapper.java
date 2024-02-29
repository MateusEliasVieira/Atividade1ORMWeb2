package br.ifgoiano.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import br.ifgoiano.dto.AutorDTO;
import br.ifgoiano.dto.EditoraDTO;
import br.ifgoiano.model.Autor;
import br.ifgoiano.model.Editora;

public class EditoraMapper {

	public static List<EditoraDTO> converterListaEditoraParaListaEditoraDTO(List<Editora> listaEditora) {
		ModelMapper mapper = new ModelMapper();
		List<EditoraDTO> listaEditoraDTO = new ArrayList<>();
		for (Editora editora : listaEditora) {
			listaEditoraDTO.add(mapper.map(editora, EditoraDTO.class));
		}
		return listaEditoraDTO;
	}
}

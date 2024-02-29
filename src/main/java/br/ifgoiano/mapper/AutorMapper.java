package br.ifgoiano.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import br.ifgoiano.dto.AutorDTO;
import br.ifgoiano.model.Autor;

public class AutorMapper {

	public static List<AutorDTO> converterListaAutorParaListaAutorDTO(List<Autor> listaAutor) {
		ModelMapper mapper = new ModelMapper();
		List<AutorDTO> listaAutorDTO = new ArrayList<>();
		for (Autor autor : listaAutor) {
			listaAutorDTO.add(mapper.map(autor, AutorDTO.class));
		}
		return listaAutorDTO;
	}
}

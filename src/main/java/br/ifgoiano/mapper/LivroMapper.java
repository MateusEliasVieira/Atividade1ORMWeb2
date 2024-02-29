package br.ifgoiano.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import br.ifgoiano.dto.AutorDTO;
import br.ifgoiano.dto.LivroDTO;
import br.ifgoiano.model.Autor;
import br.ifgoiano.model.Livro;

public class LivroMapper {

	public static List<LivroDTO> converterListaLivroParaListaLirvoDTO(List<Livro> listaLivro) {
		ModelMapper mapper = new ModelMapper();
		List<LivroDTO> listaLivroDTO = new ArrayList<>();
		for (Livro livro : listaLivro) {
			listaLivroDTO.add(mapper.map(livro, LivroDTO.class));
		}
		return listaLivroDTO;
	}
}

package br.ifgoiano.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.modelmapper.ModelMapper;

import br.ifgoiano.database.ConnectionFactory;
import br.ifgoiano.dto.AutorDTO;
import br.ifgoiano.mapper.AutorMapper;
import br.ifgoiano.model.Autor;

public class AutorRepository {

	private EntityManager entityManager;

	public AutorRepository() {
		entityManager = ConnectionFactory.getEntityManager();
	}

	// salva novo autor
	public boolean save(Autor autor) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(autor);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			entityManager.getTransaction().rollback();
			return false;
		} 
	}

	// atualiza autor
	public boolean update(Autor autor) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(autor);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			entityManager.getTransaction().rollback();
			return false;
		}
	}

	// buscar autor por id
	public Optional<Autor> findAutorById(Integer id) {
		return Optional.ofNullable(entityManager.find(Autor.class, id)); // buscamos o registro passando a classe e o id
	}

	// busca todos os registros
	public List<AutorDTO> findAll() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Autor> criteriaQuery = builder.createQuery(Autor.class);
		Root<Autor> root = criteriaQuery.from(Autor.class);
		criteriaQuery.select(root);
		List<Autor>listaAutor =  entityManager.createQuery(criteriaQuery).getResultList();
		return AutorMapper.converterListaAutorParaListaAutorDTO(listaAutor);
	}

	// deleta por id
	public boolean deleteById(Integer id) {
		try {
			entityManager.getTransaction().begin(); // abrimos a transação
			entityManager
					.remove(this.findAutorById(id).orElseThrow(() -> new Exception("Não existe autor com id " + id)));
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println(e.getMessage());
			return false;
		} 
	}

}

package br.ifgoiano.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.ifgoiano.database.ConnectionFactory;
import br.ifgoiano.dto.LivroDTO;
import br.ifgoiano.mapper.LivroMapper;
import br.ifgoiano.model.Livro;

public class LivroRepository {

	private EntityManager entityManager;

	public LivroRepository() {
		entityManager = ConnectionFactory.getEntityManager();
	}

	// Salva novo livro
	public boolean save(Livro livro) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(livro);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			entityManager.getTransaction().rollback();
			return false;
		}
	}

	// Atualiza livro
	public boolean update(Livro livro) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(livro);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			entityManager.getTransaction().rollback();
			return false;
		} 
	}

	// Busca livro por id
	public Optional<Livro> findLivroById(Integer id) {
		return Optional.empty();
	}

	// Busca todos os registros de Livro
	public List<LivroDTO> findAll() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Livro> criteriaQuery = builder.createQuery(Livro.class);
		Root<Livro> root = criteriaQuery.from(Livro.class);
		criteriaQuery.select(root);
		List<Livro> listaLivro =  entityManager.createQuery(criteriaQuery).getResultList();
		return LivroMapper.converterListaLivroParaListaLirvoDTO(listaLivro);
	}

	// Deleta livro por id
	public boolean deleteById(Integer id) {
		try {
			entityManager.getTransaction().begin();
			entityManager
					.remove(this.findLivroById(id).orElseThrow(() -> new Exception("Não existe livro com id " + id)));
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println(e.getMessage());
			return false;
		} 
	}
}

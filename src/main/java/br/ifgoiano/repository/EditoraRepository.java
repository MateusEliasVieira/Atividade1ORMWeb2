package br.ifgoiano.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.ifgoiano.database.ConnectionFactory;
import br.ifgoiano.dto.EditoraDTO;
import br.ifgoiano.mapper.EditoraMapper;
import br.ifgoiano.model.Editora;

public class EditoraRepository {

	private EntityManager entityManager;

	public EditoraRepository() {
		entityManager = ConnectionFactory.getEntityManager();
	}

	// Salva nova editora
	public boolean save(Editora editora) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(editora);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			entityManager.getTransaction().rollback();
			return false;
		} 
	}

	// Atualiza editora
	public boolean update(Editora editora) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(editora);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			entityManager.getTransaction().rollback();
			return false;
		} 
	}

	// Busca editora por id
	public Optional<Editora> findEditoraById(Integer id) {
		return Optional.ofNullable(entityManager.find(Editora.class, id));
	}

	// Busca todas as editoras
	public List<EditoraDTO> findAll() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Editora> criteriaQuery = builder.createQuery(Editora.class);
		Root<Editora> root = criteriaQuery.from(Editora.class);
		criteriaQuery.select(root);
		List<Editora> listaEditora = entityManager.createQuery(criteriaQuery).getResultList();
		return EditoraMapper.converterListaEditoraParaListaEditoraDTO(listaEditora);
	}

	// Deleta editora por id
	public boolean deleteById(Integer id) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(
					this.findEditoraById(id).orElseThrow(() -> new Exception("Não existe editora com id " + id)));
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println(e.getMessage());
			return false;
		}
	}
}

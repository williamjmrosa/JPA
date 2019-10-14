package br.edu.ifrs.canoas.jee.jpa.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ifrs.canoas.jee.jpa.util.EntityManagerUtil;

public class DiariaAvulsaDAO {

	EntityManager em;
	
	public DiariaAvulsaDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void salva(DiariaAvulsaDAO diariaAvulsa) {
		em = EntityManagerUtil.getEM();
		em.getTransaction().begin();
		em.persist(diariaAvulsa);
		em.getTransaction().commit();
		em.close();
	}
	
	public void atualiza(DiariaAvulsaDAO diariaAvulsa) {
		em = EntityManagerUtil.getEM();
		em.getTransaction().begin();
		em.persist(diariaAvulsa);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(Long id) {
		em = EntityManagerUtil.getEM();
		DiariaAvulsaDAO diariaAvulsa = em.find(DiariaAvulsaDAO.class, id);
		em.remove(diariaAvulsa);
		em.close();
	}
	
	public DiariaAvulsaDAO busca(Long id) {
		em = EntityManagerUtil.getEM();
		DiariaAvulsaDAO diariaAvulsa = em.find(DiariaAvulsaDAO.class, id);
		em.close();
		return diariaAvulsa;
	}
	
	public List<DiariaAvulsaDAO> busca(){
		em = EntityManagerUtil.getEM();
		TypedQuery<DiariaAvulsaDAO> query = em.createQuery("SELECT da FROM DiariaAvulsa da",DiariaAvulsaDAO.class);
		List<DiariaAvulsaDAO> diariaAvulsas = query.getResultList();
		return diariaAvulsas;
	}
	
}

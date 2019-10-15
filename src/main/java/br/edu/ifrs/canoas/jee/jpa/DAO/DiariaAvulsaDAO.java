package br.edu.ifrs.canoas.jee.jpa.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ifrs.canoas.jee.jpa.pojo.DiariaAvulsa;
import br.edu.ifrs.canoas.jee.jpa.util.EntityManagerUtil;

public class DiariaAvulsaDAO {

	EntityManager em;
	
	public DiariaAvulsaDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void salva(DiariaAvulsa diariaAvulsa) {
		em = EntityManagerUtil.getEM();
		em.getTransaction().begin();
		em.persist(diariaAvulsa);
		em.getTransaction().commit();
		em.close();
	}
	
	public void atualiza(DiariaAvulsa diariaAvulsa) {
		em = EntityManagerUtil.getEM();
		em.getTransaction().begin();
		em.persist(diariaAvulsa);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(Long id) {
		em = EntityManagerUtil.getEM();
		DiariaAvulsa diariaAvulsa = em.find(DiariaAvulsa.class, id);
		em.remove(diariaAvulsa);
		em.close();
	}
	
	public DiariaAvulsa busca(Long id) {
		em = EntityManagerUtil.getEM();
		DiariaAvulsa diariaAvulsa = em.find(DiariaAvulsa.class, id);
		em.close();
		return diariaAvulsa;
	}
	
	public List<DiariaAvulsa> busca(){
		em = EntityManagerUtil.getEM();
		TypedQuery<DiariaAvulsa> query = em.createQuery("SELECT da FROM DiariaAvulsa da",DiariaAvulsa.class);
		List<DiariaAvulsa> diariaAvulsas = query.getResultList();
		return diariaAvulsas;
	}
	
}

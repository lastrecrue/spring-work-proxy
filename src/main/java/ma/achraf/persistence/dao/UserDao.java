package ma.achraf.persistence.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ma.achraf.persistence.model.User;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void save2(User user) {
		save(user);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void save(User user) {
		entityManager.persist(user);
	}

}

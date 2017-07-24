package ma.achraf;

import ma.achraf.persistence.dao.UserDao;
import ma.achraf.persistence.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	@Autowired
	private UserDao userDao;

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				PersistenceJPAConfig.class);
		AutowireCapableBeanFactory autowireCapableBeanFactory = context
				.getAutowireCapableBeanFactory();
		Main main = new Main();
		autowireCapableBeanFactory.autowireBean(main);
		main.userDao.save(new User("test"));
		main.userDao.save2(new User("test"));
	}

}

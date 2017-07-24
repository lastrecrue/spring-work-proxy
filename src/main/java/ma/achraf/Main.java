package ma.achraf;

import lombok.extern.log4j.Log4j;
import ma.achraf.persistence.dao.UserDao;
import ma.achraf.persistence.model.User;

import org.hibernate.annotations.Loader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Log4j
public class Main {

	@Autowired
	private UserDao userDao;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = null;
		try {
			context = new AnnotationConfigApplicationContext(
					PersistenceJPAConfig.class);
			AutowireCapableBeanFactory autowireCapableBeanFactory = context
					.getAutowireCapableBeanFactory();
			Main main = new Main();
			autowireCapableBeanFactory.autowireBean(main);
			main.userDao.save(new User("test2"));
			main.userDao.save2(new User("test"));
		} catch (Exception e) {
			log.error(e);
		} finally {
			context.close();
		}
	}

}

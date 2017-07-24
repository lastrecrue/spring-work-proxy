package ma.achraf;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ma.achraf.persistence.dao.UserDao;
import ma.achraf.persistence.model.User;

public class Main {
	final static Logger log = Logger.getLogger(Main.class);
	@Autowired
	private UserDao userDao;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = null;
		try {
			context = new AnnotationConfigApplicationContext(PersistenceJPAConfig.class);
			AutowireCapableBeanFactory autowireCapableBeanFactory = context.getAutowireCapableBeanFactory();
			Main main = new Main();
			autowireCapableBeanFactory.autowireBean(main);
			main.userDao.save(new User("test proxy ok"));
			main.userDao.save2(new User("test ko"));
		} catch (Exception e) {
			log.error("e : ", e);
		} finally {
			context.close();
		}
	}

}

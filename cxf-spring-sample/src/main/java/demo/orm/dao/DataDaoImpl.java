package demo.orm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import demo.orm.entity.Database;

public class DataDaoImpl implements DataDao {

	@Autowired
	SessionFactory sessionFactory;
	Session session = null;
	Transaction tx = null;

	@Override
	public List<Database> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Database> dbList = session.createCriteria(Database.class).list();
		tx.commit();
		session.close();
		return dbList;
	}

}

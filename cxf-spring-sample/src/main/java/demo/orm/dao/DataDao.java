package demo.orm.dao;

import java.util.List;

import demo.orm.entity.Database;

public interface DataDao {
	public List<Database> getEntityList() throws Exception;
}

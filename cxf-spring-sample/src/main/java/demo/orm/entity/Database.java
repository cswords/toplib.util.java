package demo.orm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DOC_Order_Header_TT")
public class Database implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "OrderNo")
	private String dbName;

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
}

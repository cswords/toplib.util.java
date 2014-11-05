package demo.orm.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso({ Database.class, Exception.class })
public class ResponseContainer {

	private List<Database> list;

	public List<Database> getList() {
		return list;
	}

	public void setList(List<Database> l) {
		this.list = l;
	}

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}

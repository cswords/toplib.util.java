package toplib.test;

import java.util.List;

public class TestBean {

	private String stringProp;

	@SuppressWarnings("unused")
	private int intProp;

	private boolean boolProp;
	
	private String name;
	
	private List<Integer> intListProp; 
	
	private List<TestBean> beanListProp;

	public boolean isBoolProp() {
		return boolProp;
	}

	public void setBoolProp(boolean boolProp) {
		this.boolProp = boolProp;
	}

	public String getStringProp() {
		return stringProp;
	}

	public void setIntProp(int intProp) {
		this.intProp = intProp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getIntListProp() {
		return intListProp;
	}

	public void setIntListProp(List<Integer> intListProp) {
		this.intListProp = intListProp;
	}

	public List<TestBean> getBeanListProp() {
		return beanListProp;
	}

	public void setBeanListProp(List<TestBean> beanListProp) {
		this.beanListProp = beanListProp;
	}
	
}

package toplib.test;

public class TestBean {

	private String stringProp;

	private int intProp;

	private boolean boolProp;
	
	private String name;

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
	
}

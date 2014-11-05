package toplib.beans;

public class BeanComparatorDesc<T> extends BeanComparatorAsc<T> {

	public BeanComparatorDesc(String exp) {
		super(exp);
	}

	@Override
	public int compare(T o1, T o2) {
		return 0 - super.compare(o1, o2);
	}
}

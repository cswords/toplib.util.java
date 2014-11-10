package toplib.beans;

import java.util.Comparator;

public class BeanComparatorAsc<T> implements Comparator<T> {

	public BeanComparatorAsc(String exp) {
		this.exp = exp;
	}

	private String exp;

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public int compare(T o1, T o2) {
		try {
			Comparable left = Util.getBeanProperty(o1, exp);
			Comparable right = Util.getBeanProperty(o2, exp);
			return left.compareTo(right);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}

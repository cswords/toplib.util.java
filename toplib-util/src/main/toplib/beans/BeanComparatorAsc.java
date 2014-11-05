package toplib.beans;

import java.util.Comparator;

import toplib.beans.exceptions.NoSuchPropertyException;

public class BeanComparatorAsc<T> implements Comparator<T> {

	public BeanComparatorAsc(String exp) {
		this.exp = exp;
	}

	private String exp;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int compare(T o1, T o2) {
		try {
			Object left = Util.getField(o1, exp);
			Object right = Util.getField(o2, exp);
			if ((left instanceof Comparable) & (right instanceof Comparable)) {
				return ((Comparable) left).compareTo((Comparable) right);
			}
		} catch (NoSuchPropertyException e) {
			// e.printStackTrace();
		}
		return 0;
	}
}

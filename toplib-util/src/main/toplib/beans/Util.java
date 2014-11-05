package toplib.beans;

import java.lang.reflect.Method;

import toplib.beans.exceptions.NoSuchPropertyException;

public class Util {

	public static <T> Object getField(T o, String exp)
			throws NoSuchPropertyException {
		Object result = o;
		try {
			String[] fields = exp.split("\\.");
			for (int i = 0; i < fields.length; i++) {
				Method getter;
				try {
					getter = result.getClass().getMethod("get" + fields[i]);
				} catch (NoSuchMethodException e) {
					getter = result.getClass().getMethod("is" + fields[i]);
				}
				result = getter.invoke(result);
			}
		} catch (Exception e) {
			throw new NoSuchPropertyException(
					"There is no property for expression: " + exp + ".");
		}
		return result;

	}

}

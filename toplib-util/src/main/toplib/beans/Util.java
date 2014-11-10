package toplib.beans;

import java.lang.reflect.Method;
import java.util.*;

import toplib.beans.exceptions.*;

public class Util {

	private static <O> Object getBeanSimpleProperty(O o, String field)
			throws NoSuchPropertyException {
		Object result = o;
		Method getter;
		try {
			try {
				getter = result.getClass().getMethod("get" + field);
			} catch (NoSuchMethodException e) {
				getter = result.getClass().getMethod("is" + field);
			}
			result = getter.invoke(result);
			return result;
		} catch (Exception e) {
			throw new NoSuchPropertyException(
					"There is no property named " + field + " in the bean of "
							+ o.getClass().getName() + ".", e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <O, T> T getBeanProperty(O o, String exp)
			throws NoSuchPropertyException, TypeMismatchingException {
		Object value = o;
		String[] fields = exp.split("\\.");
		for (int i = 0; i < fields.length; i++) {
			value = getBeanSimpleProperty(value, fields[i]);
		}
		try {
			return (T) value;
		} catch (ClassCastException e) {
			throw new TypeMismatchingException(
					"The property cannot be cast into given type for expression: "
							+ exp + ".", e);
		}
	}

	@SuppressWarnings("unchecked")
	private static <O, T> List<T> getBeanSimplePropertyList(List<O> ol,
			String field) throws NoSuchPropertyException,
			TypeMismatchingException {
		List<T> result = new LinkedList<T>();

		for (int i = 0; i < ol.size(); i++) {
			O o = ol.get(i);
			try {
				List<T> listValue = (List<T>) getBeanSimpleProperty(o, field);
				if (listValue != null)
					result.addAll(listValue);
			} catch (ClassCastException e) {
				T singleValue = (T) getBeanSimpleProperty(o, field);
				if (singleValue != null)
					result.add(singleValue);
			}
		}
		return result;
	}

	public static <O, T> List<T> getBeanPropertyList(List<O> ol, String exp)
			throws NoSuchPropertyException, TypeMismatchingException {

		List<T> result = null;

		String field = exp.indexOf(".") < 0 ? exp : exp.substring(0,
				exp.indexOf("."));
		String subExp = exp.indexOf(".") < 0 ? "" : exp.substring(exp
				.indexOf(".") + 1);

		if (subExp == "") {
			result = getBeanSimplePropertyList(ol, field);
		} else {
			List<Object> valueList = getBeanSimplePropertyList(ol, field);
			result = getBeanPropertyList(valueList, subExp);
		}

		return result;
	}
}

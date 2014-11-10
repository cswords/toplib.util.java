package toplib.test;

import java.io.IOException;
import java.util.*;

import toplib.beans.*;
import toplib.beans.exceptions.*;

public class Test {

	public static void main(String[] args) throws IOException,
			ClassCastException, NoSuchPropertyException, TypeMismatchingException {

		TestBean a = new TestBean();
		a.setBoolProp(false);
		a.setIntProp(1);
		a.setName("a");

		TestBean b = new TestBean();
		b.setBoolProp(true);
		b.setIntProp(2);
		b.setName("b");

		TestBean[] list = new TestBean[] { a, b };
		Arrays.sort(list, new BeanComparatorAsc<TestBean>("BoolProp"));
		for (int i = 0; i < 2; i++) {
			System.out.println(list[i].getName());
		}
		Arrays.sort(list, new BeanComparatorDesc<TestBean>("BoolProp"));
		for (int i = 0; i < 2; i++) {
			System.out.println(list[i].getName());
		}

		List<Integer> testList = new LinkedList<Integer>();
		testList.add(2);
		testList.add(4);
		testList.add(4);
		testList.add(5);
		a.setIntListProp(testList);
		b.setIntListProp(testList);
		
		List<TestBean> testBeanList = new LinkedList<TestBean>();
		testBeanList.add(a);
		testBeanList.add(b);

		a.setBeanListProp(testBeanList);

		List<Integer> testIntList = Util.getBeanPropertyList(testBeanList,
				"BeanListProp.IntListProp");

		for (int i = 0; i < testIntList.size(); i++) {
			System.out.println(testIntList.get(i));
		}

		List<String> nameList=Util.getBeanPropertyList(testBeanList,
				"BeanListProp.Name");

		for (int i = 0; i < nameList.size(); i++) {
			System.out.println(nameList.get(i));
		}
		System.in.read();
	}

}

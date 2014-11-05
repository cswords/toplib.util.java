package toplib.test;

import java.io.IOException;
import java.util.Arrays;

import toplib.beans.*;

public class Test {

	public static void main(String[] args) throws IOException {

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

		System.in.read();
	}

}

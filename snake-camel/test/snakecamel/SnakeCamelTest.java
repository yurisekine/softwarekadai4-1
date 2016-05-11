package snakecamel;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class SnakeCamelTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
	}

	@Test
	public void snakeToCamelcaseテスト() {

		SnakeCamelUtil util = new SnakeCamelUtil();
		String expected = "AbcDefGh";
		String actual = util.snakeToCamelcase("abc__def___gh");
		//abc__def___gh → AbcDefGh
		//_abc_def__ → AbcDef
		//int expected = 35;
	//	int actual = calc.multiply(5, 7);
		assertThat(actual, is(expected));
	}
	
	@Test
	public void camelToSnakecaseテスト() {

		SnakeCamelUtil util = new SnakeCamelUtil();
		String expected = "abc_def_gh";
		String actual = util.camelToSnakecase("AbcDefGh");
		assertThat(actual, is(expected));
	}
	
	@Test
	public void capitalizeテスト() {//大文字にする

		SnakeCamelUtil util = new SnakeCamelUtil();
		String expected = "Xyz";
		String actual = util.capitalize("xyz");
		assertThat(actual, is(expected));
	}
	
	@Test
	public void uncapitalizeテスト() {//大文字でなくする

		SnakeCamelUtil util = new SnakeCamelUtil();
		String expected = "xyz";
		String actual = util.uncapitalize("Xyz");
		assertThat(actual, is(expected));
	}
	
}

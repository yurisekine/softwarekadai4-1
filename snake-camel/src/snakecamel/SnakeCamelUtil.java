package snakecamel;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SnakeCamelUtil {
	public static void main(String[] args) {
		String StoCexpected = "AbcDefGh";
		String StoCactual = snakeToCamelcase("abc__def___gh");
		assertThat(StoCactual, is(StoCexpected));
		
		String CtoSexpected = "abc_def_gh";
		String CtoSactual = camelToSnakecase("AbcDefGh");
		assertThat(CtoSactual, is(CtoSexpected));
		
		String Capexpected = "Xyz";
		String Capactual = capitalize("xyz");
		assertThat(Capactual, is(Capexpected));
		
		String unCexpected = "xyz";
		String unCactual = uncapitalize("Xyz");
		assertThat(unCactual, is(unCexpected));
		
		System.out.println("できてるよ！！");
		
	}
	public static String snakeToCamelcase(String snake_case) {
		String[] words = snake_case.split("_");//分割して、配列に単語を入れる

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < words.length; i++) { //[修正]-1消す
			words = remove(words, "");
			
			sb.append(capitalize(words[i]));
		}
		return new String(sb);
	}
	 
	private static String[] remove(String[] words, String str) {
		// TODO Auto-generated method stub
		List<String> temp = new ArrayList<String>(Arrays.asList(words));
		temp.remove(str);
		return temp.toArray(new String[0]);
	}

	public static String camelToSnakecase(String camelcase) {
		StringBuilder sb = new StringBuilder();
		int j = 0;
		for (int i = 0; i < camelcase.length(); i++) {
			char c = camelcase.charAt(i);
			if (Character.isUpperCase(c)) {
				if (j < i) { //[修正]
					sb.append(camelcase.substring(j+1, i));//
				} //[修正]
				if (sb.length() > 0) {
					sb.append("_");
				}
								
			//	sb.append(uncapitalize());
				sb.append(Character.toLowerCase(c));//小文字にしたものを足す
				j = i;
			}
		}
		sb.append(camelcase.substring(j+1));//[修正]
		return new String(sb);
	}
	
	static String capitalize(String s) {
		char first = s.charAt(0);
		char upperFirst = Character.toUpperCase(first);
		String rest = s.substring(1);
		return upperFirst + rest;
	}

	static String uncapitalize(String s) {
		char first = s.charAt(0);
		char lowerFirst = Character.toLowerCase(first);
		String rest = s.substring(1);
		return lowerFirst + rest;
	}
	
}

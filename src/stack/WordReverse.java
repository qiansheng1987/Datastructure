package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordReverse {
	
	private String input; //input string
	private String output;
	
	public WordReverse(String in) {
		this.input = in;
	}
	
	public String doRev() {
		int stackSize = input.length();
		StackX stack = new StackX(stackSize);
		for (int i = 0; i < stackSize; i++) {
			char c = input.charAt(i);
			stack.push(c);
		}
		
		output = "";
		while (!stack.isEmpty()) {
			char ch = stack.pop();
			output += ch;
		}
		return output;
	}
	
	public static void main(String[] args) {
		
		while (true) {
			System.out.print("请输入单词。。。。。");
			System.out.flush();
			String str = getString();
			if (str.equals("")) {
				break;
			}
			WordReverse rev = new WordReverse(str);
			String output = rev.doRev();
			System.out.println("反向输出的结果为：" + output);
		}
	}
	
	public static String getString() {
		InputStreamReader ins= new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(ins);
		String str = "";
		try {
			str = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
}























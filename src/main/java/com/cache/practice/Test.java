package com.cache.practice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		System.out.println(isValid("(){}[]"));
		
	}
	
	
	public static boolean isValid(String s) {
        List<String> list = new ArrayList();
        for(char c : s.toCharArray()) {
            String charStr = Character.toString(c);
            if("(".equals(charStr) || "{".equals(charStr) || "[".equals(charStr)) {
                list.add(charStr);
            } else {
            	if(list.size() == 0) return false;
                if(")".equals(charStr) && list.get(list.size()-1).equals("(")) {
                    list.remove(list.get(list.size()-1));
                }
                if("}".equals(charStr) && list.get(list.size()-1).equals("{")) {
                    list.remove(list.get(list.size()-1));
                }
                if("]".equals(charStr) && list.get(list.size()-1).equals("[")) {
                    list.remove(list.get(list.size()-1));
                }
            }
 
        }
        return list.isEmpty();
    }
	
}

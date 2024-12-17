package com.nt;
import java.util.function.Predicate;
public class Predicate_char_At {

	public static void main(String[] args) {
		
		String []s= {"abhi","sonu","keshab"};
		Predicate <String>p= s2->s2.charAt(0)=='k';
   System.out.println("the strings starts with k are");
   for(String s1:s) {
	   if(p.test(s1)) {
		   System.out.println(s1);
	   }
	   
   }
	}

}

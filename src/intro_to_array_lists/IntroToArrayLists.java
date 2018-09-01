package intro_to_array_lists;

import java.util.ArrayList;

public class IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		ArrayList<String> fruits= new ArrayList<String>();
		
		fruits.add("Mango");
		fruits.add("Blueberry");
		fruits.add("Pineapple");
		fruits.add("Apple");
		fruits.add("Strawberry");
		//   Don't forget to import the ArrayList class
		
		//2. Add five Strings to your list
		
		//3. Print all the Strings using a standard for-loop
		for(int i=0; i<fruits.size(); i++) {
			String s=fruits.get(i);
			System.out.println("String at element " + i + " " + s);
			
		}
		//4. Print all the Strings using a for-each loop
		for(String s: fruits) {
			System.out.println(s);
		}
		//5. Print only the even numbered elements in the list.
		for(int i=0; i<fruits.size(); i++) {
			String s=fruits.get(i);
			if(i==2) {
				System.out.println(i+" "+s);
			}
			if(i==4) {
				System.out.println(i+" "+s);
			}
		
			
		}
		//6. Print all the Strings in reverse order.
		for(int i=fruits.size()-1; i>-1; i--) {
			String s=fruits.get(i);
			System.out.println(i+" "+s);
			}
			
			
		
		//7. Print only the Strings that have the letter 'e' in them.
		for(String s:fruits) {
			if(s.contains("e")) {
				System.out.println(s);
			}
	
		}
	}
}


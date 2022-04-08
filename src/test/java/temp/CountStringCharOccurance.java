package temp;

import java.util.HashMap;
import java.util.Map;

public class CountStringCharOccurance {
	
	public static void main(String[] args) {
		getOccu("manojKushwaha manoj");
	}

	public static void stringchar_occurance(String name) {
		Map<Character, Integer> char_Map=new HashMap<Character, Integer>();
		char arrayChar[] = name.toCharArray();
		for(char c:arrayChar) {
			if(char_Map.containsKey(c)) {
				char_Map.put(c,char_Map.get(c)+1);
			}else{
				   char_Map.put(c, 1);	
				}
			}
		System.out.println(name +"  "+ char_Map );
		}
	
	public static void getOccu(String name) {
		Map<Character, Integer> char_map = new HashMap<Character, Integer>();
		char charArra[] = name.toCharArray();

		for(char c:charArra){
		  if(char_map.containsKey(c)){
		  char_map.put(c,char_map.get(c)+1);
		  }else{
		      char_map.put(c,1);
		  }
		}
		System.out.println(name +"  "+ char_map);
		}
	
	public static void getStringOccurance(String name){
	    Map<Character,Integer> char_map=new HashMap<Character,Integer>();
	    char charArra[]=name.toCharArray();
	    for(char c: charArra){
	        if(char_map.containsKey(c)){
	            char_map.put(c,char_map.get(c)+1);
	        }else{
	           char_map.put(c,1); 
	        }
	    }
	    System.out.println(name +"  --  "+char_map);
	}
  }

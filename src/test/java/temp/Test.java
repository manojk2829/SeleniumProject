package temp;


import java.util.HashMap;
import java.util.Map;

public class Test{
public static void main(String[] args){
	getStringOccurance("manojkushwahamanoj");
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
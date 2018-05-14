package maptest.com.digital;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashTableAdd {
	public Hashtable<String,String> add(){
		Hashtable<String, String> table = new Hashtable<String, String>();
		for(int i=0;i<1000;i++){
			table.put(String.valueOf(i), "a"+String.valueOf(i));
		}
		return table;
		
		
		
	}

}

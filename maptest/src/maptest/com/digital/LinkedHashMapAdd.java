package maptest.com.digital;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapAdd {
	public Map<String,String> add(){
		 Map<String, String> map = new LinkedHashMap<String, String>();
		for(int i=0;i<1000;i++){
			map.put(String.valueOf(i), "a"+String.valueOf(i));
		}
		return map;
		
		
		
	}

}

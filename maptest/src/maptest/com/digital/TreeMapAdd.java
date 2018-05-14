package maptest.com.digital;

import java.text.CollationKey;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapAdd {
	MyComparator comparator = new MyComparator();  
	public Map<String,String> add(){
		 Map<String, String> map = new TreeMap<String, String>(comparator);
		for(int i=0;i<1000;i++){
			map.put(String.valueOf(i), "a"+String.valueOf(i));
		}
		return map;
		
		
		
	}
	static class MyComparator implements Comparator{  
		  
        @Override  
        public int compare(Object o1, Object o2) {  
            // TODO Auto-generated method stub  
            String param1 = (String)o1;  
            String param2 = (String)o2;  
         // return -param1.compareTo(param2); //倒序 
            return param1.compareTo(param2);  //正序       
        }  
          
    }  

}

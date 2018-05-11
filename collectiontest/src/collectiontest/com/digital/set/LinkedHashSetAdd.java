package collectiontest.com.digital.set;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class LinkedHashSetAdd {
	public LinkedHashSet<String> add(){
		LinkedHashSet<String> linkedhashset =  new LinkedHashSet();
		for(int i=0;i<120000;i++){
	
			linkedhashset.add(String.valueOf(i));
		}
		return linkedhashset;
	}
}

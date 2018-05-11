package collectiontest.com.digital.list;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class LinkedHashSetAdd {
	public LinkedHashSet<String> add(){
		LinkedHashSet<String> linkedhashset =  new LinkedHashSet();
		for(int i=0;i<120000;i++){
			int x=(int)(Math.random()*100);
			linkedhashset.add(String.valueOf(x));
		}
		return linkedhashset;
	}
}

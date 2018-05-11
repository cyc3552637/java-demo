package collectiontest.com.digital.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class HashSetAdd {
	public HashSet<String> add(){
		HashSet<String> hashset =  new HashSet();
		for(int i=0;i<120000;i++){
	
			hashset.add(String.valueOf(i));
		}
		return hashset;
	}
}

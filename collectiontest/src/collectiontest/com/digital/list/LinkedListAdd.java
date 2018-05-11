package collectiontest.com.digital.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListAdd {
	public List<String> add(){
		List<String> list =  new LinkedList<String>();;
		for(int i=0;i<120000;i++){
			int x=(int)(Math.random()*100);
			list.add(String.valueOf(x));
		}
		return list;
	}

}

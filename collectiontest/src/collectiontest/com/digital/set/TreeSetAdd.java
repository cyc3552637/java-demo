package collectiontest.com.digital.set;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class TreeSetAdd {
	public TreeSet<String> add(){
		TreeSet<String> treeset =  new TreeSet();
		for(int i=0;i<120000;i++){
			int x=(int)(Math.random()*100);
			treeset.add(String.valueOf(x));
		}
		return treeset;
	}
}

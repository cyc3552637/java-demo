package com.digital.test;

import java.util.ArrayList;
import java.util.List;

public class ListAdd {
	public List<String> add(){
		List<String> list = new ArrayList();
		for(int i=0;i<12000000;i++){
			int x=(int)(Math.random()*100);
			list.add(String.valueOf(x));
		}
		return list;
	}

}

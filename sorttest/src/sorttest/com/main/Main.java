package sorttest.com.main;

import java.util.Arrays;

import sorttest.com.digital.BubbleSort;
import sorttest.com.digital.HeapSort;
import sorttest.com.digital.InsertSort;
import sorttest.com.digital.MergingSort;
import sorttest.com.digital.QickSort;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
      int[] numbers  = new int[1000];
      for(int i=0;i<numbers.length;i++)
      {
    	numbers[i]=(int)(Math.random()*1000+1); //随机产生1到10之间的任意数，你可以改成你想要的随机产生的数，我这里是
      }
      System.out.println("original: "+Arrays.toString(numbers)); 
      
      Thread thread1=new Thread(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			 InsertSort is=new InsertSort();
		      is.insertSort(numbers);
		}
    	  
      };
      
      Thread thread2=new Thread(){

  		@Override
  		public void run() {
  			// TODO Auto-generated method stub
  			 BubbleSort bs=new BubbleSort();
  		      bs.bubbleSort(numbers);
  		}
      	  
        };
      Thread thread3=new Thread(){

    		@Override
    		public void run() {
    			// TODO Auto-generated method stub
    			 HeapSort hs=new HeapSort();
    			 hs.heapsort(numbers);
    		}
        	  
          };
      Thread thread4=new Thread(){

    		@Override
    		public void run() {
    			// TODO Auto-generated method stub
    			MergingSort ms=new MergingSort();
    		      ms.mergingSort(numbers);
    		}
        	  
          };
      Thread thread5=new Thread(){

    		@Override
    		public void run() {
    			// TODO Auto-generated method stub
    			QickSort qs=new QickSort();
    		      qs.quickSort(numbers);
    		}
        	  
          };
      thread1.start();
      thread2.start();
      thread3.start();
      thread4.start();
      thread5.start();
         
	}

}

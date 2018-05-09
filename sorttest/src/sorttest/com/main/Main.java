package sorttest.com.main;

import java.util.Arrays;
import java.util.Random;

import sorttest.com.digital.BinarySort;
import sorttest.com.digital.BubbleSort;
import sorttest.com.digital.BucketSort;
import sorttest.com.digital.HeapSort;
import sorttest.com.digital.InsertSort;
import sorttest.com.digital.MergingSort;
import sorttest.com.digital.QickSort;
import sorttest.com.digital.RadixSort;
import sorttest.com.digital.SelectionSort;
import sorttest.com.digital.ShellSort;
import sorttest.com.digital.StraightSort;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
      int[] numbers  = new int[1000];
      Random random = new Random();
      for(int i=0;i<numbers.length;i++)
      {
    	numbers[i]=(int)(random.nextInt(999)); //随机产生1到1000之间的任意数，你可以改成你想要的随机产生的数，我这里是
      }
      System.out.println("original: "+Arrays.toString(numbers)); 
      Thread insertsort=new Thread(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			 InsertSort is=new InsertSort();
		      is.insertSort(numbers);
		}
    	  
      };
      
      Thread bubblesort=new Thread(){

  		@Override
  		public void run() {
  			// TODO Auto-generated method stub
  			 BubbleSort bs=new BubbleSort();
  		      bs.bubbleSort(numbers);
  		}
      	  
        };
      Thread heapsort=new Thread(){

    		@Override
    		public void run() {
    			// TODO Auto-generated method stub
    			 HeapSort hs=new HeapSort();
    			 hs.heapsort(numbers);
    		}
        	  
          };
      Thread mergingsort=new Thread(){

    		@Override
    		public void run() {
    			// TODO Auto-generated method stub
    			MergingSort ms=new MergingSort();
    		      ms.mergingSort(numbers);
    		}
        	  
          };
      Thread qicksort=new Thread(){

    		@Override
    		public void run() {
    			// TODO Auto-generated method stub
    			QickSort qs=new QickSort();
    		      qs.quickSort(numbers);
    		}
        	  
          };
          
          Thread shellsort=new Thread(){

      		@Override
      		public void run() {
      			// TODO Auto-generated method stub
      			ShellSort ss=new ShellSort();
      			ss.shellSort(numbers);
      		}
          	  
            };
            Thread straightsort=new Thread(){

          		@Override
          		public void run() {
          			// TODO Auto-generated method stub
          			StraightSort sts=new StraightSort();
          			sts.straightSort(numbers);
          		}
              	  
                };
                Thread selectionsort=new Thread(){

              		@Override
              		public void run() {
              			// TODO Auto-generated method stub
              			SelectionSort sls=new SelectionSort();
              			sls.selectSort(numbers);
              		}
                  	  
                    };
                    Thread binarysort=new Thread(){

                  		@Override
                  		public void run() {
                  			// TODO Auto-generated method stub
                  			BinarySort bs=new BinarySort();
                  			bs.binarySort(numbers);
                  		}
                      	  
                        };
                    Thread bucketsort=new Thread(){

                      @Override
                         public void run() {
                      		// TODO Auto-generated method stub
                      	    BucketSort bks=new BucketSort();
                      	  bks.bucketSort(numbers);
                      	}
                          	 
                        };
                     Thread radixsort=new Thread(){

                         @Override
                          public void run() {
                           // TODO Auto-generated method stub
                           RadixSort rs=new RadixSort();
                            rs.redixSort(numbers);
                            	}
                                	 
                              };
      insertsort.start();
      bubblesort.start();
      heapsort.start();
      mergingsort.start();
      qicksort.start();
      shellsort.start();
      straightsort.start();
      selectionsort.start();
      binarysort.start();
      bucketsort.start();
      radixsort.start();
	}

}

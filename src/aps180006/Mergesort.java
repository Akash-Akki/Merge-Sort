package aps180006;

import java.util.Random;

public class Mergesort {
		public static Random random = new Random();
	    public static int numTrials = 1;
	    public static void main(String[] args) {
	    	int n=100000;  int choice=4;
	    	if(args.length > 0) { n = Integer.parseInt(args[0]); }
	    	if(args.length > 1) { choice = Integer.parseInt(args[1]); }
	        int[] arr = new int[n];
	        for(int i=0; i<n; i++) {
	        	arr[i] = i;
	        }
	        Timer timer = new Timer();
	        switch(choice) {
	        	case 1:
	        		for(int i=0; i<numTrials; i++) {
	        			Shuffle.shuffle(arr);
	        			mergeSorttake2(arr);
	        		}
	        		break;
	        	case 2:
	        		for(int i=0; i<numTrials; i++) {
	        			Shuffle.shuffle(arr);
	        			mergeSorttake3(arr);
	        		}
	        		break;
	        	case 3:
	        		for(int i=0; i<numTrials; i++) {
	        			Shuffle.shuffle(arr);
	        			mergeSorttake4(arr);
	        		}
	        		break;
	        	case 4:
	        		for(int i=0; i<numTrials; i++) {
	        			Shuffle.shuffle(arr);
	        			mergeSorttake6(arr);
	        		}
	        		break;	
	        }
	        timer.end();
	        timer.scale(numTrials);

	        System.out.println("Choice: " + choice + "\n" + timer);
	    }

	    public static void insertionSort(int[] arr,int p,int r) {
			for (int i = p; i <= r; i++) { 
				int key = arr[i]; 
				int j = i - 1; 

				/* Move elements of arr[0..i-1], that are 
	               greater than key, to one position ahead 
	               of their current position */
				while (j >= p && arr[j] > key) {
					arr[j + 1] = arr[j]; 
					j = j - 1;
				} 
				arr[j + 1] = key; 
			} 
	    }

	    public static void mergeSorttake2(int[] arr) {
	    	int[] arrB = new int[arr.length];
	    	mergeSorttake2(arr,arrB,0,arr.length-1);
	    }

	/**
	 *
	 * @param arr input array
	 * @param arrB new array same size as that of array arr
	 * @param p lower index of arr
	 * @param r higher index of arr
	 */
	public static void mergeSorttake2(int[] arr, int[] arrB, int p, int r) {
	    	if(p<r) {
	    		int q = (p + r)/2;
	    		mergeSorttake2(arr,arrB,p,q);
	    		mergeSorttake2(arr,arrB,q+1,r);
	    		merge2(arr,arrB,p,q,r);
	    	}
	    }

	/**
	 *
	 * @param arr    input array
	 * @param arrB   new array same size as that of array arr
	 * @param p      lower index of arr
	 * @param q      mid of array arr
	 * @param r      higher index of array arr
	 */

	public static void merge2(int[] arr, int[] arrB,int p, int q, int r) {
	    	System.arraycopy(arr, p, arrB, p, r-p+1);
	    	int i = p;
	    	int k = p;
	    	int j = q+1;
	    	while(i<=q && j<=r){
	    		if(arrB[i]<=arrB[j]) {
	    			arr[k++] = arrB[i++];
	    		}else {
	    			arr[k++] = arrB[j++];
	    		}
	    	}
	    	while(i<=q) {
	    		arr[k++] = arrB[i++];
	    	}
	    	while(j<=r) {
	    		arr[k++] = arrB[j++];
	    	}
	    	
	    }

	   /**
	   *
	   * @param arr input array
	   */
		public static void mergeSorttake3(int[] arr) {
			int[] arrB = new int[arr.length];
			System.arraycopy(arr, 0, arrB, 0, arr.length);
			mergeSorttake3(arr,arrB,0,arr.length-1);
	    }

	/**
	 *
	 * @param arr input array
	 * @param arrB new array same size as that of array arr
	 * @param p lower index of arr
	 * @param r higher index of arr
	 */
	public static void mergeSorttake3(int[] arr, int[] arrB, int p, int r) {
			if(p<r) {
	    		int q = (p + r)/2;
	    		mergeSorttake3(arrB,arr,p,q);
	    		mergeSorttake3(arrB,arr,q+1,r);
	    		merge3(arr,arrB,p,q,r);
	    	}
		}

	   /**
	   *
	   * @param arr    input array
	   * @param arrB   new array same size as that of array arr
	   * @param p      lower index of arr
	   * @param q      mid of array arr
	   * @param r      higher index of array arr
		**/

		public static void merge3(int[] arr, int[] arrB,int p, int q, int r) {
			int i = p;
	    	int k = p;
	    	int j = q+1;
	    	while(i<=q && j<=r){
	    		if(arrB[i]<=arrB[j]) {
	    			arr[k++] = arrB[i++];
	    		}else {
	    			arr[k++] = arrB[j++];
	    		}
	    	}
	    	while(i<=q) {
	    		arr[k++] = arrB[i++];
	    	}
	    	while(j<=r) {
	    		arr[k++] = arrB[j++];
	    	}
		}

	/**
	 *
	 * @param arr input array arr
	 */
		public static void mergeSorttake4(int[] arr) {
			int[] arrB = new int[arr.length];
			System.arraycopy(arr, 0, arrB, 0, arr.length);
			mergeSorttake4(arr,arrB,0,arr.length-1);
		}

	/**
	 *
	 * @param arr   input array arr
	 * @param arrB  array of same size as of lenght array arr
	 * @param p     lower index of input array arr
	 * @param r     higher index of input array arr
	 */
		public static void mergeSorttake4(int[] arr, int[] arrB, int p, int r) {
			int T = 20;
			if(r-p+1 < T){
				insertionSort(arr,p,r);
			}else if(p<r) {
	    		int q = (p + r)/2;
	    		mergeSorttake4(arrB,arr,p,q);
	    		mergeSorttake4(arrB,arr,q+1,r);
	    		merge3(arr,arrB,p,q,r); //Reusing the merge3() as it has similar required usage
	    	}
		}

	/**
	 *
	 * @param arr input array arr
	 */
	public static void mergeSorttake6(int[] arr) {
			int[] arrB = new int[arr.length];
			int[] inp = arr;
			int n = arr.length;
			int T = 100;
			for( int j=0; j<n; j = j + T) {
				if(j+T-1>n-1)
					insertionSort(arr,j,n-1);
				insertionSort(arr,j,j+T-1);
			}
			
			for(int i=T;i<n;i=2*i) {
				for(int j=0;j<n;j=j+2*i) {
					int mid =Math.min(j+i-1,n-1);
					int last = Math.min(j+2*i-1,n-1);
					merge3(arrB,inp,j,mid,last);
				}
				int[] temp = inp;
				inp = arrB;
				arrB = temp;
			}
			
			if(arr!=inp) {
				System.arraycopy(inp, 0, arr, 0, arr.length);
			}
		}
		

	   /** Timer class for roughly calculating running time of programs
	     *  @author rbk
	     *  Usage:  Timer timer = new Timer();
	     *          timer.start();
	     *          timer.end();
	     *          System.out.println(timer);  // output statistics
	     */

	    public static class Timer {
	        long startTime, endTime, elapsedTime, memAvailable, memUsed;
	        boolean ready;

	        public Timer() {
	            startTime = System.currentTimeMillis();
	            ready = false;
	        }

	        public void start() {
	            startTime = System.currentTimeMillis();
	            ready = false;
	        }

	        public Timer end() {
	            endTime = System.currentTimeMillis();
	            elapsedTime = endTime-startTime;
	            memAvailable = Runtime.getRuntime().totalMemory();
	            memUsed = memAvailable - Runtime.getRuntime().freeMemory();
	            ready = true;
	            return this;
	        }

	        public long duration() { if(!ready) { end(); }  return elapsedTime; }

	        public long memory()   { if(!ready) { end(); }  return memUsed; }

	        public void scale(int num) { elapsedTime /= num; }
		
	        public String toString() {
	            if(!ready) { end(); }
	            return "Time: " + elapsedTime + " msec.\n" + "Memory: " + (memUsed/1048576) + " MB / " + (memAvailable/1048576) + " MB.";
	        }
	    }
	    
	    /** @author rbk : based on algorithm described in a book
	     */


	    /* Shuffle the elements of an array arr[from..to] randomly */
	    public static class Shuffle {
		
	    	public static void shuffle(int[] arr) {
	    		shuffle(arr, 0, arr.length-1);
	    	}

	    	public static<T> void shuffle(T[] arr) {
	    		shuffle(arr, 0, arr.length-1);
	    	}

	    	public static void shuffle(int[] arr, int from, int to) {
	    		int n = to - from  + 1;
	    		for(int i=1; i<n; i++) {
	    			int j = random.nextInt(i);
	    			swap(arr, i+from, j+from);
	    		}
	    	}

	    	public static<T> void shuffle(T[] arr, int from, int to) {
	    		int n = to - from  + 1;
	    		Random random = new Random();
	    		for(int i=1; i<n; i++) {
	    			int j = random.nextInt(i);
	    			swap(arr, i+from, j+from);
	    		}
	    	}

	    	static void swap(int[] arr, int x, int y) {
	    		int tmp = arr[x];
	    		arr[x] = arr[y];
	    		arr[y] = tmp;
	    	}
		
	    	static<T> void swap(T[] arr, int x, int y) {
	    		T tmp = arr[x];
	    		arr[x] = arr[y];
	    		arr[y] = tmp;
	    	}

	    	public static<T> void printArray(T[] arr, String message) {
	    		printArray(arr, 0, arr.length-1, message);
	    	}

	    	public static<T> void printArray(T[] arr, int from, int to, String message) {
	    		System.out.print(message);
	    		for(int i=from; i<=to; i++) {
	    			System.out.print(" " + arr[i]);
	    		}
	    		System.out.println();
	    	}
	    }		 
}


import java.util.Arrays;
import java.util.Random;


public class Lab5{

    public static void main(String[] args)
    {
    	int[] a = new int[50];
    	Random rnd = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = 1 + rnd.nextInt(a.length-1);
		}

		System.out.println();
		System.out.print("S�ralanmam�� Dizi:");
        for (int x = 0; x < a.length; x++)
        {
        	System.out.print(a[x]);
            if (x <= a.length - 2) System.out.print(",");
        }

        int[] B = Arrays.copyOf(a, a.length);
        int[] C = Arrays.copyOf(a, a.length);
        int[] D = Arrays.copyOf(a, a.length);
        
        System.out.println();
       
        int max = B[0];
        for (int i = 1; i < B.length; i++) {
          if (B[i] > max)
            max = B[i];
        }
        
		long startTime3 = System.nanoTime();
		countSort(B, B.length,max);
		System.out.println();
		long endTime3 = System.nanoTime();
		long estimatedTime3 = endTime3 - startTime3;
		System.out.print("S�ralanm�� Dizi: " );
		diziYaz(B); 
		System.out.println();
		countekdizi(D,D.length);
		System.out.println();
		System.out.println("Counting sort �al��ma zaman�: " + estimatedTime3 + " Nanosaniye");
		
		
        long startTime2 = System.nanoTime();
		sort(C, 0, C.length-1);
		long endTime2 = System.nanoTime();
		long estimatedTime2 = endTime2 - startTime2;
		System.out.println();
		System.out.println("Quicksort �al��ma zaman�: " + estimatedTime2 + " Nanosaniye");

    }

 
    static void diziYaz(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
        	System.out.print(arr[i] + " ");
        	
        }
    	System.out.println();

    }

  
    static int partition(int arr[], int alt, int ust) 
    { 
        int pivot = arr[ust];  
        int i = (alt-1);
        for (int j=alt; j<ust; j++) 
        { 
       
            if (arr[j] < pivot) 
            { 
                i++; 
  
             
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
 
        int temp = arr[i+1]; 
        arr[i+1] = arr[ust]; 
        arr[ust] = temp; 
  
        return i+1; 
    } 
  
 
    static void sort(int arr[], int alt, int ust) 
    {
        if (alt < ust) 
        { 
         
            int pi = partition(arr, alt, ust); 
            sort(arr, alt, pi-1); 
            sort(arr, pi+1, ust); 
        } 
    } 
    
    
    
   static void countSort(int array[], int size, int max) {
        int[] output = new int[size + 1];


        int[] count = new int[max + 1];

        for (int i = 0; i < max; ++i) {
          count[i] = 0;
        }

        for (int i = 0; i < size; i++) {
          count[array[i]]++;
        }

        for (int i = 1; i <= max; i++) {
          count[i] += count[i - 1];
        }

       
        for (int i = size - 1; i >= 0; i--) {
         output[count[array[i]] - 1] = array[i];
          count[array[i]]--;
        }

        for (int i = 0; i < size; i++) {
          array[i] = output[i];
        }
        
    

      }
   
   
   static void countekdizi(int array[], int size ) {
       
	   int max = array[0];
       for (int i = 1; i < size; i++) {
         if (array[i] > max)
           max = array[i];
       }
	   
	   int[] output = new int[size + 1];


       int[] count = new int[max + 1];

       for (int i = 0; i < max; ++i) {
         count[i] = 0;
       }

       for (int i = 0; i < size; i++) {
         count[array[i]]++;
       }

       for (int i = 1; i <= max; i++) {
         count[i] += count[i - 1];
       }

      
       for (int i = size - 1; i >= 0; i--) {
        output[count[array[i]] - 1] = array[i];
         count[array[i]]--;
       }

       for (int i = 0; i < size; i++) {
         array[i] = output[i];
       }
       
   	System.out.print("Ek Dizi 1: " );
		diziYaz(output); 
		System.out.println();
		System.out.print("Ek Dizi 2: " );
		diziYaz(count); 

     }
}

public class Sorts{

    public static String name(){
	return "06.Tung.Donia";
    }


  /**Selection sort of an int array. 
  *Upon completion, the elements of the array will be in increasing order.
  *@param data  the elements to be sorted.
  */
  public static void selectionSort(int[] data){
      int smallest;
      int holder;
      int index;
      for (int i = 0; i < data.length; i++){
	  smallest = data[i];
	  index = i;
	  for (int j = i; j < data.length; j++){
	      if (smallest > data[j]){
		  smallest = data[j];
		  index = j;
	      }
	  }
	  holder = data[i];
	  data[i] = smallest;
	  data[index] = holder;
      }
  }

    public static void insertionSort(int[] data){
	int num;
	for (int i = 1; i < data.length; i++){
	    num = data[i];
	    int counter = i; 
	    while (counter > 0 && num < data[counter - 1]){
		    data[counter] = data[counter - 1];
		    counter --;
	    }
	    data[counter] = num;
	}
    }


    public static void main (String[]args){
	int[] x = {4,2,6,8,12};
	System.out.print("Original : [");
	for (int i = 0; i < x.length; i++){
	    System.out.print(x[i]+ ",");
	}
	System.out.println("]");
	insertionSort(x);
        System.out.print("Sorted : [");
	for (int i = 0; i < x.length; i++){
	    System.out.print(x[i]+ ",");
	}
	System.out.println("]\n");

	int[] y = {20,18,14,3,1};
	System.out.print("Original : [");
	for (int i = 0; i < y.length; i++){
	    System.out.print(y[i]+ ",");
	}
	System.out.println("]");
	insertionSort(y);
        System.out.print("Sorted : [");
	for (int i = 0; i < y.length; i++){
	    System.out.print(y[i]+ ",");
	}
	System.out.println("]");
    }

}


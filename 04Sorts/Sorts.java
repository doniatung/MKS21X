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
      int[] temp = new int[data.length];
      for (int i = 0; i < data.length; i++){
	  smallest = data[i];
	  for (int j = i; j < data.length; j++){
	      if (smallest > data[j]){
		  smallest = data[j];
	      }
	  } 
      }
      data = temp;
  }

    public static void main (String[]args){
	int[] x = {4,2,6,8,12};
	System.out.println(x);
	selectionSort(x);
	System.out.println(x);
    }

}


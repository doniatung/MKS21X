import java.util.Iterator;
import java.util.NoSuchElementException;


public class SuperArray implements Iterable<String> {
    private String[] data;
    private int size;

    public SuperArray(){
	data = new String[10];
	size = 0;
    }

    public SuperArray(int initialCapacity){
	if (initialCapacity < 0){
	    throw new IllegalArgumentException();
	}
	data = new String[initialCapacity];
      	size = 0;
    }

    public Iterator<String> iterator(){
	return new SuperArrayIterator(this);
    }
	
	

    public int size(){
	return size;
    }


    public String get(int index){ 
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException(""+ index);
	}
	return data[index];
    }
    
    public void add(String n){
       	if (size >= data.length){
	    grow();
	}
	data[size] = n;
	size ++; 
    }

    public void grow(){ 
	String[] temp = new String[size * 2 + 1];
	for (int i = 0; i < size; i ++){
	    temp[i] = get(i);
	}
	data = temp;
    }

    public String toString(){
	String ans = "[";
       	for (int i = 0; i < data.length-1; i ++){
	    ans += data[i] + ", ";
	}
        ans += data[data.length-1] + "]";
	return ans; 
    }

    public String toStringDebug(){
        String[] nueva = new String[size];
	for (int i = 0; i < size; i ++){
	    nueva[i] = data[i];
	}
	return nueva.toString();
    }

    public  void clear(){
	String[] x = new String[data.length];
	data = x;
	size = 0;
    }


    public boolean isEmpty(){
	return size == 0;
    }

    public String set(int index, String element){ 
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
       	String x = data[index];
	data[index] = element;
	return x;
    }


    public void add(int index, String element){
	if (index < 0 || index > size){
	    throw new IndexOutOfBoundsException(index +"");
	}
	if (size ++ > data.length){
	    grow();
	}
	String[] nueva = new String[data.length+1];
	if (size() == 0 && index == 0){
	    nueva[0] = element;
	}
	else {
	    for (int i = 0; i < index; i ++){
		nueva[i] = get(i);
	    }
	    nueva[index] = element;
	    if (size() > index + 1){
		for (int i = index; i < size(); i ++){
		    nueva[i+1] = get(i);
		}
	    }
	}
	data = nueva;
	size ++;
    }

    public String remove(int index){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	String[] nueva = new String[data.length-1];
	String x = data[index];
	for (int i = 0; i < index; i ++){
	    nueva[i] = get(i);
	}
	for (int i = index; i < data.length-1; i ++){
	    nueva[i] = get(i+1);
	}
	data = nueva;
	size --;
      	return x;
    }

    public String[] toArray(){
        String[] temp = new String[size];
	for (int i = 0; i < temp.length; i ++){
	    temp[i] = data[i];
	}
	return temp;
    }


    public int indexOf(String o){
	int ans = -1;
	int i = 0;
	while (i < size){
	    if (get(i) == o){
		ans = i;
		i = size;
	    }
	    i ++;
	}
	return ans;
    }

    public int lastIndexOf(String o){
	int ans = 0;
	for (int i = 0; i < data.length; i ++){
	    if (get(i) == o){
		ans = i;
	    }
	}
       return ans;
    }

    public void trimToSize(){
	data = toArray();
    }

    
    public static void main(String[]args){
    SuperArray ary = new SuperArray();
    for (int i = 0; i < 10; i ++){
	ary.add(i+ "");
    }
    System.out.println(ary.toString());
    System.out.println(ary.size());
    for (int i = 0; i < 10; i ++){
       	ary.add(i,10-i+ "");
    }
    System.out.println(ary.toString());
    System.out.println(ary.size());
    for (int i = 0; i < 10; i ++){
	ary.remove(i);
    }
    System.out.println(ary.toString());
    for (int i = 0; i < 5; i ++){
	System.out.println(ary.lastIndexOf(ary.get(i)));
    }
    ary.clear();
    System.out.println(ary.toString());
    System.out.println(ary.toArray());
    System.out.println(ary.size());
    ary.add(5+"");
    System.out.println(ary);
    ary.trimToSize();
    System.out.println(ary.toString());
    
}
}

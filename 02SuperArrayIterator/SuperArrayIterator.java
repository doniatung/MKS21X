import java.util.Iterator;
import java.util.NoSuchElementException;

public class SuperArrayIterator implements Iterator<String>{

    private SuperArray ary;

    private int start;

    public SuperArrayIterator(int start){
	this.start = start;
    }

    public boolean hasNext(){
        return ary.size() - start > 0;
    }
    
    
    public String next(){
	if (hasNext()){
	    start ++;
	    return ary.get(start-1);
	}
	else {
	    throw new NoSuchElementException();
	}
    }


    public void remove(){
	throw new UnsupportedOperationException();
    }

}

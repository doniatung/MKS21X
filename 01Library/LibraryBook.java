abstract Class LibraryBook extends Book implements Comparable{

    private String callNumber;

    public LibraryBook(String author, String title, String ISBN, String callNumber){
	super();
	this.callNumber = callNumber;
    }

    
    
    public String getCallNumber(){
	return callNumber + "";
    }

    public void setCallNumber(String callNumber){
	this.callNumber = callNumber;
    }

    public void checkout(String patron, String due){
    }
    

    public boolean returned(){
    }

    public String circulationStatus(){
    }

    public int compareTo(){
    }
    //gotta write this soon 
    public String toString(){
	return super.toString() + "\nCall Number: " + callNumber;
    }
    

    }

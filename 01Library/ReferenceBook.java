public Class ReferenceBook extends LibraryBook{

    private String collection;

    public ReferenceBook(String author, String title, String ISBN, String callNumber, String collection){
	super();
	this.collection = collection;
    }

    public String getCollection(){
	return collection + "";
    }

    public void setCollection(String collection){
	this.collection = collection;
    }

    //Checkout


    //Returned


    //Circulation Status

    public String toString(){
	return super.toString()+ "\n Collection: " + collection;
    }

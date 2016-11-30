public class CirculatingBook{

    private String patron;
    private String dueDate;

    public CirculatingBook(String author, String title, String ISBN, String callNumber){
	super();
    }

    public String getPatron(){
	return patron + "";
    }
    public String getDueDate(){
	return dueDate + "";
    }

    public void getPatron(String patron){
	this.patron = patron;
    }
    public void getDueDate(String dueDate){
	this.dueDate = dueDate;
    }

    public void checkout(){
    }

    public void returned(boolean returned){
    }

    public String circulationStatus(){
    }

    public String toString(){
        String x = super.toString();
	if (patron != "null"){
	    x += "\n Patron: " + patron;
	}
	if (dueDate != "null"){
	    x += "\n Due: " + dueDate;
	}
	return x;
    }

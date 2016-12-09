public class Barcode implements Comparable<Barcode>{
// instance variables
   private String _zip;
   private int _checkDigit;

// constructors
//precondtion: _zip.length() = 5 and zip contains only digits.
//postcondition: throws a runtime exception zip is not the correct length
//               or zip contains a non digit
//               _zip and _checkDigit are initialized.
  public Barcode(String zip) {
      if (zip.length() != 5){
	  throw new RuntimeException();
      }
      else{
	  _zip = zip;
	  _checkDigit = checkSum(_zip) % 10;
      }
  }

     
// postcondition: computes and returns the check sum for _zip
  private static int checkSum(String zip){
      int ans = 0;
      for (int i = 0; i < zip.length(); i ++){
	  ans += (int) zip.charAt(i);
      }
      return ans;
  }
    

//postcondition: format zip + check digit + Barcode 
//ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
  public String toString(){
      return _zip + _checkDigit + "   " + toCode(_zip);
  }


// postcondition: compares the zip + checkdigit, in numerical order. 
  public int compareTo(Barcode other){
      String thisZip = _zip + _checkDigit;
      String otherZip = other._zip + other._checkDigit;
      return thisZip.compareTo(otherZip);
  }



    public static String toCode(String zip){
	String ans = "|";
	if (zip.length() != 5){
	    throw new IllegalArgumentException();
	}
	else{
	    zip += checkSum(zip) % 10;
	    for (int i = 0; i < zip.length(); i ++){
		char num = zip.charAt(i);
		String x;
		switch (num){
		case '1': x = ":::||";
		    break;
		case '2': x = "::|:|";
		    break;
		case '3': x = "::||:";
		    break;
		case '4': x = ":|::|";
		    break;
		case '5': x = ":|:|:";
		    break;
		case '6': x = ":||::";
		    break;
		case '7': x = "|:::|";
		    break;
		case '8': x = "|::|:";
		    break;
		case '9': x = "|:|::";
		    break;
		case '0': x = "||:::";
		    break;
		default: x = "smthg";
		    break;
		}
		ans += x; 
	    }
	}
      return ans + "|";
    }


    public static String toZip(String code){
	String zip = "";
	if (code.length() != 32){
	    throw new IllegalArgumentException("Please make sure you have 32 characters in your code");
	}
	if (code.charAt(0) != '|'){
	    throw new IllegalArgumentException("Please make sure your code starts with a bar");
	}
	if (code.charAt(code.length()-1) != '|'){
	    throw new IllegalArgumentException("Left and rightmost characters are not '|'");
	}
	//if (checkSum fails) I'm not sure if checkSum is supposed to be printed or not
	//invalid characters?
	else{
	    int i = 1;
	    while (i < code.length()-11){
		String numCode = code.substring(i,i+5);
		switch(numCode){
		case  ":::||": zip += 1;
		    break;
		case "::|:|": zip += 2;
		    break;
		case "::||:": zip += 3;
		    break;
		case ":|::|": zip += 4;
		    break;
		case ":|:|:": zip += 5;
		    break;
		case ":||::": zip += 6;
		    break;
		case "|:::|": zip += 7;
		    break;
		case "|::|:": zip += 8;
		    break;
		case "|:|::": zip += 9;
		    break;
		case "||:::": zip += 0;
		    break;
		default: throw new IllegalArgumentException("Please make sure you don't have a pattern mismatch");
		    // break;
		}
        	i += 5;
	    }
	}
	if (zip.charAt(5) != checkSum(zip.substring(0,5)) % 10){
	    throw new IllegalArgumentException("Faulty Barcode- your checkDigit is wrong");
	}
	else{
	    return zip;
	}
    }

    public static void main (String[]args){
	Barcode x = new Barcode("08123");
	System.out.println(x);
	System.out.println(toCode("12345"));
	String y = x.toString();
	System.out.println(y);
	System.out.println(y.length());
	System.out.println(toZip(y.substring(10)));

    }
}


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
	  _checkDigit = checkSum % 10;
      }
  }

     
// postcondition: computes and returns the check sum for _zip
  private int checkSum(){
      int ans = 0;
      for (int i = 0; i < _zip.length(); i ++){
	  ans += (int) _zip.charAt(i);
      }
      return ans;
  }


    

//postcondition: format zip + check digit + Barcode 
//ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
  public String toString(){
      return _zip + checkDigit + "   " + toCode(_zip);
  }


// postcondition: compares the zip + checkdigit, in numerical order. 
  public int compareTo(Barcode other){
      String thisZip = _zip + _checkDigit;
      String otherZip = other._zip + other._checkDigit;
      
      return thisZip.compareTo(otherZip);
	  }

    public static String toCode(String zip){
	if (zip.length() != 5){
	    throw new IllegalArgumentException();
	}
	else{
	    String ans = "|";
	    for (int i = 0; i < zip.length(); i ++){
		int num = zip.charAt(i);
		switch (num){
		case 1: ans += ":::||";
		    break;
		case 2: ans += "::|:|";
		    break;
		case 3: ans += "::||:";
		    break;
		case 4: ans += ":|::|";
		    break;
		case 5: ans += ":|:|:";
		    break;
		case 6: ans += ":||::";
		    break;
		case 7: ans += "|:::|";
		    break;
		case 8: ans += "|::|:";
		    break;
		case 9: ans += "|:|::";
		    break;
		case 0: ans += "||:::";
		    break;
		default: ans += "smthg";
		    break;
		}
	    }
	}
      return ans + "|";
    }


    public static String toZip(String code){
	if (code.length() != 32){
	    throw new IllegalArgumentException("Please make sure you have 32 characters in your code");
	}
	if (code.charAt(0) != "|"){
	    throw new IllegalArgumentException("Please make sure your code starts with a bar");
	}
	//if (checkSum fails) I'm not sure if checkSum is supposed to be printed or not
	//invalid characters?
	else{
	    String zip = "";
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
		    break;
		}
        	i += 5;
	    }
	}
	return ans;
    }

    
}

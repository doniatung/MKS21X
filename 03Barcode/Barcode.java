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

      

// postcondition: Creates a copy of a bar code.
  public Barcode clone(){
      Barcode clonedBc = new Barcode(_zip);
      return clonedBc; 
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
      String ans = _zip + checkDigit + "  |";
      for (int i = 0; i < _zip.length(); i ++){
	  int num = _zip.charAt(i);
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
      return ans;

  }


// postcondition: compares the zip + checkdigit, in numerical order. 
  public int compareTo(Barcode other){
      String thisZip = _zip + _checkDigit;
      String otherZip = other._zip + other._checkDigit;
      
      return thisZip.compareTo(otherZip);
	  }
    
}

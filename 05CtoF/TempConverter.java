public class TempConverter{

    public static int CtoF(double t){
	return (t*9)/5 + 32;
    }

    public static double FtoC(double t){
	return (t - 32) * 5 / 9;
    }

}

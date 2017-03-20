
public class BMI {
	public double calc(double weight,double height){
		try {
			double bmi=weight/(height*height);
			return bmi;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;

		}
		
	}
}	

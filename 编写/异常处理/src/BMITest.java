
public class BMITest {
	public static void main(String[] args) {
		try {
		BMI bmi=new BMI();
		double result=bmi.calc(100, 0);
		System.out.println(result);
		
		Calculartor ca=new Calculartor();
		
			ca.calc(12, 0);
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("");
		}
	}
}

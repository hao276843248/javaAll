import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Text4 {
	public static void main(String[] args) throws ParseException {
		Scanner input=new Scanner(System.in);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date str=sdf.parse(input.next());
		System.out.println(sdf.format(str));
	}
}

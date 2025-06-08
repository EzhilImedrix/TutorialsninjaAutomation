package temp;

import java.util.Date;

public class GenerateEmailDemo {

	public static void main(String[] args) {
		Date date = new Date();
		String dateString=date.toString();
		String NoSpaceDateString=dateString.replaceAll(" ", "");
		String NoSpaceAndNoColondateString=NoSpaceDateString.replaceAll(":", "");
		String EmailWithTimeStamp=NoSpaceAndNoColondateString+"@gmail.com" ;
		System.out.println(EmailWithTimeStamp);
	}}








































/*Date date = new Date();
String dateString =date.toString();
String NoSpaceDateString = dateString.replaceAll(" ","");
String NoSpaceAndnoColonsDateString = NoSpaceDateString.replaceAll(":", "");
String EmailWithTimeStamp=NoSpaceAndnoColonsDateString+"@gmail.com";
System.out.println(EmailWithTimeStamp);*/

package ebond.market;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class BondPriceCalc {

	public static long countNoOfDays(Date startDate,Date endDate){

		long noOfDays = endDate.getTime() - startDate.getTime();
		return noOfDays/(60*60*24*1000);

	}

	public static double calcCashFlow(double coupon, double fv){

		return (coupon*fv/100);

	}

	public static double calcPresentValue(double fv, double ytm, int noOfYears, double cf){

		double pv=0.0;

		for(int i=1;i<=noOfYears;i++){
			pv+=cf/Math.pow((1+ytm/100),i);
		}

		pv+=fv/Math.pow((1+ytm/100),noOfYears);

		return pv;
	}

	public static double calcAccruedInterest(Date issueDate, Date settlementDate, double cf){

		double accruedInterest;
		Calendar cal = Calendar.getInstance();
		cal.setTime(issueDate);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(settlementDate);
		int year = cal1.get(Calendar.YEAR);
		Calendar cal2 = Calendar.getInstance();
		cal2.set(Calendar.YEAR, year);
		cal2.set(Calendar.MONTH, month);
		cal2.set(Calendar.DAY_OF_MONTH,day);
		
		Date accruedDate = cal2.getTime();
		long noOfDays=countNoOfDays(accruedDate,settlementDate);
		accruedInterest = noOfDays*cf/(360);
		return accruedInterest;

	}

	public static double calcDirtyPrice(double cleanPrice, double accruedInterest){

		double dirtyPrice;
		dirtyPrice = cleanPrice + accruedInterest;
		return dirtyPrice;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double faceValue;	// from database
		double lastPrice;	// from database
		double couponRate;	// from database

		String stDate;   // from database
		String setDate;	//user Input
		String matDate;		// from database


		double yieldToMaturity;	//User Input


		double presentValue; 	// calculate
		double cashFlow;		// calculate
		double dirtyPrice;		// calculate
		double accruedInterest;	// calculate

		long noOfDays;
		int noOfYears;

		Date startDate;	
		Date settlementDate;
		Date maturityDate;



		Scanner s=new Scanner(System.in);

		// Input settlement date (user) 
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/M/yyyy");
		System.out.println("enter settlement date in format dd/mm/yyyy");
		setDate=s.next();

		// Input start date (database) in String format
		System.out.println("enter bond issue date in format dd/mm/yyyy");
		stDate=s.next();

		// Input maturity date (database) in String format
		System.out.println("enter maturity date in format dd/mm/yyyy");
		matDate=s.next();

		// Input Face Value (database)

		System.out.println("Enter Face Value");
		faceValue=s.nextDouble();

		// Input Last Price (database)

		System.out.println("Enter Last Price");
		lastPrice=s.nextDouble();

		// Input coupon rate (database)

		System.out.println("Enter Coupon Rate");
		couponRate=s.nextDouble();

		// Input Yield to Maturity from the user

		System.out.println("Enter yield to maturity");
		yieldToMaturity=s.nextDouble();


		try {
			startDate = dateformat.parse(stDate);
			settlementDate = dateformat.parse(setDate);
			maturityDate = dateformat.parse(matDate);
			noOfDays=countNoOfDays(settlementDate,maturityDate);
			if(noOfDays<0){
				System.out.println("Date not correct");
			}
			else{

				//	 System.out.println("No of Days= "+ noOfDays);
				noOfYears=(int) Math.ceil(noOfDays/365.0); 
				cashFlow = calcCashFlow( couponRate, faceValue);
				presentValue = calcPresentValue( faceValue, yieldToMaturity, noOfYears, cashFlow);	
				accruedInterest=calcAccruedInterest(startDate,settlementDate, cashFlow);
				dirtyPrice=calcDirtyPrice(lastPrice, accruedInterest);		
				System.out.println("No of Days= "+ noOfDays);
				System.out.println("No of years= "+ noOfYears);
				System.out.println("Cash Flow= "+ cashFlow);
				System.out.println("Present Value= "+ presentValue);
				System.out.println("accrued interest= "+ accruedInterest);
				System.out.println("dirty price= "+ dirtyPrice);
				

			}


		} catch (ParseException e) {	
			//	 System.out.println("error in date!!!!");
			e.printStackTrace();
		}





	}

}

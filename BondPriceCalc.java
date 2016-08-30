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

		return (Math.round((coupon*fv/100)*1000))/1000.0;

	}

	public static double calcPresentValue(double fv, double ytm, int noOfYears, double cf){

		double pv=0.0;

		for(int i=1;i<=noOfYears;i++){
			pv+=cf/Math.pow((1+ytm/100),i);
		}

		pv+=fv/Math.pow((1+ytm/100),noOfYears);

		return (Math.round(pv*1000))/1000.0;
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
		return (Math.round(accruedInterest*1000))/1000.0;

	}

	public static double calcDirtyPrice(double presentValue, double accruedInterest){

		double dirtyPrice;
		dirtyPrice = presentValue + accruedInterest;
		return (Math.round(dirtyPrice*1000))/1000.0;

	}
	
	public static double calcSettledAmount(int quantity, double dirtyPrice){
		return (Math.round((quantity*dirtyPrice)*1000))/1000.0;
	}
	
	public static double calcYield(int noOfYears, double presentValue, double faceValue,double cashFlow){
		double yield=200*(cashFlow+(faceValue-presentValue)/noOfYears)/(faceValue+presentValue);
		return (Math.round(yield*1000))/1000.0;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double faceValue=100.0;	// 
		double couponRate;	// from database
		
		

		String stDate;   // from database
		String trDate;	//user Input
		String matDate;		// from database


		double yieldToMaturity;	//User Input


		double presentValue; 	// calculate
		double cashFlow;		// calculate
		double dirtyPrice;		// calculate
		double accruedInterest;	// calculate

		long noOfDays;
		int noOfYears;

		Date startDate;	
		Date tradeDate;
		Date settlementDate;
		Date maturityDate;
		
		int quantity;
		double settledAmount;
		
		double yield;



		Scanner s=new Scanner(System.in);

		// Input settlement date (user) 
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/M/yyyy");
		System.out.println("enter trade date in format dd/mm/yyyy");
		trDate=s.next();

		// Input start date (database) in String format
		System.out.println("enter bond issue date in format dd/mm/yyyy");
		stDate=s.next();

		// Input maturity date (database) in String format
		System.out.println("enter maturity date in format dd/mm/yyyy");
		matDate=s.next();
		
		

		// Input Face Value (database)

		//System.out.println("Enter Face Value");
		//faceValue=s.nextDouble();

		// Input Last Price (database)

		//System.out.println("Enter Last Price");
		//lastPrice=s.nextDouble();

		// Input coupon rate (database)

		System.out.println("Enter Coupon Rate");
		couponRate=s.nextDouble();

		// Input Yield to Maturity from the user

		System.out.println("Enter yield to maturity");
		yieldToMaturity=s.nextDouble();
		
		// Input quntity in integer format
		System.out.println("enter quantity");
		quantity=s.nextInt();


		try {
			startDate = dateformat.parse(stDate);
			tradeDate = dateformat.parse(trDate);
			maturityDate = dateformat.parse(matDate);
			
			// add 2 days to trade date to calculate settlement date
			Calendar cal = Calendar.getInstance(); 
			cal.setTime(tradeDate);
			cal.add(Calendar.DATE, 2);
			
			settlementDate=cal.getTime();
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
				dirtyPrice=calcDirtyPrice(presentValue, accruedInterest);
				settledAmount=calcSettledAmount(quantity, dirtyPrice);
				yield=calcYield(noOfYears, presentValue, faceValue, cashFlow);
				
				// Print all variables
				System.out.println(settlementDate);
				System.out.println("No of Days= "+ noOfDays);
				System.out.println("No of years= "+ noOfYears);
				System.out.println("Cash Flow= "+ cashFlow);
				System.out.println("Clean Pricee= "+ presentValue);
				System.out.println("accrued interest= "+ accruedInterest);
				System.out.println("dirty price= "+ dirtyPrice);
				System.out.println("Settled Amount = " + settledAmount);
				System.out.println("calculated ytm = " + yield);

			}


		} catch (ParseException e) {	
			//	 System.out.println("error in date!!!!");
			e.printStackTrace();
		}
		s.close();




	}

}

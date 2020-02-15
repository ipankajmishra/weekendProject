package p1.runtimepoly;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateFactory {
	
	static Adaytodate ob[];
    static {
	ob= new Adaytodate[5];
	
	ob[0] =(String dt, String dt1)->{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(sdf.parse(dt));
		} catch (ParseException e) {
			
			//throw new Exception(e.getMessage());
		}
		//System.out.println("hello"+" "+c.get(Calendar.DATE));
		c.add(Calendar.DATE, Integer.valueOf(dt1));
		//System.out.println("ME : "+sdf.format(c.getTime()));
		return sdf.format(c.getTime());  
	};
	
	ob[1] =(String dt, String dt1)->{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(sdf.parse(dt));
		} catch (ParseException e) {
			
			//throw new Exception(e.getMessage());
		}
		//System.out.println("hello2"+" "+c.get(Calendar.DATE));
		c.add(Calendar.DATE,-1* Integer.valueOf(dt1));
		//System.out.println("ME : "+sdf.format(c.getTime()));
		return sdf.format(c.getTime());  
	};
	
	ob[2]=(String dt1, String dt2)-> {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Calendar c = Calendar.getInstance();
		Calendar c1 = Calendar.getInstance();
		try{
			c.setTime(sdf.parse(dt1));
			c1.setTime(sdf.parse(dt2));
		}catch(ParseException e){
			e.printStackTrace();
		 }
		c.add(Calendar.YEAR, c1.get(Calendar.YEAR));
		c.add(Calendar.MONTH, c1.get(Calendar.MONTH));
		c.add(Calendar.DATE, c1.get(Calendar.DATE));
		
		return sdf.format(c.getTime());  
		
	};

	ob[3]=(String dt1, String dt2)-> {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Calendar c = Calendar.getInstance();
		Calendar c1 = Calendar.getInstance();
		try{
			c.setTime(sdf.parse(dt1));
			c1.setTime(sdf.parse(dt2));
		}catch(ParseException e){
			e.printStackTrace();
		 }
		
	/*	System.out.println(c.get(Calendar.YEAR) +" "+c1.get(Calendar.YEAR));
		c.add(Calendar.YEAR, (c1.get(Calendar.YEAR) * -1));
		c.add(Calendar.MONTH, (c1.get(Calendar.MONTH) * -1));
		c.add(Calendar.DATE, (c1.get(Calendar.DATE) * -1));
		c.add(Calendar.HOUR_OF_DAY, (c1.get(Calendar.HOUR_OF_DAY) * -1));
		c.add(Calendar.MINUTE, (c1.get(Calendar.MINUTE) * -1));
	*/	
		long l1 = (c.get(Calendar.YEAR) - c1.get(Calendar.YEAR)) * 365;
		l1 += (c.get(Calendar.MONTH) - c1.get(Calendar.MONTH)) * 30;
		l1 += c.get(Calendar.DATE) - c1.get(Calendar.DATE);
				
		return String.valueOf(l1);  
		
	};

	 
	}
	
	public static Adaytodate getFactory(int n) {
		return ob[n];
	}

}

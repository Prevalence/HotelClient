package businessLogic;

import java.util.Calendar;

public class TimeFormTrans {
/**
 * 此类实现时间格式的转换
 */
	
	//String转Calendar
	public Calendar myToCalendar(String votime){
		//votime格式："2016-12-15 20:17:50"
		if(votime.equals("")){
			return null;
		}
		int year=Integer.parseInt(votime.substring(0, 4));
		int month=Integer.parseInt(votime.substring(5, 7));
		int date=Integer.parseInt(votime.substring(8, 10));
		int hour=Integer.parseInt(votime.substring(11, 13));
		int minute=Integer.parseInt(votime.substring(14, 16));
		int second=Integer.parseInt(votime.substring(17, 19));
		Calendar calendar=Calendar.getInstance();
		calendar.set(Calendar.YEAR,year);
		calendar.set(Calendar.MONTH,month);
		calendar.set(Calendar.DATE,date);
		calendar.set(Calendar.HOUR_OF_DAY,hour);
		calendar.set(Calendar.MINUTE,minute);
		calendar.set(Calendar.SECOND,second);
//		System.out.println("in line 30:  "+calendar);
		return calendar;
	}
	
	//Calendar转String
	public String myToString(Calendar calendar){
		if(calendar==null){
			return "";
		}
		
		int year1=calendar.get(Calendar.YEAR);
		int month1=calendar.get(Calendar.MONTH);
		int date1=calendar.get(Calendar.DATE);
		int hour1=calendar.get(Calendar.HOUR_OF_DAY);
		int minute1=calendar.get(Calendar.MINUTE);
		int second1=calendar.get(Calendar.SECOND);
		String year2=Integer.toString(year1);
		String month2=Integer.toString(month1);
		String date2=Integer.toString(date1);
		String hour2=Integer.toString(hour1);
		String minute2=Integer.toString(minute1);
		String second2=Integer.toString(second1);
		
		String year=year2;
		String month=month2;
		String date=date2;
		String hour=hour2;
		String minute=minute2;
		String second=second2;
		
		for(int i=0;i<4-year2.length();i++){
			year="0"+year;
		}
		for(int i=0;i<2-month2.length();i++){
			month="0"+month;
		}
		for(int i=0;i<2-date2.length();i++){
			date="0"+date;
		}
		for(int i=0;i<2-hour2.length();i++){
			hour="0"+hour;
		}
		for(int i=0;i<2-minute2.length();i++){
			minute="0"+minute;
		}
		for(int i=0;i<2-second2.length();i++){
			second="0"+second;
		}
		String time = year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second;
		
//		System.out.println("in line 56:  "+time);
		return time;
	}

//public static void main(String[] args) {
//	TimeFormTrans t=new TimeFormTrans();
//	
//	Calendar calendar=Calendar.getInstance();
//	calendar.set(Calendar.YEAR,1996);
//	calendar.set(Calendar.MONTH,9);
//	calendar.set(Calendar.DATE,20);
//	t.myToString(calendar);
//	t.myToCalendar("2016-10-12 08:00:50");
//}
	
}


import java.util.Calendar;
import java.util.Collections;


class Reserve{
	int month;
	int date;//日にち
	int rental;//貸し出し時間
	String name;//予約者の名前
	
	void set(int month, int date, int rental, String name) {
		this.month = month;
		this.date = date;
		this.rental = rental;
		this.name = name;
	}
}

public class Calender {

	public static void main(String[] args) {
		Calendar cl = Calendar.getInstance();
		//-----------------今月-----------------------------
		int thisYear = cl.get(Calendar.YEAR); //今年
		int thisMonth = cl.get(Calendar.MONTH); //今月(1月=0、2月=1であるため配列monthの添字に使用)
		outputCalendar(thisYear,thisMonth);
		
		//-----------------来月-----------------------------
		System.out.println("\n");
		int nextYear = cl.get(Calendar.YEAR); //今年
		int nextMonth = cl.get(Calendar.MONTH) + 1; //来月
		outputCalendar(nextYear,nextMonth);
		
		/*
		//-----------------------任意の年、月の確認用-----------------------
		System.out.println("\n");
		int otherYear = 2023; //西暦を入力
		int otherMonth = 8; //月を入力
		outputCalendar(otherYear,otherMonth - 1);
		*/
		
		//------------------------予約のリスト入力---------------------
		Reserve r1 = new Reserve();
		Reserve r2 = new Reserve();
		Reserve r3 = new Reserve();
		Reserve r4 = new Reserve();
		
		r1.set(6, 1, 3, "吉田");
		r2.set(6, 5, 1, "中原");
		r3.set(6, 26, 2, "久木原");
		r4.set(6, 5, 3, "官");
		
		System.out.println("予約済み一覧");
		showReserve(r1);
		showReserve(r2);
		showReserve(r3);
		showReserve(r4);
		
	}
	//--------------------------------予約リスト表示----------------------------
	static void showReserve(Reserve r) {
		if(r.rental == 1) {
			System.out.println(r.month + "月" + r.date + "日→[" + r.rental + "] 9:00 - 11:50 " + r.name + "様");
		}
		else if(r.rental ==2) {
			System.out.println(r.month + "月" + r.date + "日→[" + r.rental + "] 11:00 - 14:50 " + r.name + "様");
		} 
		else {
			System.out.println(r.month + "月" + r.date + "日→[" + r.rental + "] 15:00 - 17:50 " + r.name + "様");
		}
	}
	
	public static void outputCalendar(int inputYear, int inputMonth) {
		Calendar cl = Calendar.getInstance();
		
		String[] month = {"January","February","March","April","May","June",
				"July","August","September","October","November","December"};
		String[] week = {"Su","Mo","Tu","We","Th","Fr","Sa"};
		
		int firstDay = 1; //月の初日
		//月の初日の曜日(日曜日=1、月曜日=2であるため-1をして配列weekの添字に使用)
		cl.set(inputYear,inputMonth,firstDay);
		int firstDayWeek = cl.get(Calendar.DAY_OF_WEEK) - 1; 
		int lastDay = cl.getActualMaximum(Calendar.DAY_OF_MONTH); //月の最終日

		System.out.print("     " + month[inputMonth] + " " +  inputYear); //年と月を出力
		System.out.println(); 

		String starttime = "9:00";//開始時間
		String endtime = "18:00";//終了時間
		String [] timeslotsST = {"9:00", "12:00", "15:00"};//貸し出し開始時間
		String [] timeslotsET = {"11:50", "14:50", "17:50"};//貸し出し終了時間
		
		//------------------------カレンダー表示---------------------
		//カレンダーの曜日を出力
		for (int i = 0; i < week.length; i++) {
			System.out.printf("%2s ",week[i]);
		}
		System.out.println();
		//初日が何曜日かに合わせて空白を出力
		System.out.print(String.join("", Collections.nCopies(firstDayWeek, "   ")));
		//日付を出力
		for (int i = firstDay; i <= lastDay; i++) {
			System.out.printf("%2d ",i);
			if ((firstDayWeek + i) % 7 == 0) {
				System.out.println();
			}			
		}
		System.out.println("\n");
		//--------------------------営業時間表示--------------------------
		System.out.println("営業時間  " + starttime +" - " + endtime + "\n");
		
		//--------------------------貸出時間表示--------------------------
		System.out.println("貸出時間");
		for(int i = 0; i < timeslotsST.length; i++) {
			System.out.println("[" + (i + 1) +"] " + timeslotsST[i] + " - "+ timeslotsET[i]);
		}
		System.out.println();
		
		//--------------------日付(曜日)と空き状況の表示「縦に表示」--------------------------
		System.out.println("空き状況");
		for (int i = firstDay; i <= lastDay; i++) {
			int u =(firstDayWeek  + i -1) % 7;
			if(u ==0) {//１週間の区切りの線
				System.out.println("-------------------------------------");
			}
			if (u == 2) {//定休日の表示
				System.out.println(i + "(" + week[u] + ")→定休日");
			} else {
				System.out.println(i + "(" + week[u] +")→[1]:" + " [2]:" + " [3]:" );
			}
			
		}
		System.out.println();
		
	}
	
	
}


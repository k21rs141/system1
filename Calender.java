
import java.util.Calendar;
import java.util.Collections;


class Reserve{
	int year;//�N
	int month;//��
	int date;//���ɂ�
	int rental;//�݂��o������
	String title;//	�ړI
	
	void set(int year, int month, int date, int rental, String title) {
		this.year = year;
		this.month = month;
		this.date = date;
		this.rental = rental;
		this.title = title;
	}
}

public class Calender {

	public static void main(String[] args) {
		//------------------------�\��̃��X�g����---------------------
				Reserve r1 = new Reserve();
				Reserve r2 = new Reserve();
				Reserve r3 = new Reserve();
				Reserve r4 = new Reserve();
				
				r1.set(2023, 8, 2, 3, "����");
				r2.set(2023, 7, 5, 1, "����");
				r3.set(2023, 7, 26, 2, "�u�`");
				r4.set(2023, 7, 5, 3, "�ł����킹");
				
				System.out.println("�\��ς݈ꗗ");
				showReserve(r1);
				showReserve(r2);
				showReserve(r3);
				showReserve(r4);
				
				Reserve [] order = new Reserve[4];
				order [0] = r1;
				order [1] = r2;
				order [2] = r3;
				order [3] = r4;
			
				System.out.println();
				String starttime = "9:00";//�J�n����
				String endtime = "18:00";//�I������
				String [] timeslotsST = {"9:00", "12:00", "15:00"};//�݂��o���J�n����
				String [] timeslotsET = {"11:50", "14:50", "17:50"};//�݂��o���I������
				
				//--------------------------�c�Ǝ��ԕ\��--------------------------
				System.out.println("�c�Ǝ���  " + starttime +" - " + endtime + "\n");
				
				//--------------------------�ݏo���ԕ\��--------------------------
				System.out.println("�ݏo����");
				for(int i = 0; i < timeslotsST.length; i++) {
					System.out.println("[" + (i + 1) +"] " + timeslotsST[i] + " - "+ timeslotsET[i]);
				}
				System.out.println();
				
		
		Calendar cl = Calendar.getInstance();
		//-----------------����-----------------------------
		int thisYear = cl.get(Calendar.YEAR); //���N
		int thisMonth = cl.get(Calendar.MONTH); //����(1��=0�A2��=1�ł��邽�ߔz��month�̓Y���Ɏg�p)
		outputCalendar(thisYear,thisMonth, order);
		
		//-----------------����-----------------------------
		System.out.println("\n");
		int nextYear = cl.get(Calendar.YEAR); //���N
		int nextMonth = cl.get(Calendar.MONTH) + 1; //����
		outputCalendar(nextYear,nextMonth, order);
		
		/*
		//-----------------------�C�ӂ̔N�A���̊m�F�p-----------------------
		System.out.println("\n");
		int otherYear = 2023; //��������
		int otherMonth = 8; //�������
		outputCalendar(otherYear,otherMonth - 1);
		*/
		
		
	}
	
	//--------------------------------�\�񃊃X�g�\��----------------------------
	static void showReserve(Reserve r) {
		
		if(r.rental == 1) {
			System.out.println(r.year + "�N" + r.month + "��" + r.date + "����[" + r.rental + "] 9:00 - 11:50 " + r.title);
		}
		else if(r.rental ==2) {
			System.out.println(r.year + "�N" + r.month + "��" + r.date + "����[" + r.rental + "] 11:00 - 14:50 " + r.title);
		} 
		else {
			System.out.println(r.year + "�N" + r.month + "��" + r.date + "����[" + r.rental + "] 15:00 - 17:50 " + r.title);
		}
		
		
	}
	
	public static void outputCalendar(int inputYear, int inputMonth, Reserve [] order) {
		Calendar cl = Calendar.getInstance();
		
		String[] month = {"January","February","March","April","May","June",
				"July","August","September","October","November","December"};
		String[] week = {"Su","Mo","Tu","We","Th","Fr","Sa"};
		
		int firstDay = 1; //���̏���
		//���̏����̗j��(���j��=1�A���j��=2�ł��邽��-1�����Ĕz��week�̓Y���Ɏg�p)
		cl.set(inputYear,inputMonth,firstDay);
		int firstDayWeek = cl.get(Calendar.DAY_OF_WEEK) - 1; 
		int lastDay = cl.getActualMaximum(Calendar.DAY_OF_MONTH); //���̍ŏI��

		System.out.print("     " + month[inputMonth] + " " +  inputYear); //�N�ƌ����o��
		System.out.println(); 	
		
		//------------------------�J�����_�[�\��---------------------
		//�J�����_�[�̗j�����o��
		for (int i = 0; i < week.length; i++) {
			System.out.printf("%2s ",week[i]);
		}
		System.out.println();
		//���������j�����ɍ��킹�ċ󔒂��o��
		System.out.print(String.join("", Collections.nCopies(firstDayWeek, "   ")));
		//���t���o��
		for (int i = firstDay; i <= lastDay; i++) {
			System.out.printf("%2d ",i);
			if ((firstDayWeek + i) % 7 == 0) {
				System.out.println();
			}			
		}
		System.out.println("\n");
		
		
		//--------------------���t(�j��)�Ƌ󂫏󋵂̕\���u�c�ɕ\���v--------------------------
		System.out.println("�󂫏�");
		for (int i = firstDay; i <= lastDay; i++) {
			int u =(firstDayWeek  + i -1) % 7;
			
			String name1 ="��";
			String name2 ="��";
			String name3 ="��";
			
			/*
			String [] name = new String[3];
			for(int a = 0; a < 3; a++) {
				 name[a] = "��";
			}
			*/
			for (int x = 0; x < order.length; x++) {
				if(order[x].year == inputYear && order[x].month -1 == inputMonth && order[x].date == i) {
					if(order[x].rental == 1) {							
						name1 = order[x].title;
					}if(order[x].rental == 2) {							
						name2 = order[x].title;
					}if(order[x].rental == 3) {							
						name3 = order[x].title;
					} 
				}
			}
			
			if(u ==0) {//�P�T�Ԃ̋�؂�̐�
				System.out.println("-------------------------------------");
			}
			if (u == 2) {//��x���̕\��
				System.out.println(i + "(" + week[u] + ")����x��");
			} else {
				System.out.println(i + "(" + week[u] +")��[1]:" + name3 + " [2]:" +name2 + " [3]:" +name3);
			}
			
		}
		System.out.println();
		
	}
	
	
}


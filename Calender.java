
import java.util.Calendar;
import java.util.Collections;


class Reserve{
	int month;
	int date;//���ɂ�
	int rental;//�݂��o������
	String name;//�\��҂̖��O
	
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
		//-----------------����-----------------------------
		int thisYear = cl.get(Calendar.YEAR); //���N
		int thisMonth = cl.get(Calendar.MONTH); //����(1��=0�A2��=1�ł��邽�ߔz��month�̓Y���Ɏg�p)
		outputCalendar(thisYear,thisMonth);
		
		//-----------------����-----------------------------
		System.out.println("\n");
		int nextYear = cl.get(Calendar.YEAR); //���N
		int nextMonth = cl.get(Calendar.MONTH) + 1; //����
		outputCalendar(nextYear,nextMonth);
		
		/*
		//-----------------------�C�ӂ̔N�A���̊m�F�p-----------------------
		System.out.println("\n");
		int otherYear = 2023; //��������
		int otherMonth = 8; //�������
		outputCalendar(otherYear,otherMonth - 1);
		*/
		
		//------------------------�\��̃��X�g����---------------------
		Reserve r1 = new Reserve();
		Reserve r2 = new Reserve();
		Reserve r3 = new Reserve();
		Reserve r4 = new Reserve();
		
		r1.set(6, 1, 3, "�g�c");
		r2.set(6, 5, 1, "����");
		r3.set(6, 26, 2, "�v�،�");
		r4.set(6, 5, 3, "��");
		
		System.out.println("�\��ς݈ꗗ");
		showReserve(r1);
		showReserve(r2);
		showReserve(r3);
		showReserve(r4);
		
	}
	//--------------------------------�\�񃊃X�g�\��----------------------------
	static void showReserve(Reserve r) {
		if(r.rental == 1) {
			System.out.println(r.month + "��" + r.date + "����[" + r.rental + "] 9:00 - 11:50 " + r.name + "�l");
		}
		else if(r.rental ==2) {
			System.out.println(r.month + "��" + r.date + "����[" + r.rental + "] 11:00 - 14:50 " + r.name + "�l");
		} 
		else {
			System.out.println(r.month + "��" + r.date + "����[" + r.rental + "] 15:00 - 17:50 " + r.name + "�l");
		}
	}
	
	public static void outputCalendar(int inputYear, int inputMonth) {
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

		String starttime = "9:00";//�J�n����
		String endtime = "18:00";//�I������
		String [] timeslotsST = {"9:00", "12:00", "15:00"};//�݂��o���J�n����
		String [] timeslotsET = {"11:50", "14:50", "17:50"};//�݂��o���I������
		
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
		//--------------------------�c�Ǝ��ԕ\��--------------------------
		System.out.println("�c�Ǝ���  " + starttime +" - " + endtime + "\n");
		
		//--------------------------�ݏo���ԕ\��--------------------------
		System.out.println("�ݏo����");
		for(int i = 0; i < timeslotsST.length; i++) {
			System.out.println("[" + (i + 1) +"] " + timeslotsST[i] + " - "+ timeslotsET[i]);
		}
		System.out.println();
		
		//--------------------���t(�j��)�Ƌ󂫏󋵂̕\���u�c�ɕ\���v--------------------------
		System.out.println("�󂫏�");
		for (int i = firstDay; i <= lastDay; i++) {
			int u =(firstDayWeek  + i -1) % 7;
			if(u ==0) {//�P�T�Ԃ̋�؂�̐�
				System.out.println("-------------------------------------");
			}
			if (u == 2) {//��x���̕\��
				System.out.println(i + "(" + week[u] + ")����x��");
			} else {
				System.out.println(i + "(" + week[u] +")��[1]:" + " [2]:" + " [3]:" );
			}
			
		}
		System.out.println();
		
	}
	
	
}


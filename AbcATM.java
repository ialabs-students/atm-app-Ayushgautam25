package github_assessment;

import java.util.Scanner;

public class AbcATM {
	
	private static int balance = 0;
	
	public static void deposit(int arr[] ,int note[]) {
		int counter=1;
		int i=1;
		while(counter==1) {
			balance = 0;
			Scanner sc = new Scanner(System.in);
			System.out.print("Deposit "+i+": ");
			for(int j=0; j<arr.length; j++) {
				System.out.print(arr[j]+"s: ");
				int num = sc.nextInt();
				note[j]=note[j]+num;
				if(note[j]<0) {
					System.out.println("Incorrect deposit amount");
				}
				else
					balance = balance + arr[j]*note[j];
			}
			System.out.println("-----------------------------------------------\n");
			boolean NotesZero = true;
			for(int j=0; j<arr.length; j++){
				if(note[j]!=0) {
					NotesZero = false;
				}
			}
			if(NotesZero==true) {
				System.out.println("Deposit amount should be greater than zero ");
			}
			else {
				System.out.print("Current Balance: ");
				for(int j=0; j<arr.length; j++) {
					System.out.print(arr[j]+"s="+note[j]+" ");
				}
				System.out.println("Total Balance = "+ balance);
				i++;
				
			}
			System.out.println("Exit - 0");
			System.out.println("Continue - 1");
			counter = sc.nextInt();
			if(counter==0) {
				break;
			}
			sc.close();
		}
	}
	
	public static void withdraw(int arr[], int note[]) {
		int count = 1;
		int i=1;
		int withamt;
		while(count==1) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Withdraw "+i+": ");
			withamt = sc.nextInt();
			if(withamt<=0 || withamt>balance) {
				System.out.println("This transaction is not possible.");
			}
			else {
				int bal = balance-withamt;
				System.out.print("Dispensed: ");
				int availableamt;
				for(int j=0; j<arr.length && withamt!=0; j++) {
					availableamt = 0;
					availableamt = withamt/arr[j];
					if(availableamt<=note[j] && note[j]!=0) {
						System.out.print(arr[j]+"s="+availableamt +"  ");
						withamt = withamt%arr[j];
						note[j] = note[j]-availableamt;
						balance = balance-(arr[j]*availableamt);
					}
					else {
						while(availableamt!=0) {
							availableamt--;
							if(availableamt<=note[j] && note[j]!=0) {
								System.out.print(arr[j]+"s="+availableamt +"  ");
								withamt = withamt%arr[j];
								note[j] = note[j]-availableamt;
								balance = balance-(arr[j]*availableamt);
							}
						}
					}
				}
				System.out.println(" ");
				System.out.print("Current Balance = ");
				for(int j=0; j<arr.length; j++) {
					System.out.print(arr[j] + "s=" + note[j]+ " ");
				}
				System.out.println("Total Balance = "+balance);
				i++;
				if(bal!=balance) {
					System.out.println("These notes are not available for withdrawal.");
				}
			}
			System.out.println("Exit - 0");
			System.out.println("Continue - 1");
			count = sc.nextInt();
			if(count==0) {
				break;
			}
			sc.close();
		}
	}

	public static void main(String[] args) {
		int arr[] = {2000,1000,500,200,100,50};
		int notes[] = {0,0,0,0,0,0};
		deposit(arr,notes);
		withdraw(arr,notes);
	}
}
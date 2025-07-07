import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static int L,C;
	public static String[] arr=new String[16];
	public static String[] passArray=new String[16];
	public static boolean[] isUsed1=new boolean[16]; //모음
	public static boolean[] isUsed2=new boolean[16];
	
	public static void printArray() {
		for(int i=0;i<L;i++) 
			System.out.print(passArray[i]);
	
		System.out.println();
	}
	
	public static void makePassword(int idx, int startIdx) {
		if(idx==L) {		
			int cnt=0, cnt2=0;
			for(int i=0;i<C;i++) {
				if(isUsed1[i])
					++cnt;
				if(isUsed2[i])
					++cnt2;
			}
			
			if( cnt>=1 && cnt2>=2 ) //모음이 한 번도 사용되지 않거나 모음만 사용됐을 경우
				printArray();		
			
			return;
		}
		
		for(int i=startIdx;i<C;i++) {
			if(!isUsed1[i] && !isUsed2[i]) {
				char c=arr[i].charAt(0);
		
				switch(c) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					isUsed1[i]=true;
					break;
				}
				
				passArray[idx]=arr[i];
				
				if(!isUsed1[i])
					isUsed2[i]=true;
				else
					isUsed2[i]=false;
				
				makePassword(idx+1,i);
				
				if(isUsed1[i])
					isUsed1[i]=false;
				if(isUsed2[i])
					isUsed2[i]=false;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		L=scanner.nextInt();
		C=scanner.nextInt();
		
		for(int i=0;i<C;i++) 
			arr[i]=scanner.next();
		
		Arrays.sort(arr,0,C);
		makePassword(0,0);

		scanner.close();
	}
}

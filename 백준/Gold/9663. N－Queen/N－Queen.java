import java.util.Scanner;
public class Main {
	public static int cnt=0;
	public static boolean[] isUsed1=new boolean[40];
	public static boolean[] isUsed2=new boolean[40];
	public static boolean[] isUsed3=new boolean[40];
	
	public static void func(int cur, int n) {
		if(cur==n) {
			cnt++;
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(isUsed1[i] || isUsed2[i+cur] || isUsed3[cur-i+n-1])
				continue;
			isUsed1[i]=true;
			isUsed2[i+cur]=true;
			isUsed3[cur-i+n-1]=true;
			
			func(cur+1,n);
			
			isUsed1[i]=false;
			isUsed2[i+cur]=false;
			isUsed3[cur-i+n-1]=false;
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int N=scanner.nextInt();
	
		func(0,N);
		System.out.println(cnt);
		scanner.close();
	
	}
}

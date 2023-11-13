import java.util.Scanner;

public class Main {
	private static int[] store; //2*idx크기의 타일의 방법을 저장
	
	private static int getTileCount(int n) {
		if(store[n]!=0)
			return store[n];
		
		store[n]= ( getTileCount(n-1) +getTileCount(n-2) ) %10007;
		
		return store[n];
	}
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		store=new int[1001];	
		store[0]=1;
		store[1]=1;
		store[2]=2;
		
		int n=scanner.nextInt();
		int count=getTileCount(n);
		
		System.out.println(count);
		
		scanner.close();
	}
}
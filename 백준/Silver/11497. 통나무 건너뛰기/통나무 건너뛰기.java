import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	private static int mid,left,right;
	private static ArrayList<Integer>tempList;
	private static int[] list;
	private static void sortList(int size) {
		boolean isLeftTurn=true;
		for(int i=0;i<size-1;i++) {
			//정규분포 형태를 위해 left와 right 번갈아 삽입
			if(isLeftTurn) { //정규분포 형태로 mid의 왼쪽은 오름차순
				list[left--]=tempList.get(i);
				isLeftTurn=false;
			}
			
			else { //mid의 오른쪽은 내림차순
				list[right++]=tempList.get(i);
				isLeftTurn=true;
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCase=Integer.parseInt(br.readLine());
		
		while(testCase--!=0) {
			tempList=new ArrayList<Integer>();
			int n=Integer.parseInt(br.readLine());
			int max=0;
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				int temp=Integer.parseInt(st.nextToken());
				tempList.add(temp);
				max=Math.max(max, temp);
			}
			int maxIndex=tempList.indexOf(max);
			tempList.remove(maxIndex);
			Collections.sort(tempList, Collections.reverseOrder()); //tempList에서 최대값 삭제 후 내림차순으로 정렬
				
			mid=n/2;
			left=mid-1;
			right=mid+1;
			list=new int[n];
			list[mid]=max; //최대값을 리스트의 가운데에 삽입, 정규분포 형태
			
			sortList(n); //최종 list 정렬, 정규 분포 형태
			
			int ans=0; 
			for(int i=0;i<n;i++) {
				try { //최소 난이도를 위한 최대 높이 구하기
					ans=Math.max(ans, Math.abs(list[i]-list[i+1]));					
				}
				
				catch (ArrayIndexOutOfBoundsException e) {
					ans=Math.max(ans, Math.abs(list[0]-list[n-1]));			
				}
			}
			
			System.out.println(ans);
		}
	}
}
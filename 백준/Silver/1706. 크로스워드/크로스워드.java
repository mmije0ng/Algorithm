import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	private static int rows,cols;
	private static String[][] arr;
	private static ArrayList<String> list; //단어를 담아두는 배열
	
	private static void searchByCols() { //가로에서 찾기
		for(int i=0;i<rows;i++) {
			 String temp="";
			 for(int j=0;j<cols;j++) 
				temp+=arr[i][j];
			 String[] tempList=temp.split("#"); //#으로 분리

			 for(int k=0;k<tempList.length;k++) {
				 if(tempList[k].length()>1) //1보다 크면 단어
					 list.add(tempList[k]);
			 }
		}
	}
	
	private static void searchByRows() { //세로에서 찾기
		for(int i=0;i<cols;i++) {
			 String temp="";
			 for(int j=0;j<rows;j++) 
				 temp+=arr[j][i];
			 String[] tempList=temp.split("#");
			 
			 for(int k=0;k<tempList.length;k++) {
				 if(tempList[k].length()>1)
					 list.add(tempList[k]);
			 }
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		rows=Integer.parseInt(st.nextToken());
		cols=Integer.parseInt(st.nextToken());
		
		arr=new String[rows][cols];
		list=new ArrayList<>();
		
		for(int i=0;i<rows;i++) {
			String s=br.readLine();
			for(int j=0;j<cols;j++) {
				char c=s.charAt(j);
				arr[i][j]=s.substring(j, j+1);
			}
		}
		
		searchByCols(); //가로
		searchByRows(); //세로
		
		Collections.sort(list);
		if(list.size()>=1)
			System.out.print(list.get(0)); //사전순
		br.close();
	}
}
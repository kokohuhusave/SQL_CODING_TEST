

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 배열의 크기 설정
		int Q = Integer.parseInt(st.nextToken()); // 물어볼 횟수 설정
		
		int A[][] = new int[N + 1][N + 1];		  // N크기의 이중배열 설정
		for(int i = 1;i <= N;i++) {				  // [N][N]크기의 배열에 값을 넣는다
			st = new StringTokenizer(br.readLine());
			for(int j = 1;j <= N;j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int D[][] = new int[N + 1][N + 1];		  // 합 배열선언
		for(int i = 1;i <= N;i++) {	
			for(int j = 1;j <= N;j++) {
				D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j]; //D[3][3]을 구할때 D[3][2] + D[2][3] - D[2][2] + A[3][3]
			}															 //따라서 D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j] 	
		}
		for(int i = 0;i < Q;i++) { //물어볼 횟수만큼 반복 한다
			st = new StringTokenizer(br.readLine());	//(x2, y2) - (x1, y1) 할 구간을 선택하여 계산한다
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
															// 2 2 3 4일때 (3, 4)구간 합에서 (1, 4)구간합, (3, 1)구간합을 뺀 다음 중복하여 뺀 (1,1)를 더하면 된다
			int result = D[x2][y2] - D[x1-1][y2] -D[x2][y1-1] + D[x1-1][y1-1]; // 전체 D[x2][y2]에서 D[x1-1][y2] -D[x2][y1-1] + D[x1-1][y1-1]
			System.out.println(result); // 결과 반환
		}
		
	}
	

}

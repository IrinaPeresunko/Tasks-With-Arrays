package tasksWithArrays;

/*
 * Calculate the sum of the numbers standing above the main diagonal,
 * and compared with the sum of the numbers below it. 
 * If the sum of the top numbers more, sort in descending order,
 *  otherwise - ascending
 */

public class Task5 {

	public static void printArray(int[][] array,int N){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
					System.out.print(array[i][j]+ " ");
			}
				System.out.println();
		}
	}
	public static int[][] sortingInIncreasingOrder(int[][] array, int N,int M){
		for(int i=0,j=0;i<N && j<M;j++){			
			for(int m=0,p=0;m<N && p<M;p++){				
				if(array[i][j]<array[m][p]){
					int temp = array[i][j];
					array[i][j] = array[m][p];
					array[m][p] = temp;
				}
				if(p==M-1){ 
					m++;p=-1;
				}
			}
			if(j==M-1){ 
				i++;j=-1;
			}
		}
		return array;
	}
	public static int[][] sortingInDecreasingOrder(int[][] array, int N,int M){
		for(int i=0,j=0;i<N && j<M;j++){			
			for(int m=0,p=0;m<N && p<M;p++){				
				if(array[i][j]>array[m][p]){
					int temp = array[i][j];
					array[i][j] = array[m][p];
					array[m][p] = temp;
				}
				if(p==M-1){ 
					m++;p=-1;
				}
			}
			if(j==M-1){ 
				i++;j=-1;
			}
		}
		return array;
	}
	public static void main(String[] args) {
		int N=5;
		int[][] array=new int[N][N];
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				array[i][j]=(int) (Math.random()*10);
			}
		}
		
		printArray(array,N);
		
		int sumAboveMainDiagonal=0;
		for(int i=0;i<N-1;i++){
			int j=i+1;
				while(j!=N){
					sumAboveMainDiagonal+=array[i][j];
					j++;
				}
		}
		System.out.println("sum above main diagonal = "+sumAboveMainDiagonal);
		
		int sumBelowMainDiagonal=0;
		for(int i=N-1;i>0;i--){
			int j=i-1;
			while(j>=0){
				sumBelowMainDiagonal+=array[i][j];
				j--;
			}
		}		
		System.out.println("sum below main diagonal = "+sumBelowMainDiagonal);
		
		if(sumAboveMainDiagonal>sumBelowMainDiagonal){
			array=sortingInDecreasingOrder(array,N,N);
			System.out.println("After sotring:");
			printArray(array,N);
		}
		else{
			array=sortingInIncreasingOrder(array,N,N);
			System.out.println("After sotring:");
			printArray(array,N);
		}
	}

}

package tasksWithArrays;

import java.util.Arrays;

/*
 * Task2:sort the columns by descending sum of the numbers in the columns , rows by ascending
 */

public class Task2 {

	public static void sortTheRowsByAscendingSumOfNumbersInTheRows(int[][] array,int N){
		int[] sumInRows=getSumInRows(array,N);
		for(int n=0;n<N;n++){
			for(int k=0;k<N-1;k++){
				if(sumInRows[k]>sumInRows[k+1]){
					for(int i=0;i<N;i++){
						int temp=array[k][i];
						array[k][i]=array[k+1][i];
						array[k+1][i]=temp;
					}
					int temp = sumInRows[k];
					sumInRows[k]=sumInRows[k+1];
					sumInRows[k+1]=temp;
				}
			}
		}
	}
	public static int[] getSumInRows(int[][] array,int N){
		int[] sumInRows=new int[N];
		
		for(int j=0,k=0;j<N;j++,k++){
			for(int i=0;i<N;i++){
				sumInRows[k]+=array[j][i];
			}
		}
		
		System.out.println("Sum in the rows:"+"\n"+Arrays.toString(sumInRows));
		
		return sumInRows;
	}
	public static void sortTheColumnsByDescendingSumOfNumbersInTheColumns(int[][] array,int N){
		int[] sumInColumns=getSumInColumns(array,N);
		
		for(int n=0;n<N;n++){
			for(int k=0;k<N-1;k++){
				if(sumInColumns[k]<sumInColumns[k+1]){
					for(int i=0;i<N;i++){
						int temp=array[i][k];
						array[i][k]=array[i][k+1];
						array[i][k+1]=temp;
					}
					int temp = sumInColumns[k];
					sumInColumns[k]=sumInColumns[k+1];
					sumInColumns[k+1]=temp;
				}
			}
		}
	}
	public static int[] getSumInColumns(int[][] array,int N){
		int[] sumInColumns=new int[N];
		
		for(int j=0,k=0;j<N;j++,k++){
			for(int i=0;i<N;i++){
				sumInColumns[k]+=array[i][j];
			}
		}

		System.out.println("Sum in the columns:"+"\n"+Arrays.toString(sumInColumns));
		
		return sumInColumns;
	}
	public static void printArray(int[][] array,int N){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
					System.out.print(array[i][j]+ " ");
			}
				System.out.println();
		}
	}
	public static void main(String[] args) {
		
		int N=8;
		int[][] array=new int[N][N];
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				//array[i][j]=(int) (Math.random()*31)-15;
				array[i][j]=(int) (Math.random()*5);
			}
		}
		
		printArray(array,N);
		
			/*
			 * CALL METHODS SEPARATELY
			 */
		
		sortTheRowsByAscendingSumOfNumbersInTheRows(array,N);
		sortTheColumnsByDescendingSumOfNumbersInTheColumns(array,N);
		
		System.out.println("\n"+"After:");
		
		printArray(array,N);
	}
}
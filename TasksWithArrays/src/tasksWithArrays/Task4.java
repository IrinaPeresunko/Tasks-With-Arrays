package tasksWithArrays;

/*
 * Sorting two-dimensional array,using bubble sort.
 * Printing array in this form1: 1 2 3
 * 								6 5 4
 * 								7 8 9
 * And after in this form2:  9 6 3
 * 						    8 5 2
 * 							7 4 1	
 * And after in this form3: 9 4 3
 * 							8 5 2		
 * 							7 6 1					
 */
public class Task4 {

	public static void printArray(int[][] array, int N,int M) {
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
					System.out.print(array[i][j]+ " ");
			}
				System.out.println();
		}	
	}
	public static void printInForm2(int[][] array, int N,int M) {
		array=sortingInDecreasingOrder(array,N,M);
		for(int j=0;j<M;j++){
			for(int i=j;i<N;i++){
				if(i==j) continue;
				int temp=array[i][j];
				array[i][j]=array[j][i];
				array[j][i]=temp;
			}
		}
		printArray(array,N,M);
	}
	public static void printInForm1(int[][] array, int N,int M) {
		array=sortingInIncreasingOrder(array,N,M);
		for(int i=0;i<N;i++){
			if(i%2!=0){
				for(int j=M-1;j>=0;j--){
					System.out.print(array[i][j]+ " ");
				}
				System.out.println();
			}
			else{
				for(int j=0;j<M;j++){
					System.out.print(array[i][j]+ " ");
				}
				System.out.println();
			}
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
		int N=3,M=3;

		//int[][] array=new int[N][M];
		
//		for(int i=0;i<N;i++){
//			for(int j=0;j<M;j++){
//				//array[i][j]=(int) (Math.random()*31)-15;
//				array[i][j]=(int) (Math.random()*10);
//			}
//		}
		int[][] array={
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};

		printArray(array,N,M);

		System.out.println("Printing array in form2:");
		printInForm2(array,N,M);
		System.out.println("Printing array in form1");
		printInForm1(array,N,M);
	
	}
}

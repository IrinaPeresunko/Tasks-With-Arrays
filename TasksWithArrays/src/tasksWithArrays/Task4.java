package tasksWithArrays;

/*
 * Sorting two-dimensional array,using bubble sort
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
	public static void main(String[] args) {
		int N=5,M=7;

		int[][] array=new int[N][M];
		
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				//array[i][j]=(int) (Math.random()*31)-15;
				array[i][j]=(int) (Math.random()*10);
			}
		}
		

		printArray(array,N,M);
		
		for(int i=0,j=0;i<N && j<M;j++){			
			for(int m=0,p=0;m<N && p<M;p++){				
				if(array[i][j]>array[m][p]){
					int temp = array[i][j];
					array[i][j] = array[m][p];
					array[m][p] = temp;
				}
				if(p==M-1){ m++;p=-1;}
			}
			if(j==M-1){ i++;j=-1;}
		}

		System.out.println("__________");
		printArray(array,N,M);
	}
}

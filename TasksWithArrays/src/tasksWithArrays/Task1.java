package tasksWithArrays;

/*
 * Task1:sorting the main diagonal by ascending ,secondary diagonal by descending
 */
public class Task1 {

	public static void main(String[] args) {
		int N=10;
		int[][] array=new int[N][N];
		for(int i=0,j=0;i<N;j++){
			if(j<N){
				array[i][j]=(int) (Math.random()*31)-15;
				//array[i][j]=(int) (Math.random()*10);
			}
			else{
				i++;
				j=-1;
			}
		}
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				//if(i==j)
				System.out.print(array[i][j]+ " ");
			}
			System.out.println();
		}
		for(int k=0;k<N;k++){
			for(int i=0,j=N-1;i<N-1 && j>=0;i++,j--){
				if(array[i][i]>array[i+1][i+1]){
					int temp=array[i][i];
					array[i][i]=array[i+1][i+1];
					array[i+1][i+1]=temp;
				}
				if(array[i][j]<array[i+1][j-1]){
					int temp=array[i][j];
					array[i][j]=array[i+1][j-1];
					array[i+1][j-1]=temp;
				}
			}	
		}
		System.out.println("\n"+"After sorting:");
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				//if(i==j)
				System.out.print(array[i][j]+ " ");
			}
			System.out.println();
		}

	}

}

package tasksWithArrays;

/* Task6:
 * find rows with minimum and maximum element and swap them.
 * If the strings match , then reset them .
 * Max element deduct from its surrounding numbers.
 */
public class Task6 {

	public static void printArray(int[][] array,int N){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
					System.out.print(array[i][j]+ " ");
			}
				System.out.println();
		}
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
		
		int min=array[0][0]; int positionOfMinElement=0;
		int max=array[0][0]; int positionOfMaxElement=0;
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(max<array[i][j]){
					max=array[i][j];
					positionOfMaxElement=i;
				}
				if(min>array[i][j]){
					min=array[i][j];
					positionOfMinElement=i;
				}
			}
		}
		
		System.out.println("min = "+min+" position of min element is "+positionOfMinElement+"\n"
				+"max = "+ max+" position of max element is "+positionOfMaxElement);
		
		if(positionOfMinElement!=positionOfMaxElement){
			for(int j=0;j<N;j++){
				int temp=array[positionOfMinElement][j];
				array[positionOfMinElement][j]=array[positionOfMaxElement][j];
				array[positionOfMaxElement][j]=temp;
			}
			int temp=positionOfMinElement;
			positionOfMinElement=positionOfMaxElement;
			positionOfMaxElement=temp;
		}
		else{
			int i=positionOfMinElement;
			for(int j=0;j<N;j++){
				array[i][j]=0;
			}
		}

		System.out.println("After: ");
		printArray(array,N);
		
		int rowOfMaxElem=0;
		int colOfMaxElem=0;
		max=array[0][0];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(max<array[i][j]){
					max=array[i][j];
					rowOfMaxElem=i;
					colOfMaxElem=j;
				}
			}
		}
		System.out.println("Max element is "+max+"; row of max elem="+rowOfMaxElem+
				"; column of max elem="+colOfMaxElem);
		
		if(rowOfMaxElem!=0){
			array[rowOfMaxElem-1][colOfMaxElem]=array[rowOfMaxElem-1][colOfMaxElem]-max;
			if(colOfMaxElem!=0){
				array[rowOfMaxElem-1][colOfMaxElem-1]=array[rowOfMaxElem-1][colOfMaxElem-1]-max;
			}
			if(colOfMaxElem!=N-1){
				array[rowOfMaxElem-1][colOfMaxElem+1]=array[rowOfMaxElem-1][colOfMaxElem+1]-max;
			}
		}
		if(colOfMaxElem!=0){
			array[rowOfMaxElem][colOfMaxElem-1]=array[rowOfMaxElem][colOfMaxElem-1]-max;
		}
		if(colOfMaxElem!=N-1){
			array[rowOfMaxElem][colOfMaxElem+1]=array[rowOfMaxElem][colOfMaxElem+1]-max;
		}
		if(rowOfMaxElem!=N-1){
			array[rowOfMaxElem+1][colOfMaxElem]=array[rowOfMaxElem+1][colOfMaxElem]-max;
			if(colOfMaxElem!=0){
				array[rowOfMaxElem+1][colOfMaxElem-1]=array[rowOfMaxElem+1][colOfMaxElem-1]-max;
			}
			if(colOfMaxElem!=N-1){
				array[rowOfMaxElem+1][colOfMaxElem+1]=array[rowOfMaxElem+1][colOfMaxElem+1]-max;
			}
		}
		
		printArray(array,N);
	}
}

package tasksWithArrays;

//import java.util.Arrays;

/*
 * Task3:sort the even numbers in a row , the odd miss
 */
public class Task3 {
	public static void printArray(int[][] array, int N) {
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
					System.out.print(array[i][j]+ " ");
			}
				System.out.println();
		}	
	}
	public static int[] getPositionOfEvenNumbersInRow(int[][] array,int N,int numbRow){
		int count=0;
		for(int j=0;j<N;j++){
			if(array[numbRow][j]%2==0){
				count++;
			}
		}
		
		int[] position=new int[count];
		for(int j=0,k=0;j<N && k<count;j++){
			if(array[numbRow][j]%2==0){
				position[k]=j;
				k++;
			}
		}
		
		//System.out.println(Arrays.toString(position));
		return position;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=5;

		int[][] array=new int[N][N];
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				//array[i][j]=(int) (Math.random()*31)-15;
				array[i][j]=(int) (Math.random()*10);
			}
		}
		
		printArray(array,N);
		
		int[] position;
		for(int i=0,k=0;i<N;i++){
			position=getPositionOfEvenNumbersInRow(array,N,i);
			for(int j=0;j<N;j++){
				for(k=0;k<position.length-1;k++){
					if(array[i][position[k]]>array[i][position[k+1]]){
						int temp=array[i][position[k]];
						array[i][position[k]]=array[i][position[k+1]];
						array[i][position[k+1]]=temp;
					}
				}
			}
		}
		
		System.out.println("After sorting the even numbers in a rows:");
		printArray(array,N);
	}
	}

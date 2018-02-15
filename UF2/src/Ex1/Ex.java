package Ex1;

import java.util.Scanner;

public class Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int j = 0;
		int MAX=10;
	    int MAX2=MAX*2;
	    int A[]=new int[MAX];
	    int B[]=new int[MAX];
	    int C[]=new int[MAX2];
	    
	    for (int i = 0; i< MAX; i++) {
	    	A[i]= input.nextInt();
	    	
	    }	
	    System.out.println("Vector2");
	    for (int i = 0; i< MAX; i++) {
	    	
	    	B[i]= input.nextInt();
	    }
	    
	    for (int i = 0; i< MAX2; i++) {
	    	C[i] = A[j];
	    	C[i+1] = B[j];
	    	i++;
            j++;
	    }
	    
	    int temp;
        for(int i=1;i < C.length;i++){
            for (j=0 ; j < C.length- 1; j++){
                if (C[j] > C[j+1]){
                    temp = C[j];
                    C[j] = C[j+1];
                    C[j+1] = temp;
                }
            }
        }
        System.out.println("Resposta");
	    for (int i = 0; i< MAX2; i++) {
	    	System.out.println(C[i]);
	    }
	    
	}

}

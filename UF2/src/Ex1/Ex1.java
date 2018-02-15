package Ex1;

public class Ex1 

	{
	    static int MAX=20;
	    static int MAX2=MAX*2;
	    static int A[]=new int[MAX];
	    static int B[]=new int[MAX];
	    static int C[]=new int[MAX2];
	     
	    static void llenaArreglo(int arreglo[])
	    {
	        for(int i=0;i<arreglo.length;i++)
	        {
	            int ban;
	            do{
	            arreglo[i]=(int)(Math.random()*100+1);
	            ban=noDuplicar(arreglo,arreglo[i],i);
	            }while(ban==1);
	        }   
	    }
	 
	    static int noDuplicar(int arreglo[], int numero, int longitud)
	    {
	        int ban=0;
	        for(int i=0;i<longitud;i++)
	        {
	            if(numero==arreglo[i])
	                {ban=1;break;}
	            else
	                ban=0;
	        }
	        return ban;
	    }
	 
	    static void ordenar(int arreglo[])
	    {
	        int temp=0;
	        for(int i=1;i<arreglo.length;i++)
	        {
	            for(int j=0;j<arreglo.length-i;j++)
	            {
	                if(arreglo[j]>arreglo[j+1])
	                {
	                    temp=arreglo[j];
	                    arreglo[j]=arreglo[j+1];
	                    arreglo[j+1]=temp;
	                }
	            }
	        }
	     
	    }
	 
	    static void juntarArreglos()
	    {
	         
	        int j=0,ban=0,cant=0,k=0,m=0,v=1;
	        for(int i=0;i<C.length;i++)
	        {
	            C[i]=A[j];
	            ban=noDuplicar(C, C[i], i);
	            C[i+1]=B[j];
	            ban=noDuplicar(C, C[i+1], (i+1));
	             
	            i++;
	            j++;
	        }
	        ordenar(C);
	        cant=(C.length);
	        for(int i=0;i<cant-1;i++)
	        {           
	            if(C[i]==C[i+1])
	            {   k=i; m++;}
	             
	            for(int l=k;l<cant-1;l++)
	            {               
	                C[l]=C[l+1];                
	            }
	        }
	         
	        while(C[cant-v]==C[cant-v-1])
	        {
	            C[MAX2-v]=0;
	            v++;
	        }
	    }
	 
	    static void mostrar(int arreglo[],String n)
	    {
	        for(int i=0;i<arreglo.length;i++)
	        {
	            System.out.print(n+"["+i+"] : "+arreglo[i]);
	            System.out.println("");
	        }
	        System.out.print("\n");
	    }
	 
	    public static void main(String[] args)
	    {
	         
	        llenaArreglo(A);
	        llenaArreglo(B);
	        ordenar(A);
	        ordenar(B);
	        mostrar(A,"A");
	        mostrar(B,"B");
	        juntarArreglos();
	        mostrar(C,"C");
	    }
	}



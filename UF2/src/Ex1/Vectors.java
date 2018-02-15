/* M03UF2
  	Fusió de vectors Versió b.3
  	Gestiona dos vectors de longitud 10 i els fusiona 
  	mitjançant la tècnica de concatenació i ordenació 
  	(continuarà). 
 */

package Ex1;

import java.util.Scanner;

public class Vectors {

	public static final int TOPE = 3;
	public static final int TOPE2 = TOPE * 2;
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcio;
		int[] vector1 = new int[TOPE];
		int[] vector2 = new int[TOPE];
		int[] vector3 = new int[TOPE * 2];
		int valor;
		do {
			opcio = menu();
			switch (opcio) {
			case 1:
				obtenirVector(vector1);
				break;
			case 2:
				obtenirVector(vector2);
				break;
			case 3:
				veureVector(vector1);
				break;
			case 4:
				veureVector(vector2);
				break;
			case 5:
				ordenarVector(vector1);
				break;
			case 6:
				ordenarVector(vector2);
				break;
			case 7: // if (!concatenar(vector2,vector3,vector1))
				if (!concatenar(vector1, vector2, vector3))
					System.out.println("No s'ha pogut concatenar");
				break;
			case 8:
				veureVector(vector3);
				break;
			case 9:
				ordenarVector(vector3);
				break;
			case 10:
				System.out.println("Primer Vector:");
				obtenirVector(vector1);
				System.out.println("Segon Vector");
				obtenirVector(vector2);
				if (concatenar(vector1, vector2, vector3)) {
					ordenarVector(vector3);
					System.out.println("Vector Fusionat:");
					veureVector(vector3);
				} else
					System.out.println("No s'han pogut fusionar els vectors");
				break;
			case 11:
				System.out.println("Primer Vector:");
				obtenirVector(vector1);
				ordenarVector(vector1);
				System.out.println("Segon Vector");
				obtenirVector(vector2);
				ordenarVector(vector2);
				fusioDeLuxe(vector1, vector2, vector3);
				System.out.println("Vector Fusionat:");
				veureVector(vector3);
				break;
			case 0:
			default:
			}
		} while (opcio != 0);

	}

	/*
	 * fusiona vector1 i vector2 sobre vector3 de manera que vector3 ja queda
	 * ordenar correctament Per la qual cosa necessita que vector1 i vector2
	 * estiguin ja ordenats prèviament Exemple: si vector1 és: {10,20,30} vector2
	 * és: {15,25,30} vector3 quedarà: {10,15,20,25,30,30} SENSE FER CRIDA A
	 * ordenarVector(vector3)
	 */
	static void fusioDeLuxe(int[] vector1, int[] vector2, int[] vector3) {
		ordenarVector(vector1);
		ordenarVector(vector2);
		int j = 0;
		int k = 0;
		int p = 0;
		for (int i = 0; i < 6; i++) {
			System.out.println("MIRAR " + i);
			
			if (vector1[j] <= vector2[k]) {
				vector3[i] = vector1[j];
				System.out.println("j" + j);
				System.out.println(vector3[i]);
				if (vector1[j] == vector2[k]) {
					i++;
					vector3[i] = vector2[k];
					System.out.println("kj" + k);
					System.out.println(vector3[i]);
					
						k++;

				}

				
					j++;

			} else {
				vector3[i] = vector2[k];
				System.out.println("k" + k);
				System.out.println(vector3[i]);
				k++;

				// System.out.println(k);
			}
			
			if (k == 3 ) k=2;
			if (j == 3) j=2;
			p++;
			// vectorRes[i] = vector1[j];
			// vectorRes[i+1] = vector2[j];
			// i++;
			System.out.println("J " + j + " : K " + k );
		}
	}

	static int menu() {
		System.out.println("VECTOREANDO");
		System.out.println("-----------");
		System.out.println("1.- Obtenir Vector 1");
		System.out.println("2.- Obtenir Vector 2");
		System.out.println("3.- Veure Vector 1");
		System.out.println("4.- Veure Vector 2");
		System.out.println("5.- Ordenar Vector 1");
		System.out.println("6.- Ordenar Vector 2");
		System.out.println("7.- Concatenar Vectors");
		System.out.println("8.- Veure Vector 3");
		System.out.println("9.- Ordenar Vector 3");
		System.out.println("10.- Fusió Barata");
		System.out.println("11.- Fusió DeLuxe");
		System.out.println("0.- Sortir");
		return (sc.nextInt());
	}

	static void obtenirVector(int[] vector) {
		for (int i = 0; i < vector.length; i++) {
			System.out.println("Valor de l'element nº " + i + ": ");
			vector[i] = sc.nextInt();
		}
	}

	static void veureVector(int[] vector) {
		for (int i = 0; i < vector.length; i++)
			System.out.println("Posició nº " + i + ": " + vector[i]);
	}

	public static void ordenarVector(int[] vector) {
		int bombolla;
		for (int i = 0; i < vector.length; i++) {
			for (int j = 0; j < vector.length - 1; j++) {
				if (vector[j + 1] < vector[j]) {
					bombolla = vector[j + 1];
					vector[j + 1] = vector[j];
					vector[j] = bombolla;
				}
			}
		}
	}

	static boolean concatenar(int[] vector1, int[] vector2, int[] vectorRes) {
		boolean ok;
		if (vector1.length + vector2.length > vectorRes.length)
			ok = false;
		else {
			int x = 0;
			int y = 0;
			for (int i = 0; i < vectorRes.length; i++) {
				if (i < vector1.length) {
					vectorRes[i] = vector1[x];
					x++;
				} else {
					vectorRes[i] = vector2[y];
					y++;
				}
			}
			ok = true;
		}
		return ok;
	}

	/*
	 * static void concatenar (int[]vector1, int[]vector2, int[]vectorRes) { int
	 * x=0; int y=0; for (int i = 0;i<vectorRes.length;i++) { if (i<vector1.length)
	 * { vectorRes[i]=vector1[x]; x++; } else { vectorRes[i]=vector2[y]; y++; } } if
	 * (x+y==vector1.length+vector2.length) { System.out.println("Han concatenat.");
	 * } else { System.out.println("No han concatenat."); } }
	 */

}

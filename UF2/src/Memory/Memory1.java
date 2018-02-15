/*
 * Memory Sessió 1
 * Objectius:
 * 		- Definir taulers (de joc i secret)
 * 		- Menú principal i main per distribuir opcions
 * 		- Inicialitzar el tauler de joc
 * 		- Inicialitzar i remenar tauler secret
 * 		- possibilitat de visualitzar els taulers
 * 
 * 	Objectius (Sessió 2):
 * 		- fer les funcions 
 * 				--> demanar_posicio
 * 					(que que les coordenades siguin variables globals)
 * 				--> torn
 *
 * 	Objectius (Sessió 3):
 * 		- fer la funció joc completa (que el memory sigui ja plenament operatiu)
 *
 *	Objectius (Sessió 4):
 *		- Que l'usuari pugui triar les dimensions del tauler
 *		- Que es triar el tipus de jugador: humà o CPU
 *		- Si és CPU, aquesta triarà les caselles de manera aleatòria (joc bàsic)

 */

package Memory;

import java.util.Scanner;
/**
 * <h2>clase Empleado, se utiliza para crear y leer empleados de una BD </h2>
 * 
 * Busca información de Javadoc en <a href="http://www.google.com">GOOGLE</a>
 * @see <a href="http://www.google.com"b >N3XZR</a>
 * @version 1-2017
 * @author SOY YO 
 * @since 1-1-2017
 */

public class Memory1 {
	public static Scanner input = new Scanner(System.in);
	public static int TAULER;
//	public static char[][] Tauler = new char[TAULER][TAULER];
//	public static char[][] Secret = new char[TAULER][TAULER];
	public static Scanner sc = new Scanner(System.in);
	public static int fila;
	public static int columna;

	public static void main(String[] args) {
		int Opcio;
		System.out.println("Benvinguts al joc MEMORY!");
		System.out.println();
		
		TAULER = Obtenir_Dimensio();

		char[][] Tauler = new char[TAULER][TAULER];
		char[][] Secret = new char[TAULER][TAULER];

		do {
			Opcio = Menu();
			switch (Opcio) {
			default:
			case 0:
				break;

			case 1:
				Joc(Tauler,Secret);
				break;

			case 2:
				// TODO
				break;

			case 3:
				// TODO
				break;
			}
		} while (Opcio != 0);
	}

	public static void Inicialitzar_Tauler(char[][] Matriu) {
		for (int F = 0; F < TAULER; F++)
			for (int C = 0; C < TAULER; C++)
				Matriu[F][C] = '?';
	}

	public static void Mostrar_Tauler(char[][] Matriu) {
		for (int F = 0; F < TAULER; F++) {
			System.out.print(F);
			for (int C = 0; C < TAULER; C++)
				System.out.print(" " + Matriu[F][C]);
			System.out.println();
		}
		System.out.print("  ");
		for (int i=0;i<TAULER;i++)
			System.out.print(i+" ");
		System.out.println();
	}

	public static void Inicialitzar_Secret_Old(char[][] Matriu) {
		/*
		 * Matriu[0][0] = 'A'; Matriu[0][1] = 'A'; Matriu[0][2] = 66; //'B' ...
		 * (raonable per ser 16 posicions)
		 */

		for (int F = 0; F < TAULER; F++)
			for (int C = 0; C < TAULER; C++)
				if (F == 0)
					if (C == 0 || C == 1)
						Matriu[F][C] = 'A';
					else
						Matriu[F][C] = 'B';
				else if (F == 1)
					if (C == 0 || C == 1)
						Matriu[F][C] = 'C';
					else
						Matriu[F][C] = 'D';
				else if (F == 2)
					if (C == 0 || C == 1)
						Matriu[F][C] = 'E';
					else
						Matriu[F][C] = 'F';
				else if (F == 3)
					if (C == 0 || C == 1)
						Matriu[F][C] = 'G';
					else
						Matriu[F][C] = 'H';
	}

	public static void Remenar_Secret(char[][] Matriu) {
		int Fila, Columna;
		char Aux;

		for (int F = 0; F < TAULER; F++)
			for (int C = 0; C < TAULER; C++) {
				Fila = (int) (Math.random() * TAULER);
				Columna = (int) (Math.random() * TAULER);
				Aux = ' ';

				Aux = Matriu[F][C];
				Matriu[F][C] = Matriu[Fila][Columna];
				Matriu[Fila][Columna] = Aux;
			}
	}

	public static void Inicialitzar_Joc(char[][]Tauler,char[][]Secret) {
		Inicialitzar_Tauler(Tauler);
		Inicialitzar_Secret(Secret);
		Remenar_Secret(Secret);
	}

	public static void Joc(char[][]Tauler,char[][]Secret) {
		Inicialitzar_Joc(Tauler,Secret);
		// provisional, per provar torn
		jugar_XH(Tauler, Secret);
		/*
		 * boolean encert; int totalEncerts = 0; for(int i=0;i<TAULER*2;i++) { encert =
		 * torn(Tauler,Secret); if (encert) totalEncerts ++; }
		 * System.out.println("Total Encerts: " + totalEncerts);
		 */ // TODO
	}

	public static int Menu() {
		int Opcio;
		System.out.println("0. Sortir");
		System.out.println("1. Player vs Player");
		System.out.println("2. Player vs Ordinador (Selecció Aleatoria)");
		System.out.println("3. Player vs Ordinador (Selecció Inteligent)");
		do {
			System.out.print("Digues una Opció: ");
			Opcio = input.nextInt();
			if (Opcio > 3 || Opcio < 0)
				System.out.println("Opcio no vàlida");

		} while (Opcio > 3 || Opcio < 0);
		System.out.println();
		return Opcio;
	}

	public static void demanar_posicio(char[][] elMeuTauler) {
		do {
			// obtenir valor de coordenada X
			do {
				System.out.println("Digem la fila que vols?");
				fila = sc.nextInt();
				if (fila < 0 || fila >= TAULER)
					System.out.println("Si us plau, entre 0 i " + (TAULER - 1));
			} while (fila < 0 || fila >= TAULER);

			// obtenir valor de coordenada Y
			do {
				System.out.println("Digem la columna que vols?");
				columna = sc.nextInt();
				if (columna < 0 || columna >= TAULER)
					System.out.println("Si us plau, entre 0 i " + (TAULER - 1));
			} while (columna < 0 || columna >= TAULER);

			if (elMeuTauler[fila][columna] != '?')
				System.out.println("AQUESTA COORDENADA JA ESTA DESTAPADA!");

		} while (elMeuTauler[fila][columna] != '?');
	}

	static void Inicialitzar_Secret(char[][] Matriu) {
		char ascii = 65; // ASCII dec 65 = A equival a ascii='A';
		int comptador = 0;
		for (int F = 0; F < TAULER; F++)
			for (int C = 0; C < TAULER; C++) {
				if (comptador != 0 && (comptador % 2) == 0)
					ascii++;

				Matriu[F][C] = ascii;
				comptador++;
			}
	}

	public static boolean torn(char[][] tauler, char[][] secret) {
		boolean encert;

		Mostrar_Tauler(tauler);
		// demanar primera casella
		demanar_posicio(tauler);
		tauler[fila][columna] = secret[fila][columna];
		char cordenada1 = secret[fila][columna];
		Mostrar_Tauler(tauler);

		// per recordar quina casella hem destapat
		int xant = fila;
		int yant = columna;

		// demanar segona casella
		demanar_posicio(tauler);
		tauler[fila][columna] = secret[fila][columna];
		char cordenada2 = secret[fila][columna];
		Mostrar_Tauler(tauler);

		// comprovació de si l'has encertat o no
		if (cordenada1 == cordenada2) {
			encert = true;
			System.out.println("HAS ENCERTAT!");
		} else {
			System.out.println("TORNA A PROVAR!");
			encert = false;

			// tornem a tapar les caselles destapades (xant,yant) i (fila,columna)
			tauler[xant][yant] = '?';
			tauler[fila][columna] = '?';
		}

		return encert;
	}

	// Versió del Joc de Xavier Huete
	public static void jugar_XH(char[][] tauler, char[][] secret) {
		int puntsP1 = 0, puntsP2 = 0;
		boolean parella, win = false;
		int dealer = 0;  //jugador que te el torn (0 o 1)  
		do {
			System.out.println("Torn del Jugador " + (dealer+1));
			parella = torn(tauler, secret);
			if (parella == true) {
				if (dealer == 0) 
					puntsP1++;
				else 
					puntsP2++;

				System.out.println("Punts Jugador 1: " + puntsP1 + " Punts Jugador 2: " + puntsP2);
			}
			else
			/*	if (dealer ==0) 
					dealer =1;
				else
					dealer = 0;  */
				dealer = (dealer + 1) % 2 ;  //canvi de torn

			if (puntsP1 + puntsP2 == TAULER*TAULER/2) 
				win = true;
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	//pause d'un segon
			
		} while (win == false);

		if (puntsP1 == puntsP2) {
			System.out.println("Empat entre el Jugador 1 i el Jugador 2");
		} else {
			if (puntsP1 > puntsP2) {
				System.out.println("Guanya el Jugador 1 amb " + puntsP1 + " punts de " + TAULER*TAULER/2);
			} else {
				if (puntsP1 < puntsP2) {
					System.out.println("Guanya el Jugador 2 amb " + puntsP2 + " punts de "+ TAULER*TAULER/2);
				}
			}
		}
	}

	public static int Obtenir_Dimensio() {
		int dimensio;
		do {
			System.out.println("Digues la mida del tauler (número parell entre 2 i 10");
			dimensio = sc.nextInt();
		} while (dimensio%2 !=0 || dimensio<2 && dimensio >10);
		
		return dimensio;
	}
}

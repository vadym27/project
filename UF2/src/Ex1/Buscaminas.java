package Ex1;


import java.util.Random;
import java.util.Scanner;

public class Buscaminas {
	public static Scanner teclat = new Scanner(System.in);
	public static int fila;
	public static int columna;
	public static final int TOPE = 12;
	public static final int MIN = 3;
	public static final int BUIT = 0;
	public static final int MINA = 1;
	public static final int TAPAT = 9;
	public static final int MARCADA = -1;
	public static final int BOMBAZO = -2;
	
	public static int minas;
	//public static int[][] mines = new int[TOPE][TOPE];
	//public static int[][] camp = new int[TOPE][TOPE];
	public static Random r = new Random();
	public static boolean partidaEnCurs;
	public static int jugafila;
	public static int jugacolumna;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mines = new int[TOPE][TOPE];
		int[][] camp = new int[TOPE][TOPE];
		int opcio;
		System.out.println("Buscamines");
		System.out.println();
		do {
			opcio = menuPrincipal();
			switch (opcio) {
			case 0:
			default:
				break;
			case 1:
				ajuda();
				break;
			case 2:
				opcions();
				inicialitzar_mines(mines);
				inicialitzar_camp(camp);
				break;
			case 3:
				// System.err.println("WiP");
				partidaEnCurs = true;
				do {
					veure_tauler(camp);
					System.out.println("SECRET");
					veure_tauler(mines);
					partidaEnCurs = jugar(camp, mines);
					veure_tauler(camp);
				} while (partidaEnCurs);

				System.out.println("GAME OVER :(");
				break;
			case 4:
				System.err.println("WiP");
				break;
			case 5:
				inicialitzar_camp(camp);
				veure_tauler(camp);
				System.out.println("SECRET");
				inicialitzar_mines(mines);
				veure_tauler(mines);
				break;

			}
		} while (opcio != 0);
	}

	//inacabat, no comprova lÃ­mits
	public static int obtenirFila() {
		int f = teclat.nextInt();
		return f;
	}

	//inacabat, no comprova lÃ­mits
	public static int obtenirColumna() {
		int c = teclat.nextInt();
		return c;
	}

	
	public static boolean jugar(int camp[][], int mines[][]) {
		boolean resultat = true;
		String queFer;

		/*
		 f = obtenir fila correcta
		 c = obtenir columna correcta
		 comprovar si la casella camp[jugafila][jugacolumna] estÃ  destapada o no
		 if (camp[f][c] == TAPAT)
				preguntar si queremos destapar o marcar mina
				Si marca mina 
				 	camp[f][c] = MARCADA
				Else					
					Si casella conte mina (mines[f][c]==MINA)
						<<perd>>
						retornar false
					Else
						"expandir" 
					fisi
				fisi
		fisi
		// falta poder desmarcar una casella
*/

		int jugafila = obtenirFila();
		int jugacolumna = obtenirColumna();
		
		if (camp[jugafila][jugacolumna]==TAPAT) {
			boolean ok = false;
			do {
				System.out.println("Vols (D)destapar o (M)marcar mina");
				queFer = teclat.next();
				switch (queFer.charAt(0)) {
				case 'd':
				case 'D': if (mines[jugafila][jugacolumna]==MINA) {
							System.out.println("Havia mina!!!");
							camp[jugafila][jugacolumna]=BOMBAZO;
							resultat = false;
						  }
						  else {//expansiÃ³ !!!
							  int veines = expandir(mines,jugafila, jugacolumna);
							  camp[jugafila][jugacolumna]= veines;
						  }
						  ok = true;
						  break;
				case 'm': 
				case 'M': camp[jugafila][jugacolumna] = MARCADA;
						  ok = true;
						  break;
				default:  System.out.println("Si us plau, D/M");
				}
			} while (!ok);
		}		
		return resultat;
	}

	/*
	 * funciÃ³ que retornarÃ  el nÃºmero de mines adjacents a la posiciÃ³ mines[f][c]
	 */
	public static int expandir (int mines[][], int f, int c) {
		int bombes = 0;
		
		if (f>0) {		// mirar fila anterior  (-1)
			if (c>0) 			//columna anterior (-1)
				if (mines[f-1][c-1]==MINA) bombes ++;  //(f-1,c-1)
			if (mines[f-1][c]==MINA) bombes++;  //(f-1,c)
			if (c<columna-1)
				if (mines[f-1][c+1]==MINA) bombes++;  //(f-1,c+1)
		}

		//fila actual
		if (c>0) 			//columna anterior (-1)
			if (mines[f][c-1]==MINA) bombes ++;  //(f,c-1)
			if (c<columna-1)
				if (mines[f][c+1]==MINA) bombes++;  //(f,c+1)
	
		//fila posterior
		if (f<fila-1) {		
			if (c>0) 			//columna anterior (-1)
				if (mines[f+1][c-1]==MINA) bombes ++;  //(f+1,c-1)
			if (mines[f+1][c]==MINA) bombes++;  //(f+1,c)
			if (c<columna-1)
				if (mines[f+1][c+1]==MINA) bombes++;  //(f+1,c+1)
		}
		return bombes;
	}
	
	
	public static void opcions() {
		do {
			System.out.println("Digues les columnes del tauler:");
			columna = teclat.nextInt();
		} while (columna > TOPE || columna < MIN);
		do {
			System.out.println("Digues les files del tauler");
			fila = teclat.nextInt();
		} while (fila > TOPE || fila < MIN);
		do {
			System.out.println("Digues les mines que hi ha al tauler:");
			minas = teclat.nextInt();
		} while (minas > (columna * fila) / 3);
	}

	public static void inicialitzar_mines(int[][] mines) {
		int j = 0;
		int x, y;
		for (int f = 0; f < fila; f++)
			for (int c = 0; c < columna; c++)
				mines[f][c] = BUIT;

		for (int i = 0; i < minas; i++) {
			x = r.nextInt(fila);
			y = r.nextInt(columna);
			if (mines[x][y] == BUIT) {
				mines[x][y] = MINA;
			} else
				i--;
		}
	}

	public static void inicialitzar_camp(int[][] camp) {
		for (int f = 0; f < fila; f++)
			for (int c = 0; c < columna; c++)
				camp[f][c] = TAPAT;
	}

	public static void veure_tauler(int[][] tauler) {

		for (int f = 0; f < fila; f++) {
			System.out.print(f + " â•‘");
			for (int c = 0; c < columna; c++)
				System.out.print(" " + tauler[f][c]);
			System.out.println();
		}
		System.out.print("  â•š");
		for (int f = 0; f < fila; f++) {
			System.out.print("â•�â•�");
		}
		System.out.println("â•�");
		System.out.print("   ");
		for (int f = 0; f < fila; f++) {
			System.out.print(" " + f);
		}
		System.out.println();
	}

	public static void ajuda() {
		System.out.println("El juego consiste en despejar todas las casillas de una pantalla que no oculten una mina.\n"
				+ "Algunas casillas tienen un nÃºmero, el cual indica la cantidad de minas que hay en las casillas circundantes.\n"
				+ "AsÃ­, si una casilla tiene el nÃºmero 3, significa que de las ocho casillas que hay alrededor (si no es en una esquina o borde) \n"
				+ "hay 3 con minas y 5 sin minas. Si se descubre una casilla sin nÃºmero indica que ninguna de las casillas vecinas tiene mina y Ã©stas \n"
				+ "se descubren automÃ¡ticamente.\r\n"
				+ "Si se descubre una casilla con una mina se pierde la partida.");
		System.out.println();
	}

	public static int menuPrincipal() {
		int opcio;
		System.out.println("1.- Ajuda");
		System.out.println("2.- Inicialitzar Joc");
		System.out.println("3.- Jugar Partida");
		System.out.println("4.- Ranking (WiP)");
		System.out.println("0.- Sortir");
		do {
			System.out.println("Escull una opciÃ³:");
			opcio = teclat.nextInt();
			if (opcio > 5 || opcio < 0)
				System.err.println("Aquesta opciÃ³ no es correcta");
		} while (opcio > 5 || opcio < 0);
		return opcio;
	}

}

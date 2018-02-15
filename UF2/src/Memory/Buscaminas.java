package Memory;

import java.util.Random;
import java.util.Scanner;

public class Buscaminas {
	public static Scanner input = new Scanner(System.in);
	public static int TOPEF = 10;
	public static int TOPEC = 10;
	public static int MINES;
	public static int columnes = TOPEC;
	public static int files = TOPEF;
	public static int[][] camps = new int[files][columnes];
	public static int[][] mines = new int[files][columnes];
	public static Random r = new Random();
	public static int minesfiles;
	public static int minescolumnes;
	public static boolean partidaEnCurs = true;
	public static int intfil;
	public static int intcol;
	public static int find;
	public static int n9 = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcio;

		do {
			opcio = menu();
			switch (opcio) {
			case 1:

				break;
			case 2:
				options();
				campos(camps);
				mines(mines);
				find = MINES;
				break;
			case 3:

				veuretauler(camps);

				veuretauler(mines);
				joc();
				break;
			case 4:

				break;

			case 0:
				break;
			default:
				System.out.println("Posa la opcio que es trova en menu");
			}
		} while (opcio != 0);
	}

	static int menu() {
		System.out.println("           MENU");
		System.out.println("--------------------------");
		System.out.println("1.- Mostrar Ajuda");
		System.out.println("2.- Opcions");
		System.out.println("3.- Jugar Partida");
		System.out.println("4.- Veure Rankings");
		System.out.println("0.- Sortir");

		return (input.nextInt());
	}

	static void veuretauler(int[][] tauler) {
		System.out.println("  ╔═══╗");
		System.out.println("    " + find + "   Mines que falta per descobrir");
		System.out.println("  ╚═══╝");

		System.out.print("  ╔");
		for (int x = 0; x < TOPEC; x++)
			System.out.print("══");
		System.out.println("═╗");

		for (int x = 0; x < TOPEF; x++) {
			System.out.print(x + " ║ ");
			for (int y = 0; y < TOPEC; y++) {
				System.out.print(tauler[x][y] + " ");
			}
			System.out.print("║");
			System.out.println();

		}
		System.out.print("  ╚");
		for (int x = 0; x < TOPEC; x++)
			System.out.print("══");
		System.out.println("═╝");
		System.out.print("   ");
		for (int x = 0; x < TOPEC; x++)
			System.out.print(" " + x);

		System.out.println();
	}

	static void campos(int[][] camps) {
		for (int x = 0; x < TOPEF; x++) {
			for (int y = 0; y < TOPEC; y++) {
				camps[x][y] = 9;
			}
		}
	}

	static void mines(int[][] mines) {
		for (int x = 0; x < files; x++) {
			for (int y = 0; y < columnes; y++) {
				mines[x][y] = 0;
			}
		}
		for (int x = 0; x < MINES; x++) {
			minesfiles = r.nextInt(TOPEF);
			minescolumnes = r.nextInt(TOPEC);
			if (mines[minesfiles][minescolumnes] == 0) {
				mines[minesfiles][minescolumnes] = 1;
			} else
				x--;

		}
	}

	/*
	 * static void randomf(int randomfiles) { for (int i = 0; i < randomfiles; i++)
	 * { randomfiles = r.nextInt(TOPEF); for (int j = 0; j < i; j++) if (randomfiles
	 * == randomfiles) i--; } } static void randomc(int randomcolumnes) { for (int i
	 * = 0; i < randomcolumnes; i++) { randomcolumnes = r.nextInt(TOPEF); for (int j
	 * = 0; j < i; j++) if (randomcolumnes == randomcolumnes) i--; } }
	 */
	static void joc() {
		int casella = 0;
		boolean perdut = false;
		int resultat = (TOPEF * TOPEC) - MINES;
		while (perdut == false && partidaEnCurs == true) {
			posicion();
			if (mines[intfil][intcol] != 1) {
				// mines[intfil-1][intcol-1]; mines[intfil-1][intcol];
				// mines[intfil-1][intcol+1];
				// mines[intfil][intcol-1]; mines[intfil][intcol+1];
				// mines[intfil+1][intcol-1]; mines[intfil+1][intcol];
				// mines[intfil+1][intcol+1];
				if (intfil > 0 && intcol > 0 && intfil < TOPEF - 1 && intcol < TOPEC - 1) {
					casella = mines[intfil - 1][intcol - 1] + mines[intfil - 1][intcol] + mines[intfil - 1][intcol + 1]
							+ mines[intfil][intcol - 1] + mines[intfil][intcol + 1] + mines[intfil + 1][intcol - 1]
							+ mines[intfil + 1][intcol] + mines[intfil + 1][intcol + 1];
				}

				if (intfil == 0 && intcol == 0) {
					casella = mines[intfil][intcol + 1] + mines[intfil + 1][intcol] + mines[intfil + 1][intcol + 1];
				}
				// posicio 7 - 7
				if (intfil == TOPEF - 1 && intcol == TOPEC - 1) {
					casella = mines[intfil][intcol - 1] + mines[intfil - 1][intcol - 1] + mines[intfil - 1][intcol];

				}
				// posicio 0 7
				if (intfil == 0 && intcol == TOPEC - 1) {
					casella = mines[intfil + 1][intcol - 1] + mines[intfil + 1][intcol] + mines[intfil][intcol - 1];
				}
				// posicio 7 0
				if (intfil == TOPEF - 1 && intcol == 0) {
					casella = mines[intfil - 1][intcol] + mines[intfil - 1][intcol + 1] + mines[intfil][intcol + 1];
				}

				// posicions de 1 a 6 - COLUMNA 0
				if (intcol == 0 && intfil != 0 && intfil != TOPEF - 1) {
					casella = mines[intfil - 1][intcol] + mines[intfil - 1][intcol + 1] + mines[intfil][intcol + 1]
							+ mines[intfil + 1][intcol] + mines[intfil + 1][intcol + 1];
				}

				// posicions de 1 a 6 - FILA 0
				if (intfil == 0 && intcol != 0 && intcol != TOPEC - 1) {
					casella = mines[intfil][intcol - 1] + mines[intfil][intcol + 1] + mines[intfil + 1][intcol - 1]
							+ mines[intfil + 1][intcol] + mines[intfil + 1][intcol + 1];
				}

				// posicions de 1 a 6 - ULTIMA FILA
				if (intfil == TOPEF - 1 && intcol != 0 && intcol != TOPEC - 1) {
					casella = mines[intfil][intcol - 1] + mines[intfil][intcol + 1] + mines[intfil - 1][intcol - 1]
							+ mines[intfil - 1][intcol] + mines[intfil - 1][intcol + 1];
				}
				// posicions de 1 a 6 - ULTIMA COLUMNA
				if (intcol == TOPEC - 1 && intfil != 0 && intfil != TOPEF - 1) {
					casella = mines[intfil - 1][intcol - 1] + mines[intfil - 1][intcol] + mines[intfil][intcol - 1]
							+ mines[intfil + 1][intcol - 1] + mines[intfil + 1][intcol];
				}
				camps[intfil][intcol] = casella;
				veuretauler(camps);
				veuretauler(mines);

				n9++;
				if (resultat == n9) {
					partidaEnCurs = false;
					System.out.println("  ╔═════════════╗");
					System.out.println("  ║ HAS GUANYAT ║");
					System.out.println("  ╚═════════════╝");
				}

			} else {

				camps[intfil][intcol] = -2;
				veuretauler(camps);
				System.out.println("  ╔═══════════╗");
				System.out.println("  ║ HAS PEDUT ║");
				System.out.println("  ╚═══════════╝");
				perdut = true;

			}

			casella = 0;
		}
		// System.out.println(mines[intfil][intcol]);
	}

	static void posicion() {
		int f;
		int c;
		System.out.println("OPCIONS DEL JOC");
		System.out.println("? - Marcar la casilla");
		System.out.println("d - Desmarcar la casilla");
		System.out.println("p - Abrir casilla");
		
		
		char opciondejuego = input.next().charAt(0);
		switch (opciondejuego) {
		case '?':
			do {
				System.out.println("Introdueix fila: ");
				f = input.nextInt();
			} while (intfil >= TOPEF);
			do {
				System.out.println("Introdueix columna: ");
				c = input.nextInt();
			} while (intcol >= TOPEF);
			camps[f][c] = '?';
			find--;
			break;
		case 'd':
		case 'D':
			do {
				System.out.println("Introdueix fila: ");
				f = input.nextInt();
			} while (intfil >= TOPEF);
			do {
				System.out.println("Introdueix columna: ");
				c = input.nextInt();
			} while (intcol >= TOPEF);
			camps[f][c] = 9;
			find++;
			break;
		case 'p':
		case 'P':
			do {
				System.out.println("Introdueix fila: ");
				intfil = input.nextInt();
			} while (intfil >= TOPEF);
			do {
				System.out.println("Introdueix columna: ");
				intcol = input.nextInt();
			} while (intcol >= TOPEF);
			break;
		}
		/*
		 * do { System.out.println("Introdueix fila: "); intfil = input.nextInt(); }
		 * while (intfil >= TOPEF); do { System.out.println("Introdueix columna: ");
		 * intcol = input.nextInt(); } while (intcol >= TOPEF);
		 */
	}

	static void options() {
		System.out.println("Introdueix Nº Files: ");
		TOPEF = input.nextInt();
		System.out.println("Introdueix Nº Columnes: ");
		TOPEC = input.nextInt();
		do {
			System.out.println("Introdueix Nº Mines: ");
			MINES = input.nextInt();
		} while (MINES > (TOPEF * TOPEC) / 3);
	}

}

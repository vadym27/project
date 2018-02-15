package Memory;

import java.util.Scanner;

public class ConectaCuatro {
	public static Scanner input = new Scanner(System.in);
	public static int TOPEF = 6;
	public static int TOPEC = 7;
	public static int columnes = TOPEC;
	public static int files = TOPEF;
	public static char[][] matriu = new char[files][columnes];
	public static boolean ple = false;
	public static int nople = 0;
	public static boolean partida = true;
	public static boolean jugador = true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcio;

		iniciar(matriu);
		ver(matriu);
		joc(matriu);

		do {
			opcio = menu();
			switch (opcio) {
			case 1:
				System.out.println("Juega al conecta 4 contra el ordenador. Consigue conectar 4 fichas de tu color\r\n"
						+ "\r\n" + "Escriu la columna en la que quieras soltar tus fichas");
				break;
			case 2:

				break;
			case 3:

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
		System.out.println("1.- Informació del joc");
		System.out.println("2.- Jugar partida multijugador");
		System.out.println("3.- Single Player");
		System.out.println("0.- Sortir");

		return (input.nextInt());
	}

	static void iniciar(char[][] tauler) {
		for (int x = 0; x < TOPEF; x++) {
			for (int y = 0; y < TOPEC; y++) {
				tauler[x][y] = '*';
			}
		}

	}

	static void ver(char[][] tauler) {
		for (int x = 0; x < TOPEF; x++) {
			System.out.print(x + " ");
			for (int y = 0; y < TOPEC; y++) {
				System.out.print(tauler[x][y] + " ");
			}
			System.out.println();
		}
		System.out.print("  ");
		for (int y = 0; y < TOPEC; y++)
			System.out.print(y + " ");
		System.out.println();


	}

	static void joc(char[][] tauler) {
		
		System.out.println("    Jugador 1");
		System.out.println();
		int a = 0;
		while (partida = true) {
			int casella;
			do {
				System.out.println("Introdueix la casella: ");
				casella = input.nextInt();
			} while (casella > TOPEC - 1);
			nople = TOPEF;
			for (int x = 0; x < TOPEF; x++) {
				if (tauler[x][casella] == '*') {
					ple = true;
					nople--;
				}

			}

			int quantsplens = (TOPEF - 1) - nople;
			//System.out.println(quantsplens + " : " + TOPEF + " : " + nople);
			if (a%2==0) {
				jugador = false;
				if (nople != TOPEF)
					tauler[quantsplens][casella] = 'X';
				else
					System.out.println("Aquesta columna ja esta plena!");
				
			}
			else {
				jugador = true;
				if (nople != TOPEF)
					tauler[quantsplens][casella] = 'O';
				else
					System.out.println("Aquesta columna ja esta plena!");
				
			} 
			ver(matriu);
			a++;
			if (a%2==0)
				System.out.println("    Jugador 1");
			else System.out.println("    Jugador 2");
			System.out.println();
			//https://www.youtube.com/watch?v=o0GSZzvMQAg
			//https://www.youtube.com/watch?v=HMKZ1ef2dOE
			
		}
	}
}

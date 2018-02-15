package Memory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Memory {
	public static Scanner input = new Scanner(System.in);
	public static final int columnes = 4;
	public static final int files = 4;
	public static char[][] tauler = null;
	public static char[][] tauler1 = null;
	public static char[][] taulerlisto = null;
	public static int parelles = 0;
	public static int vector[] = new int[2];
	public static int vector1[] = new int[2];
	public static int torn = 5;
	public static int jugador1 = 0;
	public static int jugador2 = 0;
	public static Random r = new Random();

	public static void main(String[] args) {
		int opcio;
		// TODO Auto-generated method stub
		secretTauler();
		taulero1();
		do {
			opcio = menu();
			switch (opcio) {
			case 1:
				veureTauler(tauler);
				multiplayer();
				ganador();
				break;
			case 2:
				veureTauler(tauler);
				ordinador();
				ganador();
				break;
			case 3:
				veureTauler(tauler);
				single();

				break;
			case 4:
				veureTauler(tauler1);
				break;
			case 5:
				veureTauler(tauler);
				OrOr();
				ganador();
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
		System.out.println("1.- Jugador -VS- Jugador");
		System.out.println("2.- Jugador -VS- Ordinador");
		System.out.println("3.- Single Player");
		System.out.println("4.- Resposta");
		System.out.println("0.- Sortir");

		return (input.nextInt());
	}

	static void secretTauler() {
		tauler = new char[files][columnes];
		for (int x = 0; x < files; x++) {
			for (int y = 0; y < columnes; y++) {
				tauler[x][y] = '?';
			}
		}
	}

	static void veureTauler(char[][] tauler) {
		for (int x = 0; x < files; x++) {
			System.out.print(x + "| ");
			for (int y = 0; y < columnes; y++) {
				System.out.print(tauler[x][y] + " ");

			}
			System.out.println();
		}
		System.out.println("----------");
		System.out.println("   0 1 2 3");
		System.out.println();
	}


	static void torn() {
		if (torn == 0) {

			if (tauler1[vector[0]][vector1[0]] == tauler1[vector[1]][vector1[1]]) {
				jugador1++;
			} else {
				torn = 1;

			}
		} else {
			if (torn == 1) {

				if (tauler1[vector[0]][vector1[0]] == tauler1[vector[1]][vector1[1]]) {
					jugador2++;
				} else {
					torn = 0;

				}
			}
		}

	}

	static void ganador() {

		if (jugador1 > jugador2) {
			System.out.println("GANADOR ES EL JUGADOR 1 " + jugador1);
		}
		if (jugador1 < jugador2) {
			System.out.println("GANADOR ES EL JUGADOR 2 " + jugador2);
		}
		if (jugador1 == jugador2) {
			System.out.println("EMPAT " + jugador1 + " " + jugador2);
		}

	}

	static void single() {
		int ff, ff1;
		int cc, cc1;

		while (parelles != 16) {

			for (int i = 0; i < 2; i++) {
				System.out.println("Tirada Nº" + (i + 1));
				System.out.println("Introdueix la fila: ");
				vector[i] = input.nextInt();
				System.out.println("Introdueix la columna: ");
				vector1[i] = input.nextInt();

				if (vector[i] <= 3 || vector1[i] <= 3) {
					if (tauler[vector[i]][vector1[i]] != '?') {
						System.out.println(
								"ERROR! Has introduit la pocisio que ja esta descobera. Prova un altre vegada!");
						i--;
					} else {
						tauler[vector[i]][vector1[i]] = tauler1[vector[i]][vector1[i]];
						veureTauler(tauler);
					}
				} else {
					System.out.println("ERROR! Has introduit les posicions que estan fora del joc.");
					i--;
				}

			}

			for (int i = 0; i < 2; i++) {
				if (tauler1[vector[0]][vector1[0]] == tauler1[vector[1]][vector1[1]]) {
					tauler[vector[i]][vector1[i]] = tauler1[vector[i]][vector1[i]];
					parelles++;
				} else {
					tauler[vector[i]][vector1[i]] = '?';
				}
			}
			if (parelles != 16) {
				if (tauler1[vector[0]][vector1[0]] == tauler1[vector[1]][vector1[1]])
					System.out.println("Coincideixen! Pots tornar a tirar.");
			} else {
				System.out.println("No coincideixen...");
				// System.out.println();
			}

			// veureTauler();
			// solucioTauler();
			// System.out.println(parelles);

		}
		System.out.println("FINISH!");

	}

	
	
	static void multiplayer() {
		torn = 0;
		while (parelles != 16) {

			for (int i = 0; i < 2; i++) {
				System.out.println("Jugador Nº: " + (torn + 1));
				System.out.println("Tirada Nº: " + (i + 1));
				System.out.println("Introdueix la fila: ");
				vector[i] = input.nextInt();
				System.out.println("Introdueix la columna: ");
				vector1[i] = input.nextInt();

				if (vector[i] <= 3 || vector1[i] <= 3) {
					if (tauler[vector[i]][vector1[i]] != '?') {
						System.out.println(
								"ERROR! Has introduit la pocisio que ja esta descobera. Prova un altre vegada!");
						i--;
					} else {
						tauler[vector[i]][vector1[i]] = tauler1[vector[i]][vector1[i]];
						veureTauler(tauler);
					}
				} else {
					System.out.println("ERROR! Has introduit les posicions que estan fora del joc.");
					i--;
				}

			}
			for (int i = 0; i < 2; i++) {
				if (tauler1[vector[0]][vector1[0]] == tauler1[vector[1]][vector1[1]]) {
					tauler[vector[i]][vector1[i]] = tauler1[vector[i]][vector1[i]];
					parelles++;
				} else {
					tauler[vector[i]][vector1[i]] = '?';
				}
			}
			if (parelles != 16) {
				if (tauler1[vector[0]][vector1[0]] == tauler1[vector[1]][vector1[1]])
					System.out.println("Coincideixen! Pots tornar a tirar.");
			} else {
				System.out.println("No coincideixen...");
				// System.out.println();
			}

			// veureTauler();
			// solucioTauler();
			// System.out.println(parelles);
			torn();
		}

	}

	static void ordinador() {
		torn = 0;
		while (parelles != 16) {
			if (torn == 0) {
				for (int i = 0; i < 2; i++) {
					System.out.println("Jugador Nº: " + (torn + 1));
					System.out.println("Tirada Nº: " + (i + 1));
					System.out.println("Introdueix la fila: ");
					vector[i] = input.nextInt();
					System.out.println("Introdueix la columna: ");
					vector1[i] = input.nextInt();

					if (vector[i] <= 3 || vector1[i] <= 3) {
						if (tauler[vector[i]][vector1[i]] != '?') {
							System.out.println(
									"ERROR! Has introduit la pocisio que ja esta descobera. Prova un altre vegada!");
							i--;
						} else {
							tauler[vector[i]][vector1[i]] = tauler1[vector[i]][vector1[i]];
							veureTauler(tauler);
						}
					} else {
						System.out.println("ERROR! Has introduit les posicions que estan fora del joc.");
						i--;
					}

				}
			}
			if (torn == 1) {
				for (int i = 0; i < 2; i++) {
					System.out.println("Jugador Nº: " + (torn + 1));
					System.out.println("Tirada Nº" + (i + 1));
					System.out.println("Introdueix la fila: ");
					vector[i] = r.nextInt(4);
					System.out.println("Introdueix la columna: ");
					vector1[i] = r.nextInt(4);

					if (vector[i] <= 3 || vector1[i] <= 3) {
						if (tauler[vector[i]][vector1[i]] != '?') {
							System.out.println(
									"ERROR! Has introduit la pocisio que ja esta descobera. Prova un altre vegada!");
							i--;
						} else {
							tauler[vector[i]][vector1[i]] = tauler1[vector[i]][vector1[i]];
							try {
								Thread.sleep(1200);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							veureTauler(tauler);
						}
					} else {
						System.out.println("ERROR! Has introduit les posicions que estan fora del joc.");
						i--;
					}

				}

			}
			for (int i = 0; i < 2; i++) {
				if (tauler1[vector[0]][vector1[0]] == tauler1[vector[1]][vector1[1]]) {
					tauler[vector[i]][vector1[i]] = tauler1[vector[i]][vector1[i]];
					parelles++;
				} else {
					tauler[vector[i]][vector1[i]] = '?';
				}
			}
			if (parelles != 16) {
				if (tauler1[vector[0]][vector1[0]] == tauler1[vector[1]][vector1[1]])
					System.out.println("Coincideixen! Pots tornar a tirar.");
				else {
					System.out.println("No coincideixen...");
					// System.out.println();
				}
			}

			// veureTauler();
			// solucioTauler();
			// System.out.println(parelles);
			torn();
		}
	}
	static void OrOr() {
		torn = 0;
		while (parelles != 16) {
			
				for (int i = 0; i < 2; i++) {
					System.out.println("Jugador Nº: " + (torn + 1));
					System.out.println("Tirada Nº: " + (i + 1));
					System.out.println("Introdueix la fila: ");
					vector[i] = r.nextInt(4);
					System.out.println("Introdueix la columna: ");
					vector1[i] = r.nextInt(4);

					if (vector[i] <= 3 || vector1[i] <= 3) {
						if (tauler[vector[i]][vector1[i]] != '?') {
							System.out.println(
									"ERROR! Has introduit la pocisio que ja esta descobera. Prova un altre vegada!");
							i--;
						} else {
							tauler[vector[i]][vector1[i]] = tauler1[vector[i]][vector1[i]];
							try {
								Thread.sleep(1200);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							veureTauler(tauler);
						}
					} else {
						System.out.println("ERROR! Has introduit les posicions que estan fora del joc.");
						i--;
					}

				}
			
			
			for (int i = 0; i < 2; i++) {
				if (tauler1[vector[0]][vector1[0]] == tauler1[vector[1]][vector1[1]]) {
					tauler[vector[i]][vector1[i]] = tauler1[vector[i]][vector1[i]];
					parelles++;
				} else {
					tauler[vector[i]][vector1[i]] = '?';
				}
			}
			if (parelles != 16) {
				if (tauler1[vector[0]][vector1[0]] == tauler1[vector[1]][vector1[1]])
					System.out.println("Coincideixen! Pots tornar a tirar.");
				else {
					System.out.println("No coincideixen...");
					// System.out.println();
				}
			}

			// veureTauler();
			// solucioTauler();
			// System.out.println(parelles);
			torn();
		}
	}
	static void orlisto() {
		torn = 0;
		while (parelles != 16) {
			if (torn == 0) {
				for (int i = 0; i < 2; i++) {
					System.out.println("Jugador Nº: " + (torn + 1));
					System.out.println("Tirada Nº: " + (i + 1));
					System.out.println("Introdueix la fila: ");
					vector[i] = input.nextInt();
					System.out.println("Introdueix la columna: ");
					vector1[i] = input.nextInt();

					if (vector[i] <= 3 || vector1[i] <= 3) {
						if (tauler[vector[i]][vector1[i]] != '?') {
							System.out.println(
									"ERROR! Has introduit la pocisio que ja esta descobera. Prova un altre vegada!");
							i--;
						} else {
							tauler[vector[i]][vector1[i]] = tauler1[vector[i]][vector1[i]];
							veureTauler(tauler);
						}
					} else {
						System.out.println("ERROR! Has introduit les posicions que estan fora del joc.");
						i--;
					}

				}
			}
			if (torn == 1) {
				for (int i = 0; i < 2; i++) {
					System.out.println("Jugador Nº: " + (torn + 1));
					System.out.println("Tirada Nº" + (i + 1));
					System.out.println("Introdueix la fila: ");
					vector[i] = r.nextInt(4);
					System.out.println("Introdueix la columna: ");
					vector1[i] = r.nextInt(4);

					if (vector[i] <= 3 || vector1[i] <= 3) {
						if (tauler[vector[i]][vector1[i]] != '?') {
							System.out.println(
									"ERROR! Has introduit la pocisio que ja esta descobera. Prova un altre vegada!");
							i--;
						} else {
							tauler[vector[i]][vector1[i]] = tauler1[vector[i]][vector1[i]];
							try {
								Thread.sleep(1200);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							veureTauler(tauler);
						}
					} else {
						System.out.println("ERROR! Has introduit les posicions que estan fora del joc.");
						i--;
					}

				}

			}
			for (int i = 0; i < 2; i++) {
				if (tauler1[vector[0]][vector1[0]] == tauler1[vector[1]][vector1[1]]) {
					tauler[vector[i]][vector1[i]] = tauler1[vector[i]][vector1[i]];
					parelles++;
				} else {
					tauler[vector[i]][vector1[i]] = '?';
				}
			}
			if (parelles != 16) {
				if (tauler1[vector[0]][vector1[0]] == tauler1[vector[1]][vector1[1]])
					System.out.println("Coincideixen! Pots tornar a tirar.");
				else {
					System.out.println("No coincideixen...");
					// System.out.println();
				}
			}

			// veureTauler();
			// solucioTauler();
			// System.out.println(parelles);
			torn();
		}
	}
	
	
	static void taulero1() {
		ArrayList<Character> lista = new ArrayList<Character>();
		lista.add('A');
		lista.add('A');
		lista.add('B');
		lista.add('B');
		lista.add('C');
		lista.add('C');
		lista.add('D');
		lista.add('D');
		lista.add('E');
		lista.add('E');
		lista.add('F');
		lista.add('F');
		lista.add('G');
		lista.add('G');
		lista.add('H');
		lista.add('H');
		Collections.shuffle(lista);
		tauler1 = new char[files][columnes];
		int a = 0;
		for (int x = 0; x < files; x++) {
			for (int y = 0; y < columnes; y++) {
				tauler1[x][y] = lista.get(a);
				a++;

			}
		}
	}
}

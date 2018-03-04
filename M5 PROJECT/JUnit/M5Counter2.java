package Memory;

import java.util.Scanner;

public class M5Counter2 {

	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion;
		char rounds[] = new char[99999];

		/*
		 * opcion = input.nextInt(); switch (opcion) { case 1:
		 * System.out.println("El joc s'acaba quan un equipo WIN/LOST/DRAW. \n" +
		 * "El que tens que introduir es L - Lost (Has perdut aquesta ronda) W - Win (Has ganat aquesta ronda) D - (Has explotat/defusat la bomba)"
		 * );
		 * 
		 * break; case 2: joc(rounds); break; case 0: break; default:
		 * System.out.println("Posa la opcio que es trova en menu"); }
		 */
		joc(rounds);

	}

	public static void joc(char rounds[]) {
		int casos;
		int money = 0;
		int bonus = 0;
		int lostseguits = 0;
		int lost = 0;
		int win = 0;

		boolean partida = true;
		String resultat;

		// System.out.println("Introdueix els casos:");
		casos = input.nextInt();
		for (int y = 0; y < casos; y++) {
			int x = 0;
			// System.out.println("Introdueix el resultat de la ronda:");
			do {

				rounds[x] = input.next().charAt(0);

				if (rounds[x] == 'W' || rounds[x] == 'w') {
					money = money + 3250;
					lostseguits = 0;
					win++;
					
				}
				if (rounds[x] == 'L' || rounds[x] == 'l') {

					if (x > 0 && (rounds[x - 1] == 'L' || rounds[x - 1] == 'l')) {

						if (lostseguits >= 4) {
							bonus = 2000;
							// System.out.println("Eres muy malo jugando Counter!!");
						} else {
							bonus = 500 * (lostseguits );
							
						}
						money = money + 1400 + bonus;

					} else
						money = money + 1400;
					lost++;
					lostseguits++;
				}
				if (rounds[x] == 'D' || rounds[x] == 'd') {
					money = money + 3500;
					lostseguits = 0;
					win++;
				}

				resultat = resoldre(win, lost);

				if (resultat!="???") {
					System.out.println(resultat);
					partida = false;
				}
				x++;
			} while (partida != false);
			System.out.println("$" + money);
			System.out.println("Punts del teu equip: " + win);
			System.out.println("Punts del altre equip: " + lost);
			win = 0;
			lost = 0;
			lostseguits = 0;
			money = 0;
			partida = true;
		}

		// return (input.next().charAt(0));
	}

	static String resoldre(int win, int lost) {

		String res = "???";

		if (win == 15 && lost == 15) 
			res = "-Empat-";
		if (win == 16 && lost < 15) 
			res = "Has ganat!";
		if (win < 15 && lost == 16) 
			res = "Has perdut!";
		return res;
	}

}

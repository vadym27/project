package Memory;

import java.util.Scanner;

/**
  * Juego Counter-Strike
  *
  * @author Vadym Koshtovnyi
  * @version 04.03.2018
  * 
 */



public class M5CounterDoc {

	public static Scanner input = new Scanner(System.in);

/**
 * Esta es la nuestra funcion principal del juego
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char rounds[] = new char[99999];
		joc(rounds);

	}
 /**
  * En esta funcions estan todas las normativas del juego.
  * Casos de juego
  * Dinero adquirido por rondas ganadas o perdidas
  * Las rondas ganadas y perdidas ( en nuestro caso ganadas son los de tu equipo y perdidas de otro )
  * @param rounds  Valor ingresado por el usuario. (Son las rondas de un caso. 30 es el maximo de rondas de un caso.)
  *
  */
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


	}


	/**
	 * WIN ( 16 rondas y otro menos de 15 )
	 * LOST ( menos de 15 y otro 16 rondas )
	 * EMPATE ( 15 = 15 rondas ) 
	 * @param win  son las rondas ganadas (Si ganas 16 rondas y el otro equipo tiene menos de 15, escribe un mensaje "Has ganat!")
	 * @param lost  son las rondas que has perdido ( Si las rondas perdidas son 16 y ganadas menos de 14, escribe un mensaje "Has perdut!") 
	 * @return  retorna un valor (String) de resultado, cual nos quiere decir si hemos ganado, perdido o empate.
	 */
	public static String resoldre(int win, int lost) {

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

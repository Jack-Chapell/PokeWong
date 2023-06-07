import java.lang.Thread;
import java.util.*;
import java.io.*;

public class Game {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.out.println(".______     ______    __  ___  ___________    __    ____  ______   .__   __.   _______ \r\n"
				+ "|   _  \\   /  __  \\  |  |/  / |   ____\\   \\  /  \\  /   / /  __  \\  |  \\ |  |  /  _____|\r\n"
				+ "|  |_)  | |  |  |  | |  '  /  |  |__   \\   \\/    \\/   / |  |  |  | |   \\|  | |  |  __  \r\n"
				+ "|   ___/  |  |  |  | |    <   |   __|   \\            /  |  |  |  | |  . `  | |  | |_ | \r\n"
				+ "|  |      |  `--'  | |  .  \\  |  |____   \\    /\\    /   |  `--'  | |  |\\   | |  |__| | \r\n"
				+ "| _|       \\______/  |__|\\__\\ |_______|   \\__/  \\__/     \\______/  |__| \\__|  \\______| \r\n"
				+ "                                                                                       ");
		System.out.println(
				"                                 Must Capture All of Them                                    ");

		Thread.sleep(2000);
		// initialize arrays and load pokes
		Animal[] team1 = new Animal[3];
		Animal[] team2 = new Animal[3];

		for (int i = 0; i < team1.length; i++) {
			team1[i] = new Animal();
			team2[i] = new Animal();
		}

		File team1File = new File("team1.csv");
		File team2File = new File("team2.csv");

		Scanner read1 = new Scanner(team1File);
		Scanner read2 = new Scanner(team2File);
		Scanner input = new Scanner(System.in);

		for (int i = 0; i < team1.length; i++) {
			String[] split1 = read1.nextLine().split(",");
			String[] split2 = read2.nextLine().split(",");

			team1[i].setName(split1[0]);
			team2[i].setName(split2[0]);

			team1[i].setHealth(Double.parseDouble(split1[1]));
			team2[i].setHealth(Double.parseDouble(split2[1]));

			team1[i].setAttack(Double.parseDouble(split1[2]));
			team2[i].setAttack(Double.parseDouble(split2[2]));

			team1[i].setDefense(Double.parseDouble(split1[3]));
			team2[i].setDefense(Double.parseDouble(split2[3]));

			team1[i].setFear(Double.parseDouble(split1[4]));
			team2[i].setFear(Double.parseDouble(split2[4]));

			team1[i].setStrength(Double.parseDouble(split1[5]));
			team2[i].setStrength(Double.parseDouble(split2[5]));
		}
		// funny dialogue
		System.out
				.println("You may choose between 2 teams of Pokewong: \nmysterious and powerful creatures, they are ");
		System.out.println("\nTeam 1");

		for (int i = 0; i < team1.length; i++) {
			System.out.println(team1[i].toString());
			Thread.sleep(750);
		}
		Thread.sleep(1500);

		System.out.println("\nTeam 2");

		for (int i = 0; i < team2.length; i++) {
			System.out.println(team2[i].toString());
			Thread.sleep(750);
		}
		Thread.sleep(1500);

		Random r = new Random();

		System.out.println("\n" + team1[r.nextInt(0, 3)].getName() + " says, \"I Don't want to die\"");
		Thread.sleep(1000);
		System.out.println("\n" + team2[r.nextInt(0, 3)].getName() + " says, \"Why are humans so cruel\"");

		int choice = 0;
		// create new array variables that represent human vs computer
		Animal[] player = new Animal[3];
		Animal[] computer = new Animal[3];
		while (choice != 1 && choice != 2) {
			System.out.println("\nWhich team will you choose [1/2]");

			choice = input.nextInt();

			if (choice == 1) {
				player = team1;
				computer = team2;
				System.out.println("You chose team 1");
			} else if (choice == 2) {
				player = team2;
				computer = team1;
				System.out.println("Yo chose team 2");
			} else {
				System.out.println("Choose a team with the right number\n");
			}
		}
		Thread.sleep(1000);

		choice = 0;
		int playerPoke = 0;

		while (choice != 1 && choice != 2 && choice != 3) {
			System.out.println("Pick a PokeWong to fight with\n" + "1. " + player[0].getName() + "\n" + "2. "
					+ player[1].getName() + "\n" + "3. " + player[2].getName() + "\n[1,2,3]");

			choice = input.nextInt();

			if (choice == 1) {
				playerPoke = 0;
			} else if (choice == 2) {
				playerPoke = 1;
			} else if (choice == 3) {
				playerPoke = 2;
			} else {
				System.out.println("Choose a PokeWong with the right number\n");
			}
		}
		System.out.println("You chose " + player[playerPoke].getName());
		Thread.sleep(1500);

		int compPoke = r.nextInt(0, 3);
		System.out.println("The computer chose " + computer[compPoke].getName());

		Thread.sleep(1000);

		System.out.println(
				"                                                                                                                             ___   \r\n"
						+ "                                     .---.                                                                                .'/   \\  \r\n"
						+ "/|                                   |   |      __.....__                        .--. __  __   ___         __.....__     / /     \\ \r\n"
						+ "||                                   |   |  .-''         '.                      |__||  |/  `.'   `.   .-''         '.   | |     | \r\n"
						+ "||                      .|       .|  |   | /     .-''\"'-.  `.                .|  .--.|   .-.  .-.   ' /     .-''\"'-.  `. | |     | \r\n"
						+ "||  __        __      .' |_    .' |_ |   |/     /________\\   \\             .' |_ |  ||  |  |  |  |  |/     /________\\   \\|/`.   .' \r\n"
						+ "||/'__ '.  .:--.'.  .'     | .'     ||   ||                  |           .'     ||  ||  |  |  |  |  ||                  | `.|   |  \r\n"
						+ "|:/`  '. '/ |   \\ |'--.  .-''--.  .-'|   |\\    .-------------'          '--.  .-'|  ||  |  |  |  |  |\\    .-------------'  ||___|  \r\n"
						+ "||     | |`\" __ | |   |  |     |  |  |   | \\    '-.____...---.             |  |  |  ||  |  |  |  |  | \\    '-.____...---.  |/___/  \r\n"
						+ "||\\    / ' .'.''| |   |  |     |  |  |   |  `.             .'              |  |  |__||__|  |__|  |__|  `.             .'   .'.--.  \r\n"
						+ "|/\\'..' / / /   | |_  |  '.'   |  '.''---'    `''-...... -'                |  '.'                        `''-...... -'    | |    | \r\n"
						+ "'  `'-'`  \\ \\._,\\ '/  |   /    |   /                                       |   /                                          \\_\\    / \r\n"
						+ "           `--'  `\"   `'-'     `'-'                                        `'-'                                            `''--'  ");

		// battle sequence
		int playerPokeLeft = 3;
		int compPokeLeft = 3;
		
		while (playerPokeLeft > 0 && compPokeLeft > 0) {
			int win = 0;
			int condition = 0;
			String playerName = player[playerPoke].getName();
			String compName = computer[compPoke].getName();
			System.out.println("Comfort your PokeWong if it's fear goes above 100");
			while (win == 0) {
				condition = 0;
				while (condition == 0) {
					System.out.println("\n" + playerName + ", Health: " + player[playerPoke].getHealth() + ", Fear: "
							+ player[playerPoke].getFear());
					System.out.println("Your turn, what will " + playerName + " do?\n" + "1. Attack" + "\n2. Comfort");
					int action = input.nextInt();

					if (action == 1) {
						if (player[playerPoke].getFear() <= 100) {
							int crit = r.nextInt(0, 5);
							if (crit == 0) {
								computer[compPoke]
										.damage(player[playerPoke].getStrength() * player[playerPoke].getAttack());
								System.out.println("You got a CRTICAL HIT and did " + (player[playerPoke].getStrength()
										* player[playerPoke].getAttack() * computer[compPoke].getDefense()) + " to "
										+ compName);
								Thread.sleep(1000);
								System.out.println(playerName
										+ " looks guilty about the damage it just did and runs up to you, but you don't care and yell at it until it returns to battle");
								player[playerPoke].addFear(10);
								condition = 1;
							} else {
								computer[compPoke].damage(player[playerPoke].getStrength());
								System.out.println(playerName + " dealt "
										+ (player[playerPoke].getStrength() * computer[compPoke].getDefense())
										+ " damage to " + compName);
								Thread.sleep(1000);
								System.out.println(playerName + " says \"I don't want to fight\", however, you don't care");
								player[playerPoke].addFear(5);
								condition = 1;
							}
						} else {
							System.out.println(playerName
									+ " is too afraid to battle, and begins to cry not listening to your commands");
							player[playerPoke].setFear(100);
							condition = 1;
						}

					} else if (action == 2) {
						System.out.println("You try to comfort your PokeWong, it only works a little");
						player[playerPoke].addFear(-10);
						condition = 1;
					} else {
						System.out.println("Since you cleary can't figure out how to enter a number, you did nothing");
						condition = 0;
					}
				}

				if (player[playerPoke].getHealth() <= 0 || computer[compPoke].getHealth() <= 0) {
					win = 1;
				} 

				Thread.sleep(1000);
				if (win == 0) {
					System.out.println("\n" + compName + "'s turn. Health: " + computer[compPoke].getHealth());
					Thread.sleep(1000);
					int compAction = r.nextInt(0, 10);

					if (compAction == 0) {
						System.out.println("As much as the computer tells " + compName + " to fight, it refuses in fear");
					} else if (compAction <= 2) {
						player[playerPoke].damage(computer[compPoke].getStrength() * computer[compPoke].getAttack());
						System.out.println(compName
								+ " got a CRTICAL HIT and did " + (computer[compPoke].getStrength()
										* computer[compPoke].getAttack() * player[playerPoke].getDefense())
								+ " to " + playerName);
						Thread.sleep(1000);
						System.out.println(compName + " fears death with a look of guilt in it's eyes");
					} else {
						player[playerPoke].damage(computer[compPoke].getStrength());
						System.out.println(
								compName + " did " + (computer[compPoke].getStrength() * player[playerPoke].getDefense())
										+ " damage to " + playerName);
						Thread.sleep(1000);
					}
					
					if (player[playerPoke].getHealth() <= 0 || computer[compPoke].getHealth() <= 0) {
						win = 1;
					} 
				}

			}
			
			Thread.sleep(2000);
			
			if (player[playerPoke].getHealth() <= 0) {
				System.out.println("You lost and " + playerName + " is dead. Look what you've done.");
				Thread.sleep(2000);
				playerPokeLeft --;
				if (playerPokeLeft > 0) {
					System.out.println("Time to send a new PokeWong into battle");
					ArrayList<Integer> playerChoices = new ArrayList<Integer>();
					for (int i = 0 ; i < player.length; i ++) {
						if (player[i].getHealth() > 0) {
							playerChoices.add(i);
						}
						
					}
					playerPoke = playerChoices.get(r.nextInt(0, playerChoices.size()));
					
					System.out.println("You send " + player[playerPoke].getName() + " into battle");
				} else {
					System.out.println("You have run out of PokeWong");
					win = 1;
				}
				
			} else {
				System.out.println("You won, but now the blood of " + compName + " is on your hands. Was it truly worth it?");
				Thread.sleep(2000);
				compPokeLeft --;
				if (compPokeLeft > 0) {
					System.out.println("The computer will send in it's next PokeWong:");
					ArrayList<Integer> compChoices = new ArrayList<Integer>();
					for (int i = 0 ; i < computer.length; i ++) {
						if (computer[i].getHealth() > 0) {
							compChoices.add(i);
						}
						
					
						
					}
					compPoke = compChoices.get(r.nextInt(0, compChoices.size()));
					System.out.println("\n" + computer[compPoke].getName());
				} else {
					System.out.println("The computer has run out of PokeWong");
					win = 1;
				}
				
			}
		}
		
		if (playerPokeLeft <= 0) {
			System.out.println("You Lose");
			Thread.sleep(1000);
			System.out.println("                                                                                                                         \r\n"
				+ "`8.`8888.      ,8'  ,o888888o.     8 8888      88           8 888888888o.       8 8888 8 8888888888   8 888888888o.      \r\n"
				+ " `8.`8888.    ,8'. 8888     `88.   8 8888      88           8 8888    `^888.    8 8888 8 8888         8 8888    `^888.   \r\n"
				+ "  `8.`8888.  ,8',8 8888       `8b  8 8888      88           8 8888        `88.  8 8888 8 8888         8 8888        `88. \r\n"
				+ "   `8.`8888.,8' 88 8888        `8b 8 8888      88           8 8888         `88  8 8888 8 8888         8 8888         `88 \r\n"
				+ "    `8.`88888'  88 8888         88 8 8888      88           8 8888          88  8 8888 8 888888888888 8 8888          88 \r\n"
				+ "     `8. 8888   88 8888         88 8 8888      88           8 8888          88  8 8888 8 8888         8 8888          88 \r\n"
				+ "      `8 8888   88 8888        ,8P 8 8888      88           8 8888         ,88  8 8888 8 8888         8 8888         ,88 \r\n"
				+ "       8 8888   `8 8888       ,8P  ` 8888     ,8P           8 8888        ,88'  8 8888 8 8888         8 8888        ,88' \r\n"
				+ "       8 8888    ` 8888     ,88'     8888   ,d8P            8 8888    ,o88P'    8 8888 8 8888         8 8888    ,o88P'   \r\n"
				+ "       8 8888       `8888888P'        `Y88888P'             8 888888888P'       8 8888 8 888888888888 8 888888888P'      ");
		} else {
			System.out.println("You Won");
			Thread.sleep(1000);
			System.out.println("Y88b   d88P                     888       888                   \r\n"
					+ " Y88b d88P                      888   o   888                   \r\n"
					+ "  Y88o88P                       888  d8b  888                   \r\n"
					+ "   Y888P  .d88b.  888  888      888 d888b 888  .d88b.  88888b.  \r\n"
					+ "    888  d88\"\"88b 888  888      888d88888b888 d88\"\"88b 888 \"88b \r\n"
					+ "    888  888  888 888  888      88888P Y88888 888  888 888  888 \r\n"
					+ "    888  Y88..88P Y88b 888      8888P   Y8888 Y88..88P 888  888 \r\n"
					+ "    888   \"Y88P\"   \"Y88888      888P     Y888  \"Y88P\"  888  888 \r\n"
					+ "                                                                \r\n"
					+ "                                                                \r\n"
					+ "                                                                ");
		}
		
		

	}

}

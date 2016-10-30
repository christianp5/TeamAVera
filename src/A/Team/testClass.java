package A.Team;

import java.util.Scanner;

public class testClass {

    public static void main(String[] args)
    {

//		This is slotMachine constructor for reference:
//		public SlotMachine(String machineName, int machineBalance, int jackpotOdds,
//				int jackpotPayAmount, int regularWinOdds, int regularPayout){

        // Creates each of the slot machine objects
        Machines lucky777 = new Machines("Lucky 777", 5000, 10000, 5000, 10, 5);
        Machines luckyLotto = new Machines("Lucky Lotto", 55000, 100000, 75000, 50, 25);
        Machines purplePeopleEater = new Machines("Purple People Eater", 1000, 50, 40, 5, 2);

        int i = 0;
        double displayCurrentPlayerBalance = 0.0F;
        int playerCount = 1;
        int slotRunOnce = 0;

        // creates array of 50 players
        Player slotPlayers[] = new Player[50];

        // initialize player array
        for(i=0;i<slotPlayers.length;i++)
        {
            slotPlayers[i] = new Player();
        }

        int currentPlayerLoaded = 0;
        String displayCurrentPlayer = "Vera";
        slotPlayers[0].loadVera();
        displayCurrentPlayerBalance = slotPlayers[currentPlayerLoaded].getMoneyBalance();

        String userChoice = " ";
        Scanner input = new Scanner(System.in);
        while(userChoice.charAt(0) != 'Q')
        {
            //	userChoice = " "; // resets userChoice
            System.out.println("*******************************************************");
            System.out.println("***              Vera Plays Vegas                   ***");
            System.out.println("***                 Main Menu                       ***");
            System.out.println("*******************************************************");
            System.out.println("Current player:  " + slotPlayers[currentPlayerLoaded].getName().getFirstName() + " " + slotPlayers[currentPlayerLoaded].getName().getLastName());
            System.out.println("Current balance: " + slotPlayers[currentPlayerLoaded].getMoneyBalance());
            System.out.println("*******************************************************");
            System.out.println("A. Add a new player (each player starts with $20)");
            System.out.println("B. Play a Slot Machine");
            System.out.println("C. Slot Machine Stats");
            System.out.println("D. List players and set current player");
            System.out.println("");
            System.out.println("Q. Quit");
            System.out.println("*******************************************************");
            System.out.println("Enter selection: ");

            userChoice = input.next();
            userChoice = userChoice.toUpperCase();

            switch(userChoice.charAt(0))
            {

                case 'A':

                    userChoice = " "; // resets userChoice
                    if(playerCount != 50)
                    {
                        slotPlayers[playerCount].addNewPlayer();
                        playerCount++;
                    }

                    else
                        System.out.println("Max players is 50. You cannot add more players");
                    break;

                case 'B':

                    while(userChoice.charAt(0) != 'Q')
                    {
                        System.out.println("*******************************************************");
                        System.out.println("***              Vera Plays Vegas                   ***");
                        System.out.println("***           Play Slot Machine Menu                ***");
                        System.out.println("*******************************************************");
                        System.out.println("Current player:  " + slotPlayers[currentPlayerLoaded].getName().getFirstName() + " " + slotPlayers[currentPlayerLoaded].getName().getLastName());
                        System.out.println("Current balance: " + slotPlayers[currentPlayerLoaded].getMoneyBalance());
                        System.out.println("*******************************************************");
                        System.out.println("           Choose a slot machine to play               ");
                        System.out.println("*******************************************************");
                        System.out.println("A. Lucky 777");
                        System.out.println("B. Lucky Lotto");
                        System.out.println("C. Purple People Eater");
                        System.out.println("");
                        System.out.println("Q. Back to Main Menu");
                        System.out.println("*******************************************************");
                        System.out.println("Enter selection: ");

                        userChoice = input.next();
                        userChoice = userChoice.toUpperCase();

                        switch(userChoice.charAt(0))
                        {
                            case 'A': // play Lucky 777
                                userChoice = " "; // resets userChoice
                                if (slotPlayers[0].getMoneyBalance() > 0)
                                {
                                    // current player plays Lucky 777
                                    lucky777.playMachine(slotPlayers[currentPlayerLoaded]);
                                    displayCurrentPlayerBalance = slotPlayers[currentPlayerLoaded].getMoneyBalance();
                                }
                                break;

                            case 'B':
                                userChoice = " "; // resets userChoice
                                if (slotPlayers[0].getMoneyBalance() > 0)
                                {
                                    luckyLotto.playMachine(slotPlayers[currentPlayerLoaded]);
                                    displayCurrentPlayerBalance = slotPlayers[currentPlayerLoaded].getMoneyBalance();
                                }
                                break;

                            case 'C':
                                userChoice = " "; // resets userChoice
                                if (slotPlayers[0].getMoneyBalance() > 0)
                                {
                                    // current player plays Lucky Lotto
                                    purplePeopleEater.playMachine(slotPlayers[currentPlayerLoaded]);
                                    displayCurrentPlayerBalance = slotPlayers[currentPlayerLoaded].getMoneyBalance();
                                }
                                break;

                            case 'Q':
                                System.out.println("Returning to Main Menu...");
                                break;

                            default:
                                System.out.println("\nYou need to select one from the menu!\n");

                        }; // end nested switch
                    }// end while (Play Slot Machine Menu)

                    userChoice = " "; // resets choice input after each sub menu while loop
                    break;

                case 'C': // slot stats

                    while(userChoice.charAt(0) != 'Q')
                    {

                        //	userChoice = " "; // resets choice input
                        System.out.println("*******************************************************");
                        System.out.println("***              Vera Plays Vegas                   ***");
                        System.out.println("***           Slot Machine Stats Menu               ***");
                        System.out.println("*******************************************************");
                        System.out.println("A. For all machines");
                        System.out.println("B. For a machine");
                        System.out.println("");
                        System.out.println("Q. Back to Main Menu");
                        System.out.println("*******************************************************");
                        System.out.println("Enter selection: ");

                        userChoice = input.next();
                        userChoice = userChoice.toUpperCase();

                        switch(userChoice.charAt(0))
                        {
                            case 'A': // play Lucky 777

                                userChoice = " "; // resets userChoice
                                System.out.println("*******************************************************");
                                System.out.println("***              Vera Plays Vegas                   ***");
                                System.out.println("***          All  Slot Machine Stats                ***");
                                System.out.println("*******************************************************");
                                System.out.println(lucky777.getMachineName() + " balance is: $" + lucky777.getMachineBalance());
                                System.out.println(lucky777.getMachineName() + " total plays: " + lucky777.getMachineTotalPlaysCount());
                                System.out.println("*******************************************************");
                                System.out.println(luckyLotto.getMachineName() + " balance is: " + luckyLotto.getMachineBalance());
                                System.out.println(luckyLotto.getMachineName() + " total plays: " + luckyLotto.getMachineTotalPlaysCount());
                                System.out.println("*******************************************************");
                                System.out.println(purplePeopleEater.getMachineName() + " balance is: " + purplePeopleEater.getMachineBalance());
                                System.out.println(purplePeopleEater.getMachineName() + " total plays: " + purplePeopleEater.getMachineTotalPlaysCount());
                                System.out.println("*******************************************************");
                                break;

                            case 'B':

                                while(userChoice.charAt(0) != 'Q')
                                {
                                    System.out.println("*******************************************************");
                                    System.out.println("***              Vera Plays Vegas                   ***");
                                    System.out.println("***     Slot Machine Stats by Machine Menu          ***");
                                    System.out.println("*******************************************************");
                                    System.out.println("A. Lucky 777 Stats");
                                    System.out.println("B. Lucky Lotto Stats");
                                    System.out.println("C. Purple People Eater Stats");
                                    System.out.println("");
                                    System.out.println("Q. Back to Main Menu");
                                    System.out.println("*******************************************************");
                                    System.out.println("Enter selection: ");

                                    userChoice = input.next();
                                    userChoice = userChoice.toUpperCase();

                                    switch(userChoice.charAt(0))
                                    {

                                        case 'A': // play Lucky 777
                                            System.out.println("*******************************************************");
                                            System.out.println(lucky777.getMachineName() + " balance is: " + lucky777.getMachineBalance());
                                            System.out.println(lucky777.getMachineName() + " total plays: " + lucky777.getMachineTotalPlaysCount());
                                            System.out.println("*******************************************************");
                                            break;

                                        case 'B':
                                            System.out.println("*******************************************************");
                                            System.out.println(luckyLotto.getMachineName()+ " balance is: " + luckyLotto.getMachineBalance());
                                            System.out.println(luckyLotto.getMachineName() + " total plays: " + luckyLotto.getMachineTotalPlaysCount());
                                            System.out.println("*******************************************************");
                                            break;

                                        case 'C': // Purple People Eater Stats
                                            System.out.println("*******************************************************");
                                            System.out.println(purplePeopleEater.getMachineName() + " balance is: " + purplePeopleEater.getMachineBalance());
                                            System.out.println(purplePeopleEater.getMachineName() + " total plays: " + purplePeopleEater.getMachineTotalPlaysCount());
                                            System.out.println("*******************************************************");
                                            break;

                                        case 'Q':
                                            System.out.println("Returning to Slot Machine Menu...");
                                            break;

                                        default:
                                            System.out.println("\nYou need to select one from the menu!\n");

                                    }; // end nested switch
                                }// end while (Slot Machine Stats by Machine Menu)

                                userChoice = " "; // resets choice input after each sub menu while loop
                                break;

                            case 'Q':
                                System.out.println("Returning to Main Menu...");
                                break;

                            default:
                                System.out.println("\nYou need to select one from the menu!\n");

                        }; // end switch
                    } // end while (Slot Machine Stats Menu)

                    userChoice = " "; // resets choice input after each sub menu while loop
                    break;

                case 'D': // set currentPlayerLoaded

                    // Displays list of available players to choose from
                    for(i=0;i<playerCount;i++)
                    {
                        if(slotPlayers[i].getName().getFirstName() != null)
                        {
                            System.out.println((i+1) + ". " +	slotPlayers[i].getName().getFirstName() + " " + slotPlayers[i].getName().getLastName());
                        }
                    }

                    System.out.print("Choose number of player to load: ");
                    currentPlayerLoaded = input.nextInt();
                    currentPlayerLoaded = currentPlayerLoaded - 1;
                    displayCurrentPlayer = slotPlayers[currentPlayerLoaded].getName().getFirstName();
                    break;

                case 'Q':
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("\nYou need to select one from the menu!\n");

            }; // end switch
        } // end while (Main Menu)
    }
}


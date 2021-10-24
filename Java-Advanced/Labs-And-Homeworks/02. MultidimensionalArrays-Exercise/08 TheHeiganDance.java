import java.util.Scanner;

public class TheHeiganDance_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double damageHeiganTurn = Double.parseDouble(scanner.nextLine());
        int[][] matrix = new int[15][15];
        double heiganPoints = 3000000;
        int playerPoints = 18500;
        int playerRow = 7;
        int playerCol = 7;
        boolean isPlagueCloud = false;
        String spell = "";
        while (heiganPoints > 0 && playerPoints > 0) {
            heiganPoints -= damageHeiganTurn;
            if (isPlagueCloud) {
                playerPoints -= 3500;
                isPlagueCloud = false;
            }
            if (playerPoints <= 0) {
                spell = "Plague Cloud";
                break;
            }
            if (heiganPoints <= 0) {
                break;
            }

            String[] input = scanner.nextLine().split("\\s+");
            spell = input[0];
            int damageRow = Integer.parseInt(input[1]);
            int damageCol = Integer.parseInt(input[2]);
            boolean playerIsAreaDamage = checkPlayerIsAreaDamage(playerRow, playerCol, damageRow, damageCol);
            if (playerIsAreaDamage) {
                if (!checkPlayerIsAreaDamage(playerRow - 1, playerCol, damageRow, damageCol) && checkRange(matrix, playerRow - 1, playerCol)) {
                    playerRow--;
                } else if (!checkPlayerIsAreaDamage(playerRow, playerCol + 1, damageRow, damageCol) && checkRange(matrix, playerRow, playerCol + 1)) {
                    playerCol++;
                } else if (!checkPlayerIsAreaDamage(playerRow + 1, playerCol, damageRow, damageCol) && checkRange(matrix, playerRow + 1, playerCol)) {
                    playerRow++;
                } else if (!checkPlayerIsAreaDamage(playerRow, playerCol - 1, damageRow, damageCol) && checkRange(matrix, playerRow, playerCol - 1)) {
                    playerCol--;
                } else {
                    if (spell.equals("Cloud")) {
                        isPlagueCloud = true;
                        playerPoints -= 3500;
                    } else if (spell.equals("Eruption")) {
                        playerPoints -= 6000;
                    }
                }
            }
        }
        printOutput(heiganPoints, spell, playerPoints, playerRow, playerCol);
    }

    private static boolean checkPlayerIsAreaDamage(int playerRow, int playerCol, int damageRow, int damageCol) {
        if (playerRow == damageRow && playerCol == damageCol) {
            return true;
        }
        if (playerRow == damageRow - 1 && playerCol == damageCol - 1) {
            return true;
        }
        if (playerRow == damageRow - 1 && playerCol == damageCol) {
            return true;
        }
        if (playerRow == damageRow - 1 && playerCol == damageCol + 1) {
            return true;
        }
        if (playerRow == damageRow && playerCol == damageCol - 1) {
            return true;
        }
        if (playerRow == damageRow && playerCol == damageCol + 1) {
            return true;
        }
        if (playerRow == damageRow + 1 && playerCol == damageCol - 1) {
            return true;
        }
        if (playerRow == damageRow + 1 && playerCol == damageCol) {
            return true;
        }
        if (playerRow == damageRow + 1 && playerCol == damageCol + 1) {
            return true;
        }
        return false;
    }

    private static boolean checkRange(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static void printOutput(double heiganPoints, String spell, int playerPoints, int playerRow, int playerCol) {
        if (heiganPoints <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", heiganPoints);
        }
        if (playerPoints <= 0) {
            System.out.printf("Player: Killed by %s%n", spell);
        } else {
            System.out.printf("Player: %d%n", playerPoints);
        }
        System.out.printf("Final position: %d, %d", playerRow, playerCol);
    }
}
import java.util.*;

public class RadioactiveMutantVampireBunnies_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sizeLair = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = sizeLair[0];
        int cols = sizeLair[1];

        char[][] lair = new char[rows][cols];
        Map<Integer, List<Integer>> bunnyCords = new TreeMap<>();
        int rowPlayer = -5;
        int colPlayer = -5;
        for (int row = 0; row < lair.length; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < lair[row].length; col++) {
                char currentSymbol = line.charAt(col);
                lair[row][col] = currentSymbol;
                if (currentSymbol == 'B') {
                    bunnyCords.putIfAbsent(row, new ArrayList<>());
                    bunnyCords.get(row).add(col);
                } else if (currentSymbol == 'P') {
                    rowPlayer = row;
                    colPlayer = col;
                }
            }
        }
        String directions = scanner.nextLine();
        boolean isWins = false;
        boolean isKill = false;
        for (char direction : directions.toCharArray()) {
            if (direction == 'U') {
                if (rowPlayer - 1 < 0) {
                    lair[rowPlayer][colPlayer] = '.';
                    isWins = true;
                }
                if (!isWins) {
                    if (lair[rowPlayer - 1][colPlayer] == '.') {
                        lair[rowPlayer - 1][colPlayer] = 'P';
                    } else if (lair[rowPlayer - 1][colPlayer] == 'B') {
                        isKill = true;
                    }
                    lair[rowPlayer][colPlayer] = '.';
                    rowPlayer--;
                }
            } else if (direction == 'D') {
                if (rowPlayer + 1 >= rows) {
                    lair[rowPlayer][colPlayer] = '.';
                    isWins = true;
                }
                if (!isWins) {
                    if (lair[rowPlayer + 1][colPlayer] == '.') {
                        lair[rowPlayer + 1][colPlayer] = 'P';
                    } else if (lair[rowPlayer + 1][colPlayer] == 'B') {
                        isKill = true;
                    }
                    lair[rowPlayer][colPlayer] = '.';
                    rowPlayer++;
                }
            } else if (direction == 'L') {
                if (colPlayer - 1 < 0) {
                    lair[rowPlayer][colPlayer] = '.';
                    isWins = true;
                }
                if (!isWins) {
                    if (lair[rowPlayer][colPlayer - 1] == '.') {
                        lair[rowPlayer][colPlayer - 1] = 'P';
                    } else if (lair[rowPlayer][colPlayer - 1] == 'B') {
                        isKill = true;
                    }
                    lair[rowPlayer][colPlayer] = '.';
                    colPlayer--;
                }
            } else if (direction == 'R') {
                if (colPlayer + 1 >= cols) {
                    lair[rowPlayer][colPlayer] = '.';
                    isWins = true;
                }
                if (!isWins) {
                    if (lair[rowPlayer][colPlayer + 1] == '.') {
                        lair[rowPlayer][colPlayer + 1] = 'P';
                    } else if (lair[rowPlayer][colPlayer + 1] == 'B') {
                        isKill = true;
                    }
                    lair[rowPlayer][colPlayer] = '.';
                    colPlayer++;
                }
            }

            Map<Integer, List<Integer>> newBunnyCods = new TreeMap<>();
            for (Map.Entry<Integer, List<Integer>> row : bunnyCords.entrySet()) {
                for (Integer col : row.getValue()) {
                    if (row.getKey() - 1 >= 0) {
                        if (lair[row.getKey() - 1][col] == 'P') {
                            isKill = true;
                            lair[row.getKey() - 1][col] = 'B';
                        } else if (lair[row.getKey() - 1][col] == '.') {
                            lair[row.getKey() - 1][col] = 'B';
                            newBunnyCods.putIfAbsent(row.getKey() - 1, new ArrayList<>());
                            newBunnyCods.get(row.getKey() - 1).add(col);
                        }
                    }
                    if (row.getKey() + 1 < rows) {
                        if (lair[row.getKey() + 1][col] == 'P') {
                            isKill = true;
                            lair[row.getKey() - 1][col] = 'B';
                        } else if (lair[row.getKey() + 1][col] == '.') {
                            lair[row.getKey() + 1][col] = 'B';
                            newBunnyCods.putIfAbsent(row.getKey() + 1, new ArrayList<>());
                            newBunnyCods.get(row.getKey() + 1).add(col);
                        }
                    }
                    if (col - 1 >= 0) {
                        if (lair[row.getKey()][col - 1] == 'P') {
                            isKill = true;
                            lair[row.getKey() - 1][col] = 'B';
                        } else if (lair[row.getKey()][col - 1] == '.') {
                            lair[row.getKey()][col - 1] = 'B';
                            newBunnyCods.putIfAbsent(row.getKey(), new ArrayList<>());
                            newBunnyCods.get(row.getKey()).add(col - 1);
                        }
                    }
                    if (col + 1 < cols) {
                        if (lair[row.getKey()][col + 1] == 'P') {
                            isKill = true;
                            lair[row.getKey() - 1][col] = 'B';
                        } else if (lair[row.getKey()][col + 1] == '.') {
                            lair[row.getKey()][col + 1] = 'B';
                            newBunnyCods.putIfAbsent(row.getKey(), new ArrayList<>());
                            newBunnyCods.get(row.getKey()).add(col + 1);
                        }
                    }
                }
            }
            if (isKill || isWins) {
                break;
            }
            addedNewBunnyCods(bunnyCords, newBunnyCods);
        }

        printMatrix(lair);
        printResult(isKill, rowPlayer, colPlayer);
    }

    //    private static char[][] readMatrix(Scanner scanner, int rows, int cols) {
//        char[][] lair = new char[rows][cols];
//        for (int row = 0; row < lair.length; row++) {
//            String line = scanner.nextLine();
//            for (int col = 0; col < lair[row].length; col++) {
//                lair[row][col] = line.charAt(col);
//            }
//        }
//        return lair;
//    }
    private static void addedNewBunnyCods(Map<Integer, List<Integer>> bunnyCords, Map<Integer, List<Integer>> newBunnyCods) {
        for (Map.Entry<Integer, List<Integer>> row : newBunnyCods.entrySet()) {
            for (Integer col : row.getValue()) {
                bunnyCords.putIfAbsent(row.getKey(), new ArrayList<>());
                bunnyCords.get(row.getKey()).add(col);
            }
        }
    }

    private static void printMatrix(char[][] lair) {
        for (int row = 0; row < lair.length; row++) {
            for (int col = 0; col < lair[row].length; col++) {
                System.out.print(lair[row][col]);
            }
            System.out.println();
        }
    }

    private static void printResult(boolean isKill, int rowPlayer, int colPlayer) {
        if (isKill) {
            System.out.printf("dead: %d %d", rowPlayer, colPlayer);
        } else {
            System.out.printf("won: %d %d", rowPlayer, colPlayer);
        }
    }
}
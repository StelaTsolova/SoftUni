import java.util.Scanner;

public class ArrayManipulator_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        String[] command = scanner.nextLine().split(" ");
        while (!command[0].equals("end")) {
            switch (command[0]) {
                case "exchange":
                    int indexElementExchange = Integer.parseInt(command[1]);
                    if (indexElementExchange == array.length - 1) {
                        break;
                    }
                    boolean isValidIndexElement = checkIndex(indexElementExchange, array);
                    if (isValidIndexElement) {
                        array = exchangesArray(indexElementExchange, array);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "max":
                    int indexMaxElement = getIndexElement(command[1], command[0], array);
                    printOutput(indexMaxElement);
                    break;
                case "min":
                    int indexMinElement = getIndexElement(command[1], command[0], array);
                    printOutput(indexMinElement);
                    break;
                case "first":
                    int countFirstElements = Integer.parseInt(command[1]);
                    boolean isValidCountFirstEl = checkCount(countFirstElements, array);
                    if (isValidCountFirstEl) {
                        String[] firstCountElements = getCountElements(countFirstElements, array, command[2], command[0]);
                        int countZero = getCountZero(firstCountElements);
                        printOutputCountElements(countZero, firstCountElements);
                    } else {
                        System.out.println("Invalid count");
                    }
                    break;
                case "last":
                    int countLastElements = Integer.parseInt(command[1]);
                    boolean isValidCountLastEl = checkCount(countLastElements, array);
                    if (isValidCountLastEl) {
                        String[] lastCountElements = getCountElements(countLastElements, array, command[2], command[0]);
                        int countZero = getCountZero(lastCountElements);
                        printOutputCountElements(countZero, lastCountElements);
                    } else {
                        System.out.println("Invalid count");
                    }
                    break;
            }
            command = scanner.nextLine().split(" ");
        }
        printFormatArray(array);
    }

    private static boolean checkIndex(int indexElementExchange, int[] array) {
        return indexElementExchange < array.length && indexElementExchange >= 0;
    }

    private static int[] exchangesArray(int countExchanges, int[] array) {
        for (int i = 0; i < countExchanges + 1; i++) {
            int firstNumber = array[0];
            for (int j = 0; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }
            array[array.length - 1] = firstNumber;
        }
        return array;
    }

    private static int getIndexElement(String typeNumber, String value, int[] array) {
        int index = -1;
        if (typeNumber.equals("even")) {
            if (value.equals("max")) {
                index = getMaxEven(array);
            } else if (value.equals("min")) {
                index = getMinEven(array);
            }
        } else if (typeNumber.equals("odd")) {
            if (value.equals("max")) {
                index = getMaxOdd(array);
            } else if (value.equals("min")) {
                index = getMinOdd(array);
            }
        }
        return index;
    }

    private static int getMaxEven(int[] array) {
        int indexMaxNumber = -1;
        int maxNumber = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0 && array[i] >= maxNumber) {
                maxNumber = array[i];
                indexMaxNumber = i;
            }
        }
        return indexMaxNumber;
    }

    private static int getMaxOdd(int[] array) {
        int indexMaxNumber = -1;
        int maxNumber = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0 && array[i] >= maxNumber) {
                maxNumber = array[i];
                indexMaxNumber = i;
            }
        }
        return indexMaxNumber;
    }

    private static int getMinEven(int[] array) {
        int indexMinNumber = -1;
        int minNumber = 1001;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0 && array[i] <= minNumber) {
                minNumber = array[i];
                indexMinNumber = i;
            }
        }
        return indexMinNumber;
    }

    private static int getMinOdd(int[] array) {
        int indexMinNumber = -1;
        int minNumber = 1001;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0 && array[i] <= minNumber) {
                minNumber = array[i];
                indexMinNumber = i;
            }
        }
        return indexMinNumber;
    }

    private static void printOutput(int indexElement) {
        if (indexElement == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(indexElement);
        }
    }

    private static boolean checkCount(int count, int[] array) {
        return count <= array.length;
    }

    private static String[] getCountElements(int count, int[] array, String typeElements, String typeStartDirection) {
        String[] countElements = new String[count];
        if (typeElements.equals("even")) {
            if (typeStartDirection.equals("first")) {
                countElements = firstCountEvenElements(count, array);
            } else if (typeStartDirection.equals("last")) {
                countElements = lastCountEvenElements(count, array);
            }
        } else if (typeElements.equals("odd")) {
            if (typeStartDirection.equals("first")) {
                countElements = firstCountOddElements(count, array);
            } else if (typeStartDirection.equals("last")) {
                countElements = lastCountOddElements(count, array);
            }
        }
        return countElements;
    }

    private static String[] firstCountEvenElements(int count, int[] array) {
        String[] firstEvenCountElements = new String[count];
        int index = 0;
        for (int element : array) {
            if (element % 2 == 0) {
                if (index == count) {
                    break;
                }
                firstEvenCountElements[index++] = String.valueOf(element);
            }
        }
        return firstEvenCountElements;
    }

    private static String[] firstCountOddElements(int count, int[] array) {
        String[] firstOddCountElements = new String[count];
        int index = 0;
        for (int element : array) {
            if (element % 2 != 0) {
                if (index == count) {
                    break;
                }
                firstOddCountElements[index++] = String.valueOf(element);
            }
        }
        return firstOddCountElements;
    }

    private static String[] lastCountEvenElements(int count, int[] array) {
        String[] lastEvenCountElements = new String[count];
        int index = lastEvenCountElements.length - 1;
        for (int j = array.length - 1; j >= 0; j--) {
            if (array[j] % 2 == 0) {
                if (index == -1) {
                    break;
                }
                lastEvenCountElements[index--] = String.valueOf(array[j]);
            }
        }
        return lastEvenCountElements;
    }

    private static String[] lastCountOddElements(int count, int[] array) {
        String[] lastOddCountElements = new String[count];
        int index = lastOddCountElements.length - 1;
        for (int j = array.length - 1; j >= 0; j--) {
            if (array[j] % 2 != 0) {
                if (index == -1) {
                    break;
                }
                lastOddCountElements[index--] = String.valueOf(array[j]);
            }
        }
        return lastOddCountElements;
    }

    private static int getCountZero(String[] firstCountElements) {
        int countZero = 0;
        for (String element : firstCountElements) {
            if (element == null) {
                countZero++;
            }
        }
        return countZero;
    }

    private static void printOutputCountElements(int countZero, String[] firstCountElements) {
        if (countZero == firstCountElements.length) {
            System.out.println("[]");
        } else if (countZero == 0) {
            System.out.println("[" + String.join(", ", firstCountElements) + "]");
        } else {
            String[] outputFirstCountElements = getOutput(countZero, firstCountElements);
            System.out.println("[" + String.join(", ", outputFirstCountElements) + "]");
        }
    }

    private static String[] getOutput(int countZero, String[] firstCountElements) {
        String[] output = new String[firstCountElements.length - countZero];
        int index = 0;
        for (String firstCountElement : firstCountElements) {
            if (firstCountElement != null) {
                if (index == output.length) {
                    break;
                }
                output[index++] = firstCountElement;
            }
        }
        return output;
    }

    private static void printFormatArray(int[] array) {
        String[] outputArray = new String[array.length];
        for (int i = 0; i < outputArray.length; i++) {
            outputArray[i] = String.valueOf(array[i]);
        }
        System.out.println("[" + String.join(", ", outputArray) + "]");
    }
}
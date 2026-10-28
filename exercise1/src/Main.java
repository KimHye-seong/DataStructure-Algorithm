import java.util.Scanner;
import java.util.Arrays;

public class Main {

    // LINEAR SEARCH
    static int linearSearch(int[] arr, int target){
        int steps = 0;

        for (int i = 0; i < arr.length; i++){
            steps++;
            System.out.println("\tStep " + steps + ": index " + i + " is " + arr[i]);
            if (arr[i] == target){
                System.out.println("\tTotal Steps/Comparisons: " + steps);
                return i;
            }
        }
        System.out.println("\tTotal Steps/Comparisons: " + steps);
        return -1;
    }

    // BINARY SEARCH
    static int binarySearch(int[] arr, int target){
        int low = 0, high = arr.length - 1, steps = 0;

        while (low <= high){
            int mid = low + (high - low) / 2;
            steps++;
            System.out.println("\tStep " + steps + ": low = " + low + ", high = " + high + ", mid = " + mid + " is " + arr[mid]);
            if (arr[mid] == target){
                System.out.println("\tTotal Steps/Comparisons: " + steps);
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        System.out.println("\tTotal Step/Comparisons: " + steps);
        return -1;
    }

    // PRINT RESULT
    static void printFinalResults(int index){
        if (index == -1){
            System.out.println("Result is NOT FOUND");
        }else {
            System.out.println("Result IS FOUND at index " + index);
        }
    }

    public static void main(String[] args) {
        Scanner jarvis = new Scanner(System.in);
        int[] randDataNum = {6, 7, 19, 59, 82, 67, 1, 57, 38, 23};
        int choice;

        do {
            System.out.println("\n~=~=~=~=~ LINEAR & BINARY SEARCH ~=~=~=~=~");
            System.out.println("List: " + Arrays.toString(randDataNum));
            System.out.println("[1] Linear Search");
            System.out.println("[2] Binary Search (sorts a copy first)");
            System.out.println("[3] Sort the list");
            System.out.println("[4] Enter my own list");
            System.out.println("[0] Exit");
            System.out.print("Choose: ");
            choice = jarvis.nextInt();

            switch (choice){
                case 1: {
                    System.out.print("Search for: ");
                    int target = jarvis.nextInt();
                    printFinalResults(linearSearch(randDataNum, target));
                    break;
                }
                case 2: {
                    int[] sorted = randDataNum.clone();
                    Arrays.sort(sorted);
                    System.out.println("Sorted: " + Arrays.toString(sorted));
                    System.out.print("Search for: ");
                    int target = jarvis.nextInt();
                    printFinalResults(binarySearch(sorted, target));
                    break;
                }
                case 3: {
                    Arrays.sort(randDataNum);
                    System.out.println("Sorted: " + Arrays.toString(randDataNum));
                    break;
                }
                case 4: {
                    System.out.print("How many numbers? ");
                    int num = jarvis.nextInt();
                    randDataNum = new int[num];
                    for (int i = 0; i < num; i++) {
                        System.out.print("Number " + (i + 1) + ": ");
                        randDataNum[i] = jarvis.nextInt();
                    }
                    break;
                }
                case 0:
                    break;
                default:
                    System.out.println("Invalid Choice");
                }
            }while (choice != 0);

        System.out.println("\nGoodbye!");
        System.out.println("\n~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~");
        jarvis.close();
        }
    }

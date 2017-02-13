import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class AlgEx {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("input.txt"));
        FileWriter writer = new FileWriter("output.txt");
        int size = scanner.nextInt();
        int constant = scanner.nextInt();
        int keyNum = scanner.nextInt();
        int[] table = new int[size];
        int key;
        for (int i = 0; i < size; i++) {
            table[i] = -1;
        }
        for (int i = 0; i < keyNum; i++) {
            key = scanner.nextInt();
            add(key, size, constant, table);
        }
        for(int i = 0; i < size - 1; i++) {
            writer.write(table[i] + " ");
        }
        writer.write(table[size - 1] + "");
        writer.close();
        scanner.close();
    }

    private static int hashCode(int key, int counter, int size, int constant) {
        return ((key % size) + constant * counter) % size;
    }

    private static void add(int key, int size, int constant, int[] table) {
        int counter = 0;
        int hash;
        do {
            hash = hashCode(key, counter++, size, constant);
            if(table[hash] == key) {
                return;
            }
        } while(table[hash] != -1);
        table[hash] = key;
    }
}

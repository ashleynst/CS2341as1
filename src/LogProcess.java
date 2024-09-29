import java.util.Scanner;

public class LogProcess<Item> {

    public static void main(String[] args) {
        Queue<String> logQueue = new Queue<>();
        Stack<String> errorStack = new Stack<>();
        Queue<String> recentError = new Queue<>();
        int infoCount = 0, warningCount = 0, errorCount = 0, memoryCount = 0;

        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine())
        {
            String entry = scanner.nextLine();
            logQueue.enqueue(entry);
        }

            while (!logQueue.isEmpty()) {
                String entry = logQueue.dequeue();

                if (entry.contains("INFO")) {
                    infoCount++;
                } else if (entry.contains("WARN")) {
                    warningCount++;
                    if (entry.contains("Memory")) {
                        memoryCount++;
                    }
                } else if (entry.contains("ERROR")) {
                    errorCount++;
                    errorStack.push(entry);
                    recentError.enqueue(entry);
                    if (recentError.size() > 100) {
                        recentError.dequeue();
                    }
                }
            }

            System.out.println("INFO entries: " + infoCount);
            System.out.println("WARN entries: " + warningCount);
            System.out.println("ERROR entries: " + errorCount);
            System.out.println("Memory Warnings: " + memoryCount);

            System.out.println("Last 100 errors:");
            while (!recentError.isEmpty()) {
                System.out.println(recentError.dequeue());
            }
        }
    }

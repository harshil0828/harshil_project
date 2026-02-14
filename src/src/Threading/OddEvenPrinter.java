package Threading;

public class OddEvenPrinter {

    static class Printer {
        private int num = 1;
        private final int MAX = 10;

        synchronized void printOdd() {
            while (num <= MAX) {
                while (num % 2 == 0 && num <= MAX) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        return;
                    }
                }

                if (num <= MAX) {
                    System.out.println("Odd: " + num);
                    num++;
                    notify();
                }
            }
        }

        synchronized void printEven() {
            while (num <= MAX) {
                while (num % 2 == 1 && num <= MAX) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        return;
                    }
                }

                if (num <= MAX) {
                    System.out.println("Even: " + num);
                    num++;
                    notify();
                }
            }
        }
    }

    public static void main(String[] args) {

        Printer printer = new Printer();

        Thread oddThread = new Thread(printer::printOdd);
        Thread evenThread = new Thread(printer::printEven);

        oddThread.start();
        evenThread.start();
    }
}

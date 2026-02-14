package Threading;

public class PingPongLimited {

    static class Printer {
        private boolean pingTurn = true;
        private int count = 0;
        private final int MAX = 10;

        synchronized void printPing() {
            while (count < MAX) {
                while (!pingTurn && count < MAX) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        return;
                    }
                }

                if (count >= MAX) return;

                System.out.println("Ping");
                count++;
                pingTurn = false;
                notify();
            }
        }

        synchronized void printPong() {
            while (count < MAX) {
                while (pingTurn && count < MAX) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        return;
                    }
                }

                if (count >= MAX) return;

                System.out.println("Pong");
                count++;
                pingTurn = true;
                notify();
            }
        }
    }

    public static void main(String[] args) {

        Printer printer = new Printer();

        Thread ping = new Thread(printer::printPing);
        Thread pong = new Thread(printer::printPong);

        ping.start();
        pong.start();
    }
}

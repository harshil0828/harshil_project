package Threading;
public class PingPong {

    static class Printer {
        boolean pingTurn = true;

        synchronized void printPing() {
            while (true) {
                while (!pingTurn) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        return;
                    }
                }
                System.out.println("Ping");
                pingTurn = false;
                notify();
                sleep();
            }
        }

        synchronized void printPong() {
            while (true) {
                while (pingTurn) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        return;
                    }
                }
                System.out.println("Pong");
                pingTurn = true;
                notify();
                sleep();
            }
        }

        private void sleep() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
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

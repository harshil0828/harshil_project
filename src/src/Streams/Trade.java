package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Trade {

    String symbol;
    int volume;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getVolume() {
        return volume;
    }

    public static void main (String[] args) {

        Trade trade1 = new Trade();
        Trade trade2 = new Trade();
        Trade trade3 = new Trade();

        trade1.symbol = "IBM";
        trade1.volume = 100;

        trade2.symbol = "TCS";
        trade2.volume = 100;

        trade3.symbol = "IBM";
        trade3.volume = 200;

        List<Trade> trades = new ArrayList<>();
        trades.add(trade1);
        trades.add(trade2);
        trades.add(trade3);

        Map<String, Integer> volumeMap = trades.stream()
                .collect(Collectors.groupingBy(Trade::getSymbol, Collectors.summingInt(Trade::getVolume)));

        System.out.println(volumeMap);//{TCS=100, IBM=300}
    }
}

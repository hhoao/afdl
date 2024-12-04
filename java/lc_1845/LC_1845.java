package lc_1845;


/**
 * LC_1845
 *
 * @author w
 * @since 2024/9/30
 **/

public class LC_1845 {
}


class SeatManager {
    private final boolean[] seats;
    private int currentMin;

    public SeatManager(int n) {
        seats = new boolean[n];
        currentMin = 0;
    }

    public int reserve() {
        int ret = currentMin + 1;
        seats[currentMin] = true;
        while (currentMin < seats.length && seats[currentMin]) {
            currentMin++;
        }
        return ret;
    }

    public void unreserve(int seatNumber) {
        seats[seatNumber - 1] = false;
        currentMin = Math.min(seatNumber - 1, currentMin);
    }
}

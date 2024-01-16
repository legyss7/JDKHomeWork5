package org.example;

import java.util.ArrayList;
import java.util.List;

public class Fork {
    private List<Boolean> forkList;

    public Fork(int countFork) {
        //все 5 вилок свободны
        forkList = new ArrayList<>();
        for (int i = 0; i <= countFork; i++) {
            forkList.add(true);
        }
    }
    public synchronized boolean getFork(int forkLeft, int forkRight) {
        if (forkList.get(forkLeft) && forkList.get(forkRight)) {
            forkList.set(forkLeft, false);
            forkList.set(forkRight, false);
            System.out.println(forkLeft + ", " + forkRight + " busy");
            return true;
        }
        return false;
    }
    public synchronized void giveFork(int forkLeft, int forkRight) {
            forkList.set(forkLeft, true);
            forkList.set(forkRight, true);
            System.out.println(forkLeft + ", " + forkRight + " free");
    }
}

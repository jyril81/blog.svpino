package com.jyril;

/**
 * Created by jyril81 on 9.06.2015.
 */
public class Hanoi {

    public static void main(String[] args) {
        int nrMovesDone = myhanoi(3, 1, 3, 2, 0);
        System.out.println("Nr moves done " + nrMovesDone);
    }

    public static int myhanoi(int nrdisksToMove, int from, int to, int spare, int nrMovesDone) {
        if (nrdisksToMove >= 1) {
            //move n-1 disks from->spare
            nrMovesDone = myhanoi(nrdisksToMove - 1, from, spare, to, nrMovesDone);
            //move 1 disk from->to
            System.out.println("Moving from " + from + "to " + to);
            nrMovesDone++;
            //move n-1 disks spare->to
            nrMovesDone = myhanoi(nrdisksToMove - 1, spare, to, from, nrMovesDone);
            return nrMovesDone;
        }
        return nrMovesDone;
    }
}

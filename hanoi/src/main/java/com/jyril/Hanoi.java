package com.jyril;

/**
 * Created by jyril81 on 9.06.2015.
 */
public class Hanoi {

    public static void main(String[] args) {
        int nrMovesDone = playHanoy(3, 1, 3, 2, 0);
        System.out.println("Nr moves done " + nrMovesDone);
    }

    /**
     * Classical recursive solution that solves with min nr of moves
     *
     * @param nrdisksToMove
     * @param from
     * @param to
     * @param spare
     * @param nrMovesDone
     * @return
     */
    public static int classicHanoi(int nrdisksToMove, int from, int to, int spare, int nrMovesDone) {
        if (nrdisksToMove >= 1) {
            //move n-1 disks from->spare
            nrMovesDone = classicHanoi(nrdisksToMove - 1, from, spare, to, nrMovesDone);
            //move 1 disk from->to
            System.out.println("Moving from " + from + "to " + to);
            nrMovesDone++;
            //move n-1 disks spare->to
            nrMovesDone = classicHanoi(nrdisksToMove - 1, spare, to, from, nrMovesDone);
            return nrMovesDone;
        }
        return nrMovesDone;
    }


    /**
     * Another recursive solution I tried to play with recursion
     * It works (finally resulting in desired state)but does not give min nr of moves ...
     *
     * @param nrdisksToMove
     * @param from
     * @param to
     * @param spare
     * @param nrMovesDone
     * @return
     */
    public static int playHanoy(int nrdisksToMove, int from, int to, int spare, int nrMovesDone) {
        if (nrdisksToMove >= 1) {
            //move n-1 disks from-->to
            nrMovesDone = playHanoy(nrdisksToMove - 1, from, to, spare, nrMovesDone);
            //move 1 disk from from-->spare
            System.out.println("Moving from " + from + "to " + spare);
            nrMovesDone++;
            //move n-1 disks to-->from
            nrMovesDone = playHanoy(nrdisksToMove - 1, to, from, spare, nrMovesDone);
            //move 1 disk spare--->to
            System.out.println("Moving from " + spare + "to " + to);
            nrMovesDone++;
            //move n-1 disks from-->to
            nrMovesDone = playHanoy(nrdisksToMove - 1, from, to, spare, nrMovesDone);
            return nrMovesDone;
        }
        return nrMovesDone;
    }
}

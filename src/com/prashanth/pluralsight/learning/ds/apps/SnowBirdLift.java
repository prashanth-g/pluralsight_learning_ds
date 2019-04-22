package com.prashanth.pluralsight.learning.ds.apps;

import com.prashanth.pluralsight.learning.ds.queue.BasicQueue;
import com.prashanth.pluralsight.learning.ds.queue.ListQueue;
import com.prashanth.pluralsight.learning.ds.queue.Queue;

public class SnowBirdLift {

    Queue<CoupleChair> coupleChairQueue = new ListQueue<CoupleChair>();

    public static void main(String[] args) {
        SnowBirdLift lift = new SnowBirdLift();
        lift.runLift();
    }

    public void runLift() {
        loadLift();

        System.out.println(coupleChairQueue.size());


        System.out.println("Lift has Xin and Peng on it: " + coupleChairQueue.contains(new CoupleChair("Xin", "Peng")));


        System.out.println("2nd chair has: " + coupleChairQueue.access(1).listChairRiders());

        unloadLift();

        try {
            unloadLift();
        } catch (IllegalStateException t) {
            System.out.println("Can't unload any more skiers because the lift is empty: " + t.getMessage());
        }
    }

    private void loadLift() {

        CoupleChair chair1 = new CoupleChair("John", "Dave");
        CoupleChair chair2 = new CoupleChair("Samantha", "Kelly");
        CoupleChair chair3 = new CoupleChair("Xin", "Peng");
        CoupleChair chair4 = new CoupleChair("Robert", "Chad");
        CoupleChair chair5 = new CoupleChair("Sarah", "Bill");

        coupleChairQueue.enQueue(chair1);
        coupleChairQueue.enQueue(chair2);
        coupleChairQueue.enQueue(chair3);
        coupleChairQueue.enQueue(chair4);
        coupleChairQueue.enQueue(chair5);
    }

    private void unloadLift() {

        CoupleChair chair = coupleChairQueue.deQueue();

        System.out.println(chair.listChairRiders());

        chair = coupleChairQueue.deQueue();

        System.out.println(chair.listChairRiders());

        chair = coupleChairQueue.deQueue();

        System.out.println(chair.listChairRiders());

        chair = coupleChairQueue.deQueue();

        System.out.println(chair.listChairRiders());

        chair = coupleChairQueue.deQueue();

        System.out.println(chair.listChairRiders());
    }

    class CoupleChair {

        private String seat1;
        private String seat2;

        public CoupleChair(String seat1, String seat2) {
            this.seat1 = seat1;
            this.seat2 = seat2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CoupleChair that = (CoupleChair) o;

            if (seat1 != null ? !seat1.equals(that.seat1) : that.seat1 != null) return false;
            return seat2 != null ? seat2.equals(that.seat2) : that.seat2 == null;

        }

        @Override
        public int hashCode() {
            int result = seat1 != null ? seat1.hashCode() : 0;
            result = 31 * result + (seat2 != null ? seat2.hashCode() : 0);
            return result;
        }

        public String listChairRiders() {
            return this.seat1 + ", " + this.seat2;
        }

        private SnowBirdLift getOuterType() {
            return SnowBirdLift.this;
        }
    }
}

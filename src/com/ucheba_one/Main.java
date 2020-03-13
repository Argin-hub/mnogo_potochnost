package com.ucheba_one;

import java.util.Date;

public class Main {
    public static int delay = 1000;

    public static void main(String[] args) {
        Thread violin = new Thread(new Violin("Player"));
        violin.start();
    }

    public static void sleepNSeconds(int n) {
        try {
            Thread.sleep(n * delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public interface MusicalInstrument extends Runnable {
        Date startPlaying();

        Date stopPlaying();
    }

    public static class Violin implements MusicalInstrument {
        private String owner;

        public Violin(String owner) {
            this.owner = owner;
        }

        public Date startPlaying() {
            System.out.println(this.owner + " is starting to play");
            return new Date();
        }

        public Date stopPlaying() {
            System.out.println(this.owner + " is stopping playing");
            return new Date();
        }

        @Override
        public void run() {
            startPlaying();
            Date currentTime = new Date();
            sleepNSeconds(1);
            stopPlaying();
            Date newTime = new Date();
            long msDelay = newTime.getTime() - currentTime.getTime(); //вычисляем разницу
            float dd = msDelay + 2f;
            System.out.println("Playing: " + (int) dd + " ms");
        }
    }
}



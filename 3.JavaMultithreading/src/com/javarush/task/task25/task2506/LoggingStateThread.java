package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread thread; // ссылка на таргет
    private State state;

    public LoggingStateThread(Thread target) {
        super(target);
        this.thread = target;
        this.state = thread.getState();
    }

    @Override
    public void run() {
        System.out.println(state);
        while (true) {
            if (!(state.equals(thread.getState()))) {
                System.out.println(thread.getState());
                state = thread.getState();
            }
            if (thread.getState().equals(State.TERMINATED)) {
                //System.out.println(thread.getState());
                break;
            }
        }
    }
}

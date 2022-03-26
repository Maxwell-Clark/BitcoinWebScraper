package com.maxwell.app.models;

public class MessariStatus {
    private int elapsed;
    private String timestamp;

    public MessariStatus(int elapsed, String timestamp) {
        this.elapsed = elapsed;
        this.timestamp = timestamp;
    }

    public int getElapsed() {
        return elapsed;
    }

    public void setElapsed(int elapsed) {
        this.elapsed = elapsed;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "status{" +
                "elapsed=" + elapsed +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}

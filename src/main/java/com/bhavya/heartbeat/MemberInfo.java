package com.bhavya.heartbeat;

public class MemberInfo {

    private String id;
    private Long lastTimestamp;
    private Long lastHeartBeat;
    private Status status;

    public MemberInfo(String id, Long lastTimestamp, Long lastHeartBeat) {
        this.id = id;
        this.lastTimestamp = lastTimestamp;
        this.lastHeartBeat = lastHeartBeat;
        this.status = Status.ALIVE;
    }

    public void incrementHeartBeat() {
        this.lastHeartBeat += 1;
    }

    public void update(Long lastTimestamp, Long lastHeartBeat) {
        this.lastTimestamp = lastTimestamp;
        this.lastHeartBeat = lastHeartBeat;
    }

    public String getId() {
        return id;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public Long getLastTimestamp() {
        return lastTimestamp;
    }
}

package src.com.bhavya.heartbeat;

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

    public void update(Long lastTimestamp, Long lastHeartBeat) {
        this.lastTimestamp = lastTimestamp;
        this.lastHeartBeat = lastHeartBeat;
    }

    public String getId() {
        return id;
    }
}

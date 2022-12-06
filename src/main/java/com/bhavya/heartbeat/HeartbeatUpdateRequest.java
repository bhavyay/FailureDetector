package com.bhavya.heartbeat;

import java.util.List;

public class HeartbeatUpdateRequest {
    private final List<HeartbeatUpdateInfo> heartbeats;

    public HeartbeatUpdateRequest(List<HeartbeatUpdateInfo> heartbeats) {
        this.heartbeats = heartbeats;
    }

    public List<HeartbeatUpdateInfo> getHeartbeats() {
        return heartbeats;
    }
}

class HeartbeatUpdateInfo {
    private final String id;
    private final Long lastHeartbeat;
    private final Long lastTimestamp;

    public HeartbeatUpdateInfo(String id, Long lastHeartbeat, Long lastTimestamp) {
        this.id = id;
        this.lastHeartbeat = lastHeartbeat;
        this.lastTimestamp = lastTimestamp;
    }

    public String getId() {
        return id;
    }

    public Long getLastHeartbeat() {
        return lastHeartbeat;
    }

    public Long getLastTimestamp() {
        return lastTimestamp;
    }
}

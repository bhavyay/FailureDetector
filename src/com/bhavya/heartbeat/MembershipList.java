package src.com.bhavya.heartbeat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MembershipList {
    private Map<String, MemberInfo> members;

    public MembershipList() {
        this.members = new HashMap<>();
    }

    public void addMember(MemberInfo member) {
        this.members.put(member.getId(), member);
    }

    public void update(HeartbeatUpdateRequest request) {
        for (HeartbeatUpdateInfo requestInfo: request.getHeartbeats()) {
            String serverId = requestInfo.getId();
            if (members.containsKey(serverId)) {
                MemberInfo member = members.get(serverId);
                member.update(requestInfo.getLastTimestamp(), requestInfo.getLastHeartbeat());
            } else {
                MemberInfo newMember =new MemberInfo(requestInfo.getId(), requestInfo.getLastTimestamp(),
                        requestInfo.getLastHeartbeat());
                this.addMember(newMember);
            }
        }
    }

    public List<MemberInfo> getMembers() {
        return new ArrayList<>(members.values());
    }
}

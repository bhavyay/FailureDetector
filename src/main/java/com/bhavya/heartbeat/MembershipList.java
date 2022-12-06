package com.bhavya.heartbeat;

import java.util.*;

public class MembershipList {
    private Map<String, MemberInfo> members;

    public MembershipList() {
        this.members = new HashMap<>();
    }

    public void addMember(MemberInfo member) {
        this.members.put(member.getId(), member);
    }

    public void deleteMember(String id) {
        this.members.remove(id);
    }

    public void updateMemberHeartbeat(String id) {
        MemberInfo memberInfo = this.members.get(id);
        memberInfo.incrementHeartBeat();
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

    public List<MemberInfo> selectPeers(int count, List<String> nodesToExclude) {
        Set<String> memberSet = members.keySet();
        for (String memberId : nodesToExclude) {
            memberSet.remove(memberId);
        }

        List<String> memberIds = new ArrayList<>(memberSet);
        List<MemberInfo> selectedPeers = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            int rnd = new Random().nextInt(memberIds.size());
            selectedPeers.add(members.get(memberIds.get(rnd)));
        }
        return selectedPeers;
    }
}

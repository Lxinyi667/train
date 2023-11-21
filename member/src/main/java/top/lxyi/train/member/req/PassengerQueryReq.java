package top.lxyi.train.member.req;

import top.lxyi.train.common.req.PageReq;

public class PassengerQueryReq extends PageReq {
    private Long memberId;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @Override
        public String toString() {
        return "PassengerQueryReq{" +
        "} " + super.toString();
        }
}
package top.lxyi.train.member.req;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lxyi.train.common.req.PageReq;

@EqualsAndHashCode(callSuper = true)
@Data
public class PassengerQueryReq  extends PageReq {
    private Long memberId;
}

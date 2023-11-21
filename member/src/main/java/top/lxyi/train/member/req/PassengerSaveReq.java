package top.lxyi.train.member.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PassengerSaveReq {
    private Long id;
    private Long memberId;
    private String name;
    private String idCard;
    private String type;
    private Date createTime;
    private Date updateTime;
}

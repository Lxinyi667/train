package top.lxyi.train.member.req;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberRegisterReq {
    @NotBlank(message = "[手机号]不能为空")
    private String mobile;
}

package top.lxyi.train.member.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberLoginReq {
    @NotBlank(message = "[手机号]不能为空")
    @Pattern(regexp = "^1\\d{10}$",message = "手机号格式错误")
    private String mobile;

    @NotBlank(message = "[短信验证码]不能为空")
    private String code;
}

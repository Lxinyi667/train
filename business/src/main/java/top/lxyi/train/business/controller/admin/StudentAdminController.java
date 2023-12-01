package top.lxyi.train.business.controller.admin;

import top.lxyi.train.common.context.LoginMemberContext;
import top.lxyi.train.common.resp.CommonResp;
import top.lxyi.train.common.resp.PageResp;
import top.lxyi.train.business.req.StudentQueryReq;
import top.lxyi.train.business.req.StudentSaveReq;
import top.lxyi.train.business.resp.StudentQueryResp;
import top.lxyi.train.business.service.StudentService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/student")
public class StudentAdminController {

@Resource
private StudentService studentService;

@PostMapping("/save")
public CommonResp<Object> save(@Valid @RequestBody StudentSaveReq req) {
    studentService.save(req);
    return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<StudentQueryResp>> queryList(@Valid StudentQueryReq req) {
        PageResp<StudentQueryResp> list = studentService.queryList(req);
            return new CommonResp<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id) {
        studentService.delete(id);
        return new CommonResp<>();
    }
    @GetMapping("/query")
    public CommonResp<List<StudentQueryResp>> queryList2(StudentQueryReq req){
        List<StudentQueryResp> list = studentService.queryList2(req);
        return new CommonResp<>(list);
    }
}
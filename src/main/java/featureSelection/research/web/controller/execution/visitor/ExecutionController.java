package featureSelection.research.web.controller.execution.visitor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Stephen
 * @date 2020/3/26 21:12
 */
@Controller
public class ExecutionController {

    /**
     *
     * 跳转到execution.html
     * @return
     */
    @GetMapping("/execution")
    public String getExecutionIndex(){
        return "/pages/execution/visitor/execution.html";
    }

    @GetMapping("/accountLogin")
    public String accountLogin() {
        return "/pages/demo/visitor/login.html";
    }

    @GetMapping("/unauthorized")
    @ResponseBody
    public String unauthorized() {
        return "unauthorized";
    }

}

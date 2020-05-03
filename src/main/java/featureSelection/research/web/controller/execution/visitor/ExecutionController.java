package featureSelection.research.web.controller.execution.visitor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}

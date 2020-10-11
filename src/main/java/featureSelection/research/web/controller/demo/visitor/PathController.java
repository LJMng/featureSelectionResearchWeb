package featureSelection.research.web.controller.demo.visitor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName : PathController
 * @Description :
 * @Author : WDD
 * @Date: 2020-09-28 08:32
 */
@Controller
public class PathController {

    @GetMapping("/accountRegister")
    public String accountLogin() {
        return "/pages/demo/visitor/register.html";
    }
}

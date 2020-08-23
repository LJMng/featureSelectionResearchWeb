package featureSelection.research.web.config.shiro;

import featureSelection.research.web.entity.UserType;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @description: UsernamePasswordByUserTypeToken
 * @date: 2020/8/22 22:32
 * @author: Stephen
 */
public class CustomUsernamePasswordToken extends UsernamePasswordToken {
    private static final long serialVersionUID = 2020457391511655213L;
    private UserType userType;

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public CustomUsernamePasswordToken(String username, String password, UserType userType) {
        super(username, password);
        this.userType = userType;
    }

}

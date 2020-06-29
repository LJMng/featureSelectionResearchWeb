package featureSelection.research.web.entity;

/**
 * @ClassName : ResultEnum
 * @Description : 结果信息枚举类，定义一些常用的返回结果状态码和
 * @Author : WDD
 * @Date: 2020-05-04 20:44
 */
public enum ResultEnum {
    //这里是可以自己定义的，方便与前端交互即可
    UNKNOWN_ERROR(-1,"未知错误"),
    SUCCESS(200,"成功"),
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

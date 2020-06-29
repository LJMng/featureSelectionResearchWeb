package featureSelection.research.web.entity;


/**
 * @ClassName : Result
 * @Description : 接口返回结果信息类
 * @Author : WDD
 * @Date: 2020-05-04 20:44
 */
public class Result<T> {
    //状态码
    private Integer code;
    //状态信息
    private String msg;
    //返回数据
    private T data;

    public Result() {
        super();
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
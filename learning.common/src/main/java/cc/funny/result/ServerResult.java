package cc.funny.result;

import javax.annotation.Nullable;
import java.io.Serializable;
/**
 * 服务处理公共返回结果
 *
 * @author gehui
 */
public final class ServerResult<T> implements Serializable {

  private static final long serialVersionUID = 5315567140678435610L;

  private final int code;
  private final String msg;
  private final T data;

  private ServerResult(int code, @Nullable String msg, @Nullable T data) {
    this.code = code;
    this.msg = msg;
    this.data = data;
  }

  public int code() {
    return code;
  }

  public String msg() {
    return msg;
  }

  public T data() {
    return data;
  }

  public int getCode() {
    return code;
  }

  public String getMsg() {
    return msg;
  }

  public T getData() {
    return data;
  }

  public static <Response> ServerResult<Response> of(int ret, String msg, Response data) {
    return new ServerResult<>(ret, msg, data);
  }

  public static <Response> ServerResult<Response> of(int ret, String msg) {
    return new ServerResult<>(ret, msg, null);
  }

  public static <Response> ServerResult<Response> of() {
    return new ServerResult<>(ResponseResultInfoEnum.NO_ERROR.getCode(), ResponseResultInfoEnum.NO_ERROR.getDescription(), null);
  }

  public static <Response> ServerResult<Response> of(Response data) {
    return new ServerResult<>(ResponseResultInfoEnum.NO_ERROR.getCode(), ResponseResultInfoEnum.NO_ERROR.getDescription(), data);
  }

  public static <Response> ServerResult<Response> of(ResponseResultInfoEnum rspEnum, Response data) {
    return new ServerResult<>(rspEnum.getCode(), rspEnum.getDescription(), data);
  }

  public static <Response> ServerResult<Response> of(ResponseResultInfoEnum rspEnum) {
    return new ServerResult<>(rspEnum.getCode(), rspEnum.getDescription(), null);
  }

  public static <Response> ServerResult<Response> of(RetCode retCode) {
    return new ServerResult<>(retCode.code(), retCode.defaultMsg(), null);
  }

  public static <Response> ServerResult<Response> of(RetCode retCode, Response data) {
    return new ServerResult<>(retCode.code(), retCode.defaultMsg(), data);
  }

  public static <Response> ServerResult<Response> of(RetCode retCode, @Nullable String msg) {
    if (msg == null) {
      msg = retCode.defaultMsg();
    }
    return new ServerResult<>(retCode.code(), msg, null);
  }

  public static <Response> ServerResult<Response> of(RetCode retCode, @Nullable String msg, Response data) {
    if (msg == null) {
      msg = retCode.defaultMsg();
    }
    return new ServerResult<>(retCode.code(), msg, data);
  }

  public static <Response> ServerResult<Response> nestedOf(RetCode retCode, ServerResult<?> nestedResult) {
    String msg = (nestedResult.msg() == null ? retCode.defaultMsg() : nestedResult.msg()) + "(" + nestedResult.code() + ")";
    return new ServerResult<>(retCode.code(), msg, null);
  }

  public static <Response> ServerResult<Response> nestedOf(RetCode retCode, ServerResult<?> nestedResult, Response data) {
    String msg = (nestedResult.msg() == null ? retCode.defaultMsg() : nestedResult.msg()) + "(" + nestedResult.code() + ")";
    return new ServerResult<>(retCode.code(), msg, data);
  }

  public boolean isSuccess() {
    return this.code == ResponseResultInfoEnum.NO_ERROR.getCode();
  }
}

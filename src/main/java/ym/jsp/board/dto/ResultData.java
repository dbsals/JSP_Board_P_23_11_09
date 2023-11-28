package ym.jsp.board.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ym.jsp.board.util.Ut;

import java.util.Map;

@NoArgsConstructor
@ToString
public class ResultData {
  @Getter
  private String resultCode;
  @Getter
  private String msg;
  @Getter
  private Map<String, Object> body;

  public boolean isSuccess() {
    return resultCode.startsWith("S-");
  }

  public boolean isFail() {
    return !isSuccess();
  }

  public static ResultData from(String resultCode, String msg, Object... bodyArgs) {
    ResultData rd = new ResultData();

    rd.resultCode = resultCode;
    rd.msg = msg;
    rd.body = Ut.mapOf(bodyArgs);

    return rd;
  }
}
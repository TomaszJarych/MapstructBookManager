package tj.udemy.Commons.Result;

import static lombok.AccessLevel.PRIVATE;

import lombok.AllArgsConstructor;

@AllArgsConstructor(access = PRIVATE)
public class Result {

	private Integer errorCode;

	private String message;

	private Object data;

	public static Result ok(Object data) {
		return new Result(200, "OK", data);
	}

	public static Result error(String message) {
		return new Result(500, message, null);
	}

	public static Result errorWithCodeAndMessage(Integer code, String message) {
		return new Result(code, message, null);
	}

	public static Result errorWithObject(Integer code, String message, Object data) {
		return new Result(code, message, data);
	}

}

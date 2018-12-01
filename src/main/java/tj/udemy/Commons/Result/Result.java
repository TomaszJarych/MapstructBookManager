package tj.udemy.Commons.Result;

import lombok.Getter;

@Getter
public class Result {
	
	private static final String OK_CODE = "200";
	private static final String ERROR_CODE_500 = "500";
	private static final String OK_MESSAGE = "OK";

	private  String errorCode;

	private  String message;

	private  Object data;

	public static Result ok(Object data) {
		return new Result(OK_CODE, OK_MESSAGE, data);
	}
	
	public static Result okMessage() {
		return new Result(OK_CODE, OK_MESSAGE, null);
	}

	public static Result error(String message) {
		return new Result(ERROR_CODE_500, message, null);
	}

	public static Result errorWithCodeAndMessage(String code, String message) {
		return new Result(code, message, null);
	}

	public static Result errorWithObject(String code, String message, Object data) {
		return new Result(code, message, data);
	}

	private Result(String errorCode, String message, Object data) {
		this.errorCode = errorCode;
		this.message = message;
		this.data = data;
	}
	
	

}

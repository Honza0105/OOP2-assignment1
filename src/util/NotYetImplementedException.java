package util;

public class NotYetImplementedException extends RuntimeException {
	private static final long serialVersionUID = -587186577902539708L;
	private static final String message = "Method has not yet been implemented";

	public NotYetImplementedException() {
		super(message);
	}

	public NotYetImplementedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NotYetImplementedException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotYetImplementedException(String message) {
		super(message);
	}

	public NotYetImplementedException(Throwable cause) {
		super(message, cause);
	}
}

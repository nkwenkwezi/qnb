package qa.co.qnb.exception;

public class FileFormatNotSupported extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FileFormatNotSupported(String message) {
		super(message);
	}
	public FileFormatNotSupported(String message, Throwable cause) {
		super(message, cause);
	}
}

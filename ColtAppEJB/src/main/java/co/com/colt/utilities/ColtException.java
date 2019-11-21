package co.com.colt.utilities;

/**
 *
 * @author
 */
public class ColtException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ColtException(String message) {
		super(message);
	}

	public ColtException(Throwable tr) {
		super(tr);
	}

	public ColtException(String message, Throwable tr) {
		super(message, tr);
	}

}

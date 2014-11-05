package toplib.beans.exceptions;

public class NoSuchPropertyException extends ReflectiveOperationException {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a <code>NoSuchPropertyException</code> without a detail
	 * message.
	 */
	public NoSuchPropertyException() {
		super();
	}

	/**
	 * Constructs a <code>NoSuchPropertyException</code> with a detail message.
	 *
	 * @param s
	 *            the detail message.
	 */
	public NoSuchPropertyException(String s) {
		super(s);
	}
}
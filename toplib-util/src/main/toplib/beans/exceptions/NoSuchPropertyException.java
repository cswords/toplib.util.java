package toplib.beans.exceptions;

public class NoSuchPropertyException extends ReflectiveOperationException {
	private static final long serialVersionUID = 1L;

	public NoSuchPropertyException(String s, Throwable cause) {
		super(s);
	}
}
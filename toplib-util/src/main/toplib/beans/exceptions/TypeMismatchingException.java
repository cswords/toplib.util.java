package toplib.beans.exceptions;

public class TypeMismatchingException extends Exception {
	private static final long serialVersionUID = 1L;

	public TypeMismatchingException(String message, ClassCastException cause) {
		super(message, cause);
	}
}

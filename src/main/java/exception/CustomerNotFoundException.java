package exception;

/**
 * @author Mark.Wayne.de.Claro
 *
 */
public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1069114762887415252L;

	public CustomerNotFoundException(String exception) {
		super(exception);
	}

}

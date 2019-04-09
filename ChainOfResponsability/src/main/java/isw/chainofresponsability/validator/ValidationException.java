package isw.chainofresponsability.validator;

public class ValidationException extends Exception {

    public ValidationException(String message) throws ValidationException {
        super(message);
    }
}
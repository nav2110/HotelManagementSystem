package People;

public class ValidationException extends Exception {
    private ValidationException(String message) {
        super(message);
    }

    static int validRate(int rating) throws ValidationException {

        if (rating < 0 || rating > 5) throw new ValidationException("Rating should be between 0 and 5 inclusive.");
        return rating;
    }

}

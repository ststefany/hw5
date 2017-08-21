package exceptions;

public class FileValidateException extends RuntimeException {
    public FileValidateException(String message) {
        super(message);
    }
}

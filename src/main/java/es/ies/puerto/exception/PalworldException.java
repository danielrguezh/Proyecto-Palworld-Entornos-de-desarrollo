package es.ies.puerto.exception;

public class PalworldException extends Exception{

    public PalworldException(String message) {
        super(message);
    }

    public PalworldException(String message, Throwable tipo) {
        super(message,tipo);
    }
}

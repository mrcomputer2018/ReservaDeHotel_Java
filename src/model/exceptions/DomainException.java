package model.exceptions;

import java.io.Serial;

public class DomainException extends Exception{
    // Declarando a versao de uma classe serialize
    @Serial
    private static final long serialVersionUID = 1L;

    // Contrutor
    public DomainException( String msg ) {
        super(msg);
    }
}

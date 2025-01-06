package org.example.productcatalogservice_jan2025.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public ProductNotFoundException(Throwable cause) {
        super(cause);
    }
}

package com.viajesCompartidos.viajesCompartidos.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ViajesCompartidosExceptions extends RuntimeException{

        private String message;
        private HttpStatus httpStatus;

        public ViajesCompartidosExceptions(String message,HttpStatus httpStatus){
            super(message);
            this.message = message;
            this.httpStatus = httpStatus;
        }
}

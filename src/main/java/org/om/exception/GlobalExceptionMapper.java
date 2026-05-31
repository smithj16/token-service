package org.om.exception;

import io.quarkus.logging.Log;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception exception) {
        String message = exception.getMessage();

        Log.warn(message);

        if(exception instanceof TokenRecordNotFoundException || exception instanceof NotFoundException)
            return handleNotFoundResponse(message);
        else if(exception instanceof TokenCreationFailedException)
            return handleBadRequestResponse(message);
        else if(exception instanceof TokenRedeemedException)
            return handleBadRequestResponse(message);

        return Response.status(Response.Status.BAD_REQUEST)
                .entity(message)
                .build();
    }

    private Response handleBadRequestResponse(String message){
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(message)
                .build();
    }

    private Response handleNotFoundResponse(String message){
        return Response.status(Response.Status.NOT_FOUND)
                .entity(message)
                .build();
    }

    private Response handleInternalServerErrorResponse(String message){
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(message)
                .build();
    }
}

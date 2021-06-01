package com.weatherforecast.exception;

import com.weatherforecast.constants.WeatherForecastConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author Vinod Kumar Potta
 */

@RestControllerAdvice(basePackages = {"com.weatherforecast"})
@Slf4j
public class BaseControllerAdvice implements ResponseBodyAdvice<Object> {

        @ExceptionHandler(ClientExceptions.class)
        public ResponseEntity<GlobalError> doClientExceptionsHandler(ClientExceptions exception) {
            return new ResponseEntity<> (new GlobalError(exception.getMessage(),exception.getErrorReason()), HttpStatus.NOT_FOUND);
        }

        /*
        This advice will never be used for this Microservice because WeatherForecastRequest has two fields and both are optional as per OpenWeather third party API
         */
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<GlobalError> handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {
            return new ResponseEntity<> (new GlobalError("Argument Type Mismatch Error","The given method argument type is invalid. Please check the request again!!!"), HttpStatus.BAD_REQUEST);
        }

        @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        @ExceptionHandler(Throwable.class)
        public  ResponseEntity<GlobalError>  doHandleGenericException(Throwable exception){
            return new ResponseEntity<> (new GlobalError(exception.getMessage(), WeatherForecastConstants.GENERIC_EXCEPTION_OCCURED), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        @Override
        public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
            return true;
        }

        @Override
        public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
                if(body instanceof GlobalError){
                    log.error ("Exception occured",body.toString ());
                }
                return body;
        }
}

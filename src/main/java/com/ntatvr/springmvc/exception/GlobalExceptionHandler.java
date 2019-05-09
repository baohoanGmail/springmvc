package com.ntatvr.springmvc.exception;

import java.util.Collections;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.hibernate.hql.internal.ast.QuerySyntaxException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

/**
 * @ControllerAdvice It allows you to handle exceptions across the whole application, not just to an
 *                   individual controller
 * 
 * @author AnhNT
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

  /** Provides handling for exceptions throughout this service. */
  @ExceptionHandler({EntryNotFoundException.class, EntityNotFoundException.class,
      ContentNotAllowedException.class, QuerySyntaxException.class,
      InvalidDataAccessResourceUsageException.class})
  public final ResponseEntity<ApiError> handleException(Exception e, WebRequest request) {

    HttpHeaders headers = new HttpHeaders();

    if (e instanceof EntryNotFoundException) {

      HttpStatus status = HttpStatus.NOT_FOUND;
      EntryNotFoundException enfe = (EntryNotFoundException) e;
      return handleEntryNotFoundException(enfe, headers, status, request);
    } else if (e instanceof EntityNotFoundException) {

      HttpStatus status = HttpStatus.NOT_FOUND;
      EntityNotFoundException enfe = (EntityNotFoundException) e;
      return handleEntityNotFoundException(enfe, headers, status, request);
    } else if (e instanceof ContentNotAllowedException) {

      HttpStatus status = HttpStatus.BAD_REQUEST;
      ContentNotAllowedException cnae = (ContentNotAllowedException) e;
      return handleContentNotAllowedException(cnae, headers, status, request);

    } else if (e instanceof QuerySyntaxException) {

      HttpStatus status = HttpStatus.BAD_REQUEST;
      QuerySyntaxException qse = (QuerySyntaxException) e;
      return handleQuerySyntaxException(qse, headers, status, request);
    } else {

      HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
      return handleExceptionInternal(e, null, headers, status, request);
    }
  }

  /** Customize the response for EntryNotFoundException. */
  protected ResponseEntity<ApiError> handleEntryNotFoundException(EntryNotFoundException e,
      HttpHeaders headers, HttpStatus status, WebRequest request) {

    List<String> errors = Collections.singletonList(e.getMessage());
    return handleExceptionInternal(e, new ApiError(errors), headers, status, request);
  }

  /** Customize the response for QuerySyntaxException. */
  protected ResponseEntity<ApiError> handleQuerySyntaxException(QuerySyntaxException e,
      HttpHeaders headers, HttpStatus status, WebRequest request) {

    List<String> errors = Collections.singletonList(e.getMessage());
    return handleExceptionInternal(e, new ApiError(errors), headers, status, request);
  }

  /** Customize the response for EntityNotFoundException. */
  protected ResponseEntity<ApiError> handleEntityNotFoundException(EntityNotFoundException e,
      HttpHeaders headers, HttpStatus status, WebRequest request) {

    List<String> errors = Collections.singletonList(e.getMessage());
    return handleExceptionInternal(e, new ApiError(errors), headers, status, request);
  }

  /** Customize the response for ContentNotAllowedException. */
  protected ResponseEntity<ApiError> handleContentNotAllowedException(ContentNotAllowedException e,
      HttpHeaders headers, HttpStatus status, WebRequest request) {

    // List<String> errorMessages = e.getErrors()
    // .stream()
    // .map(contentError -> contentError.getObjectName() + " " + contentError.getDefaultMessage())
    // .collect(Collectors.toList());

    return handleExceptionInternal(e, new ApiError(""), headers, status, request);
  }

  /** A single place to customize the response body of all Exception types. */
  protected ResponseEntity<ApiError> handleExceptionInternal(Exception ex, ApiError body,
      HttpHeaders headers, HttpStatus status, WebRequest request) {

    if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
      request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
    }
    return new ResponseEntity<>(body, headers, status);
  }
}

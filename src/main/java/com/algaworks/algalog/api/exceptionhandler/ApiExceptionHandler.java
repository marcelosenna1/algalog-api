package com.algaworks.algalog.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	// opcional para traduzir as mensagens de erro
	// private MessageSource messageSource;

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<Problema.Campo> campos = new ArrayList<>();

		for (ObjectError error : ex.getBindingResult().getAllErrors()) {

			String nome = ((FieldError) error).getField();
			String mensagem = error.getDefaultMessage(); // essa opção já resolvia o problema
			// String mensagem = messageSource.getMessage(error,
			// LocaleContextHolder.getLocale());
			campos.add(new Problema.Campo(nome, mensagem));

		}

		Problema problema = new Problema(status.value(), LocalDateTime.now(),
				"Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente", campos);

		return handleExceptionInternal(ex, problema, headers, status, request);
	}

}

package br.com.zupacademy.casadocodigo.validation.genericvalidation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
	@Documented
	@Constraint(validatedBy = { ValidaEstadoPaisValidator.class })
	@Target({ ElementType.TYPE })
	@Retention(RetentionPolicy.RUNTIME)
	public @interface ValidaEstadoPais {

		String message() default "Não pode existir 2 estados iguais no mesmo país";

		Class<?>[] groups() default {};

		Class<? extends Payload>[] payload() default {};

	}




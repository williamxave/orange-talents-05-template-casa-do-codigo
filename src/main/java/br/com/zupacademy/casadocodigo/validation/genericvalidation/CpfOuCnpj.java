package br.com.zupacademy.casadocodigo.validation.genericvalidation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

//Fonte -> https://gist.github.com/rponte/b7a827224c2ac88d588c2ed6fbeefd14

@CPF
@CNPJ
@ConstraintComposition(CompositionType.OR) // OR como operador booleano em vez de AND
@ReportAsSingleViolation // os relatórios de erro de cada restrição de composição individual são ignorados
@Documented
@Constraint(validatedBy = {}) // não precisamos de um validator
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CpfOuCnpj {
	
	String message() default "CPF ou CNPJ inválido";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}

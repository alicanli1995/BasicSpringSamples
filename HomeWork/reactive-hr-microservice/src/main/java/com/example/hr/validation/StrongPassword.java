package com.example.hr.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Pattern.List({
	 @Pattern(regexp="^.*\\d+.*$",message="{validation.strongPassword2}"),
     @Pattern(regexp="^.*[-_]+.*$",message="{validation.strongPassword3}")
})
@Size(min=8)
@Constraint(validatedBy = {})
public @interface StrongPassword {
	   String message() default "{validation.strongPassword1}";
	    Class<?>[] groups() default {};
	    Class<? extends Payload>[] payload() default {};
}

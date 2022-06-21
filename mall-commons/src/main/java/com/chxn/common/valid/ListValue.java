package com.chxn.common.valid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = { ListValueConstraint.class })
public @interface ListValue {

//    String message() default "{com.chxn.common.valid.ListValue.message}";
    String message() default "该列数值只能包含在范围内！";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    int[] val() default { };

}

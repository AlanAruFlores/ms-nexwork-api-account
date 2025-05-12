package com.nexwork.api.account.ms_nexwork_api_account.utils.annotations;
import org.springframework.stereotype.Component;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
@Component
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DataAccessObject {
    
}

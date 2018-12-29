package com.spstudio.hitchcock.service.extra.impl.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.core.annotation.AliasFor;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.spstudio.hitchcock.service.extra.impl.bootstrap.WilliamBootTestContextBootstrapper;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@BootstrapWith(WilliamBootTestContextBootstrapper.class)
@ExtendWith(SpringExtension.class)
public @interface WilliamBootTest{
	
	@AliasFor("properties")
	String[] value() default {};

	@AliasFor("value")
	String[] properties() default {};

	Class<?>[] classes() default {};

	WebEnvironment webEnvironment() default WebEnvironment.MOCK;

	enum WebEnvironment {

		MOCK(false),

		RANDOM_PORT(true),

		DEFINED_PORT(true),

		NONE(false);

		private final boolean embedded;

		WebEnvironment(boolean embedded) {
			this.embedded = embedded;
		}

		public boolean isEmbedded() {
			return this.embedded;
		}

	}
}

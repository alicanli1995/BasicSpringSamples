package com.example.hr.domain;

import java.util.Objects;

import com.example.ddd.annotations.ValueObject;

@ValueObject
public record Iban(String value) {
	public static Iban of(String value) {
		Objects.requireNonNull(value);
		if (!isValid(value))
			throw new IllegalArgumentException("This is not a valid iban.");
		return new Iban(value);
	}

	private static boolean isValid(String value) {
		return true;
	}
}

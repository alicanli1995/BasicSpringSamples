package com.example.hr.domain;

import java.util.Base64;
import java.util.Objects;

import com.example.ddd.annotations.ValueObject;

@ValueObject
public final class Photo {
	private final byte[] value;

	public static Photo of(String base64Value) {
		return new Photo(Base64.getDecoder().decode(base64Value));
	}

	public static Photo of(byte[] value) {
		Objects.requireNonNull(value);
		if (value.length == 0)
			throw new IllegalArgumentException("value must have at least one byte.");
		return new Photo(value);
	}

	private Photo(byte[] value) {
		this.value = value;
	}

	public byte[] getValue() {
		return value;
	}

	public String getBase64Value() {
		return Base64.getEncoder().encodeToString(value);
	}

}

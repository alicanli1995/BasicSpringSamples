package com.example.hr.domain;

import java.util.Objects;

import com.example.ddd.annotations.ValueObject;

@ValueObject
public final class BirthYear {
	private int value;

	public static BirthYear valueOf(int value) {
		if (value > 2022)
			throw new IllegalArgumentException("This is not a valid birth year.");
		return new BirthYear(value);
	}

	private BirthYear(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BirthYear other = (BirthYear) obj;
		return value == other.value;
	}

	@Override
	public String toString() {
		return "BirthYear [value=" + value + "]";
	}

}

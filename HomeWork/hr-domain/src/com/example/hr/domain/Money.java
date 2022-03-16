package com.example.hr.domain;

import java.util.Objects;

import com.example.ddd.annotations.ValueObject;

@ValueObject
public final class Money {
	private final double value;
	private final FiatCurrency currency;

	public static Money ofTurkishLiras(double value) {
		return of(value, FiatCurrency.TL);
	}

	public static Money of(double value, FiatCurrency currency) {
		Objects.requireNonNull(currency);
		if (value <= 0) {
			throw new IllegalArgumentException("Value must be a positive value");
		}
		return new Money(value, currency);
	}

	private Money(double value, FiatCurrency currency) {
		this.value = value;
		this.currency = currency;
	}

	public double getValue() {
		return value;
	}

	public FiatCurrency getCurrency() {
		return currency;
	}

	@Override
	public int hashCode() {
		return Objects.hash(currency, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		return currency == other.currency && Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value);
	}

	@Override
	public String toString() {
		return "Money [value=" + value + ", currency=" + currency + "]";
	}

	public Money multiply(double rate) {
		return Money.of(value * rate, currency);
	}

}

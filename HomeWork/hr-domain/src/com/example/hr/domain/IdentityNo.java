package com.example.hr.domain;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import com.example.ddd.annotations.ValueObject;

// Value Object: 
//   i) no identity -> all fields define an identity 
//  ii) must belong to an entity
// iii) immutable
@ValueObject
public final class IdentityNo {
	private final String value;
	private static final Map<String, IdentityNo> cache = new ConcurrentHashMap<>();

	// factory method
	static public IdentityNo valueOf(String value) {
		// validation
		Objects.requireNonNull(value);
		if (!isValid(value))
			throw new IllegalArgumentException("This is not a valid identity.");
		// object pooling = caching
		var cachedIdentity = cache.get(value);
		if (Objects.isNull(cachedIdentity)) {
			cachedIdentity = new IdentityNo(value);
			cache.put(value, cachedIdentity);
		}
		return cachedIdentity;
	}

	private static boolean isValid(String value) {
		return true;
	}

	private IdentityNo(String value) {
		this.value = value;
	}

	public String getValue() {
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
		IdentityNo other = (IdentityNo) obj;
		return Objects.equals(value, other.value);
	}

	@Override
	public String toString() {
		return "IdentityNo [value=" + value + "]";
	}

}

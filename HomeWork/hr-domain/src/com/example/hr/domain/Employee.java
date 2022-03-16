package com.example.hr.domain;

import com.example.ddd.annotations.Aggregate;

// Analysis -> Domain -> sub-domains 
// Design -> sub-domain <--> bounded-context
// Ubiquitous Language: Employee, IdentityNo, FullName, Iban, ...
// i) Entity ii) Value Object iii) Aggregate=Entity Root
// Employee -> Entity Class i) persist ii) identity iii) mutable
@Aggregate(id = "identity")
public class Employee {
	private final IdentityNo identity;
	private FullName fullname;
	private Iban iban;
	private Money salary;
	private JobStyle jobStyle;
	private Photo photo;
	private Department department;
	private final BirthYear birthYear;

	private Employee(IdentityNo identity, FullName fullname, BirthYear birthYear) {
		this.identity = identity;
		this.fullname = fullname;
		this.birthYear = birthYear;
	}

	public Employee(Builder builder) {
		this(builder.identity, builder.fullname, builder.birthYear);
		this.iban = builder.iban;
		this.salary = builder.salary;
		this.photo = builder.photo;
		this.department = builder.department;
		this.jobStyle = builder.jobStyle;
	}

	public FullName getFullname() {
		return fullname;
	}

	public void setFullname(FullName fullname) {
		this.fullname = fullname;
	}

	public Iban getIban() {
		return iban;
	}

	public void setIban(Iban iban) {
		this.iban = iban;
	}

	public Money getSalary() {
		return salary;
	}

	public void setSalary(Money salary) {
		this.salary = salary;
	}

	public JobStyle getJobStyle() {
		return jobStyle;
	}

	public void setJobStyle(JobStyle jobStyle) {
		this.jobStyle = jobStyle;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public IdentityNo getIdentity() {
		return identity;
	}

	public BirthYear getBirthYear() {
		return birthYear;
	}

	public static class Builder {
		private IdentityNo identity;
		private FullName fullname;
		private Iban iban;
		private Money salary;
		private JobStyle jobStyle;
		private Photo photo;
		private Department department;
		private BirthYear birthYear;

		public Builder(String value) {
			this.identity = IdentityNo.valueOf(value);
		}

		public Builder fullname(String firstname, String lastname) {
			this.fullname = FullName.of(firstname, lastname);
			return this;
		}

		public Builder iban(String value) {
			this.iban = Iban.of(value);
			return this;
		}

		public Builder salary(double value, FiatCurrency currency) {
			this.salary = Money.of(value, currency);
			return this;
		}

		public Builder salary(double value) {
			this.salary = Money.ofTurkishLiras(value);
			return this;
		}

		public Builder jobStyle(String value) {
			this.jobStyle = JobStyle.valueOf(value);
			return this;
		}

		public Builder jobStyle(JobStyle style) {
			this.jobStyle = style;
			return this;
		}

		public Builder department(String value) {
			this.department = Department.valueOf(value);
			return this;
		}

		public Builder department(Department department) {
			this.department = department;
			return this;
		}

		public Builder birthYear(int year) {
			this.birthYear = BirthYear.valueOf(year);
			return this;
		}

		public Builder photo(byte[] value) {
			this.photo = Photo.of(value);
			return this;
		}

		public Builder photo(String value) {
			this.photo = Photo.of(value);
			return this;
		}

		public Employee build() {
			// validation
			// business rule
			// constraint
			// invariance
			return new Employee(this);
		}

	}
}

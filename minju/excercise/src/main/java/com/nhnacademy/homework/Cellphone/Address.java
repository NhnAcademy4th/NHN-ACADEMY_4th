package com.nhnacademy.homework.Cellphone;

public class Address {
    private String phoneNumber;
    private String name;
    private String company;

    public Address(String phoneNumber, String name, String company) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.company = company;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        if (!this.company.isEmpty()) {
            sb.append("(");
            sb.append(company);
            sb.append(")");
        }
        sb.append(" : ");
        sb.append(this.phoneNumber);
        return sb.toString();
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }
}

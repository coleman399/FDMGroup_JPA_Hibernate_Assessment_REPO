package com.fdmgroup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FULLTIME_EMPLOYEE")
public class FullTimeEmployee extends Employee {
    @Column(name = "SALARY", nullable = false)
    private double salary;

    public FullTimeEmployee() {
    }

    public FullTimeEmployee(double salary) {
        this.salary = salary;
    }

    public FullTimeEmployee(String empName, String empDesignation, Department department, double salary) {
        super(empName, empDesignation, department);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "FullTimeEmployee [salary=" + salary + "]";
    }

}

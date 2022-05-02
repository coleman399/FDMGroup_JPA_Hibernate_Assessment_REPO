package com.fdmgroup;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@NamedQuery(name = "findEmployeesByDeptName", query = "SELECT e FROM Employee e JOIN Department d ON e.department = d.deptId WHERE d.deptName LIKE :deptName")
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMP_ID", nullable = false)
    private int empId;
    @Column(name = "EMP_NAME", nullable = false)
    private String empName;
    @Column(name = "EMP_DESIGNATION", nullable = false)
    private String empDesignation;
    @OneToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH })
    @JoinColumn(name = "FK_DEP_ID")
    private Department department;

    public Employee() {
    }

    public Employee(String empName, String empDesignation) {
        this.empName = empName;
        this.empDesignation = empDesignation;
    }

    public Employee(String empName, String empDesignation, Department department) {
        this.empName = empName;
        this.empDesignation = empDesignation;
        this.department = department;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpDesignation() {
        return empDesignation;
    }

    public void setEmpDesignation(String empDesignation) {
        this.empDesignation = empDesignation;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee [empDesignation=" + empDesignation + ", empId=" + empId + ", empName=" + empName + "]";
    }

}

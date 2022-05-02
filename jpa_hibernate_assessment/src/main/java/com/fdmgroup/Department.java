package com.fdmgroup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQuery(name = "findDepartmentByDeptName", query = "SELECT d FROM Department d WHERE d.deptName LIKE :deptName")
@Entity
@Table(name = "DEPARTMENT")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DEPT_ID", nullable = false)
    private int deptId;
    @Column(name = "DEPT_NAME", nullable = false)
    private String deptName;

    public Department() {
    }

    public Department(String deptName) {
        this.deptName = deptName;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Department [deptId=" + deptId + ", deptName=" + deptName + "]";
    }

}

package com.fdmgroup;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Demo {

    static EntityManagerFactory emf;

    public static List<Department> findDepartmentByDeptName(final String deptName) {
        final EntityManager em = emf.createEntityManager();
        final TypedQuery<Department> query = em.createNamedQuery("findDepartmentByDeptName", Department.class);
        query.setParameter("deptName", deptName);
        final List<Department> results = query.getResultList();
        em.close();
        return results;
    }

    public static List<Employee> findEmployeesByDeptName(String deptName) {
        final EntityManager em = emf.createEntityManager();
        final TypedQuery<Employee> query = em.createNamedQuery("findEmployeesByDeptName", Employee.class);
        query.setParameter("deptName", deptName);
        final List<Employee> results = query.getResultList();
        em.close();
        return results;
    }

    public static void main(String[] args) {
        Department Academy = new Department("Academy");
        Department Sales = new Department("Sales");
        Employee employee1 = new Employee("John Doe", "Trainer", Academy);
        Employee employee2 = new Employee("Jane Doe", "Executive", Sales);
        Employee employee3 = new Employee("James Smith", "Trainer", Academy);
        
        emf = Persistence.createEntityManagerFactory("JPA");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.merge(Academy);
        em.merge(Sales);
        em.merge(employee1);
        em.merge(employee2);
        em.merge(employee3);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        List<Department> searchByDepartmentNameResults = findDepartmentByDeptName("Academy");
        System.out.println("searchByDepartmentNameResults: " + searchByDepartmentNameResults);

        List<Employee> findEmployeesByDeptNameResults = findEmployeesByDeptName("Sales");
        System.out.println("findEmployeesByDeptNameResults: " + findEmployeesByDeptNameResults);

        em.getTransaction().commit();
        em.close();

    }
}

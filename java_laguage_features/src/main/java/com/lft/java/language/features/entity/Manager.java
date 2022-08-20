package com.lft.java.language.features.entity;

public class Manager extends Employee {

    /**
     * 这里使用@Override在编译时会报错
     *
     * @param salary 工资
     * @ Override 不能使用在静态方法上
     */
    public void setSalary(int salary) {
        System.out.printf("Manager.setSalary() is : %s", salary);
    }

    public static void main(String[] args) {
        Employee employee = new Manager();
        double salary1 = 20;
        int salary2 = 20;
        employee.setSalary(salary1);
        employee.setSalary(salary2);

    }
}

package src.main.java;

import java.util.Date;

public class Employee implements Comparable<Employee> {
    private String name;//姓名
    private int salary;//工资
    private Date hireDay;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void setHireDay(Date hireDay) {
        this.hireDay = hireDay;
    }

    public boolean equals(Object otherObject){
        if(this == otherObject) {
            return true;
        }//判断对象引用是否相同
        if(otherObject == null) {
            return false;
        }//判断目标对象是否为空
        if(getClass() != otherObject.getClass()){
            return false;
        }//判断对象所属类型是否相同
        Employee employee = (Employee)otherObject;//目标对象不为空，所属类型相同，且对象引用相同的情况下，强转目标对象为实际类型
        return this.name.equals(employee.name) && this.salary == employee.salary && this.hireDay.equals(employee.hireDay);
    }
    public int compareTo(Employee other){
        return Integer.compare(this.salary, other.salary);
    }
}

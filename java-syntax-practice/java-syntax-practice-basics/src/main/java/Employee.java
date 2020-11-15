package src.main.java;

import java.util.Date;

public class Employee implements Comparable<Employee> {
    private String name;//����
    private int salary;//����
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
        }//�ж϶��������Ƿ���ͬ
        if(otherObject == null) {
            return false;
        }//�ж�Ŀ������Ƿ�Ϊ��
        if(getClass() != otherObject.getClass()){
            return false;
        }//�ж϶������������Ƿ���ͬ
        Employee employee = (Employee)otherObject;//Ŀ�����Ϊ�գ�����������ͬ���Ҷ���������ͬ������£�ǿתĿ�����Ϊʵ������
        return this.name.equals(employee.name) && this.salary == employee.salary && this.hireDay.equals(employee.hireDay);
    }
    public int compareTo(Employee other){
        return Integer.compare(this.salary, other.salary);
    }
}

package com.barokah.java.belajar.p20.lombok;

import com.barokah.java.belajar.p20.lombok.equalsandhashcode.Employee;
import com.barokah.java.belajar.p20.lombok.equalsandhashcode.EmployeeWihExclude;
import com.barokah.java.belajar.p20.lombok.equalsandhashcode.Manager;
import com.barokah.java.belajar.p20.lombok.equalsandhashcode.ManagerWihCallSuper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
//@EqualsAndHashCode is to create equals() method and hashcode() method
public class P04EqualsAndHashCodeTest {

    @Test
    void testEqualsAndHashCode(){
        Employee employee1 = new Employee("001", "PT Sejahtera");
        Employee employee2 = new Employee("001", "PT Sejahtera");

        Assertions.assertEquals(employee1,employee2);
        Assertions.assertEquals(employee1.hashCode(),employee2.hashCode());
    }

    @Test
    void testEqualsAndHashCodeWithExclude(){
        EmployeeWihExclude employee1 = new EmployeeWihExclude("001", "PT Sejahtera");
        EmployeeWihExclude employee2 = new EmployeeWihExclude("001", "PT Indonesia Maju");

        Assertions.assertEquals(employee1,employee2);
        Assertions.assertEquals(employee1.hashCode(),employee2.hashCode());
    }

    @Test
    void testEqualsAndHashCodeManager(){
        Manager manager1 = new Manager();
        Manager manager2 = new Manager();

        manager1.setId("001");
        manager1.setName("PT Maju");
        manager1.setTotalEmployee(10);

        manager2.setId("002");
        manager2.setName("PT Laku");
        manager2.setTotalEmployee(10);

        Assertions.assertEquals(manager1,manager2);
        Assertions.assertEquals(manager1.hashCode(),manager2.hashCode());
    }

    @Test
    void testEqualsAndHashCodeManagerWithSuper(){
        ManagerWihCallSuper manager1 = new ManagerWihCallSuper();
        ManagerWihCallSuper manager2 = new ManagerWihCallSuper();

        manager1.setId("001");
        manager1.setName("PT Maju");
        manager1.setTotalEmployee(10);

        manager2.setId("002");
        manager2.setName("PT Laku");
        manager2.setTotalEmployee(10);

        Assertions.assertNotEquals(manager1,manager2);
        Assertions.assertNotEquals(manager1.hashCode(),manager2.hashCode());
    }


}

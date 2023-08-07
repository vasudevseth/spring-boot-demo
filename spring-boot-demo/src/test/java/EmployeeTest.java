import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.telstra.springbootdemo.model.Employee;

public class EmployeeTest {
	@Test
	public void getSalaryTest() {
		Employee employee = new Employee(1001,"Ram","Manager",50000);
		assertEquals(50000,employee.getSalary());
	}
	@Test
	public void getNameTest() {
		Employee employee = new Employee(1001,"Ram","Manager",50000);
		assertEquals(50000,employee.getName());
	}

}

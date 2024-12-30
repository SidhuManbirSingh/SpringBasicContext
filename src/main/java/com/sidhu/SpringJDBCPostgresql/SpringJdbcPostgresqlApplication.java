package com.sidhu.SpringJDBCPostgresql;

import com.sidhu.SpringJDBCPostgresql.model.Student;
import com.sidhu.SpringJDBCPostgresql.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcPostgresqlApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringJdbcPostgresqlApplication.class, args);

//		Student s = context.getBean(Student.class);
//		s.setId(4);
//		s.setName("Manbir");
//		s.setMarks(92);
//
		StudentService service = context.getBean(StudentService.class);

//		service.addStudent(s);

		List<Student> students = service.getStudents();
		System.out.println(students + "");
	}

}

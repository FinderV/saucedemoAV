package org.tms.test;

import org.testng.annotations.Test;
import org.tms.model.Student;

public class StudentTest {

  @Test
  public void createTest() {
    Student student = new Student.StudentBuilder("Egor", "Petrov")
                                 .phone("343434343")
                                 .correspondenceStudent(false)
                                 .age(34)
                                 .country("RF")
                                 .build();

    Student student1 = new Student.StudentBuilder("Ivan", "Petrov").build();

    Student student2 = new Student.StudentBuilder("Kiril", "Petrov")
                                  .age(30)
                                  .build();

  }

}

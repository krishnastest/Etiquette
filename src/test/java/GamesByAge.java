
import com.google.gson.Gson;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;


public class GamesByAge {

    //1. Arrange
    public class Students {

        private int age;
        private String name;
        
    }

    public class StudentAgeGroup {

        public int minAge;
        public int maxAge;

        public ArrayList<Students> students = new ArrayList<>();


        boolean isInAgeRange(int studentsAge) {
            if (studentsAge >= minAge && studentsAge <= maxAge) {
                return true;
            }
            return false;
        }
    }

    public class StudentData {

        public ArrayList<Students> allStudents;

        public ArrayList<StudentAgeGroup> studentAgeGroups;
    }

    @Test
    public void test() throws IOException {

        String projectDirectoryPath = System.getProperty("user.dir");
        Path currentRelativePath = Paths.get(projectDirectoryPath + "/src/test/java/students.json");

        String jsonText = Files.readString(currentRelativePath);

        Gson gson = new Gson();

        StudentData studentData = gson.fromJson(jsonText, StudentData.class);

        ArrayList<Integer> ageDistributionList = new ArrayList<>();

        for (int i=0; i < studentData.allStudents.size(); i++) {

            Students currentStudent = studentData.allStudents.get(i);

            if (!ageDistributionList.contains(currentStudent.age)) {
                ageDistributionList.add(currentStudent.age);
            }
        }

        studentData.studentAgeGroups = new ArrayList<>();

        for (int i=0; i<ageDistributionList.size(); i++) {

            int age = ageDistributionList.get(i);

            StudentAgeGroup ageGroup = new StudentAgeGroup();
            ageGroup.minAge = age - 1;
            ageGroup.maxAge = age + 1;

            studentData.studentAgeGroups.add(ageGroup);
        }

        for (int i=0; i < studentData.allStudents.size(); i++) {

            Students currentStudent = studentData.allStudents.get(i);

            for (int j = 0; j<studentData.studentAgeGroups.size(); j++) {

                StudentAgeGroup currentAgeGroup = studentData.studentAgeGroups.get(j);

                if (currentAgeGroup.isInAgeRange(currentStudent.age)) {
                    currentAgeGroup.students.add(currentStudent);
                    break;
                }
            }
        }


        for (int i = 0; i<studentData.studentAgeGroups.size(); i++) {

            StudentAgeGroup studentGroup = studentData.studentAgeGroups.get(i);

            // some logically possible groups might not have students, don't print them
            if (studentGroup.students.size() > 0) {

                // print the students assigned to each existing group
                System.out.println("Group " + i+1 + ": Students: " + gson.toJson(studentGroup.students));
            }
        }
    }
}




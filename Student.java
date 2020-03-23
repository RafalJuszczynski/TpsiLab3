package labs;
import java.util.ArrayList;
import java.util.List;

    public class Student extends Person {

        private String groupId;
        private List<Double> grades = new ArrayList<>();
        
        public Student(String firstName, String lastName ) {
            super(firstName, lastName);
            this.groupId = groupId;
        }
        public String getGroupId() {
            return groupId;
        }

        public void setGroupId(String groupId) {
            this.groupId = groupId;
        }
        
        public List<Double> getGrades() {
            return grades;
        }

        public void addGrade(double grade) {
             grades.add(grade);
        }
        
        public double getGradesAverage() {
            double avgGrades=0.0;
            for(Double temp : grades){
                avgGrades+=temp;
            }
            avgGrades/=grades.size();
            return avgGrades;
        }
        
    }  
        
    
    
     


package in.one2n.exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Grader {

    public List<Student> parseCSV(String filepath) {
       
        List<Student> students = new ArrayList<>();
        String line = "";

        try{
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            while((line = br.readLine())!=null){
                
                String values[] = line.split(",");

                if(!values[0].contains("FirstName")){
                Student s = new Student(values[0],values[1],values[2],
                    Double.valueOf(values[3]),Double.valueOf(values[4]), Double.valueOf(values[5]),Double.valueOf(values[6]));
            
                students.add(s);
                }
            }
            br.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    public List<Student> calculateGrade(List<Student> students) {
       
        students.stream().forEach((s) ->{
            Double finalscore = (s.getTest1Score()+s.getTest2Score()+s.getTest3Score()+s.getTest4Score())/4;
            s.setFinalScore(finalscore);
            if(finalscore<35){
                s.setGrade(Grade.F);
            }
            else if(finalscore>=35 && finalscore< 50){
                s.setGrade(Grade.C);
            }
            else if(finalscore>=50 && finalscore<70){
                s.setGrade(Grade.B);
            }
            else {
                s.setGrade(Grade.A);
            }
        });

        return students;
    }

    public Student findOverallTopper(List<Student> gradedStudents) {
    
        Student student = gradedStudents.stream()
        .max(Comparator.comparingDouble(Student::getFinalScore))
        .get();
        
        return student;
    }

    public Map<String, Student> findTopperPerUniversity(List<Student> gradedStudents) {
        
        Map<String, Student> toppers = gradedStudents.stream()
                .collect(Collectors.toMap(Student::getUniversity, Function.identity(),
                BinaryOperator.maxBy(Comparator.comparing(Student::getFinalScore))));

        return toppers;
    }
}

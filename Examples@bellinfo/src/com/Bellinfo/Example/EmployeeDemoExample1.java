package com.Bellinfo.Example;

import java.util.Scanner;
 
public class EmployeeDemoExample1 {
    Scanner scan;
 
    public static void main(String[] args) {
        EmployeeDemoExample1 ede =new EmployeeDemoExample1();
        StudentDetails[] uniqueSDArray = ede.recieveInputsFromConsole();
        ede.displayResults(uniqueSDArray);
    }
 
    /**
     * method to receive inputs from console
     * @return
     */
    StudentDetails[] recieveInputsFromConsole(){
        scan = new Scanner(System.in);
        System.out.println("enter student count:");
        int studentCount = scan.nextInt();
        StudentDetails[] originalStudArray = new StudentDetails[studentCount];
        StudentDetails[] uniqueStudArray = new StudentDetails[studentCount];
        System.out.println("");
        for(int i=0;i<=studentCount-1;i++){
            System.out.println("Student Details"+i+" :");
            System.out.println("Student Id:");
            int sId =scan.nextInt();
            System.out.println("Student Name:");
            String sName = scan.next();
            System.out.println("Course Id:");
            int cId = scan.nextInt();
            System.out.println("Course Name:");
            String cName = scan.next();
            System.out.println("Course Duration:");
            int cDuration = scan.nextInt();
             
            StudentDetails sd =populateStudentDetails(sId, sName, cId, cName, cDuration);
            originalStudArray[i] =sd;
        }
        uniqueStudArray = eliminateDuplicateStudentRecords(originalStudArray);
        return uniqueStudArray;
    }
     
    /***
     * Method used to process inputs and populate the object required.
     * @param sId
     * @param sName
     * @param cId
     * @param cName
     * @param cDuration
     * @return
     */
    StudentDetails populateStudentDetails(int sId, String sName, int cId, String cName, int cDuration){
        Course c = new Course();
        c.setCourseId(cId);
        c.setCourseName(cName);
        c.setCourseDuration(cDuration);
         
        StudentDetails sd = new StudentDetails();
        sd.setStudentId(sId);
        sd.setStudentName(sName);
        sd.setCourse(c);
         
        return sd;
         
    }
     
    /**
     * Logic to eliminate the duplicates
     * @param orignialStudArray
     * @return
     */
    StudentDetails[] eliminateDuplicateStudentRecords(StudentDetails[] orignialStudArray){
        StudentDetails[] filteredArray = new StudentDetails[orignialStudArray.length];
        filteredArray = orignialStudArray.clone();
        for(int i=0; i<=orignialStudArray.length-1; i++){
            StudentDetails sd1 = orignialStudArray[i];
            for(int j=i+1,y=0;j<=orignialStudArray.length-1;j++){
                StudentDetails sd2 = orignialStudArray[j];
                if(sd1.equals(sd2)){
                    filteredArray[j] =null;
                }
             }
        }
         
         System.out.println("EliminateDuplicate Student Record"+ filteredArray);
        return filteredArray;
         
    }
     
    /**
     * This method used for displaying the results after filtering the results.
     * @param array
     */
    void displayResults(StudentDetails[] array){
        System.out.println("****************************************");
        System.out.println("********Unique Student Records**********");
        System.out.println("****************************************");
        System.out.println("Id"+"     "+"Name"+"     "+"CId"+"     "+"CName"+"     "+"CDuration");
        for(int i=0;i<=array.length-1;i++){
            if(array[i]!=null){
                StudentDetails sd = array[i];
                System.out.println(sd.toString());
            }
        }
    }
}
 
 
 





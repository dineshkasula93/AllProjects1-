package com.Bellinfo.Example;

public class Course{
    private int courseId;
    private String courseName;
    private int courseDuration;
     
    public int getCourseId() {
        return courseId;
    }
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public int getCourseDuration() {
        return courseDuration;
    }
    public void setCourseDuration(int courseDuration) {
        this.courseDuration = courseDuration;
    }
     
    public boolean equals(Object otherCourse){
         if(otherCourse ==null){
             return false;
         }
         if(otherCourse instanceof Course){
             Course otherObj = (Course) otherCourse;
             if(this.courseId==otherObj.courseId && this.courseName.equals(otherObj.courseName)
                     && this.courseDuration==this.getCourseDuration()){
                 return true;
                  
             }
         }
         return false;
    }
     
    public int hashCode(){
        return 31*courseId*courseDuration*courseName.hashCode();
         
    }
    public String toString(){
        return courseId+"     "+courseName+"     "+courseDuration;
    }
     
     
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxycorpspringmvcpractice.springmvcpractice.Controller;

import java.util.Objects;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Foxy
 */
public class UserInfo {
    
    @NotNull
    @Size(min=4, max=15)
    private String name;
    
    private String course;
    @Min(100)
    private int fee;
    @Min(2017)
    private int year;
    private String CurDate;

     @Override
    public String toString() {
        return "UserInfo{" + "name=" + name + ", course=" + course + ", fee=" + fee + ", year=" + year + ", CurDate=" + CurDate + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.name);
        hash = 43 * hash + Objects.hashCode(this.course);
        hash = 43 * hash + this.fee;
        hash = 43 * hash + this.year;
        hash = 43 * hash + Objects.hashCode(this.CurDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserInfo other = (UserInfo) obj;
        if (this.fee != other.fee) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.course, other.course)) {
            return false;
        }
        if (!Objects.equals(this.CurDate, other.CurDate)) {
            return false;
        }
        return true;
    }
    


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCurDate() {
        return CurDate;
    }

    public void setCurDate(String CurDate) {
        this.CurDate = CurDate;
    }
    

    
    
}

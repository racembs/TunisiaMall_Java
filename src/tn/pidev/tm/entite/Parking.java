/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.pidev.tm.entite;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ADMIN
 */
public class Parking {
    private int id;
    private int numPlace;
    //private int etatDispo;
    private Client c;
    private Time tE;
     private Time tS;
    Date datePark;

    public Parking() {
    }

    public Parking(int numPlace) {
        this.numPlace = numPlace;
    }

    public Parking(int id, int numPlace, Client c) {
        this.id = id;
        this.numPlace = numPlace;
        this.c = c;
    }

    public Parking(int id, int numPlace, Client c, Time tE, Time tS, Date datePark) {
        this.id = id;
        this.numPlace = numPlace;
        this.c = c;
        this.tE = tE;
        this.tS = tS;
        this.datePark = datePark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumPlace() {
        return numPlace;
    }

    public void setNumPlace(int numPlace) {
        this.numPlace = numPlace;
    }

    public Client getC() {
        return c;
    }

    public void setC(Client c) {
        this.c = c;
    }

    public Time gettE() {
        return tE;
    }

    public void settE(Time tE) {
        this.tE = tE;
    }

    public Time gettS() {
        return tS;
    }

    public void settS(Time tS) {
        this.tS = tS;
    }

    public Date getDatePark() {
        return datePark;
    }

    public void setDatePark(Date datePark) {
        this.datePark = datePark;
    }

    @Override
    public String toString() {
        return "Parking{" + "id=" + id + ", numPlace=" + numPlace + ", c=" + c + ", tE=" + tE + ", tS=" + tS + ", datePark=" + datePark + '}';
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
        final Parking other = (Parking) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.numPlace != other.numPlace) {
            return false;
        }
        if (!Objects.equals(this.c, other.c)) {
            return false;
        }
        if (!Objects.equals(this.tE, other.tE)) {
            return false;
        }
        if (!Objects.equals(this.tS, other.tS)) {
            return false;
        }
        if (!Objects.equals(this.datePark, other.datePark)) {
            return false;
        }
        return true;
    }

  
   
    
   public  java.sql.Time toSqlTime(LocalTime localTime) {
    return java.sql.Time.valueOf(localTime);
  }
      public  java.sql.Date toSqlDate(LocalDate localTime) {
    return java.sql.Date.valueOf(localTime);
  }
          public java.sql.Date convert(String date)throws ParseException
    {
    SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date date1=sdf1.parse(date);
    java.sql.Date sqldate= new java.sql.Date(date1.getTime());
    return sqldate;
    
    }
              public java.sql.Date convert(java.util.Date date) {
    return new java.sql.Date(date.getTime());
}
                public LocalTime toLocalTime(java.sql.Time time) {
    return time.toLocalTime();
  }
   
}

// A classed used to store a date with a year, month and day fields. Has date calculation methods.
public class Date{
   private int day;
   private int month;
   private int year;
   
   public Date(){
      this.year = 2000;
      this.month = 1;
      this.day = 1;
   }
   
   public Date(int year){
      this();
      this.year = year;
   }
   
   public Date(int year, int month){
      this(year);
      this.month = month;
   }
   
   public Date(int year, int month, int day){
      this(year, month);
      this.day = day;
   }
   
   public int getYear(){ return this.year;}
   public int getMonth(){ return this.month;}
   public int getDay(){ return this.day;}
   
   public void setYear(int year){ this.year = year;}
   public void setMonth(int month){ this.month = month;}
   public void setDay(int day){ this.day = day;}

   public String toString(){
      return month + "/" + day + "/" + year;
   }
   
   // This method calculates the number of days from current object date to the passed in date.
   public int daysTo(Date endDate){
   int totalDays = daysOver(endDate.getMonth(), endDate.getDay(), isLeap(endDate.getYear()));
   totalDays -= daysOver(this.month, this.day, isLeap(this.year));
   totalDays += getLeapYears(this.year, endDate.getYear());
   for(int i = this.year; i < endDate.getYear(); i++){
      totalDays += 365;
   }
   return totalDays;

   }
   
   // This method calculates the number of days from the passed in date to the current objects date.
   public int daysFrom(Date startDate){
      int totalDays = daysOver(this.month, this.day, isLeap(this.year));
      totalDays -= daysOver(startDate.getMonth(), startDate.getDay(), isLeap(startDate.getYear()));
      totalDays += getLeapYears(startDate.getYear(), this.year);
      for(int i = startDate.getYear(); i < this.year; i++){
         totalDays += 365;
      }
      return totalDays;
   }
   
   private int daysOver(int month, int day, boolean leap){
      int totalDays = day;
      for(int i = 1; i < month; i++){
         if(i == 2){
            if(leap){
               totalDays += 29;
            }
            else{
               totalDays += 28;
            }
         }
         else if(i==4||i==6||i==9||i==11){
            totalDays += 30;
         }
         else{
            totalDays += 31;
         }
      }
      return totalDays;
   }
   
   private boolean isLeap(int year){
      if(year%400==0 && year%4==0){
         return true;
      }
      if(year%4==0 && year%100 != 0){
         return true;
      }
      return false;
   }
   
   private int getLeapYears(int startYear, int endYear){
      int leapYears = 0;
      for(int i = startYear; i < endYear; i++){
         if(isLeap(i)){
            leapYears++;
         }
      }
      return leapYears;
   }
}
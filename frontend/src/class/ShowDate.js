export default class ShowDate {
    id=null;
    day= '';  
    date= null;
    month= null;
    year= null;
    completeDate='';
    constructor(id,day,date,month,year,completeDate) 
    {
      this.id = id;
      this.day = day;
      this.date = date;
      this.month = month;
      this.year = year;
      this.completeDate = completeDate;
    }        
}
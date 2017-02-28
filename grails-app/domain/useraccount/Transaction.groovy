package useraccount

/*
creates a new Transaction object with amount, category and date. The date is entered as yyyy-mm-dd, which is then broken up into
three separate variables corresponding to year, month and day respectively.

Contains methods: get_amount, get_category, get_date, get_year, get_month, get_day
 */
class Transaction {

    Double amount
    String category, date, d1, d2, d3
    Integer year, month, day

    Transaction(double amount, String category, String date){
        this.amount = amount
        this.category = category
        this.date = date

        //Now we break up the string into year, month and day
        String[] datestuff = date.split("-")

        d1 = datestuff[0]//year
        d2 = datestuff[1]//month
        d3 = datestuff[2]//day

        year = Integer.parseInt(d1)
        month = Integer.parseInt(d2)
        day = Integer.parseInt(d3)

        //assign to constructor
        this.year = year
        this.month = month
        this.day = day


    }

    /*
    returns the amount of a particular transaction
     */
    def get_amount(){
        return amount
    }

    /*
    returns the category that the transaction was placed into
     */
    def get_category(){
        return category
    }

    /*
    returns the date that the transaction took place on
     */
    def get_date(){
        return date
    }

    //The following getters are for more specific categorization and in the event that the year, month or day specifically
    // of a transaction must be called

    /*
    returns the year in which the transaction took place
     */
    def get_year(){
        return year

    }
    /*
    returns the month in which the transaction took place
     */
    def get_month(){
        return month

    }
    /*
    returns the day on which the transaction took place
     */
    def get_day(){
        return day
    }



    static constraints = {
        //constaints so that year, month and day values all make sense
        year > 0
        1<= month && month <= 12
        1<= day && day <= 31

    }
}

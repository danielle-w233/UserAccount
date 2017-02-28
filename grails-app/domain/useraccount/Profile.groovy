package useraccount

import java.awt.Image
import java.io.IOException;
import javax.imageio.ImageIO;
import java.net.URL
/*

Creates a new Profile with savings, income and an avatar that is a .PNG image file pulled from an online respository using java.imageio
Notes:
This class contains methods get_savings, get_income, get_transactions, get_avatar, get_achievements, set_income, add_transaction, add_achievement
set_avatar and set_savings.

The change_avatar method was omitted because the inclusion of set_avatar makes this method redundant
 */

class Profile extends Achievement{

    Double savings, income
    Image avatar = null
    String urlName
    //Profile has both many transactions and achievements
    static hasMany = [Transactions: Transaction, Achievements: Achievement]
    //Each profile belongs to a user account
    static belongsTo = [userAccount: UserAccount]

    //check the type of structure in database
    ArrayList<Transaction> transactions = new ArrayList<Transaction>()
    ArrayList<Achievement> achievements = new ArrayList<Achievement>()

    Profile(Double savings, Double income, String urlName){
        this.savings = savings
        this.income = income
        this.urlName = urlName

        try{
            url = new URL(urlName)
            avatar = ImageIO.read(url)

        }
        catch(IOException e){
            System.out.println(e.getMessage())
        }

    }

    /*
    returns savings amount
     */
    def get_savings() {
        return savings
    }

    /*
    returns income amount
     */
    def get_income(){
        return income
    }

    /*
    returns a list that contains all the user's transactions
     */
    def get_transactions(){
        return transactions
    }

    /*
    returns the current avatar image
     */
    def get_avatar(){
        return avatar
    }

    /*
    returns the list of achievements, including those earned and not earned
     */
    def get_achievements(){
        return achievements

    }

    /*
    sets a new income for the user's profile
     */
    def set_income(double newincome){
        income = newincome
    }

    /*
    adds a transaction to the user's profile
     */
    def add_transaction(double amount, String category, String date){
        Transaction newTransaction = new Transaction(amount, category, date)
        transactions.add(newTransaction)
    }

    /*
    sets the avatar for the profile using a url to an image in an online repository
     */
    def  set_avatar(String newAvatarUrl){
        try{
            url = new URL(newAvatarUrl)
            avatar = ImageIO.read(url)

        }
        catch(IOException e){
            System.out.println(e.getMessage())
        }
    }

    /*
    adds an achievement to the list
     */
    def add_achievement(Achievement newachievement){
        //adds the new achivement to the list
        achievements.add(newachievement)
    }

    /*
    sets the savings amount for the profile
     */
    def set_savings(double newsavings){
        savings = newsavings
    }





    static constraints = {
        //savings must be less than income
        savings < income
    }
}

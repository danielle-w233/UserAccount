package useraccount

import java.awt.Image
import java.io.IOException;
import javax.imageio.ImageIO;
import java.net.URL

/*
This class creates a new UserAccount object using input from the user as well as information already stored in the user's profile
Contains methods: get_username, get_password, get_profile, set_password, set_profile and delete_account

For obtaining images from an online repository we use java's imageio package and urls.
 */
class UserAccount extends Profile{

    String userName
    String password
    Profile profile
    Image avatar
    URL url
    static hasOne = [profile: Profile]

    UserAccount(String userName, String password, Profile profile){
        this.userName = userName
        this.password = password
        this.profile = profile

    }

    /*
    returns the username
     */
    String get_username(){
        return userName

    }

    /*
    returns the password
     */
    def get_password(){
        return password

    }

    /*

     */
    def get_profile(){
        return profile

    }

    /*
    sets a new password or replaces a previous password
     */
    def set_password(String newpassword){
        password = newpassword
    }

    /*
    sets a profile associated with this user account or replaces the profile with a new one
     */
    def set_profile(double newSavings, double newIncome, URL newImageUrl){
        savings = newSavings
        income = newIncome


        try{
            url = new URL(newImageUrl)
            avatar = ImageIO.read(url)

        }
        catch(IOException e){
            System.out.println(e.getMessage())
        }
    }

    /*
    deletes this instance of UserAccount
     */
    def delete_account(){
        //sets all parameters associated with particular instance of user account to null
        this.userName = null
        this.password = null
        this.profile = null
        this.transactions = null
        this.achievements = null
    }



    static constraints = {
        //password must be between 8 and 14 characters
        password size: 8..14
    }
}

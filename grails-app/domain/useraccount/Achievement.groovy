package useraccount

import java.awt.Image
import java.io.IOException;
import javax.imageio.ImageIO;
import java.net.URL

/*
class creates a new Achievement object with name, status and picture, where the picture is a .PNG file pulled from an online
repository using java.imageio

Contains methods: get_name, get_status, get_picture
 */
class Achievement {

    String name
    Boolean status
    Image picture = null
    String urlName
    URL url

    Achievement(String name, Boolean status, String urlName){
        this.name = name
        this.status = status
        this.urlName = urlName

        try{
            url = new URL(urlName)
            picture = ImageIO.read(url)

        }
        catch(IOException e){
            System.out.println(e.getMessage())
        }

    }

    /*
    returns the name of the achievement
     */
    def get_name(){
        return name
    }

    /*
    returns the status of the achievement (either 0 or 1) where 1 indicates that the achievement has been earned
    and 0 indicates that it has not yet been earned
     */
    def get_status(){
        return status
    }

    /*
    returns the image associated with a particular achievement.
     */
    def get_picture(){
        return picture

    }


    static constraints = {
        urlName != null
    }
}

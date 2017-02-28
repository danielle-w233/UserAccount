package useraccount
import grails.rest.RestfulController

class UserAccountController extends RestfulController{

    //json files for now, specific format that we want to use?
    static responseFormats = ['json']

    UserAccountController(){
        super(UserAccount)
    }







    //def index() { }
}

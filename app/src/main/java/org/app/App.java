package org.app;

import edu.ita.softserve.service.UserService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	UserService service = new UserService();
    	System.out.println(service.findById(1).getFirstName());
    	System.out.println("sdfsd");
        //System.out.println( service.getAvarageAgeByBookName("Chorne Sonce") );
    }
}

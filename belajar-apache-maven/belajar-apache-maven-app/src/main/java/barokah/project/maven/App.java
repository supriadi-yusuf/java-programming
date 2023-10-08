package barokah.project.maven;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Person person = new Person("Supriadi Yusuf");

        Gson gson = new Gson();
        String json = gson.toJson(person);

        System.out.println( json );
    }
}

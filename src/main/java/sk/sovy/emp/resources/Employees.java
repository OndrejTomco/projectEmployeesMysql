package sk.sovy.emp.resources;

import sk.sovy.emp.db.MySQL;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/employee")
public class Employees {

    @GET
    @Path("/employees")
    @Produces(MediaType.APPLICATION_JSON)

    public String getCountries(){
        MySQL mySQL=new MySQL();
        List<String> list= mySQL.getEmployees();
        System.out.println(list);


        boolean b = false;
        String result= "showEmployees({\"name\":[";
        for(String temp:list){
            if(b == true){
                result+=',';
            }
            else
                b=true;
            result+="\""+temp+"\"";
        }
        return result+="]})";

    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)

    public String getSalary(@PathParam("name") String name){
        String salary = new MySQL().getSalary(name);
        System.out.println(salary);
        String res = "showSalary({\"salary\":\""+salary+"\"})";
        System.out.println(res);

        return res;

    }

}

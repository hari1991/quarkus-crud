package in.hkb.samples.quarkus;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/employees")
public class EmployeeResource {
	
	@Inject
	EmployeeService service;

    @GET
    @Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public String getEmployees() {
        return "Hello RESTEasy";
    }
    
    @POST
    @Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Employee createEmployee(Employee employee) {
    	System.out.println("");
		return service.addNewEmployee(employee);
    }
    
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String updateEmployee(@PathParam(value = "id") int id, Employee employee) {
        return "Hello RESTEasy";
    }
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteEmployee(@PathParam(value = "id") int id) {
        return "Hello RESTEasy";
    }
}
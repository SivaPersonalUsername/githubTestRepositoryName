package com.siva.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.siva.dao.SoftwareModulesDao;





@Path("/SMS")
public class SoftwareModulesService {

	//http://localhost:8080/SoftwareModulesService/rest/SMS/getSoftwareModuleById?smid=1
	@GET
	@Path("/getSoftwareModuleById")
	@Produces(MediaType.APPLICATION_JSON)
	public SoftwareModule getSoftwareModuleById(@QueryParam("smid") int smid) {
		SoftwareModulesDao softwareModulesDao=new SoftwareModulesDao();
		
		return softwareModulesDao.getSoftwareModuleById(smid);
	}
	//http://localhost:8080/SoftwareModulesService/rest/SMS/fetchAll
	@GET
	@Path("/fetchAll")
    @Produces(MediaType.APPLICATION_XML)
    public List<SoftwareModule> fetchAll() {
		
		SoftwareModulesDao softwareModulesDao=new SoftwareModulesDao();
		List<SoftwareModule>  softwareModulesList=new ArrayList<SoftwareModule>();
		
        return softwareModulesDao.fetchAll();
    }
	
	//http://localhost:8080/SoftwareModulesService/rest/SMS/createModule
	@POST
	@Path("/createModule")
    public Response createModule(@QueryParam("sm_name") String sm_name,@QueryParam("sm_des") String sm_des,@QueryParam("sm_version") int sm_version,@QueryParam("username") String username) {
		SoftwareModule softwareModule=new SoftwareModule();
		SoftwareModulesDao softwareModulesDao=new SoftwareModulesDao();
		Response response=null;
		softwareModule.setSm_name(sm_name);
		softwareModule.setSm_des(sm_des);
		softwareModule.setSm_version(sm_version);
		softwareModule.setUsername(username);
		System.out.println("=======createModule=======");
		
		int result=softwareModulesDao.createModule(softwareModule);
		if(result>=0){
			return response.status(Status.OK).entity("Successfully Inserted the Details").build();
		}else {
			return response.status(Status.BAD_REQUEST).entity("Failed to  Insert the Details").build();
		}
}
}

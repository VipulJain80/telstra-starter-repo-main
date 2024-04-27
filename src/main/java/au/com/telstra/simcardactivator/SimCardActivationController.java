package au.com.telstra.simcardactivator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import au.com.telstra.simcardactivator.Model.ActuatorRequest;
import au.com.telstra.simcardactivator.Model.SimCardModel;


@RestController
public class SimCardActivationController {
	
    private final RestTemplate restTemplate;
	
	public SimCardActivationController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

	@PostMapping("/simcardactivation")
	public ResponseEntity<String> activateSim(@RequestBody SimCardModel simcardmodelrequest) {
		try {			
	        String iccid = simcardmodelrequest.getIccid();	        
	        
	        if(iccid.isEmpty())
	        {
	        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("SIM ICCID is empty.Please Check Again...");            
	        }
	        else {
	        	ActuatorRequest req= new ActuatorRequest(iccid);
		        
		        ResponseEntity <String> responseEntity = restTemplate.postForEntity(
		        		"http://localhost:8444/actuate",req,String.class);
		        
		        if (responseEntity.getStatusCode().is2xxSuccessful()) {
		            return ResponseEntity.ok(responseEntity.getBody());	            
		        } else {
		        	return ResponseEntity.ok(responseEntity.getBody());
		         }	
	        }
	        
		}
		catch(Exception e) {
			e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to communicate with actuator microservice");            
		}
		
	}
	
}

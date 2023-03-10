/**
 *
 */
import {ajaxRequest} from './request.js';
function guestService(method,url,params){
	//ajax요청
	let returnHJsonResult={};
    ajaxRequest(method,
                url,
                function(jsonResult){
	                console.log(jsonResult);
                },
                params,
                true);
                
	
	returnJsonResult;
}
export{ guestService}
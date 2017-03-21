angular.module('hostelapp').service("loginService",
		function($http, HOSTELAPP_CONSTANTS) {
			this.doLogin = function(loginDetails) {
				
				console.log(HOSTELAPP_CONSTANTS.DO_LOGIN());
				//var log=$http.post(HOSTELAPP_CONSTANTS.DO_LOGIN(), loginDetails);
				var config = {headers:  {
					'Access-Control-Allow-Origin':' *',
				
			        'Access-Control-Allow-Methods': 'GET, POST, PATCH, PUT, DELETE, OPTIONS',
			        'Content-Type': 'application/json;odata=verbose'
			    }
			};
				var log=$http.post(HOSTELAPP_CONSTANTS.DO_LOGIN(),loginDetails,config);
				return log;
			};
			this.forgotPassword = function(email){
				console.log(HOSTELAPP_CONSTANTS.FORGOT_PASSWORD()+email)
				return $http.get(HOSTELAPP_CONSTANTS.FORGOT_PASSWORD()+email);
			};
			
			

		});

var hostelappConstants = function() {
	var protocol = "http";
	var host = "localhost";
	/*var host = "localhost";*/
	var port = 5000;  //
	var url = protocol + "://" + host + ":" + port + "/";
	return {
		PROTOCOL : protocol,
		HOST : host,
		PORT : port,
		URL : url,
		DO_LOGIN : function() {
			return url + "login";
		},
		ADD_HOSTEL : function() {
			return url + "hostel";
		}
	
	}
	}

angular.module('hostelapp').constant('HOSTELAPP_CONSTANTS', hostelappConstants());
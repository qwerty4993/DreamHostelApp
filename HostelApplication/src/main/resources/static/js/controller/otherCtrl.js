angular.module('hostelapp').controller(
		"otherCtrl",
		function($state, $scope, $http, $localStorage, HOSTELAPP_CONSTANTS,
				$stateParams, notify, $location) {
			

		                $scope.countries = {
		                    'India': {
		                    	'Andhra Pradesh': ["Visakhapatnam","Vijayawada","Guntur","Nellore","Kurnool","Kadapa",
                                                  "Rajahmundry","Kakinada","Tirupati","Eluru","Anantapur","Vizianagaram","Ongole","Nandyal",
                                                  "Machilipatnam","Adoni","Tenali","Proddatur","Chittoor","Hindupur","Bhimavaram","Madanapalle","Guntakal", "Srikakulam","Dharmavaram","Gudivada","Narasaraopet", 
		                    		              "Tadipatri","Tadepalligudem","Chilakaluripet"],
		                    	'Telangana': ["Adilabad","Hyderabad","Karimnagar","Khammam","Mahbubnagar","Miryalaguda","Nalgonda","Nizamabad","Ramagundam","Siddipet","Suryapet","Warangal"],
		                        
		                        'Rajasthan': ['Jaipur', 'Ajmer', 'Jodhpur']
		                    }
		          
		                };
		         


		
	});
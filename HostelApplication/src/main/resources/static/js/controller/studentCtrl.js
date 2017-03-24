angular.module('hostelapp').controller(
		"studentCtrl",
		function($state, $scope, $http, $localStorage, notify,
				HOSTELAPP_CONSTANTS) {
			$scope.userId = $localStorage.user.studentId;
		console.log("user is ---->"+	$scope.userId);
			$scope.goToHomePage = function() {
				$state.go('web.home');
			};
			
			
			$scope.goToAddHostelRequestPage =function() {
				$state.go('hostel.addHostelRequest');
			};
			$scope.goToHostelRequestListPage =function() {
				$state.go('hostel.studenthostelRequestList');
			};
			
			$scope.hostelDetailsListTest=[];
			// Get All Hostel Which Have Approval already
			$scope.findAllHostel = function() {

				var url = HOSTELAPP_CONSTANTS.URL + "hostel/getAllHostels";

				$http.get(url).then(function(data) {
					console.log(data.data.responseObjects)
					$scope.hostelDetailsList = data.data.responseObjects;
					
					$scope.hostelDetailsListTest.push($scope.hostelDetailsList);
				}, function(error) {
					alert(error.data.message);
				});
			}
		
			
			
		}).filter('expenditurePayeeFilter', [function($filter) {
            return function(inputArray, searchCriteria, hostelDetailsListTest){ 
            	
                if(!angular.isDefined(searchCriteria) || searchCriteria === ''){
                    return inputArray;
                }         
                var data=[];
                angular.forEach(inputArray, function(item){             
                    if(item.hostelDetailsListTest == hostelDetailsListTest){
                        if(item.hostelDetailsListTest.name.toLowerCase().indexOf(searchCriteria.toLowerCase()) != -1){
                            data.push(item);
                        }
                    }
                });      
             return data;
           };
         }]);
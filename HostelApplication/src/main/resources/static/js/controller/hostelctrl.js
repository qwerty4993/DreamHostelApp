angular.module('hostelapp').controller(
				"hostelCtrl",function($state, $scope, $http, $localStorage, HOSTELAPP_CONSTANTS , notify,$location) {
					
					$scope.goToHomePage = function() {
						$state.go('web.home');
					};
					
					
					
					
					
					$scope.addHostel = function(hostel) {
						//console.log(hostel);
					//	var url = HOSTELAPP_CONSTANTS.DO_LOGIN()ADD_HOSTEL()+"/hostelRequest";
						
						$scope.role = {
								id : 1
							}
							$scope.hostel.role = $scope.role;
							console.log($scope.hostel);
							var url = HOSTELAPP_CONSTANTS.URL + "hostel/hostelrequest";
							$http.post(url, $scope.hostel).then(function(data) {
								console.log(data.data);

//								if (data.data.statusCode == 201) {
//									notify({
//										message : "Successfully Registered",
//										classes : 'alert-success',
//										duration : 1000
//									})
//								}

							});
					
						
					};
					
				});
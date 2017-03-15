angular.module('hostelapp').controller(
		"studentCtrl",
		function($state, $scope, $http, $localStorage, notify,
				HOSTELAPP_CONSTANTS) {
			
			
			$scope.goToHomePage = function() {
				$state.go('web.home');
			};
			
			
			$scope.addStudent = function(student) {
				$scope.user.username = $scope.student.email;
				$scope.student.user = $scope.user;
//				 $scope.gender =  $scope.student.selected;
				 
				$scope.role = {
					id : 3
				}
				$scope.student.user.role = $scope.role;
				console.log($scope.student);
				var url = HOSTELAPP_CONSTANTS.URL + "studentregistration/";
				$http.post(url, $scope.student).then(function(data) {
					console.log(data.data);

					if (data.data.statusCode == 201) {
						notify({
							message : "Successfully Registered",
							classes : 'alert-primary',
							duration : 1000
						})
					}

				});

			}
		});
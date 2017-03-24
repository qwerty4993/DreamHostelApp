angular.module('hostelapp').controller("webCtrl",
		function($state, $scope, $http, $localStorage, notify,
				HOSTELAPP_CONSTANTS) {

			$scope.goToHomePage = function() {

				$state.go('web.home');
			}
			$scope.goToForgotPasswordPage = function() {

				$state.go('forgotPasswordPage');
			}
			
			
			$scope.addStudent = function(student) {
				$scope.user.username = $scope.student.email;
				$scope.student.user = $scope.user;
//				 $scope.gender =  $scope.student.selected;
				 
				$scope.role = {
					id : 3
				}
				$scope.student.user.role = $scope.role;
				console.log($scope.student);
				$scope.checkPassword();
				if ($scope.flag == true) {
				var url = HOSTELAPP_CONSTANTS.URL + "studentregistration/";
				$http.post(url, $scope.student).then(function(data) {
					console.log(data.data);

					if (data.data.statusCode == 201) {
						$scope.goToHomePage();
						notify({
							message : "Successfully Registered",
							classes : 'alert-primary',
							duration : 2000
						})
					}else{
						notify({
							message : data.data.statusDesc,
							classes : 'alert-primary',
							duration : 2000
						});
					}

				});

				}			}
			
			$scope.checkPassword = function() {
				if ($scope.user.password != $scope.student.confirmpassword) {
					$scope.flag = false;
					notify({
						message : "password does not match",
						classes : 'alert-primary',
					})
				} else {
					$scope.flag = true;
				}
			}

		});

angular.module('hostelapp').controller(
		"roleCtrl",
		function($state, $scope, loginService, $localStorage,
				HOSTELAPP_CONSTANTS, $http, notify, $stateParams) {

			$scope.goToAddRolePage = function() {
				$state.go('hostel.addRole');

			}

			$scope.role = {
				status : undefined,
				name : undefined,
				displayName : undefined,
				created : undefined,
				modified : undefined,
				deleted : undefined,
				features : []
			}
			
			/* Find All Features */
			$scope.findAllFeatures = function() {

				var url = HOSTELAPP_CONSTANTS.URL + "feature/getAllFeatures";

				$http.get(url).then(function(response) {
					console.log("findAllFeatures : "+response.data)
					
					$scope.featureLookupList = response.data;
					$scope.role.features = response.data
					console.log($scope.role.features)
				}, function(error) {
					alert(error.data.message);
				});
			};
			
			/* Get All Roles */
			$scope.findAllRoles = function() {

				var url = HOSTELAPP_CONSTANTS.URL + "role/";

				$http.get(url).then(function(response) {
					$scope.rolesList = response.data;
				}, function(error) {
					alert(error.data.message);
				});
			};
			
			
			/* Add Role */
			$scope.addRole = function(role) {
				var count = 0;
				angular.forEach(role.features, function(feature) {
					if (feature.allowCreate == true
							|| feature.allowDelete == true
							|| feature.allowEdit == true
							|| feature.allowRead == true) {
						count++;
					}
				})
				if (count >= 1) {
					var url = HOSTELAPP_CONSTANTS.URL + "role/add";

					$http.post(url, role).then(function(response) {
						console.log(response.data);
						$scope.goToRolesListPage();
						notify({
							message : "Successfully Registered",
							classes : 'alert-primary',
							duration: 1500
						});
					}, function(error) {
						notify({
							message : error.data.message,
							classes : 'alert-danger',
						});
					});
				} else {
					
					notify({
						message : "Please allow access to atleast 1 feature",
						classes : 'alert-danger',
						duration: 1500
					});
				}
			};
			
			
			
			

		});

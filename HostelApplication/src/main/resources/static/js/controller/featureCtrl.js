angular.module('hostelapp').controller(
		"featureCtrl",
		function($state, $scope, loginService, $localStorage,
				HOSTELAPP_CONSTANTS, $http, $stateParams, notify) {

			
			
			
			/* Page Transfers */
			$scope.goToAddFeaturePage = function() {
				$state.go('hostel.addFeature');
			};
			$scope.goToFeaturesListPage = function() {
				$state.go('hostel.featureList');
			};
			

			/* Get All Features */
			$scope.findAllFeatures = function() {

				var url = HOSTELAPP_CONSTANTS.URL + "feature/getAllFeatures";

				$http.get(url).then(function(response) {
					$scope.featureLookupList = response.data;
				}, function(error) {
					alert(error.data.message);
				});
			}

			/* Add Feature */
			$scope.addFeature = function(feature) {

				var url = HOSTELAPP_CONSTANTS.URL + "feature/add";

				$http.post(url, feature).then(function(response) {
					console.log(response.data);
					$scope.goToFeaturesListPage();
					notify({
						message : "Successfully Registered",
						classes : 'alert-primary',
						duration: 1500
					});
				},function(error) {
					notify({
						message : error.data.message,
						classes : 'alert-danger',
						duration: 1500
					});
				});
			};

			
		});

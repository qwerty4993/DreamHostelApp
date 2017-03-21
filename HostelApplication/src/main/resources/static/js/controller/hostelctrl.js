angular.module('hostelapp').controller(
		"hostelCtrl",
		function($state, $scope, $http, $localStorage, HOSTELAPP_CONSTANTS,
				$stateParams, notify, $location) {

			$scope.goToHomePage = function() {
				$state.go('web.home');
			};
			$scope.goToSuccessPage = function() {
				$state.go('successRegister');
			};
			
			$scope.previewHostelDetails = $stateParams.previewHostelDetails;

			$scope.goToHostelDetailsView = function(previewHostelDetails) {
				$state.go('hostel.HostelDetailsView', {
					previewHostelDetails : previewHostelDetails
				});
			}
			
			$scope.goToHostelRequestList = function() {
				$state.go('hostel.HostelRequestList');
			}

			// Get hostel By ID
			$scope.goToViewHostelDetails = function(hostelId) {
				var url = HOSTELAPP_CONSTANTS.URL + "hostel/hostelDetails/"
						+ hostelId;
				$http.get(url).then(function(response) {
					console.log(response.data);
					previewHostelDetails = response.data;
					console.log(previewHostelDetails)
					$scope.goToHostelDetailsView(previewHostelDetails);

				}, function(error) {
					alert(error.data.message);
				});

			};
			// Hostel For Approval
			$scope.findAllHostelRequest = function() {

				var url = HOSTELAPP_CONSTANTS.URL
						+ "hostel/getAllHostelsForApproval";

				$http.get(url).then(function(response) {
					console.log(response.data)
					$scope.hostelRequestList = response.data;
				}, function(error) {
					alert(error.data.message);
				});
			}
			// Get All Hostel Which Have Approval already
			$scope.findAllHostel = function() {

				var url = HOSTELAPP_CONSTANTS.URL + "hostel/getAllHostels";

				$http.get(url).then(function(data) {
					console.log(data.data.responseObjects)
					$scope.hostelDetailsList = data.data.responseObjects;
				}, function(error) {
					alert(error.data.message);
				});
			}
			$scope.approveHostel = function(hostelId) {

				console.log(hostelId)

				var url = HOSTELAPP_CONSTANTS.URL + "hostel/approvalStudent/"
						+ hostelId;

				$http.get(url).then(function(data) {
					$scope.goToHostelRequestList();
					notify({
						message : "Successfully Approved",
						classes : 'alert-primary',
						duration : 1000
					})

				}, function(error) {
					alert(error.data.message);
				});
			}

			// Add new Hostel
			$scope.addHostel = function(hostel) {
				// console.log(hostel);
				// var url =
				// HOSTELAPP_CONSTANTS.DO_LOGIN()ADD_HOSTEL()+"/hostelRequest";

				$scope.role = {
					id : 2
				}
				$scope.hostel.role = $scope.role;
				console.log($scope.hostel);
				var url = HOSTELAPP_CONSTANTS.URL + "hostel/hostelrequest";
				$http.post(url, $scope.hostel).then(function(data) {
					console.log(data.data);

				 if (data.data.statusCode == 201) {
					 $scope.goToSuccessPage();
					 notify({
					 message : "Successfully Registered",
					 classes : 'alert-success',
					duration : 1000
					 })
				 }else{
						notify({
							message : data.data.statusDesc,
							classes : 'alert-primary',
							duration : 1500
						});
					}

				});

			};

		});
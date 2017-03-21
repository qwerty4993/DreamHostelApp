var hostelapp = angular.module('hostelapp');
hostelapp.config(function($stateProvider, $urlRouterProvider) {
	$stateProvider.state('hostel.HostelRequestList', {
		templateUrl : 'views/Hostel/HostelRequestList.html',
		url : '/HostelRequestList',
		controller : 'hostelCtrl'

	}).state('hostel.HostelDetaislList', {
		templateUrl : 'views/Hostel/HostelDetailsList.html',
		url : '/HostelDetailsList',
		controller : 'hostelCtrl'

	}).state('hostel.HostelDetailsView', {
		templateUrl : 'views/Hostel/HostelDetailsView.html',
		url : '/HostelDetailsView',
		controller : 'hostelCtrl',
		params : {
			previewHostelDetails : null,
		}

	}).state('successRegister', {
		templateUrl : 'views/successRegister.html',
		url : 'success'
		
	});
});

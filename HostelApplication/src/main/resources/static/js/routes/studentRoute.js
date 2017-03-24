var hostelapp = angular.module('hostelapp');
hostelapp.config(function($stateProvider, $urlRouterProvider) {

	$stateProvider.state('hostel.studenthostelRequestList', {
		templateUrl : 'views/Student/hostelRequestList.html',
		url : '/studenthostelRequestList',
		controller : 'studentCtrl'
	}).state('hostel.addHostelRequest', {
		templateUrl : 'views/Student/addhostelRequest.html',
		url : '/addHostelRequest',
		controller : 'studentCtrl'
	});
});
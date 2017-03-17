var hostelapp = angular.module('hostelapp');
hostelapp.config(function($stateProvider, $urlRouterProvider) {

	$stateProvider.state('hostel.profileView', {
		templateUrl : 'views/Profile/profile.html',
		url : '/profile'
	});
});
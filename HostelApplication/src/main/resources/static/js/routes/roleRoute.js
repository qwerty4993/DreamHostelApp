var  hostelapp = angular.module('hostelapp');
hostelapp.config(function($stateProvider, $urlRouterProvider) {
	$urlRouterProvider.otherwise('/home');


	$stateProvider.state('hostel.roleList', {
		templateUrl : 'views/role/roleList.html',
		url : '/roleList',
		controller : 'roleCtrl'

	}).state('hostel.addRole', {
		templateUrl : 'views/role/addRole.html',
		url : '/addrole',
		controller : 'roleCtrl'

	});
});

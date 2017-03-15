var hostelapp = angular.module('hostelapp');
hostelapp.config(function($stateProvider, $urlRouterProvider) {
	$urlRouterProvider.otherwise('/home');


	$stateProvider.state('hostel.featureList', {
		templateUrl : 'views/Feature/featureLookupList.html',
		url : '/featureList',
		controller : 'featureCtrl'

	}).state('hostel.addFeature', {
		templateUrl : 'views/Feature/addFeatureLookup.html',
		url : '/addfeature',
		controller : 'featureCtrl'

	});
});

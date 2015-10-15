var app =
    angular.module('x0app', ['ngRoute', 'ngAnimate', 'ngAria', 'ngMaterial'])
        .config(function ($routeProvider) {
            $routeProvider
                .when('/', {
                    templateUrl: '/views/main.html',
                    controller: 'MainCtrl'
                })
        });
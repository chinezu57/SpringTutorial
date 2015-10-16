var app =
    angular.module('x0app', ['ngRoute', 'ngAnimate', 'ngAria', 'ngMaterial', 'ngStorage'])
        .config(function ($routeProvider) {
            $routeProvider
                .when('/rooms', {
                    templateUrl: '/views/main.html',
                    controller: 'MainCtrl'
                })
                .when('/login', {
                    templateUrl: '/views/login.html',
                    controller: 'LoginCtrl'
                })
                .when('/game', {
                    templateUrl: '/views/game.html',
                    controller: 'GameCtrl'
                })
                .otherwise('/login');
        });
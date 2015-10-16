app.controller('MainCtrl', function ($scope, $rootScope, $localStorage, $location, roomService) {
    $scope.rooms = [];

    $rootScope.$on('newRoom', function (ev, data) {
        $scope.rooms = data.rooms.body.slice(1, data.rooms.body.length - 1);
    });

    $rootScope.$on('gameCreated', function () {
        $location.path('/game');

        $rootScope.$apply();
    });

    $scope.createNewRoom = function () {
          roomService.createNewGame($localStorage.currentUser);
    };
});
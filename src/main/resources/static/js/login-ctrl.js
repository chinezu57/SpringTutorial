app.controller('LoginCtrl', function ($scope, $rootScope, $location, playerService) {
    $scope.joinGame = function () {
        if ($scope.userName && $scope.userName.length > 0) {
            playerService.createNewUser($scope.userName);
        }
    };

    $rootScope.$on('userCreated', function () {
        $location.path('/rooms');

        $rootScope.$apply();
    });
});
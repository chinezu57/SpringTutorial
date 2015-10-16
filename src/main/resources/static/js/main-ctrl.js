app.controller('MainCtrl', function ($scope, $rootScope, $mdDialog) {
    $scope.currentUserType = 'X';

    $scope.players = [
        'aaa',
        'bbb',
        'ccc',
        'ddd',
        'aaa',
        'bbb',
        'ccc',
        'ddd',
        'aaa',
        'bbb',
        'ccc',
        'ddd',
        'aaa',
        'bbb',
        'ccc',
        'ddd',
        'aaa',
        'bbb',
        'ccc',
        'ddd',
        'aaa',
        'bbb',
        'ccc',
        'ddd',
        'aaa',
        'bbb',
        'ccc',
        'ddd',
        'aaa',
        'bbb',
        'ccc',
        'ddd'
    ];

    $scope.selectCell = function (cell, ev) {
        if (!cell.type) {
            cell.type = $scope.currentUserType;
        }
    };

    var showWinningModal = function (ev) {
        $mdDialog.show(
            $mdDialog.alert()
                .parent(angular.element(document.body))
                .clickOutsideToClose(true)
                .title('Winner')
                .content('Congratulation, you won!')
                .ariaLabel('Winner dialog')
                .ok('Thanks!')
                .targetEvent(ev)
        );
    }
});
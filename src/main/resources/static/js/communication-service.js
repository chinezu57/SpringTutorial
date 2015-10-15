app.service('communicationService', function(messageInterpretor) {
    var sock;

    var init = function () {
        sock = new SockJS('');

        sock.onopen = onOpen;
        sock.onmessage = onMessage;
        sock.onclose = onClose;
    };

    var onOpen = function () {
        console.log('open');
    };

    var onMessage = function (e) {
        console.log('message', e.data);
    };

    var onClose = function () {
        console.log('close');
    };

    this.sendMessage = function (message) {
        sock.send(message);
    };
});
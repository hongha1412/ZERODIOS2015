$(document).ready(function() {
    var screenModel = new ScreenModel();
    ko.applyBindings(screenModel);

    $('#message-area').find('.alert-link').parent().hover(function() {
        $(this).css('background-color', '#E9C9C9');
        $(this).css('cursor', 'pointer');
    }, function() {
        $(this).css('background-color', '');
        $(this).css('cursor', '');
    });
});

function ScreenModel() {
    var self = this;
    self.email = ko.observable();
    self.password = ko.observable();
}

ScreenModel.prototype.submit = function() {
    var self = this;

    $('#login-form').attr('action', '/adm/Login.do').attr('method', 'post').submit();
}

ScreenModel.prototype.forceError = function(name, message) {
    var self = this;
    var controlName = name.trim();
    $("#" + controlName).parsley().options.messages["ZDMessage-" + controlName] = message;
    $("#login-form").parsley().validate("", controlName);
}
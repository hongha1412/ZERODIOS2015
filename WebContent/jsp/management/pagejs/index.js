$(document).ready(function() {
    var screenModel = new ScreenModel();
    ko.applyBindings(screenModel);
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
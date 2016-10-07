$(document).ready(function() {
    var screenModel = new ScreenModel();
    ko.observable(screenModel);
});

function ScreenModel() {
    var self = this;
    self.test = ko.observable("test");
}
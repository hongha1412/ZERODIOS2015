var root = undefined;
$(document).ready(function() {
    var screenModel = new ScreenModel();
    ko.applyBindings(screenModel);
});

function ScreenModel() {
    var self = this;
    root = self;
}

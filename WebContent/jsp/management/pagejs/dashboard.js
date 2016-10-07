$(document).ready(function() {
    var masterModel = new MasterModel();
    ko.applyBindings(masterModel);
});

function MasterModel() {
    var self = this;
}
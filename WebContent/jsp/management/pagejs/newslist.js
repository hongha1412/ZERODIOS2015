var root = undefined;
$(document).ready(function() {
    var screenModel = new ScreenModel();
    ko.applyBindings(screenModel);
});

function ScreenModel() {
    var self = this;
    self.currentNews = ko.observable(new CurrentNews());
    self.lsData = ko.observableArray([]);
    self.categories = ko.observableArray([]);
    self.loadCategories().done(function() {
        self.loadData();
    });
    root = self;
}

ScreenModel.prototype.loadCategories = function() {
    var self = this;
    var dfd = $.Deferred();
    zd.utils.request.send("/adm/categoryservlet").done(function(rs) {
        if (Array.isArray(rs)) {
            $.each(rs, function() {
                self.pushToCategories(this);
            });
        } else {
            self.pushToCategories(this);
        }
        dfd.resolve(self.categories());
    });
    return dfd.promise();
}

ScreenModel.prototype.pushToCategories = function(data) {
    var self = this;
    self.categories.push(new Category(data.id, data.name, data.parent, data.status, data.version));
}

ScreenModel.prototype.loadData = function() {
    var self = this;
    var dfd = $.Deferred();
    $.blockUI();
    zd.utils.request.send("/adm/newsservlet").done(function(rs) {
        self.lsData([]);
        if (Array.isArray(rs)) {
            $.each(rs, function() {
                self.lsData.push(new NewsObject(this.id, this.category, this.title, this.description, this.author, this.date, this.remark, this.pin, this.status, this.version));
            });
        } else {
            self.lsData.push(new NewsObject(rs.id, rs.category, rs.title, rs.description, rs.author, rs.date, rs.remark, rs.pin, rs.status, rs.version));
        }

        $("#news-table").igGrid({
            width: "100%",
            autoGenerateColumns: false,
            renderCheckboxes: true,
            primaryKey: "id",
            columns: [
                { headerText: "Id", key: "id", dataType: "string", width: "100px", columnCssClass: "table-data-center"},
                { headerText: "Pin", key: "pin", dataType: "bool", width: "100px", columnCssClass: "table-data-center"},
                { headerText: "Remark", key: "remark", dataType: "string", columnCssClass: "table-data-center", width: "150px", formatter: RemarkIcon},
                { headerText: "Title", key: "title", dataType: "string"},
                { headerText: "Author", key: "author", dataType: "string", width: "20%"},
                { headerText: "Date", key: "date", dataType: "date", format: "dd/MM/yyyy", width: "18%"},
                { headerText: "Edit", key: "id", columnCssClass: "table-data-center", width: "100px", formatter: EditIcon}
            ],
            features: [
                { 
                    name: "Filtering"
                },
                {
                    name: "Paging",
                    type: "local",
                    pageSize: 50
                },
                {
                    name: "Responsive"
                },
                {
                    name: "Resizing"
                }
            ],
            dataSource: rs
        });
        generateAddButton();
        $.unblockUI();
        dfd.resolve(rs);
        ko.applyBindings(self, $("#news-table")[0]);
    });
    return dfd.promise();
}

ScreenModel.prototype.editNews = function(newsId, data, event) {
    var self = this;
    self.currentNews().actionType(1);
    if (newsId === undefined || self.lsData() === undefined || self.lsData().length <= 0) {
        return;
    }
    $.each(self.lsData(), function() {
        if ((this.id() + "") === (newsId + "")) {
            self.currentNews().load(this);
            return;
        }
    });
    
}

ScreenModel.prototype.addNews = function(screenModel, evt) {
    var self = this;
    self.currentNews().clear();
    // return true;
}

function CurrentNews() {
    var self = this;
    self.actionType = ko.observable(0);
    self.id = ko.observable();
    self.category = ko.observable();
    self.title = ko.observable();
    self.description = ko.observable();
    self.author = ko.observable();
    self.date = ko.observable();
    self.pin = ko.observable(false);
    self.remark = ko.observable(0);
    self.status = ko.observable(true);
    self.version = ko.observable();
}

CurrentNews.prototype.clear = function() {
    var self = this;
    self.actionType(0);
    self.id("");
    self.category("");
    self.title("");
    self.description("");
    self.author("");
    self.date("");
    self.pin(false);
    self.remark(0);
    self.status(true);
    self.version("");
}

CurrentNews.prototype.load = function(newsObject) {
    var self = this;
    self.actionType(1);
    self.id(newsObject.id());
    self.category(newsObject.category());
    self.title(newsObject.title());
    self.description(newsObject.description());
    self.author(newsObject.author());
    self.date(newsObject.date());
    self.pin(newsObject.pin());
    self.remark(newsObject.remark());
    self.status(newsObject.status());
    self.version(newsObject.version());
}

CurrentNews.prototype.submit = function() {
    var self = this;
    if (!$("#current-news-form").parsley().validate()) {
        return;
    }

    var param = {action: self.actionType(), condition: self, newsid: self.id()};
    zd.utils.request.send("/adm/newsservlet", param).done(function(result) {
        if (result) {
            if (root) {
                $.blockUI();
                root.loadData().done(function() {
                    $.unblockUI();
                });
            }
            $.notify("<strong>" + $.trim(result) + "</strong>");
        }
    });
}

function NewsObject(id, category, title, description, author, date, remark, pin, status, version) {
    var self = this;
    self.id = ko.observable(id);
    self.category = ko.observable(category);
    self.title = ko.observable(title);
    self.description = ko.observable(description);
    self.author = ko.observable(author);
    self.date = ko.observable(date);
    self.remark = ko.observable(remark);
    self.pin = ko.observable(pin);
    self.status = ko.observable(status);
    self.version = ko.observable(version);
}

function generateAddButton() {
    if ($(".ui-iggrid-pagesizedropdowncontainerabove").find("#addButton").length <= 0) {
        var button = $("#addButton").detach();
        $(".ui-iggrid-pagesizedropdowncontainerabove").append(button);
    }
}

function RemarkIcon(value) {
    var icon;

    switch (value) {
        case '1':
            icon = $('<img src="/jsp/management/pageresources/none.svg" width="20px" height="20px" />');
            break;
        case '2':
            icon = $('<img src="/jsp/management/pageresources/new.svg" width="20px" height="20px" />');
            break;
        case '3':
            icon = $('<img src="/jsp/management/pageresources/hot.svg" width="20px" height="20px" />');
            break;
        default:
            icon = null;
            break;
    }
    return icon === null ? "" : icon.prop("outerHTML");
}

function EditIcon(value) {
    var icon = $("<a href='#edit' class='edit-news' data-toggle='modal' data-bind='click: function(data, event) { editNews(" + value + ", data, event) }'>").prepend("<i class='fa fa-pencil'>");
    return icon.prop("outerHTML");
}

function Category(id, name, parent, status, version) {
    var self = this;
    self.id = ko.observable(id);
    self.name = ko.observable(name);
    self.parent = ko.observable(parent);
    self.status = ko.observable(status);
    self.version = ko.observable(version);
}
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.common-controls.com/cc/tags-template" prefix="template" %>
<html xmlns="http://www.w3.org/1999/xhtml"
    xmlns:h="http://java.sun.com/jsf/html"
    xmlns:com="http://xmlns.jcp.org/jsf/component" class="app">
<head>
  <title>ZeroDios Web Management</title>

  <jsp:include page="inc/header.jsp" />

  <template:get name="header" />
  <script>
    $(document).ready(function() {
        $("li").removeClass("active");
        var el = $("a[href='" + window.location.pathname + "']");
        if ($(el) !== undefined) {
            el = $(el).parent("li");
        }
        while ($(el) !== undefined && $(el).prop("tagName") === "LI") {
            $(el).addClass("active");
            if ($(el).parent("ul") !== undefined && $(el).parent("ul").prop("tagName") === "UL") {
                el = $(el).parent("ul").parent("li");
            } else {
                el = undefined;
            }
        }
        /* if ($(el).parent("li") !== undefined) {
            $(el).parent("li").addClass("active");
        }
        if ($(el).parent("li") !== undefined && $(el).parent("li").parent("ul") !== undefined &&
                $(el).parent("li").parent("ul").parent("li") !== undefined) {
            $(el).parent("li").parent("ul").parent("li").addClass("active");
        } */
    });
  </script>
</head>
<body class="">
  <section class="vbox">
    <jsp:include page="inc/top-bar.jsp" />
    <section>
      <section class="hbox stretch">
        <!-- .aside -->
            <jsp:include page="inc/left-menu.jsp" />
        <!-- /.aside -->
        <!-- Page Context -->
        <section id="content">
            <template:get name="content" />
        </section>
        <!-- /Page Context -->
        <aside class="bg-light lter b-l aside-md hide" id="notes">
          <div class="wrapper">Notification</div>
        </aside>
      </section>
    </section>
  </section>
</body>
</html>
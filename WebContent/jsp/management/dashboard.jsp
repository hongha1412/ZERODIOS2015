<!DOCTYPE html>
<html lang="en" class="app">
<head>
  <jsp:include page="inc/header.jsp" />

  <title>ZeroDios Web Management</title>
  <script src="/jsp/management/pagejs/dashboard.js" ></script>
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
            <jsp:include page="pages/home.jsp" />
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
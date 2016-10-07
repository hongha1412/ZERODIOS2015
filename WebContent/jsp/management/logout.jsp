<jsp:include page="/jsp/management/inc/header.jsp"></jsp:include>
<div id="logout-modal" class="modal-over">
    <section id="message-area" data-bind="visible: isError">
        <div class="alert alert-danger">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <div class="message-content"
                style="padding: 3px 0px 3px 0px">
                <i class="fa fa-ban"></i> <a data-bind="text: message"></a>
            </div>
        </div>
    </section>
    <div class="modal-center animated fadeInUp text-center" style="width:200px;margin:-80px 0 0 -100px;">
    <div class="thumb-md"><img src="/jsp/management/images/avatar.jpg" class="img-circle b-a b-light b-3x"></div>
    <p class="text-white h4 m-t m-b">${accountInfo.name}</p>
    <form class="input-group" id="relog-form" data-validate="parsley">
      <input type="password" data-bind="value: relogpassword" class="form-control text-sm" name="password" id="password"
            placeholder="Enter pwd to continue">
      <span class="input-group-btn">
        <button class="btn btn-success" id="relog-submit" type="submit" data-bind="click: relogsubmit"><i class="fa fa-arrow-right"></i></button>
      </span>
    </form>
  </div>
</div>
<script src="/jsp/management/pagejs/logout.js" ></script>
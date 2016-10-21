<%@page import="com.zerodios2015.Utils.MessageProperties"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.common-controls.com/cc/tags-template" prefix="template" %>
<template:insert template="/jsp/management/dashboard.jsp">
    <template:put name="header">
        <link href="/js/igniteui/css/themes/infragistics/infragistics.theme.css" rel="stylesheet" />
        <link href="/js/igniteui/css/structure/infragistics.css" rel="stylesheet" />
        <link href="/jsp/management/pagecss/newslist.css" rel="stylesheet" />
        <link rel="stylesheet" href="/jsp/management/js/select2/select2.css" type="text/css" />
        <link rel="stylesheet" href="/jsp/management/js/select2/theme.css" type="text/css" />
        <link rel="stylesheet" href="/jsp/management/js/fuelux/fuelux.css" type="text/css" />
        <link rel="stylesheet" href="/jsp/management/js/datepicker/datepicker.css" type="text/css" />
        <link rel="stylesheet" href="/jsp/management/js/slider/slider.css" type="text/css" />

        <!-- fuelux -->
        <script src="/jsp/management/js/fuelux/fuelux.js"></script>
        <!-- datepicker -->
        <script src="/jsp/management/js/datepicker/bootstrap-datepicker.js"></script>
        <!-- slider -->
        <script src="/jsp/management/js/slider/bootstrap-slider.js"></script>
        <!-- file input -->  
        <script src="/jsp/management/js/file-input/bootstrap-filestyle.min.js"></script>
        <!-- combodate -->
        <script src="/jsp/management/js/libs/moment.min.js"></script>
        <script src="/jsp/management/js/combodate/combodate.js"></script>
        <!-- select2 -->
        <script src="/jsp/management/js/select2/select2.min.js"></script>
        <!-- wysiwyg -->
        <script src="/jsp/management/js/wysiwyg/jquery.hotkeys.js"></script>
        <script src="/jsp/management/js/wysiwyg/bootstrap-wysiwyg.js"></script>
        <script src="/jsp/management/js/wysiwyg/demo.js"></script>
        <!-- markdown -->
        <script src="/jsp/management/js/markdown/epiceditor.min.js"></script>

        <script src="/jsp/management/pagejs/newslist.js"></script>
        <script src="/js/igniteui/js/modernizr-2.8.3.js"></script>
        <script src="/js/igniteui/js/jquery-ui.min.js"></script>
        <script src="/js/igniteui/js/infragistics.core.js"></script>
        <script src="/js/igniteui/js/infragistics.dv.js"></script>
        <script src="/js/igniteui/js/infragistics.lob.js"></script>
    </template:put>
    <template:put name="content">
        <section class="vbox">
            <section class="scrollable padder">
              <section class="table">
                <div id="news-table"></div>
              </section>
            </section>
          </section>

          <!-- Edit dialog -->
          <div class="modal fade" id="edit">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                  <h3 class="modal-title">Edit News</h3>
                </div>
                <div class="modal-body" data-bind="with: currentNews">
                  
                  <div class="form-inline">
                    <h4 class="col-xs-1"><%=MessageProperties.getMessage("news.Title") %></h4>
                    <input type="text" class="form-control" placeholder="Enter News Title" data-bind="value: title" />
                  </div>
                  <div class="line line-dashed line-lg pull-in"></div>
                  <div class="form-group">
                    <div class="col-lg-1">
                        <h4><%=MessageProperties.getMessage("news.Remark") %>&nbsp;</h4>
                    </div>
                    <div id="remark-group" class="col-lg-10">
                        <div class="radio inline">
                            <label class="radio-custom">
                                <input type="radio" name="remark" value="0" checked="checked" data-bind="checked: remark" />
                                <i class="fa fa-circle-o checked"></i>
                                <img src="/jsp/management/pageresources/none.svg" width="20px" height="20px" />
                            </label>
                        </div>
                        <div class="radio inline">
                            <label class="radio-custom">
                                <input type="radio" name="remark" value="1" data-bind="checked: remark" />
                                <i class="fa fa-circle-o"></i>
                                <img src="/jsp/management/pageresources/new.svg" width="20px" height="20px" />
                            </label>
                        </div>
                        <div class="radio inline">
                            <label class="radio-custom">
                                <input type="radio" name="remark" value="2" data-bind="checked: remark" />
                                <i class="fa fa-circle-o"></i>
                                <img src="/jsp/management/pageresources/hot.svg" width="20px" height="20px" />
                            </label>
                        </div>
                    </div>
                  </div>
                  <div class="line line-dashed line-lg pull-in"></div>
                  <div class="form-group">
                    <div id="pin-group">
                        <h4 class="inline col-xs-1"><%=MessageProperties.getMessage("news.Pin") %>&nbsp;</h4>
                        <div class="checkbox inline">
                            <label class="checkbox-custom">
                                <input type="checkbox" name="pin" data-bind="value: isPin" />
                                <i class="fa fa-fw fa-square-o"></i>
                                <%=MessageProperties.getMessage("global.Yes") %>
                            </label>
                        </div>
                    </div>
                  </div>
                  <div class="line line-dashed line-lg pull-in"></div>

                  <!-- Start editor -->
                  <div class="form-group">
                      <h4 class="col-xs-12"><%=MessageProperties.getMessage("news.Content") %></h4>
                      <div>
                        <div class="btn-toolbar m-b-sm btn-editor" data-role="editor-toolbar" data-target="#editor">
                          <div class="btn-group">
                            <a class="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown" title="Font"><i class="fa fa-font"></i><b class="caret"></b></a>
                              <ul class="dropdown-menu">
                              </ul>
                          </div>
                          <div class="btn-group">
                            <a class="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown" title="Font Size"><i class="fa fa-text-height"></i>&nbsp;<b class="caret"></b></a>
                              <ul class="dropdown-menu">
                              <li><a data-edit="fontSize 5"><font size="5">Huge</font></a></li>
                              <li><a data-edit="fontSize 3"><font size="3">Normal</font></a></li>
                              <li><a data-edit="fontSize 1"><font size="1">Small</font></a></li>
                              </ul>
                          </div>
                          <div class="btn-group">
                            <a class="btn btn-default btn-sm" data-edit="bold" title="Bold (Ctrl/Cmd+B)"><i class="fa fa-bold"></i></a>
                            <a class="btn btn-default btn-sm" data-edit="italic" title="Italic (Ctrl/Cmd+I)"><i class="fa fa-italic"></i></a>
                            <a class="btn btn-default btn-sm" data-edit="strikethrough" title="Strikethrough"><i class="fa fa-strikethrough"></i></a>
                            <a class="btn btn-default btn-sm" data-edit="underline" title="Underline (Ctrl/Cmd+U)"><i class="fa fa-underline"></i></a>
                          </div>
                          <div class="btn-group">
                            <a class="btn btn-default btn-sm" data-edit="insertunorderedlist" title="Bullet list"><i class="fa fa-list-ul"></i></a>
                            <a class="btn btn-default btn-sm" data-edit="insertorderedlist" title="Number list"><i class="fa fa-list-ol"></i></a>
                            <a class="btn btn-default btn-sm" data-edit="outdent" title="Reduce indent (Shift+Tab)"><i class="fa fa-dedent"></i></a>
                            <a class="btn btn-default btn-sm" data-edit="indent" title="Indent (Tab)"><i class="fa fa-indent"></i></a>
                          </div>
                          <div class="btn-group">
                            <a class="btn btn-default btn-sm" data-edit="justifyleft" title="Align Left (Ctrl/Cmd+L)"><i class="fa fa-align-left"></i></a>
                            <a class="btn btn-default btn-sm" data-edit="justifycenter" title="Center (Ctrl/Cmd+E)"><i class="fa fa-align-center"></i></a>
                            <a class="btn btn-default btn-sm" data-edit="justifyright" title="Align Right (Ctrl/Cmd+R)"><i class="fa fa-align-right"></i></a>
                            <a class="btn btn-default btn-sm" data-edit="justifyfull" title="Justify (Ctrl/Cmd+J)"><i class="fa fa-align-justify"></i></a>
                          </div>
                          <div class="btn-group">
                          <a class="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown" title="Hyperlink"><i class="fa fa-link"></i></a>
                            <div class="dropdown-menu">
                              <div class="input-group m-l-xs m-r-xs">
                                <input class="form-control input-sm" placeholder="URL" type="text" data-edit="createLink"/>
                                <div class="input-group-btn">
                                  <button class="btn btn-default btn-sm" type="button">Add</button>
                                </div>
                              </div>
                            </div>
                            <a class="btn btn-default btn-sm" data-edit="unlink" title="Remove Hyperlink"><i class="fa fa-cut"></i></a>
                          </div>
                          
                          <div class="btn-group" style="width:34px">
                            <a class="btn btn-default btn-sm" title="Insert picture (or just drag & drop)" id="pictureBtn"><i class="fa fa-picture-o"></i></a>
                            <input type="file" data-role="magic-overlay" data-target="#pictureBtn" data-edit="insertImage" />
                          </div>
                          <div class="btn-group">
                            <a class="btn btn-default btn-sm" data-edit="undo" title="Undo (Ctrl/Cmd+Z)"><i class="fa fa-undo"></i></a>
                            <a class="btn btn-default btn-sm" data-edit="redo" title="Redo (Ctrl/Cmd+Y)"><i class="fa fa-repeat"></i></a>
                          </div>
                        </div>
                        <div id="editor" class="form-control" style="overflow:scroll;height:150px;max-height:150px">
                          Go ahead&hellip;
                        </div>
                      </div>
                    </div>
                    <!-- End editor -->

                </div>
              </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
          </div>
          <a href="#" class="hide nav-off-screen-block" data-toggle="class:nav-off-screen, open" data-target="#nav,html"></a>
    </template:put>
</template:insert>
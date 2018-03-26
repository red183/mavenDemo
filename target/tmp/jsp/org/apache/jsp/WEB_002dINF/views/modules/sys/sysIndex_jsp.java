package org.apache.jsp.WEB_002dINF.views.modules.sys;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class sysIndex_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_0;
static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_1;
static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_2;
static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_3;
static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_4;
static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_5;
static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_6;
static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_7;

static {
  _jspx_fnmap_0= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fns:getAdminPath", com.cnwanweb.quickframework.common.config.Global.class, "getAdminPath", new Class[] {});
  _jspx_fnmap_1= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fns:getConfig", com.cnwanweb.quickframework.common.config.Global.class, "getConfig", new Class[] {java.lang.String.class});
  _jspx_fnmap_2= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fns:getFrontPath", com.cnwanweb.quickframework.common.config.Global.class, "getFrontPath", new Class[] {});
  _jspx_fnmap_3= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fnc:getCurrentSiteId", com.cnwanweb.quickframework.modules.cms.entity.Site.class, "getCurrentSiteId", new Class[] {});
  _jspx_fnmap_4= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fns:getDictList", com.cnwanweb.quickframework.modules.sys.utils.DictUtils.class, "getDictList", new Class[] {java.lang.String.class});
  _jspx_fnmap_5= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fns:getUser", com.cnwanweb.quickframework.modules.sys.utils.UserUtils.class, "getUser", new Class[] {});
  _jspx_fnmap_6= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fns:getMenuList", com.cnwanweb.quickframework.modules.sys.utils.UserUtils.class, "getMenuList", new Class[] {});
  _jspx_fnmap_7= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fn:indexOf", org.apache.taglibs.standard.functions.Functions.class, "indexOf", new Class[] {java.lang.String.class, java.lang.String.class});
}

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/WEB-INF/views/include/taglib.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_varStatus_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_varStatus_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_set_var_value_nobody.release();
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_forEach_varStatus_var_items.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_set_1(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_set_2(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_set_3(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<title>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fns:getConfig('productName')}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_1));
      out.write("</title>\r\n");
      out.write("\t<meta name=\"decorator\" content=\"blank\"/>");
      if (_jspx_meth_c_set_4(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("    ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("\t\t#main {padding:0;margin:0;} #main .container-fluid{padding:0 4px 0 6px;}\r\n");
      out.write("\t\t#header {margin:0 0 8px;position:static;} #header li {font-size:14px;_font-size:12px;}\r\n");
      out.write("\t\t#header .brand {font-family:Helvetica, Georgia, Arial, sans-serif, 黑体;font-size:26px;padding-left:33px;}\r\n");
      out.write("\t\t#footer {margin:8px 0 0 0;padding:3px 0 0 0;font-size:11px;text-align:center;border-top:2px solid #0663A2;}\r\n");
      out.write("\t\t#footer, #footer a {color:#999;} #left{overflow-x:hidden;overflow-y:auto;} #left .collapse{position:static;}\r\n");
      out.write("\t\t#userControl>li>a{/*color:#fff;*/text-shadow:none;} #userControl>li>a:hover, #user #userControl>li.open>a{background:transparent;}\r\n");
      out.write("\t</style>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t$(document).ready(function() {\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t// 绑定菜单单击事件\r\n");
      out.write("\t\t\t$(\"#menu a.menu\").click(function(){\r\n");
      out.write("\t\t\t\t// 一级菜单焦点\r\n");
      out.write("\t\t\t\t$(\"#menu li.menu\").removeClass(\"active\");\r\n");
      out.write("\t\t\t\t$(this).parent().addClass(\"active\");\r\n");
      out.write("\t\t\t\t// 左侧区域隐藏\r\n");
      out.write("\t\t\t\tif ($(this).attr(\"target\") == \"mainFrame\"){\r\n");
      out.write("\t\t\t\t\t$(\"#left,#openClose\").hide();\r\n");
      out.write("\t\t\t\t\twSizeWidth();\r\n");
      out.write("\t\t\t\t\t// ");
      if (_jspx_meth_c_if_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\treturn true;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t// 左侧区域显示\r\n");
      out.write("\t\t\t\t$(\"#left,#openClose\").show();\r\n");
      out.write("\t\t\t\tif(!$(\"#openClose\").hasClass(\"close\")){\r\n");
      out.write("\t\t\t\t\t$(\"#openClose\").click();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t// 显示二级菜单\r\n");
      out.write("\t\t\t\tvar menuId = \"#menu-\" + $(this).attr(\"data-id\");\r\n");
      out.write("\t\t\t\tif ($(menuId).length > 0){\r\n");
      out.write("\t\t\t\t\t$(\"#left .accordion\").hide();\r\n");
      out.write("\t\t\t\t\t$(menuId).show();\r\n");
      out.write("\t\t\t\t\t// 初始化点击第一个二级菜单\r\n");
      out.write("\t\t\t\t\tif (!$(menuId + \" .accordion-body:first\").hasClass('in')){\r\n");
      out.write("\t\t\t\t\t\t$(menuId + \" .accordion-heading:first a\").click();\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tif (!$(menuId + \" .accordion-body li:first ul:first\").is(\":visible\")){\r\n");
      out.write("\t\t\t\t\t\t$(menuId + \" .accordion-body a:first i\").click();\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t// 初始化点击第一个三级菜单\r\n");
      out.write("\t\t\t\t\t$(menuId + \" .accordion-body li:first li:first a:first i\").click();\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t// 获取二级菜单数据\r\n");
      out.write("                    //console.log($(this).attr(\"data-href\"));\r\n");
      out.write("\t\t\t\t\t$.get($(this).attr(\"data-href\"), function(data){\r\n");
      out.write("\t\t\t\t\t\tif (data.indexOf(\"id=\\\"loginForm\\\"\") != -1){\r\n");
      out.write("\t\t\t\t\t\t\talert('未登录或登录超时。请重新登录，谢谢！');\r\n");
      out.write("\t\t\t\t\t\t\ttop.location = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctxAdmin}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("\t\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t$(\"#left .accordion\").hide();\r\n");
      out.write("                        //console.log(data);\r\n");
      out.write("\t\t\t\t\t\t$(\"#left\").append(data);\r\n");
      out.write("\t\t\t\t\t\t// 链接去掉虚框\r\n");
      out.write("\t\t\t\t\t\t$(menuId + \" a\").bind(\"focus\",function() {\r\n");
      out.write("\t\t\t\t\t\t\tif(this.blur) {this.blur()};\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t// 二级标题\r\n");
      out.write("\t\t\t\t\t\t$(menuId + \" .accordion-heading a\").click(function(){\r\n");
      out.write("\t\t\t\t\t\t\t$(menuId + \" .accordion-toggle i\").removeClass('icon-chevron-down').addClass('icon-chevron-right');\r\n");
      out.write("\t\t\t\t\t\t\tif(!$($(this).attr('data-href')).hasClass('in')){\r\n");
      out.write("\t\t\t\t\t\t\t\t$(this).children(\"i\").removeClass('icon-chevron-right').addClass('icon-chevron-down');\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t// 二级内容\r\n");
      out.write("\t\t\t\t\t\t$(menuId + \" .accordion-body a\").click(function(){\r\n");
      out.write("\t\t\t\t\t\t\t$(menuId + \" li\").removeClass(\"active\");\r\n");
      out.write("\t\t\t\t\t\t\t$(menuId + \" li i\").removeClass(\"icon-white\");\r\n");
      out.write("\t\t\t\t\t\t\t$(this).parent().addClass(\"active\");\r\n");
      out.write("\t\t\t\t\t\t\t$(this).children(\"i\").addClass(\"icon-white\");\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t// 展现三级\r\n");
      out.write("\t\t\t\t\t\t$(menuId + \" .accordion-inner a\").click(function(){\r\n");
      out.write("\t\t\t\t\t\t\tvar href = $(this).attr(\"data-href\");\r\n");
      out.write("\t\t\t\t\t\t\tif($(href).length > 0){\r\n");
      out.write("\t\t\t\t\t\t\t\t$(href).toggle().parent().toggle();\r\n");
      out.write("\t\t\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t// ");
      if (_jspx_meth_c_if_3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t// 默认选中第一个菜单\r\n");
      out.write("\t\t\t\t\t\t$(menuId + \" .accordion-body a:first i\").click();\r\n");
      out.write("\t\t\t\t\t\t$(menuId + \" .accordion-body li:first li:first a:first i\").click();\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t// 大小宽度调整\r\n");
      out.write("\t\t\t\twSizeWidth();\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t// 初始化点击第一个一级菜单\r\n");
      out.write("\t\t\t$(\"#menu a.menu:first span\").click();\r\n");
      out.write("\t\t\t// ");
      if (_jspx_meth_c_if_4(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t// 鼠标移动到边界自动弹出左侧菜单\r\n");
      out.write("\t\t\t$(\"#openClose\").mouseover(function(){\r\n");
      out.write("\t\t\t\tif($(this).hasClass(\"open\")){\r\n");
      out.write("\t\t\t\t\t$(this).click();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t// 获取通知数目  ");
      if (_jspx_meth_c_set_5(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\tfunction getNotifyNum(){\r\n");
      out.write("\t\t\t\t$.get(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctxAdmin}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/oa/oaNotify/self/count?updateSession=0&t=\"+new Date().getTime(),function(data){\r\n");
      out.write("\t\t\t\t\tvar num = parseFloat(data);\r\n");
      out.write("\t\t\t\t\tif (num > 0){\r\n");
      out.write("\t\t\t\t\t\t$(\"#notifyNum,#notifyNum2\").show().html(\"(\"+num+\")\");\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t$(\"#notifyNum,#notifyNum2\").hide()\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tgetNotifyNum(); //");
      if (_jspx_meth_c_if_5(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t// ");
      if (_jspx_meth_c_if_6(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction aUserInfo(_this){\r\n");
      out.write("\t\t\t  $('a[data-href=\".menu3-29\"]').click();\r\n");
      out.write(" \t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction aModifyPwd(_this){\r\n");
      out.write("\t\t\t  $('a[data-href=\".menu3-30\"]').click();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction aSelf(_this){\r\n");
      out.write("\t\t\t  $('a[data-href=\".menu3-89\"]').click();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t</script>\r\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/theme_flat2016/ui-index.css?v=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctxVersion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"main\">\r\n");
      out.write("\t\t<div id=\"header\" class=\"navbar navbar-fixed-top\">\r\n");
      out.write("\t\t\t<div class=\"navbar-inner\">\r\n");
      out.write("\t\t\t\t<div class=\"logo\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/theme_flat2016/images/logo2.png\" /></div>\r\n");
      out.write("\t\t\t\t<div class=\"brand\"><span id=\"productName\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fns:getConfig('productName')}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_1));
      out.write("</span></div>\r\n");
      out.write("\t\t\t\t<ul id=\"userControl\" class=\"nav pull-right\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fns:getFrontPath()}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_2));
      out.write("/index-");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fnc:getCurrentSiteId()}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_3));
      out.write(".html\" target=\"_blank\" title=\"访问网站主页\"><i class=\"icon-home\"></i></a></li>\r\n");
      out.write("\t\t\t\t\t<li id=\"themeSwitch\" class=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t<!-- \t<a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\" title=\"主题切换\"><i class=\"icon-th-large\"></i></a> -->\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t\t\t\t");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"javascript:cookie('tabmode','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tabmode eq '1' ? '0' : '1'}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("');location=location.href\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tabmode eq '1' ? '关闭' : '开启'}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("页签模式</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t<!--[if lte IE 6]><script type=\"text/javascript\">$('#themeSwitch').hide();</script><![endif]-->\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li id=\"userInfo\" class=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t\t<a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\" title=\"个人信息\">您好, ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fns:getUser().name}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_5));
      out.write("&nbsp;<span id=\"notifyNum\" class=\"label label-info hide\"></span></a>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctxAdmin}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/sys/user/info\" target=\"mainFrame\" id=\"aUserInfo\" onclick=\"aUserInfo(this)\"><i class=\"icon-user\"></i>&nbsp;个人信息</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctxAdmin}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/sys/user/modifyPwd\" target=\"mainFrame\" id=\"aModifyPwd\" onclick=\"aModifyPwd(this)\"><i class=\"icon-lock\"></i>&nbsp;  修改密码</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctxAdmin}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/oa/oaNotify/self\" target=\"mainFrame\" id=\"aSelf\" onclick=\"aSelf(this)\"><i class=\"icon-bell\"></i>&nbsp;  我的通知 <span id=\"notifyNum2\" class=\"label label-info hide\"></span></a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctxAdmin}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/logout\" title=\"退出登录\">退出</a></li>\r\n");
      out.write("\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"nav-collapse\">\r\n");
      out.write("\t\t\t\t\t<ul id=\"menu\" class=\"nav\" style=\"*white-space:nowrap;float:none;\">\r\n");
      out.write("\t\t\t\t\t\t");
      if (_jspx_meth_c_set_6(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div><!--/.nav-collapse -->\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t    <div class=\"container-fluid\">\r\n");
      out.write("\t\t\t<div id=\"content\" class=\"row-fluid\">\r\n");
      out.write("\t\t\t\t<div id=\"left\">");
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div id=\"openClose\" class=\"close\">&nbsp;</div>\r\n");
      out.write("\t\t\t\t<div id=\"right\" style=\"padding-top: 3px;\">\r\n");
      out.write("\t\t\t\t\t<iframe id=\"mainFrame\" name=\"mainFrame\" src=\"\" style=\"overflow:visible;\" scrolling=\"yes\" frameborder=\"no\" width=\"100%\" height=\"650\"></iframe>\r\n");
      out.write("\t\t\t\t\t<div id=\"footer2\" class=\"row-fluid\" style=\"position: absolute;bottom:0;font-size: 9px;text-align:center;line-height:25px;color:#8f8f8f;\">\r\n");
      out.write("\t\t\t\t\t\tCopyright &copy; ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fns:getConfig('copyrightYear')}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_1));
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fns:getConfig('productName')}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_1));
      out.write(" - Powered By 福建省万维智能科技有限公司 ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fns:getConfig('version')}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_1));
      out.write("\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t    ");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script type=\"text/javascript\"> \r\n");
      out.write("\t\tvar leftWidth = 190; // 左侧窗口大小,orgin:160\r\n");
      out.write("\t\tvar tabTitleHeight = 33; // 页签的高度\r\n");
      out.write("\t\tvar htmlObj = $(\"html\"), mainObj = $(\"#main\");\r\n");
      out.write("\t\tvar headerObj = $(\"#header\"), footerObj = $(\"#footer\");\r\n");
      out.write("\t\tvar frameObj = $(\"#left, #openClose, #right, #right iframe\");\r\n");
      out.write("\t\tvar uiFixHeight = 32;\r\n");
      out.write("\t\tfunction wSize(){\r\n");
      out.write("\t\t\tvar minHeight = 500, minWidth = 980;\r\n");
      out.write("\t\t\tvar strs = getWindowSize().toString().split(\",\");\r\n");
      out.write("\t\t\thtmlObj.css({\"overflow-x\":strs[1] < minWidth ? \"auto\" : \"hidden\", \"overflow-y\":strs[0] < minHeight ? \"auto\" : \"hidden\"});\r\n");
      out.write("\t\t\tmainObj.css(\"width\",strs[1] < minWidth ? minWidth - 10 : \"auto\");\r\n");
      out.write("\t\t\t//frameObj.height((strs[0] < minHeight ? minHeight : strs[0]) - headerObj.height() - footerObj.height() - (strs[1] < minWidth ? 42 : 28));\r\n");
      out.write("\t\t\tframeObj.height((strs[0] < minHeight ? minHeight : strs[0]) - headerObj.height() +  uiFixHeight - (strs[1] < minWidth ? 42 : 28));\r\n");
      out.write("\t\t\t//console.log('openClose height: ', $(\"#openClose\").height() - 5);\r\n");
      out.write("\t\t\t$(\"#openClose\").height($(\"#openClose\").height() - 5 + uiFixHeight);// ");
      if (_jspx_meth_c_if_11(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\twSizeWidth();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction wSizeWidth(){\r\n");
      out.write("\t\t\tvar width = '100%';\r\n");
      out.write("\t\t\tif (!$(\"#openClose\").is(\":hidden\")){\r\n");
      out.write("\t\t\t\tvar leftWidth = ($(\"#left\").width() < 0 ? 0 : $(\"#left\").width());\r\n");
      out.write("\t\t\t\twidth = $(\"#content\").width()- leftWidth - $(\"#openClose\").width() -5;\r\n");
      out.write("\t\t\t\t$(\"#right\").width(width);\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\t$(\"#right\").width(width);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t$('#footer2').width(width);\r\n");
      out.write("\t\t}// ");
      if (_jspx_meth_c_if_12(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctxStatic}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/common/wsize.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("ctx");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }

  private boolean _jspx_meth_c_set_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_1.setPageContext(_jspx_page_context);
    _jspx_th_c_set_1.setParent(null);
    _jspx_th_c_set_1.setVar("ctxAdmin");
    _jspx_th_c_set_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}${fns:getAdminPath()}", java.lang.Object.class, (PageContext)_jspx_page_context, _jspx_fnmap_0));
    int _jspx_eval_c_set_1 = _jspx_th_c_set_1.doStartTag();
    if (_jspx_th_c_set_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_1);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_1);
    return false;
  }

  private boolean _jspx_meth_c_set_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_2 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_2.setPageContext(_jspx_page_context);
    _jspx_th_c_set_2.setParent(null);
    _jspx_th_c_set_2.setVar("ctxStatic");
    _jspx_th_c_set_2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}/static", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_2 = _jspx_th_c_set_2.doStartTag();
    if (_jspx_th_c_set_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_2);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_2);
    return false;
  }

  private boolean _jspx_meth_c_set_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_3 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_3.setPageContext(_jspx_page_context);
    _jspx_th_c_set_3.setParent(null);
    _jspx_th_c_set_3.setVar("ctxLogout");
    _jspx_th_c_set_3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctxAdmin}/logout", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_3 = _jspx_th_c_set_3.doStartTag();
    if (_jspx_th_c_set_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_3);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_3);
    return false;
  }

  private boolean _jspx_meth_c_set_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_4 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_4.setPageContext(_jspx_page_context);
    _jspx_th_c_set_4.setParent(null);
    _jspx_th_c_set_4.setVar("tabmode");
    _jspx_th_c_set_4.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empty cookie.tabmode.value ? '0' : cookie.tabmode.value}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_4 = _jspx_th_c_set_4.doStartTag();
    if (_jspx_th_c_set_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_4);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_4);
    return false;
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tabmode eq '1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<link rel=\"Stylesheet\" href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctxStatic}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/jerichotab/css/jquery.jerichotab.css\" />\r\n");
        out.write("    <script type=\"text/javascript\" src=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctxStatic}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/jerichotab/js/jquery.jerichotab.js\"></script>");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tabmode eq '1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" 初始化页签\r\n");
        out.write("\t\t\t$.fn.initJerichoTab({\r\n");
        out.write("                renderTo: '#right', uniqueId: 'jerichotab',\r\n");
        out.write("                contentCss: { 'height': $('#right').height() - tabTitleHeight },\r\n");
        out.write("                tabs: [], loadOnce: true, tabWidth: 110, titleHeight: tabTitleHeight\r\n");
        out.write("            });//");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_if_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent(null);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tabmode eq '1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" 隐藏页签\r\n");
        out.write("\t\t\t\t\t$(\".jericho_tab\").hide();\r\n");
        out.write("\t\t\t\t\t$(\"#mainFrame\").show();//");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }

  private boolean _jspx_meth_c_if_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_3.setPageContext(_jspx_page_context);
    _jspx_th_c_if_3.setParent(null);
    _jspx_th_c_if_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tabmode eq '1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
    if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" 打开显示页签\r\n");
        out.write("\t\t\t\t\t\t\treturn addTab($(this)); // ");
        int evalDoAfterBody = _jspx_th_c_if_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
    return false;
  }

  private boolean _jspx_meth_c_if_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_4 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_4.setPageContext(_jspx_page_context);
    _jspx_th_c_if_4.setParent(null);
    _jspx_th_c_if_4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tabmode eq '1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_4 = _jspx_th_c_if_4.doStartTag();
    if (_jspx_eval_c_if_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" 下拉菜单以选项卡方式打开\r\n");
        out.write("\t\t\t$(\"#userInfo .dropdown-menu a\").mouseup(function(){\r\n");
        out.write("\t\t\t\tif($(this).attr('id')=='aUserInfo'){\r\n");
        out.write("\t\t\t\t\treturn false;\r\n");
        out.write("\t\t\t\t}else if($(this).attr('id')=='aModifyPwd'){\r\n");
        out.write("\t\t\t\t\treturn false;\r\n");
        out.write("\t\t\t\t}else if($(this).attr('id')=='aSelf'){\r\n");
        out.write("\t\t\t\t\treturn false;\r\n");
        out.write("\t\t\t\t}\r\n");
        out.write("\t\t\t\treturn addTab($(this), true);\r\n");
        out.write("\t\t\t});// ");
        int evalDoAfterBody = _jspx_th_c_if_4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_4);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_4);
    return false;
  }

  private boolean _jspx_meth_c_set_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_5 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_5.setPageContext(_jspx_page_context);
    _jspx_th_c_set_5.setParent(null);
    _jspx_th_c_set_5.setVar("oaNotifyRemindInterval");
    _jspx_th_c_set_5.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fns:getConfig('oa.notify.remind.interval')}", java.lang.Object.class, (PageContext)_jspx_page_context, _jspx_fnmap_1));
    int _jspx_eval_c_set_5 = _jspx_th_c_set_5.doStartTag();
    if (_jspx_th_c_set_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_5);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_5);
    return false;
  }

  private boolean _jspx_meth_c_if_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_5 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_5.setPageContext(_jspx_page_context);
    _jspx_th_c_if_5.setParent(null);
    _jspx_th_c_if_5.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${oaNotifyRemindInterval ne '' && oaNotifyRemindInterval ne '0'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_5 = _jspx_th_c_if_5.doStartTag();
    if (_jspx_eval_c_if_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\tsetInterval(getNotifyNum, ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${oaNotifyRemindInterval}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("); //");
        int evalDoAfterBody = _jspx_th_c_if_5.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_5);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_5);
    return false;
  }

  private boolean _jspx_meth_c_if_6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_6 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_6.setPageContext(_jspx_page_context);
    _jspx_th_c_if_6.setParent(null);
    _jspx_th_c_if_6.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tabmode eq '1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_6 = _jspx_th_c_if_6.doStartTag();
    if (_jspx_eval_c_if_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" 添加一个页签\r\n");
        out.write("\t\tfunction addTab($this, refresh){\r\n");
        out.write("\t\t\t$(\".jericho_tab\").show();\r\n");
        out.write("\t\t\t$(\"#mainFrame\").hide();\r\n");
        out.write("\t\t\t$.fn.jerichoTab.addTab({\r\n");
        out.write("                tabFirer: $this,\r\n");
        out.write("                title: $this.text(),\r\n");
        out.write("                closeable: true,\r\n");
        out.write("                data: {\r\n");
        out.write("                    dataType: 'iframe',\r\n");
        out.write("                    dataLink: $this.attr('href')\r\n");
        out.write("                }\r\n");
        out.write("            }).loadData(refresh);\r\n");
        out.write("\t\t\treturn false;\r\n");
        out.write("\t\t}// ");
        int evalDoAfterBody = _jspx_th_c_if_6.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_6);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_6);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fns:getDictList('theme')}", java.lang.Object.class, (PageContext)_jspx_page_context, _jspx_fnmap_4));
    _jspx_th_c_forEach_0.setVar("dict");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("<li><a href=\"#\" onclick=\"location='");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("/theme/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dict.value}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("?url='+location.href\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dict.label}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a></li>");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_set_6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_6 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_6.setPageContext(_jspx_page_context);
    _jspx_th_c_set_6.setParent(null);
    _jspx_th_c_set_6.setVar("firstMenu");
    _jspx_th_c_set_6.setValue(new String("true"));
    int _jspx_eval_c_set_6 = _jspx_th_c_set_6.doStartTag();
    if (_jspx_th_c_set_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_6);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_6);
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fns:getMenuList()}", java.lang.Object.class, (PageContext)_jspx_page_context, _jspx_fnmap_6));
    _jspx_th_c_forEach_1.setVar("menu");
    _jspx_th_c_forEach_1.setVarStatus("idxStatus");
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t");
          if (_jspx_meth_c_if_7((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_1, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_varStatus_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_7(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_7 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_7.setPageContext(_jspx_page_context);
    _jspx_th_c_if_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_1);
    _jspx_th_c_if_7.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${menu.parent.id eq '1'&&menu.isShow eq '1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_7 = _jspx_th_c_if_7.doStartTag();
    if (_jspx_eval_c_if_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t<li class=\"menu ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty firstMenu && firstMenu ? ' active' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_if_8((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_7, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_if_9((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_7, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_if_10((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_7, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_set_8((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_7, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_7.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_7);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_7);
    return false;
  }

  private boolean _jspx_meth_c_if_8(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_7, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_8 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_8.setPageContext(_jspx_page_context);
    _jspx_th_c_if_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_7);
    _jspx_th_c_if_8.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empty menu.href}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_8 = _jspx_th_c_if_8.doStartTag();
    if (_jspx_eval_c_if_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<a class=\"menu\" href=\"javascript:\" data-href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctxAdmin}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/sys/menu/tree?parentId=");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${menu.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\" data-id=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${menu.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\"><span>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${menu.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</span></a>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_8.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_8);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_8);
    return false;
  }

  private boolean _jspx_meth_c_if_9(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_7, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_9 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_9.setPageContext(_jspx_page_context);
    _jspx_th_c_if_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_7);
    _jspx_th_c_if_9.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty menu.href}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_9 = _jspx_th_c_if_9.doStartTag();
    if (_jspx_eval_c_if_9 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<a class=\"menu\" href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fn:indexOf(menu.href, '://') eq -1 ? ctx : ''}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_7));
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${menu.href}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\" data-id=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${menu.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\" target=\"mainFrame\"><span>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${menu.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</span></a>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_9.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_9);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_9);
    return false;
  }

  private boolean _jspx_meth_c_if_10(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_7, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_10 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_10.setPageContext(_jspx_page_context);
    _jspx_th_c_if_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_7);
    _jspx_th_c_if_10.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${firstMenu}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_10 = _jspx_th_c_if_10.doStartTag();
    if (_jspx_eval_c_if_10 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_set_7((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_10, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_10.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_10);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_10);
    return false;
  }

  private boolean _jspx_meth_c_set_7(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_10, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_7 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_7.setPageContext(_jspx_page_context);
    _jspx_th_c_set_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_10);
    _jspx_th_c_set_7.setVar("firstMenuId");
    _jspx_th_c_set_7.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${menu.id}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_7 = _jspx_th_c_set_7.doStartTag();
    if (_jspx_th_c_set_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_7);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_7);
    return false;
  }

  private boolean _jspx_meth_c_set_8(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_7, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_8 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_8.setPageContext(_jspx_page_context);
    _jspx_th_c_set_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_7);
    _jspx_th_c_set_8.setVar("firstMenu");
    _jspx_th_c_set_8.setValue(new String("false"));
    int _jspx_eval_c_set_8 = _jspx_th_c_set_8.doStartTag();
    if (_jspx_th_c_set_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_8);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_8);
    return false;
  }

  private boolean _jspx_meth_c_if_11(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_11 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_11.setPageContext(_jspx_page_context);
    _jspx_th_c_if_11.setParent(null);
    _jspx_th_c_if_11.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tabmode eq '1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_11 = _jspx_th_c_if_11.doStartTag();
    if (_jspx_eval_c_if_11 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t$(\".jericho_tab iframe\").height($(\"#right\").height() - tabTitleHeight); // ");
        int evalDoAfterBody = _jspx_th_c_if_11.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_11);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_11);
    return false;
  }

  private boolean _jspx_meth_c_if_12(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_12 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_12.setPageContext(_jspx_page_context);
    _jspx_th_c_if_12.setParent(null);
    _jspx_th_c_if_12.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tabmode eq '1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_12 = _jspx_th_c_if_12.doStartTag();
    if (_jspx_eval_c_if_12 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" \r\n");
        out.write("\t\tfunction openCloseClickCallBack(b){\r\n");
        out.write("\t\t\t$.fn.jerichoTab.resize();\r\n");
        out.write("\t\t} // ");
        int evalDoAfterBody = _jspx_th_c_if_12.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_12);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_12);
    return false;
  }
}

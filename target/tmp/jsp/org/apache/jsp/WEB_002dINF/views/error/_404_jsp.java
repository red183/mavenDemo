package org.apache.jsp.WEB_002dINF.views.error;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.cnwanweb.quickframework.common.web.Servlets;

public final class _404_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_0;

static {
  _jspx_fnmap_0= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fns:getAdminPath", com.cnwanweb.quickframework.common.config.Global.class, "getAdminPath", new Class[] {});
}

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(2);
    _jspx_dependants.add("/WEB-INF/views/include/taglib.jsp");
    _jspx_dependants.add("/WEB-INF/views/include/head.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_set_var_value_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    Throwable exception = org.apache.jasper.runtime.JspRuntimeLibrary.getThrowable(request);
    if (exception != null) {
      response.setStatus((Integer)request.getAttribute("javax.servlet.error.status_code"));
    }
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


response.setStatus(404);

// 如果是异步请求或是手机端，则直接返回信息
if (Servlets.isAjaxRequest(request)) {
	out.print("页面不存在.");
}

//输出异常信息页面
else {

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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<title>404 - 页面不存在</title>\r\n");
      out.write("\t");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\" /><meta name=\"author\" content=\"http://www.china-wanwei.com//\"/>\r\n");
      out.write("<meta name=\"renderer\" content=\"webkit\"><meta http-equiv=\"X-UA-Compatible\" content=\"IE=8,IE=9,IE=10\" />\r\n");
      out.write("<meta http-equiv=\"Expires\" content=\"0\"><meta http-equiv=\"Cache-Control\" content=\"no-cache\"><meta http-equiv=\"Cache-Control\" content=\"no-store\">\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctxStatic}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/jquery/jquery-1.8.3.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctxStatic}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/bootstrap/2.3.1/css_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty cookie.theme.value ? cookie.theme.value : 'cerulean'}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/bootstrap.min.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctxStatic}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/bootstrap/2.3.1/js/bootstrap.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctxStatic}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/bootstrap/2.3.1/awesome/font-awesome.min.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("<!--[if lte IE 7]><link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctxStatic}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/bootstrap/2.3.1/awesome/font-awesome-ie7.min.css\" type=\"text/css\" rel=\"stylesheet\" /><![endif]-->\r\n");
      out.write("<!--[if lte IE 6]><link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctxStatic}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/bootstrap/bsie/css/bootstrap-ie6.min.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctxStatic}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/bootstrap/bsie/js/bootstrap-ie.min.js\" type=\"text/javascript\"></script><![endif]-->\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctxStatic}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/jquery-select2/3.4/select2.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctxStatic}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/jquery-select2/3.4/select2.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctxStatic}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/jquery-validation/1.11.0/jquery.validate.min.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctxStatic}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/jquery-validation/1.11.0/jquery.validate.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctxStatic}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/jquery-jbox/2.3/Skins/Bootstrap/jbox.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctxStatic}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/jquery-jbox/2.3/jquery.jBox-2.3.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctxStatic}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/My97DatePicker/WdatePicker.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctxStatic}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/common/mustache.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctxStatic}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/common/quicksite.css?v=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctxVersion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/theme_flat2016/ui.css?v=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctxVersion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctxStatic}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/common/quicksite.js?v=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctxVersion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">var ctx = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctxAdmin}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("', ctxStatic='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctxStatic}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("';</script>");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"container-fluid\">\r\n");
      out.write("\t\t<div class=\"page-header\"><h1>页面不存在.</h1></div>\r\n");
      out.write("\t\t<div><a href=\"javascript:\" onclick=\"history.go(-1);\" class=\"btn\">返回上一页</a></div>\r\n");
      out.write("\t\t<script>try{top.$.jBox.closeTip();}catch(e){}</script>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");

out.print("<!--"+request.getAttribute("javax.servlet.forward.request_uri")+"-->");
} out = pageContext.pushBody();

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
}

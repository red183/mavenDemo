<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ attribute name="id" type="java.lang.String" required="true" description="编号"%>
<%@ attribute name="name" type="java.lang.String" required="true" description="隐藏域名称（ID）"%>
<%@ attribute name="value" type="java.lang.String" required="true" description="隐藏域值（ID）"%>
<%@ attribute name="labelName" type="java.lang.String" required="true" description="输入框名称（Name）"%>
<%@ attribute name="labelValue" type="java.lang.String" required="true" description="输入框值（Name）"%>
<%@ attribute name="title" type="java.lang.String" required="true" description="选择框标题"%>
<%@ attribute name="checked" type="java.lang.Boolean" required="false" description="是否显示复选框，如果不需要返回父节点，请设置notAllowSelectParent为true"%>
<%@ attribute name="allowInput" type="java.lang.Boolean" required="false" description="文本框可填写"%>
<%@ attribute name="cssClass" type="java.lang.String" required="false" description="css样式"%>
<%@ attribute name="cssStyle" type="java.lang.String" required="false" description="css样式"%>
<%@ attribute name="smallBtn" type="java.lang.Boolean" required="false" description="缩小按钮显示"%>
<%@ attribute name="hideBtn" type="java.lang.Boolean" required="false" description="是否显示按钮"%>
<div class="input-append">
	<%--<input id="${id}" name="${name}" ${allowInput?'':'readonly="readonly"'} type="text" value="${labelValue}"--%>
	<img class="imgupload" id="${id}Img" <c:if test="${not empty labelValue}">src="${ctx}${labelValue}"</c:if> class="${cssClass}">
		<input id="${id}" name="${name}" ${allowInput?'':'readonly="readonly"'} type="hidden" value="${labelValue}"
		class="${cssClass}" style="${cssStyle}"/><a id="${id}Button" href="javascript:" class="btn ${disabled} ${hideBtn ? 'hide' : ''}" style="${smallBtn?'padding:4px 2px;':''}">&nbsp;<i class="icon-search"></i>&nbsp;</a>&nbsp;&nbsp;
</div>
<script type="text/javascript">
	$("#${id}Button, #${id}Name").click(function(){
		// 是否限制选择，如果限制，设置为disabled
		if ($("#${id}Button").hasClass("disabled")){
			return true;
		}
		// 正常打开	buttons:{"确定":"ok", "关闭":true}
		top.$.jBox.open("iframe:${ctxAdmin}/tag/uploadselect", "选择${title}", 300, 400, {
			ajaxData:{selectIds: $("#${id}Id").val()},buttons:{"确定":"ok", "关闭":true},
			submit:function(v, h, f){
                var subWin = h.find("iframe")[0].contentWindow;
                var $imgShow = $(subWin.imgShow);
                var $relativeUrl = $(subWin.relativeUrl);//$('#relativeUrl')
                var $fileId = $(subWin.fileId);
                var imageSrc = $imgShow.attr('src');
                var relativeUrl = $relativeUrl.val();
                var fileId = $fileId.val();
			    if(v == 'browse') {
                    window.open(imageSrc);
                } else if (v=="ok"){
                    $("#${id}").val(fileId);
                    $(".imgupload").attr('src',imageSrc);
                    $(".imgmodal").hide();
				}
			}, loaded:function(h){
				$("#jbox-content", top.document).css({"padding-left": 0,"overflow":"hidden"});

				//var currentUrl = $("#${id}").val();
                var currentUrl = $("#${id}Img").attr('src');
				if(!!currentUrl) {
                    var subWin = h.find("iframe")[0].contentWindow;
                    var $imgShow = $(subWin.imgShow);
                    var $relativeUrl = $(subWin.relativeUrl);
                    if(currentUrl.indexOf("http") == 0) {
                        $imgShow.attr('src', currentUrl);
                    } else {
                        <%--$imgShow.attr('src', '${ctx}' + currentUrl);--%>
                        $imgShow.attr('src',currentUrl);
                    }
                    $relativeUrl.val(currentUrl);
                }
			}
		});
        top.$('.jbox-body .jbox-icon').css({'top':'70px',"left": "30px","width":"37px","height": "37px"});
        top.$('.jbox-body .jbox-button-panel').css({'text-align':'center',"height": "45px"});
	});
</script>
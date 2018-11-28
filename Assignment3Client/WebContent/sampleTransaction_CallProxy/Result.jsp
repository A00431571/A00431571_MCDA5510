<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleTransaction_CallProxyid" scope="session" class="com.mcds5510.webservice.Transaction_CallProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleTransaction_CallProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleTransaction_CallProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleTransaction_CallProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        com.mcds5510.webservice.Transaction_Call getTransaction_Call10mtemp = sampleTransaction_CallProxyid.getTransaction_Call();
if(getTransaction_Call10mtemp == null){
%>
<%=getTransaction_Call10mtemp %>
<%
}else{
        if(getTransaction_Call10mtemp!= null){
        String tempreturnp11 = getTransaction_Call10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String id_1id=  request.getParameter("id16");
            java.lang.String id_1idTemp = null;
        if(!id_1id.equals("")){
         id_1idTemp  = id_1id;
        }
        String nameOnCard_2id=  request.getParameter("nameOnCard18");
            java.lang.String nameOnCard_2idTemp = null;
        if(!nameOnCard_2id.equals("")){
         nameOnCard_2idTemp  = nameOnCard_2id;
        }
        String cardNumber_3id=  request.getParameter("cardNumber20");
            java.lang.String cardNumber_3idTemp = null;
        if(!cardNumber_3id.equals("")){
         cardNumber_3idTemp  = cardNumber_3id;
        }
        String unitPrice_4id=  request.getParameter("unitPrice22");
            java.lang.String unitPrice_4idTemp = null;
        if(!unitPrice_4id.equals("")){
         unitPrice_4idTemp  = unitPrice_4id;
        }
        String quantity_5id=  request.getParameter("quantity24");
            java.lang.String quantity_5idTemp = null;
        if(!quantity_5id.equals("")){
         quantity_5idTemp  = quantity_5id;
        }
        String expDate_6id=  request.getParameter("expDate26");
            java.lang.String expDate_6idTemp = null;
        if(!expDate_6id.equals("")){
         expDate_6idTemp  = expDate_6id;
        }
        java.lang.String create_Transaction13mtemp = sampleTransaction_CallProxyid.create_Transaction(id_1idTemp,nameOnCard_2idTemp,cardNumber_3idTemp,unitPrice_4idTemp,quantity_5idTemp,expDate_6idTemp);
if(create_Transaction13mtemp == null){
%>
<%=create_Transaction13mtemp %>
<%
}else{
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(create_Transaction13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
}
break;
case 28:
        gotMethod = true;
        String id_7id=  request.getParameter("id31");
            java.lang.String id_7idTemp = null;
        if(!id_7id.equals("")){
         id_7idTemp  = id_7id;
        }
        String nameOnCard_8id=  request.getParameter("nameOnCard33");
            java.lang.String nameOnCard_8idTemp = null;
        if(!nameOnCard_8id.equals("")){
         nameOnCard_8idTemp  = nameOnCard_8id;
        }
        String cardNumber_9id=  request.getParameter("cardNumber35");
            java.lang.String cardNumber_9idTemp = null;
        if(!cardNumber_9id.equals("")){
         cardNumber_9idTemp  = cardNumber_9id;
        }
        String unitPrice_10id=  request.getParameter("unitPrice37");
            java.lang.String unitPrice_10idTemp = null;
        if(!unitPrice_10id.equals("")){
         unitPrice_10idTemp  = unitPrice_10id;
        }
        String quantity_11id=  request.getParameter("quantity39");
            java.lang.String quantity_11idTemp = null;
        if(!quantity_11id.equals("")){
         quantity_11idTemp  = quantity_11id;
        }
        String expDate_12id=  request.getParameter("expDate41");
            java.lang.String expDate_12idTemp = null;
        if(!expDate_12id.equals("")){
         expDate_12idTemp  = expDate_12id;
        }
        java.lang.String update_Transaction28mtemp = sampleTransaction_CallProxyid.update_Transaction(id_7idTemp,nameOnCard_8idTemp,cardNumber_9idTemp,unitPrice_10idTemp,quantity_11idTemp,expDate_12idTemp);
if(update_Transaction28mtemp == null){
%>
<%=update_Transaction28mtemp %>
<%
}else{
        String tempResultreturnp29 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(update_Transaction28mtemp));
        %>
        <%= tempResultreturnp29 %>
        <%
}
break;
case 43:
        gotMethod = true;
        String id_13id=  request.getParameter("id46");
            java.lang.String id_13idTemp = null;
        if(!id_13id.equals("")){
         id_13idTemp  = id_13id;
        }
        java.lang.String delete_Transaction43mtemp = sampleTransaction_CallProxyid.delete_Transaction(id_13idTemp);
if(delete_Transaction43mtemp == null){
%>
<%=delete_Transaction43mtemp %>
<%
}else{
        String tempResultreturnp44 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(delete_Transaction43mtemp));
        %>
        <%= tempResultreturnp44 %>
        <%
}
break;
case 48:
        gotMethod = true;
        String id_14id=  request.getParameter("id51");
            java.lang.String id_14idTemp = null;
        if(!id_14id.equals("")){
         id_14idTemp  = id_14id;
        }
        java.lang.String view_Transaction48mtemp = sampleTransaction_CallProxyid.view_Transaction(id_14idTemp);
if(view_Transaction48mtemp == null){
%>
<%=view_Transaction48mtemp %>
<%
}else{
        String tempResultreturnp49 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(view_Transaction48mtemp));
        %>
        <%= tempResultreturnp49 %>
        <%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>
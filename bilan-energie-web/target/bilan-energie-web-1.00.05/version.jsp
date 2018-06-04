<%@page pageEncoding="UTF-8" contentType="text/plain;charset=UTF-8"%>
<%@page import="java.net.InetAddress"%>
bilan-energie.version=1.00.05
bilan-energie.localhost.hostaddress=<%=InetAddress.getLocalHost().getHostAddress() %>
bilan-energie.localhost.canonicalhostname=<%=InetAddress.getLocalHost().getCanonicalHostName() %>
bilan-energie.localhost.hostname=<%=InetAddress.getLocalHost().getHostName() %>
<% 
HttpSession theSession = request.getSession( false );

try {
    if( theSession != null ) {
      synchronized( theSession ) {
        theSession.invalidate();
      }
    }
} catch (Exception e) {
}
%>
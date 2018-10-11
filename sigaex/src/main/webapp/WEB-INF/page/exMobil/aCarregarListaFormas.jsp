<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	buffer="64kb"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<select id="idFormaDoc" name="idFormaDoc" onchange="javascript:alteraForma();">
	<option value="0" >
		[Todos]
	</option>
	<c:forEach items="${todasFormasDocPorTipoForma}" var="item">
		<option value="${item.idFormaDoc}" ${item.idFormaDoc == idFormaDoc ? 'selected' : ''}>
			${item.descrFormaDoc}
		</option>  
	</c:forEach>
</select>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>TO-DO-LIST</title>
    <link type="text/css" rel="stylesheet" href="./css/list.css">
    <link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
<%-- <style type="text/css">
<%@include file="style.css" %>
<%@include file="blog.css" %>
</style> --%>
</head>
<body>
 <nav>
        <ul>
           <li> <a href="${pageContext.request.contextPath}/mylists">My Lists</a></li>
           		 <li> <a href="${pageContext.request.contextPath}/alllists">All Lists</a></li>
             <li> <a href="${pageContext.request.contextPath}/login">Login</a></li>
            <li> <a href="${pageContext.request.contextPath}/signup">Sign Up</a></li>
        </ul>
    </nav>
    <div class="body-div1">
        <div>Your  Lists</div>
   <c:if test="${list == null}">
  <a href="${pageContext.request.contextPath}/new"><button class="button" id="addList" ><i class="fas fa-plus-circle"></i>Add New Post</button></a>  
   </c:if>
    </div>
<!-- <div id="popup"> -->
<!-- Popup Div Starts Here -->
<div id="popupContact">
<h2>Write here </h2>
 
<!-- Contact Us Form -->
<%-- <form action="${pageContext.request.contextPath}/new" id="form" method="post" name="form"> --%>
 		<c:if test="${list != null}">
            <form action="${pageContext.request.contextPath}/update" method="post">
        </c:if>
        <c:if test="${list == null}">
            <form action="${pageContext.request.contextPath}/new" method="post">
        </c:if>
 		<c:if test="${list != null}">
  		<input type="hidden" name="listid" value="<c:out value='${list.getListId()}' />" />
   		</c:if>  
					<c:if test="${list != null}">
            			Edit List
            		</c:if>
						<c:if test="${list == null}">
            			Add New List
            		</c:if>
		<input id="title" name="type" value="<c:out value='${list.getListType()}'/>" placeholder="list Type" type="text"/>
		<textarea id="msg" name="message" placeholder="Description"><c:out value='${list.getListDescription()}'/></textarea>
		<button id="post" type="submit" >ADD</button>
	</form>
</div>
</body>
</html>
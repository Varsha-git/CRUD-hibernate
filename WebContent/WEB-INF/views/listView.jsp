<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>LIST APP</title>
    <!--  <link rel="stylesheet" href="./css/style.css"> -->
    <link rel="stylesheet" href="./css/list.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
</head>
<body>
 <nav>
        <ul>
           <li> <a href="${pageContext.request.contextPath}/myblogs">My Lists</a></li>
        	 <li> <a href="${pageContext.request.contextPath}/allblogs">All Lists</a></li>
             <li> <a href="${pageContext.request.contextPath}/login">Login</a></li>
         </ul>
    </nav>
    <div class="body-div1">
        <div>Yours List</div>
  <a href="${pageContext.request.contextPath}/new"> 
  <button class="button" id="addList" ><i class="fas fa-plus-circle"></i>Create New List</button>
  </a>  
    </div>

<div class="body-div2">

<c:forEach var="list"  items="${listslip}">
      <div class="article-card">
            <img src="./assets/arrow.png"  width="80px"  height="80px" alt="">
            <div class="card-text">
               <p id="type"><c:out value="${list.getListType()}" /></p> 
               <hr>
                <p id="message"><c:out value="${list.getListDescription()}" /></p>
            </div>
      	  <div class="card-buttons">
             <a href="edit?id=<c:out value='${list.getListId()}' />"><button type="button" id="edit">EDIT</button></a>
              <span>|</span>
              <a href="delete?id=<c:out value='${list.getListId()}'/>"><button type="button"  id="delete">DELETE</button></a>
            </div>
        </div>
     </c:forEach> 
</div>

<div class="body-div3">
<h1>${message}</h1>
</div>

</body>
</html>